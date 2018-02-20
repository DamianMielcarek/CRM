package crm.service;

import crm.entity.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<User> findAll();

    void saveUser(User user);

}
