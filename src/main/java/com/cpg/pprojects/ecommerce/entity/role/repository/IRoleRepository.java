package com.cpg.pprojects.ecommerce.entity.role.repository;

import com.cpg.pprojects.ecommerce.entity.AppRole;
import com.cpg.pprojects.ecommerce.entity.role.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleRepository {
    Role findById(long id);
    List<Role> findAll();
    Role save(Role role);
    void delete(Role role);

    Optional<Role> findByRoleName(AppRole appRole);

}
