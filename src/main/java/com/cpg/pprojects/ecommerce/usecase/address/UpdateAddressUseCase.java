package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.domain.user.repository.IUserRepository;
import com.cpg.pprojects.ecommerce.usecase.address.dto.AddressDTO;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

public class UpdateAddressUseCase {
    private final IAddressRepository addressRepository;
    private final IUserRepository userRepository;

    public UpdateAddressUseCase(IAddressRepository addressRepository,  IUserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public Address execute(Long idAddress, AddressDTO addressDTO){
        Address addressToBeUpdated = addressRepository.findById(idAddress)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "idAddress", idAddress));

        addressToBeUpdated.setStreet(addressDTO.getStreet());
        addressToBeUpdated.setBuildingName(addressDTO.getBuildingName());
        addressToBeUpdated.setPincode(addressDTO.getPincode());
        addressToBeUpdated.setCity(addressDTO.getCity());
        addressToBeUpdated.setState(addressDTO.getState());
        addressToBeUpdated.setCountry(addressDTO.getCountry());

        Address updatedAddress = addressRepository.save(addressToBeUpdated);

        Long idUser = addressToBeUpdated.getUser().getIdUser();
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User", "idUser", idAddress));
        user.getAddresses().removeIf(address -> address.getIdAddress().equals(idAddress));
        user.getAddresses().add(updatedAddress);
        userRepository.save(user);

        return updatedAddress;
    }
}
