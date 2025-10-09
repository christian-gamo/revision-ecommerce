package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetUserAddressesUseCase {
    private final IAddressRepository addressRepository;

    public GetUserAddressesUseCase(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> execute(User user){
        if(user == null){
            throw new APIException("User is null");
        }
        if (user.getAddresses() == null) {
            return Collections.emptyList();
        }
        List<Address> addresses = user.getAddresses();
        return addresses.stream()
                .map(AddressDTO::new)
                .collect(Collectors.toList());
    }

}
