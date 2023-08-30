package com.yvan.simpleregistrationapi.Service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yvan.simpleregistrationapi.Model.User;
import com.yvan.simpleregistrationapi.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
        @Autowired
        UserRepository userRepository;
    
    @Override
    public User getUserById(int id) {
       return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


    @Override
    public List<User> getUsers() {
       return userRepository.findAll();
    }

    @Override
    public void updateUser(int id, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
  
    
}