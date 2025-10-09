package com.cpg.pprojects.ecommerce.domain.address.repository;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository {
    List<Address> findAll();
    Optional<Address> findById(Long id);
    Address save(Address address);
    void delete(Address address);

    List<Address> findByIdUser(Long idUser);
}
