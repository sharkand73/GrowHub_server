package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
