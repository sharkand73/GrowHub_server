package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
