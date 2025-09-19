package com.cpg.pprojects.ecommerce.model.address.repository;

import com.cpg.pprojects.ecommerce.model.address.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository {
    List<Address> findAll();
    Optional<Address> findById(long id);
    Address save(Address address);
    void delete(Address address);

    List<Address> findByUserId(long idUser);
}
