package tech.zohari.ktgradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.Banner

@SpringBootApplication
class KtgradleApplication

fun main(args: Array<String>) {// @Generated

	runApplication<KtgradleApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}