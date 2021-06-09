package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.BulletinItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulletinItemRepository extends JpaRepository<BulletinItem, Long> {
}
