package crm.service;

import crm.entity.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user);

}
