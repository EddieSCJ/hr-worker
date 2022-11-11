package com.hrworker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableEurekaClient
@EnableJpaRepositories
@SpringBootApplication
class HrWorkerApplication

fun main(args: Array<String>) {
    runApplication<HrWorkerApplication>(*args)
}
