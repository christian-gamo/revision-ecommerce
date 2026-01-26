package com.cpg.pprojects.ecommerce.infrastructure.cart.controller;

import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.infrastructure.util.AuthUtil;
import com.cpg.pprojects.ecommerce.usecase.cart.AddProductToCartUseCase;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductToCartUseCaseController {
    private final AddProductToCartUseCase addProductToCartUseCase;
    private final AuthUtil authUtil;

    public AddProductToCartUseCaseController(
            AddProductToCartUseCase addProductToCartUseCase,
            AuthUtil authUtil
    ) {
        this.addProductToCartUseCase = addProductToCartUseCase;
        this.authUtil = authUtil;
    }

    @PostMapping("/carts/products/{idProduct}/quantity/{quantity}")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable Long idProduct,
                                                    @PathVariable Integer quantity){
        User user = authUtil.loggedInUser();
        CartDTO cartDTO = addProductToCartUseCase.execute(idProduct, quantity, user);
        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.CREATED);
    }
}
