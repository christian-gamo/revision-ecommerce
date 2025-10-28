package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;
import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

import java.util.List;

public class GetCartUseCase {
    private final ICartRepository cartRepository;

    public GetCartUseCase(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDTO execute(String email, Long idCart) {
        Cart cart = cartRepository.findCartByEmailAndIdCart(email, idCart);
        if (cart == null){
            throw new ResourceNotFoundException("Cart", "idCart", idCart);
        }
        CartDTO cartDTO = new CartDTO(cart);

        cart.getCartItems().forEach(
                c -> c.getProduct().setQuantity(c.getQuantity())
        );

        List<ProductDTO> products = cart.getCartItems().stream()
                .map(cartItem -> new ProductDTO(cartItem.getProduct()))
                .toList();
        cartDTO.setProducts(products);

        return cartDTO;
    }
}
