package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

public class GetAddressByIdUseCase {
    private final IAddressRepository addressRepository;

    public GetAddressByIdUseCase(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(Long idAddress) {
        Address address = addressRepository.findById(idAddress)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "idAddress", idAddress));
        return new AddressDTO(address);
    }
}
