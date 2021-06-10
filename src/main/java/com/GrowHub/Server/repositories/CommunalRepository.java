package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.Communal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunalRepository extends JpaRepository<Communal, Long> {
}
