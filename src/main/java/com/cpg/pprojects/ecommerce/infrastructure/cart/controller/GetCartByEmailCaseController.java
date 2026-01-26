package com.cpg.pprojects.ecommerce.infrastructure.cart.controller;

import com.cpg.pprojects.ecommerce.infrastructure.util.AuthUtil;
import com.cpg.pprojects.ecommerce.usecase.cart.GetCartByEmailUseCase;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCartByEmailCaseController {
    private final GetCartByEmailUseCase getCartByEmailUseCase;
    private final AuthUtil authUtil;

    public GetCartByEmailCaseController(
            GetCartByEmailUseCase getCartByEmailUseCase,
            AuthUtil authUtil
    ) {
        this.getCartByEmailUseCase = getCartByEmailUseCase;
        this.authUtil = authUtil;
    }

    @GetMapping("/carts/users/cart")
    public ResponseEntity<CartDTO> getCartByEmail(){
        String email = authUtil.loggedInEmail();

        CartDTO cartDTO = getCartByEmailUseCase.execute(email);
        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
    }
}
