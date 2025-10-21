package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetAddressesUseCase {
    private final IAddressRepository addressRepository;

    public GetAddressesUseCase(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> execute(){
        List<Address> addresses = addressRepository.findAll();
        if (addresses.isEmpty()) {
            return Collections.emptyList();
        }
        return addresses.stream()
                .map(AddressDTO::new)
                .collect(Collectors.toList());
    }
}
