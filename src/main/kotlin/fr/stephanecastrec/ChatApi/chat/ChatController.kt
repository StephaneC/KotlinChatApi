package fr.stephanecastrec.ChatApi.chat

import fr.stephanecastrec.ChatApi.utils.randomStr
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class ChatController @Autowired constructor(
        private val messagesDao: ChatDao){

    @GetMapping("/messages")
    fun messages(model: Model): List<Message> {
        return messagesDao.findAll().toList();
    }

    @PostMapping("/messages")
    fun addMessages(@RequestBody message: String): String {
        // add id
        val id = randomStr()
        messagesDao.save(Message(id, message, "USER"));
        return id;
    }

    @DeleteMapping("/messages/{id}")
    fun deleteMessages(@PathVariable id: String): ResponseEntity<Unit> {
        messagesDao.deleteById(id);
        return ResponseEntity.ok().build();
    }

}