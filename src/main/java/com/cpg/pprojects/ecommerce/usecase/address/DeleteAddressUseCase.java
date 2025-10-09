package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.domain.user.repository.IUserRepository;
import com.cpg.pprojects.ecommerce.usecase.exceptions.ResourceNotFoundException;


public class DeleteAddressUseCase {
    private final IAddressRepository addressRepository;
    private final IUserRepository userRepository;

    public DeleteAddressUseCase(IAddressRepository addressRepository,  IUserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public String execute(Long idAddress){
        Address addressFromDatabase =  addressRepository.findById(idAddress)
                .orElseThrow(()-> new ResourceNotFoundException("Address","idAddress",idAddress));

        Long idUser = addressFromDatabase.getUser().getIdUser();
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User", "idUser", idAddress));

        user.getAddresses().removeIf(address -> address.getIdAddress().equals(idAddress));
        userRepository.save(user);
        addressRepository.delete(addressFromDatabase);

        return "Address deleted successfully with idAddress: " + idAddress;

    }
}
