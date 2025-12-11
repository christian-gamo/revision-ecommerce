package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;


public class DeleteAddressUseCase {
    private final IAddressRepository addressRepository;

    public DeleteAddressUseCase(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public String execute(Long idAddress){
        Address addressFromDatabase =  addressRepository.findById(idAddress)
                .orElseThrow(()-> new ResourceNotFoundException("Address","idAddress",idAddress));

        addressRepository.delete(addressFromDatabase);

        return "Address deleted successfully with idAddress: " + idAddress;

    }
}
