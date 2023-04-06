package com.job.broad.services;

import com.job.broad.dto.RoleDto;
import com.job.broad.entity.Role;
import com.job.broad.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;

    }

    public Role addRoles(RoleDto roleDto) {
        Role role = new Role();
        System.out.println("role data" + roleDto.getId());
        role.setId(roleDto.getId());
        role.setRolename(roleDto.getRoleName());

        roleRepository.save(role);

        return role;

    }
}
