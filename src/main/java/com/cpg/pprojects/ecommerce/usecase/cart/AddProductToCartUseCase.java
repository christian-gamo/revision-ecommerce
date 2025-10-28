package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import com.cpg.pprojects.ecommerce.domain.product.repository.IProductRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;
import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

import java.util.List;
import java.util.stream.Stream;

public class AddProductToCartUseCase {
    private final ICartRepository cartRepository;
    private final IProductRepository productRepository;
    private final ICartItemRepository cartItemRepository;

    public AddProductToCartUseCase(
            ICartRepository cartRepository,
            IProductRepository productRepository,
            ICartItemRepository cartItemRepository
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public CartDTO execute(Long idProduct, Integer quantity, User user) {
        Cart cart;
        Cart userCart  = cartRepository.findCartByEmail(user.getEmail());
        if(userCart != null){
            cart = userCart;
        }
        else{
            Cart newCart = new Cart();
            newCart.setTotalPrice(0.00);
            newCart.setUser(user);
            cart = cartRepository.save(newCart);
        }

        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "idProduct", idProduct));
        CartItem cartItem = cartItemRepository.findCartItemByIdCartAndIdProduct(cart.getIdCart(), idProduct);

        if (cartItem != null) {
            throw new APIException("Product " + product.getProductName() + " already exists in the cart");
        }
        if (product.getQuantity() == 0) {
            throw new APIException(product.getProductName() + " is not available");
        }
        if (product.getQuantity() < quantity) {
            throw new APIException("Please, make an order of the " + product.getProductName()
                    + " less than or equal to the available quantity (" + product.getQuantity() + ").");
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(product);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(quantity);
        newCartItem.setDiscount(product.getDiscount());
        newCartItem.setProductPrice(product.getSpecialPrice());
        cartItemRepository.save(newCartItem);

        product.setQuantity(product.getQuantity());

        cart.setTotalPrice(cart.getTotalPrice() + (product.getSpecialPrice() * quantity));

        Cart savedCart = cartRepository.save(cart);

        CartDTO cartDTO = new CartDTO(savedCart);
        List<CartItem> cartItems = cart.getCartItems();
        Stream<ProductDTO> productStream = cartItems.stream().map(item -> {
            ProductDTO productDTO = new ProductDTO(item.getProduct());
            productDTO.setQuantity(item.getQuantity());
            return productDTO;
        });
        cartDTO.setProducts(productStream.toList());

        return cartDTO;
    }


}
