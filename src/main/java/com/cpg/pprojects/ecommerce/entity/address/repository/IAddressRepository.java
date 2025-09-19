package com.cpg.pprojects.ecommerce.entity.address.repository;

import com.cpg.pprojects.ecommerce.entity.address.model.Address;

import java.util.List;

public interface IAddressRepository {
    List<Address> findAll();
    Address findById(long id);
    Address save(Address address);
    void delete(Address address);

    List<Address> findByUserId(long idUser);
}
