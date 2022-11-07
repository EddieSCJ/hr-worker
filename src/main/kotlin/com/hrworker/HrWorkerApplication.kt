package com.hrworker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class HrWorkerApplication

fun main(args: Array<String>) {
    runApplication<HrWorkerApplication>(*args)
}
