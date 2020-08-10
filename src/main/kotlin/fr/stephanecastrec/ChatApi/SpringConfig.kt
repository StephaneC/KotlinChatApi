package fr.stephanecastrec.ChatApi

import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate


@SpringBootConfiguration
class SpringConfig {

    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        val config = RedisStandaloneConfiguration("localhost", 6379)
        val jedisConFactory = JedisConnectionFactory(config)

        return jedisConFactory
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String?, Any?>? {
        val template: RedisTemplate<String?, Any?> = RedisTemplate()
        template.setConnectionFactory(jedisConnectionFactory())
        return template
    }
}