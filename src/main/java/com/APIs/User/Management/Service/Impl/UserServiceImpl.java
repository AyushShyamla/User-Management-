package com.APIs.User.Management.Service.Impl;

import com.APIs.User.Management.Entity.User;
import com.APIs.User.Management.Service.UserService;
import com.APIs.User.Management.UserRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User GetUser(Long UserId) {
          Optional<User> optionalUser= userRepository.findById(UserId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User UpdateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.getGender());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
       userRepository.deleteById(userId);
    }
}
