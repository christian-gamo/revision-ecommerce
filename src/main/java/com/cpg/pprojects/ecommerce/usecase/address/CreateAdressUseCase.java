package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.APIException;

import java.util.List;

public class CreateAdressUseCase {
    private final IAddressRepository addressRepository;

    public CreateAdressUseCase(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public AddressDTO execute(AddressDTO addressDTO, User user) {
        if(addressDTO == null || user == null){
            throw new APIException("Null arguments in CreateAdressUseCase");
        }
        Address address = new Address(
                addressDTO.getBuildingName(),
                addressDTO.getStreet(),
                addressDTO.getCity(),
                addressDTO.getState(),
                addressDTO.getCountry(),
                addressDTO.getPincode(),
                user
        );
        List<Address> userAddresses = user.getAddresses();
        userAddresses.add(address);
        user.setAddresses(userAddresses);
        Address savedAddress = addressRepository.save(address);

        return new AddressDTO(savedAddress);
    }

}
