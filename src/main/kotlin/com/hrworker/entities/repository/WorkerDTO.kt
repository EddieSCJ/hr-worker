package com.hrworker.entities.repository

import com.hrworker.entities.Worker
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tb_worker")
data class WorkerDTO(
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val dailyIncome: Double
) {
        fun toEntity(): Worker = Worker(id, name, dailyIncome)
}