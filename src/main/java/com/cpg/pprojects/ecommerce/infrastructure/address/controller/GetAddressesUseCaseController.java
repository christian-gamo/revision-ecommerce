package com.cpg.pprojects.ecommerce.infrastructure.address.controller;

import com.cpg.pprojects.ecommerce.usecase.address.GetAddressesUseCase;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAddressesUseCaseController {
    private final GetAddressesUseCase getAddressesUseCase;

    public GetAddressesUseCaseController(GetAddressesUseCase getAddressesUseCase) {
        this.getAddressesUseCase = getAddressesUseCase;
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses(){
        List<AddressDTO> addressList = getAddressesUseCase.execute();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
}
