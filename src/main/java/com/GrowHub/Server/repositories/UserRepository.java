package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByPlotsPlotNumber(int plotNumber);

}
