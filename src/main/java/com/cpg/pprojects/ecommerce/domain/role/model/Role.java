package com.cpg.pprojects.ecommerce.domain.role.model;

import com.cpg.pprojects.ecommerce.domain.user.AppRole;

public class Role {
    private Integer idRole;
    private AppRole roleName;

    public Role() {}

    public Role(Integer idRole, AppRole roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public AppRole getRoleName() {
        return roleName;
    }

    public void setRoleName(AppRole roleName) {
        this.roleName = roleName;
    }
}
