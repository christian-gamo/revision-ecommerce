package com.cpg.pprojects.ecommerce.infrastructure.address.controller;

import com.cpg.pprojects.ecommerce.usecase.address.GetAddressByIdUseCase;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAddressByIdUseCaseController {
    private final GetAddressByIdUseCase getAddressByIdUseCase;

    public GetAddressByIdUseCaseController(GetAddressByIdUseCase getAddressByIdUseCase) {
        this.getAddressByIdUseCase = getAddressByIdUseCase;
    }

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long idAddress){
        AddressDTO addressDTO = getAddressByIdUseCase.execute(idAddress);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }


}
