package com.cpg.pprojects.ecommerce.domain.user.repository;

import com.cpg.pprojects.ecommerce.domain.user.AppRole;
import com.cpg.pprojects.ecommerce.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    User findById(long id);
    List<User> findAll();
    User save(User user);
    void delete(User user);

    Optional<User> findByUserName(String username);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);

    List<User> findByRoleName(
            AppRole role,
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortOrder
    );
}
