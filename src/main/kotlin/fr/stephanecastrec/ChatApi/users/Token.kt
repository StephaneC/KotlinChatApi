package fr.stephanecastrec.ChatApi.users

import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@RedisHash("Token")
data class Token(
        val id: String,
        val userId: String,
        val ts: Long = Instant.now().toEpochMilli())