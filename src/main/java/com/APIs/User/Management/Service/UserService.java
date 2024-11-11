package com.APIs.User.Management.Service;

import com.APIs.User.Management.Entity.User;

import java.util.List;

public interface UserService {
  User CreateUser(User user);

  User GetUser(Long UserId);

  List<User> getAllUsers();

  User UpdateUser (User user);

  void deleteUser(Long userId);
}
