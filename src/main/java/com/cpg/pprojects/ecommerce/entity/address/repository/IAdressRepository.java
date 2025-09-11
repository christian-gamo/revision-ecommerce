package com.cpg.pprojects.ecommerce.entity.address.repository;

import com.cpg.pprojects.ecommerce.entity.address.model.Address;

import java.util.List;

public interface IAdressRepository {
    List<Address> findAll();
    Address findById(int id);

    Address save(Address address);
    void delete(Address address);
}
