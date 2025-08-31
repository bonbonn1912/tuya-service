package com.bonbonn.tuya.service;

import com.bonbonn.tuya.data.entity.Queue;
import com.bonbonn.tuya.repository.QueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueueService {

  private final QueueRepository queueRepository;

  @Transactional
  public void save(String payload) {
    Queue entry = new Queue();
    entry.setPayload(payload);
    this.queueRepository.save(entry);
  }

  @Transactional
  public Queue getNext() {
    return this.queueRepository.findFirstByOrderByIdAsc();
  }

  @Transactional
  public void delete(Long id) {
    this.queueRepository.deleteById(id);
  }
}
