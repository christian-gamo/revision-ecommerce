package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.AddressEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IAdressJpaRepository extends JpaRepository<AddressEntity, Long> {
    List<AddressEntity> findAllByUser(UserEntity user);
}
