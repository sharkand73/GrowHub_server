package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.AllotmentSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllotmentSettingsRepository extends JpaRepository <AllotmentSettings, Long> {
}
