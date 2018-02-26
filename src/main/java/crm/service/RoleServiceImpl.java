package crm.service;

import crm.entity.Role;
import crm.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Iterable<Role> listAllRoles() {
        return roleRepository.findAll();
    }

}
