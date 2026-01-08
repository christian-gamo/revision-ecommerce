package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.model.CartItem;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;
import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

import java.util.List;

public class GetCartUseCase {
    private final ICartRepository cartRepository;
    private final ICartItemRepository cartItemRepository;

    public GetCartUseCase(ICartRepository cartRepository, ICartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public CartDTO execute(String email, Long idCart) {
        Cart cart = cartRepository.findCartByEmailAndIdCart(email, idCart);
        if (cart == null){
            throw new ResourceNotFoundException("Cart", "idCart", idCart);
        }
        CartDTO cartDTO = new CartDTO(cart);

        List<CartItem> cartItemsFromCart = cartItemRepository.findAllByCart(cart);
        cartItemsFromCart.forEach(
                c -> c.getProduct().setQuantity(c.getQuantity())
        );

        List<ProductDTO> products = cartItemsFromCart.stream()
                .map(cartItem -> new ProductDTO(cartItem.getProduct()))
                .toList();
        cartDTO.setProducts(products);

        return cartDTO;
    }
}
