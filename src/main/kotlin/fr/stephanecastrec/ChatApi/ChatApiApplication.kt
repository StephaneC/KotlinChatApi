package fr.stephanecastrec.ChatApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ChatApiApplication


fun main(args: Array<String>) {
	runApplication<ChatApiApplication>(*args)
}
