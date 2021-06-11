package com.GrowHub.Server.repositories;

import com.GrowHub.Server.models.Comment;
import com.GrowHub.Server.models.Knowhow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}

