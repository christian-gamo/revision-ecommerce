package com.cpg.pprojects.ecommerce.infrastructure.address.controller;

import com.cpg.pprojects.ecommerce.usecase.address.DeleteAddressUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAddressUseCaseController {

    private final DeleteAddressUseCase deleteAddressUseCase;

    public DeleteAddressUseCaseController(DeleteAddressUseCase deleteAddressUseCase){
        this.deleteAddressUseCase = deleteAddressUseCase;
    }


    @DeleteMapping("/addresses/{idAddress}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long idAddress){
        String status = deleteAddressUseCase.execute(idAddress);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
