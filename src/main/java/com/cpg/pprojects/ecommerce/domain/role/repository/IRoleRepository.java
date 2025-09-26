package com.cpg.pprojects.ecommerce.domain.role.repository;

import com.cpg.pprojects.ecommerce.domain.role.model.Role;
import com.cpg.pprojects.ecommerce.domain.user.AppRole;

import java.util.List;
import java.util.Optional;

public interface IRoleRepository {
    Role findById(long id);
    List<Role> findAll();
    Role save(Role role);
    void delete(Role role);

    Optional<Role> findByRoleName(AppRole appRole);

}
