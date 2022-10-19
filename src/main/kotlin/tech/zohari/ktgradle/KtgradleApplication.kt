package tech.zohari.ktgradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtgradleApplication

fun main(args: Array<String>) {
	runApplication<KtgradleApplication>(*args)
}