package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.BulletinItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulletinItemRepository extends JpaRepository<BulletinItem, Long> {
}
