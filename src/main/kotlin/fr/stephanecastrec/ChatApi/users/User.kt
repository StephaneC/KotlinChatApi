package fr.stephanecastrec.ChatApi.users

import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@RedisHash("User")
data class User(
        val id: String,
        val username: String,
        val pwd: String,
        val ts: Long = Instant.now().toEpochMilli())