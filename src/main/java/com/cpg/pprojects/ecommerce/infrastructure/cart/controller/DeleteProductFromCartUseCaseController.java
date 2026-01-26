package com.cpg.pprojects.ecommerce.infrastructure.cart.controller;

import com.cpg.pprojects.ecommerce.usecase.cart.DeleteProductFromCartUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DeleteProductFromCartUseCaseController {
    private final DeleteProductFromCartUseCase deleteProductFromCartUseCase;

    public DeleteProductFromCartUseCaseController(
            DeleteProductFromCartUseCase deleteProductFromCartUseCase
    ) {
        this.deleteProductFromCartUseCase = deleteProductFromCartUseCase;
    }

    @DeleteMapping("/carts/{idCart}/product/{idProduct}")
    public ResponseEntity<String> deleteProductFromCart(@PathVariable Long idCart,
                                                        @PathVariable Long idProduct) {
        String status = deleteProductFromCartUseCase.execute(idCart, idProduct);

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}
