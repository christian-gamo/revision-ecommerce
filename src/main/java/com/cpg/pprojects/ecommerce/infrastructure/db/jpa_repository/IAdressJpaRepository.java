package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository;

import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdressJpaRepository extends JpaRepository<AddressEntity, Long> {
}
