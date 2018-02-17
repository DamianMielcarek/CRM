package crm.service;

import crm.entity.User;

public interface UserService {

    User findByUserName(String name);
    void saveUser(User user);

}
