package MyFirstSpring.controllers

import com.fasterxml.jackson.databind.util.JSONPObject
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/number", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class NumberController {

    @GetMapping("/verificarExtenso")
    fun verificarExtenso(number: Int): MutableMap<String, String> {
        return Collections.singletonMap("extenso",NumbersUtil.readNumberExtensive(number))
    }
}