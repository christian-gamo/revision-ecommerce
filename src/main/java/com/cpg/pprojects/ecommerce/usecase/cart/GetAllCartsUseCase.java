package com.cpg.pprojects.ecommerce.usecase.cart;

import com.cpg.pprojects.ecommerce.domain.cart.model.Cart;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;
import com.cpg.pprojects.ecommerce.usecase.product.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllCartsUseCase {
    private final ICartRepository cartRepository;

    public  GetAllCartsUseCase(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartDTO> getAllCarts(){
        List<Cart>  carts = cartRepository.findAll();
        if (carts.isEmpty()) {
            throw new APIException("No cart exists");
        }
        List<CartDTO> cartDTOs = carts
                .stream()
                .map(cart -> {
                    CartDTO cartDTO = new CartDTO(cart);
                    List<ProductDTO> products = cart.getCartItems()
                            .stream()
                            .map(cartItem -> {
                                ProductDTO productDTO = new ProductDTO(cartItem.getProduct());
                                productDTO.setQuantity(cartItem.getQuantity());
                                return productDTO;
                            }).toList();
                    cartDTO.setProducts(products);
                    return cartDTO;
                }).toList();
        return cartDTOs;
    }
}
