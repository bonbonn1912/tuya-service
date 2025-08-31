package com.bonbonn.tuya.repository;

import com.bonbonn.tuya.data.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
  Queue findFirstByOrderByIdAsc();
}
