package com.cpg.pprojects.ecommerce.infrastructure.address.repository_impl;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.AddressEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.UserEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository.IAdressJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository implements IAddressRepository {

    IAdressJpaRepository addressJpaRepository;

    public AddressRepository(IAdressJpaRepository addressJpaRepository) {
        this.addressJpaRepository = addressJpaRepository;
    }

    @Override
    public List<Address> findAll() {
        List<AddressEntity> addressEntities = addressJpaRepository.findAll();
        if (addressEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return addressEntities
                .stream()
                .map(AddressEntity::toAddress)
                .toList();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressJpaRepository.findById(id)
                .map(AddressEntity::toAddress);
    }

    @Override
    public Address save(Address address) {

        return addressJpaRepository.save(new AddressEntity(address)).toAddress();
    }

    @Override
    public void delete(Address address) {
        addressJpaRepository.delete(new AddressEntity(address));
    }

    @Override
    public List<Address> findAllByUser(User user) {

        return addressJpaRepository.findAllByUser(new UserEntity(user))
                .stream()
                .map(AddressEntity::toAddress)
                .toList();
    }

}
