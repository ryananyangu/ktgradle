package tech.zohari.ktgradle.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloWorld {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Hello Ryan"
        return "hello"
    }
}
