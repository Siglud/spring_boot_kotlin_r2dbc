package org.acgeek.jerk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
class JerkApplication

fun main(args: Array<String>) {
    runApplication<JerkApplication>(*args)
}
