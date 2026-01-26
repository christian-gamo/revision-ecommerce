package com.cpg.pprojects.ecommerce.infrastructure.cart.controller;

import com.cpg.pprojects.ecommerce.usecase.cart.GetAllCartsUseCase;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllCartsUseCaseController {
    private final GetAllCartsUseCase getAllCartsUseCase;

    public GetAllCartsUseCaseController(GetAllCartsUseCase getAllCartsUseCase) {
        this.getAllCartsUseCase = getAllCartsUseCase;
    }

    @GetMapping("/carts")
    public ResponseEntity<List<CartDTO>> getAllCarts() {
        List<CartDTO> cartDTOs = getAllCartsUseCase.execute();
        return new ResponseEntity<List<CartDTO>>(cartDTOs, HttpStatus.FOUND);
    }
}
