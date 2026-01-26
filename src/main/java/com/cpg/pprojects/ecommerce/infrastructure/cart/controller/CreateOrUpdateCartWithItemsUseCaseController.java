package com.cpg.pprojects.ecommerce.infrastructure.cart.controller;

import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.infrastructure.util.AuthUtil;
import com.cpg.pprojects.ecommerce.usecase.cart.CreateOrUpdateCartWithItemsUseCase;
import com.cpg.pprojects.ecommerce.usecase.cart.dto.CartItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreateOrUpdateCartWithItemsUseCaseController {
    private final CreateOrUpdateCartWithItemsUseCase createOrUpdateCartWithItemsUseCaseController;
    private final AuthUtil authUtil;

    public CreateOrUpdateCartWithItemsUseCaseController(
            CreateOrUpdateCartWithItemsUseCase createOrUpdateCartWithItemsUseCase,
            AuthUtil authUtil
    ){
        this.createOrUpdateCartWithItemsUseCaseController = createOrUpdateCartWithItemsUseCase;
        this.authUtil = authUtil;
    }

    @PostMapping("/cart/create")
    public ResponseEntity<String> createOrUpdateCart(@RequestBody List<CartItemDTO> cartItems){
        User user = authUtil.loggedInUser();
        String response = createOrUpdateCartWithItemsUseCaseController.execute(cartItems, user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
