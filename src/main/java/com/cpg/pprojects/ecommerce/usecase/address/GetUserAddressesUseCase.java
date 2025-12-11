package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;

import java.util.Collections;
import java.util.List;

public class GetUserAddressesUseCase {
    private final IAddressRepository addressRepository;

    public GetUserAddressesUseCase(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> execute(User user){

        if(user == null){
            throw new APIException("User is null");
        }

        List<Address> addresses = addressRepository.findAllByUser(user);

        if(addresses == null || addresses.isEmpty()){
            return Collections.emptyList();
        }
        return addresses.stream()
                .map(AddressDTO::new)
                .toList();
    }

}
