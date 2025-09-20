package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

public class GetAddressUseCase {
    private final IAddressRepository addressRepository;

    public GetAddressUseCase(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public Address execute(long idAddress) {
        return addressRepository.findById(idAddress).orElseThrow(() -> new ResourceNotFoundException("Address", "idAddress", idAddress));
    }
}
