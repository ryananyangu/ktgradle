package tech.zohari.ktgradle

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtgradleApplication

fun main(args: Array<String>) { // @Generated

    @Suppress("SpreadOperator")
    runApplication<KtgradleApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
