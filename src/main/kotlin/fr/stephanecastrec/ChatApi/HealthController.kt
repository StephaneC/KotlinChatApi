package fr.stephanecastrec.ChatApi

import fr.stephanecastrec.ChatApi.utils.randomStr
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class HealthController {

    @GetMapping("/")
    fun health(model: Model): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}