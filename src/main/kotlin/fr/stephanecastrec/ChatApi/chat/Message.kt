package fr.stephanecastrec.ChatApi.chat

import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@RedisHash("Message")
data class Message(
        val id: String,
        val message: String,
        val user: String,
        val ts: Long = Instant.now().toEpochMilli())