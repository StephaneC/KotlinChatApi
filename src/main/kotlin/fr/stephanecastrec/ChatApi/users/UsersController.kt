package fr.stephanecastrec.ChatApi.users

import fr.stephanecastrec.ChatApi.utils.hashString
import fr.stephanecastrec.ChatApi.utils.randomStr
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class UsersController @Autowired constructor(
        private val usersDao: UsersDao,
        private val tokenDao: TokenDao){

    @GetMapping("/users")
    fun users(@RequestHeader token: String): List<User> {
        return usersDao.findAll().toList();
    }

    @PostMapping("/users")
    fun addUser(@RequestParam username: String, @RequestParam pwd: String): ResponseEntity<String> {
        println("create user : " + username)

        // check if user exist
        val found = usersDao.findAll().find { it.username.equals(username, ignoreCase = true) }
        // if not found
        if (found === null) {
            // add it
            val id = randomStr()
            usersDao.save(User(id, username, hashString(pwd)));
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Unit> {
        usersDao.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    fun connect(@RequestParam username: String, @RequestParam pwd: String): ResponseEntity<String> {
        val found = usersDao.findAll().find { it.username.equals(username, ignoreCase = true) }
        if (found != null && hashString(pwd).equals(found.pwd)) {
            val token = Token(randomStr(), found.id);
            tokenDao.save(token)
            println("User connected : " + username)
            return ResponseEntity.ok(token.id)
        }
        println("username not found : " + username)
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}