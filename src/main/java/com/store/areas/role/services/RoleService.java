package com.store.areas.role.services;

import com.store.areas.role.models.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findByAuthority(String authority);

    void addRole(RoleServiceModel roleServiceModel);
}
