package com.cpg.pprojects.ecommerce.infrastructure.cart.controller;

import com.cpg.pprojects.ecommerce.infrastructure.util.AuthUtil;
import com.cpg.pprojects.ecommerce.usecase.cart.UpdateProductQuantityInCartUseCase;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public class UpdateProductQuantityInCartUseCaseController {
    private final UpdateProductQuantityInCartUseCase updateProductQuantityInCartUseCase;
    private final AuthUtil authUtil;

    public UpdateProductQuantityInCartUseCaseController(
            UpdateProductQuantityInCartUseCase updateProductQuantityInCartUseCase,
            AuthUtil authUtil
    ){
        this.updateProductQuantityInCartUseCase = updateProductQuantityInCartUseCase;
        this.authUtil = authUtil;
    }

    @PutMapping("/cart/products/{idProduct}/quantity/{operation}")
    public ResponseEntity<CartDTO> updateProductQuantityInCart(@PathVariable Long idProduct,
                                                     @PathVariable String operation) {

        String email = authUtil.loggedInEmail();
        CartDTO cartDTO = updateProductQuantityInCartUseCase.execute(email, idProduct,
                operation.equalsIgnoreCase("delete") ? -1 : 1);

        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
    }

}
