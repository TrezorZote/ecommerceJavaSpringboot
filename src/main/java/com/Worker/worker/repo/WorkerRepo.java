package com.Worker.worker.repo;


import com.Worker.worker.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {

    Optional<Worker> findWorkerById(Long id);

}
