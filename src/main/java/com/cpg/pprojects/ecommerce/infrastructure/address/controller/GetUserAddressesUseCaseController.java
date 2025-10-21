package com.cpg.pprojects.ecommerce.infrastructure.address.controller;

import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.infrastructure.util.AuthUtil;
import com.cpg.pprojects.ecommerce.usecase.address.GetUserAddressesUseCase;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetUserAddressesUseCaseController {
    private final GetUserAddressesUseCase getUserAddressesUseCase;
    private final AuthUtil authUtil;

    public GetUserAddressesUseCaseController(
            GetUserAddressesUseCase getUserAddressesUseCase,
            AuthUtil authUtil
    ) {
        this.getUserAddressesUseCase = getUserAddressesUseCase;
        this.authUtil = authUtil;
    }

    @GetMapping("/users/addresses")
    public ResponseEntity<List<AddressDTO>> getUserAddresses(){
        User user = authUtil.loggedInUser();
        List<AddressDTO> addressList = getUserAddressesUseCase.execute(user);
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
}
