package ru.itmo.hls.cronservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class CronServiceApplication

fun main(args: Array<String>) {
    runApplication<CronServiceApplication>(*args)
}
