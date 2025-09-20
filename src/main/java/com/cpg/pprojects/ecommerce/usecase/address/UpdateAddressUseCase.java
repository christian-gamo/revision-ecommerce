package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.domain.user.repository.IUserRepository;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;

public class UpdateAddressUseCase {
    private final IAddressRepository addressRepository;
    private final IUserRepository userRepository;

    public UpdateAddressUseCase(IAddressRepository addressRepository,  IUserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public Address execute(long idAddress, Address addressWithUpdatedFields){
        Address addressToBeUpdated = addressRepository.findById(idAddress).orElseThrow(() -> new ResourceNotFoundException("Address", "idAddress", idAddress));
        addressToBeUpdated.setBuildingName(addressWithUpdatedFields.getBuildingName());
        addressToBeUpdated.setStreet(addressWithUpdatedFields.getStreet());
        addressToBeUpdated.setCity(addressWithUpdatedFields.getCity());
        addressToBeUpdated.setState(addressWithUpdatedFields.getState());
        addressToBeUpdated.setCountry(addressWithUpdatedFields.getCountry());
        addressToBeUpdated.setPincode(addressWithUpdatedFields.getPincode());

        Address updatedAddress = addressRepository.save(addressToBeUpdated);

        User user = userRepository.findById(updatedAddress.getUser().getIdUser());
        user.getAddresses().removeIf(add -> add.getIdAddress() == idAddress);
        user.getAddresses().add(updatedAddress);
        return updatedAddress;
    }
}
