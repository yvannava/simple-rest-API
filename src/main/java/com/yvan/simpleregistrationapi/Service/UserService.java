package com.yvan.simpleregistrationapi.Service;

import com.yvan.simpleregistrationapi.Model.User;
import java.util.List;

public interface UserService {
   User getUserById(int id);
   void deleteUser(int id);
    void saveUser(User user);
    void updateUser(int id, User user);
    List<User> getUsers();

}
