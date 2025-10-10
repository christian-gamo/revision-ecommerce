package com.cpg.pprojects.ecommerce.infrastructure.address.controller;

import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.infrastructure.util.AuthUtil;
import com.cpg.pprojects.ecommerce.usecase.address.CreateAdressUseCase;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAdressUseCaseController {
    private final CreateAdressUseCase createAdressUseCase;
    private final AuthUtil authUtil;

    public CreateAdressUseCaseController(
            CreateAdressUseCase createAdressUseCase,
            AuthUtil authUtil
    ) {
        this.createAdressUseCase = createAdressUseCase;
        this.authUtil = authUtil;
    }

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO){
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = createAdressUseCase.execute(addressDTO, user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }


}
