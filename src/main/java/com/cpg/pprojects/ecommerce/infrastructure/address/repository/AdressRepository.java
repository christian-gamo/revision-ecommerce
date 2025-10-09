package com.cpg.pprojects.ecommerce.infrastructure.address.repository;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.AddressEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository.IAdressJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AdressRepository implements IAddressRepository {

    IAdressJpaRepository jpaRepository;

    public AdressRepository(IAdressJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Address> findAll() {
        List<AddressEntity> addressEntities = jpaRepository.findAll();
        if (addressEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return addressEntities.stream()
                .map(AddressEntity::toAddress)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Address> findById(Long id) {
        return jpaRepository.findById(id)
                .map(AddressEntity::toAddress);
    }

    @Override
    public Address save(Address address) {
        return jpaRepository.save(new AddressEntity(address)).toAddress();
    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public List<Address> findByIdUser(Long idUser) {
        return List.of();
    }

}
