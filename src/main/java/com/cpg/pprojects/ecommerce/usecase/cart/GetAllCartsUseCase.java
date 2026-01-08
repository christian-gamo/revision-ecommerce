package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;
import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllCartsUseCase {
    private final ICartRepository cartRepository;
    private final ICartItemRepository cartItemRepository;

    public  GetAllCartsUseCase(
            ICartRepository cartRepository,
            ICartItemRepository cartItemRepository
    ) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartDTO> getAllCarts(){
        List<Cart>  carts = cartRepository.findAll();
        if (carts.isEmpty()) {
            throw new APIException("No cart exists");
        }

        return carts
                .stream()
                .map(cart -> {
                    CartDTO cartDTO = new CartDTO(cart);
                    List<ProductDTO> products = cartItemRepository.findAllByCart(cart)
                            .stream()
                            .map(cartItem -> {
                                ProductDTO productDTO = new ProductDTO(cartItem.getProduct());
                                productDTO.setQuantity(cartItem.getQuantity());
                                return productDTO;
                            }).toList();
                    cartDTO.setProducts(products);
                    return cartDTO;
                }).toList();
    }
}
