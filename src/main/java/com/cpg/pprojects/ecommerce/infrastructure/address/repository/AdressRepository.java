package com.cpg.pprojects.ecommerce.infrastructure.address.repository;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;

import java.util.List;
import java.util.Optional;

public class AdressRepository implements IAddressRepository {
    @Override
    public List<Address> findAll() {
        return List.of();
    }

    @Override
    public Optional<Address> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public List<Address> findByUserId(long idUser) {
        return List.of();
    }
}
