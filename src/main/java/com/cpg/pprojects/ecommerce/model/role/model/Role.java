package com.cpg.pprojects.ecommerce.model.role.model;

import com.cpg.pprojects.ecommerce.model.user.AppRole;

public class Role {
    private int idRole;
    private AppRole roleName;

    public Role() {}

    public Role(int idRole, AppRole roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public AppRole getRoleName() {
        return roleName;
    }

    public void setRoleName(AppRole roleName) {
        this.roleName = roleName;
    }
}
