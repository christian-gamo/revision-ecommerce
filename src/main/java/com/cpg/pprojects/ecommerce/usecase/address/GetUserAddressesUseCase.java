package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;

import java.util.List;

public class GetUserAddressesUseCase {
    private final IAddressRepository addressRepository;

    public GetUserAddressesUseCase(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> execute(Long idUser){
        return addressRepository.findByIdUser(idUser);
    }


}
