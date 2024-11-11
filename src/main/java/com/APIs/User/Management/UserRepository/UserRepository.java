package com.APIs.User.Management.UserRepository;

import com.APIs.User.Management.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
