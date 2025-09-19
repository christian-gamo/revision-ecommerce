package com.cpg.pprojects.ecommerce.usecase.address;

import com.cpg.pprojects.ecommerce.entity.address.model.Address;
import com.cpg.pprojects.ecommerce.entity.address.repository.IAdressRepository;

public class CreateAdressUseCase {
    private final IAdressRepository adressRepository;

    public CreateAdressUseCase(IAdressRepository adressRepository){
        this.adressRepository = adressRepository;
    }

    public Address execute(Address address) {
        return adressRepository.save(address);
    }

}
