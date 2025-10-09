package com.cpg.pprojects.ecommerce.infrastructure.address.repository;

import com.cpg.pprojects.ecommerce.domain.address.model.Address;
import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.AddressEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository.IAdressJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdressRepository implements IAddressRepository {

    IAdressJpaRepository jpaRepository;

    public AdressRepository(IAdressJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Address> findAll() {
        List<AddressEntity> addressEntities = jpaRepository.findAll();
        return null;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Address save(Address address) {
        return jpaRepository.save(new AddressEntity(address)).toAddress();
    }

    @Override
    public void delete(Address address) {

    }

    @Override
    public List<Address> findByUserId(Long idUser) {
        return List.of();
    }

}
