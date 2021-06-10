package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.Tip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipRepository extends JpaRepository<Tip, Long> {
}
