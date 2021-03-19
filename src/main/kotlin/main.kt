package MyFirstSpring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TesteApplication

fun main() {
    runApplication<TesteApplication>()
}