package com.hrworker.handler

import com.hrworker.entities.Worker
import com.hrworker.repository.WorkerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/workers")
class WorkerHandler(
    @Value("\${test.config}") private val testConfig: String,
    private val workerRepository: WorkerRepository,
    private val env: Environment
) {
    private val logger = LoggerFactory.getLogger(WorkerHandler::class.java)
    @GetMapping
    fun findAll(): ResponseEntity<List<Worker>> = ResponseEntity.ok(workerRepository.findAll().map { it.toEntity() })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Worker> {
        logger.info("PORT = ${env.getProperty("local.server.port")}")

        val worker = workerRepository.findById(id)
        return when (worker.isPresent) {
            true -> ResponseEntity.ok(worker.get().toEntity())
            false -> ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/configs")
    fun getConfigs(): ResponseEntity<Void> {
        logger.info("CONFIG = $testConfig")
        return ResponseEntity.noContent().build()
    }
}