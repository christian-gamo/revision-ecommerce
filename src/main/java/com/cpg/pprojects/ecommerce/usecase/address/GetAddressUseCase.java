package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.entity.address.model.Address;
import com.cpg.pprojects.ecommerce.entity.address.repository.IAddressRepository;

public class GetAddressUseCase {
    private final IAddressRepository addressRepository;

    public GetAddressUseCase(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public Address execute(long idAddress) {
        return addressRepository.findById(idAddress);
    }
}
