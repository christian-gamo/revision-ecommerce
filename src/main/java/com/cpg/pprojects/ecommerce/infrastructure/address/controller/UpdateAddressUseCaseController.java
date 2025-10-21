package com.cpg.pprojects.ecommerce.infrastructure.address.controller;

import com.cpg.pprojects.ecommerce.usecase.address.UpdateAddressUseCase;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateAddressUseCaseController {
    UpdateAddressUseCase updateAddressUseCase;

    public UpdateAddressUseCaseController(UpdateAddressUseCase updateAddressUseCase){
        this.updateAddressUseCase = updateAddressUseCase;
    }

    @PutMapping("/addresses/{idAddress}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable Long idAddress
            , @RequestBody AddressDTO addressDTO){
        AddressDTO updatedAddress = updateAddressUseCase.execute(idAddress, addressDTO);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }
}
