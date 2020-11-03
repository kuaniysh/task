package com.task.beeline

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeelineApplication

fun main(args: Array<String>) {
	runApplication<BeelineApplication>(*args)
}
