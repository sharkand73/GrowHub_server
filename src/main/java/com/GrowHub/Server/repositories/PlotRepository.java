package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

    List<Plot> findByUsersShortName(String name);
}
