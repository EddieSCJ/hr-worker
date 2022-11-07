package com.hrworker.repository

import com.hrworker.entities.repository.WorkerDTO
import org.springframework.data.jpa.repository.JpaRepository

interface WorkerRepository : JpaRepository<WorkerDTO, Long>