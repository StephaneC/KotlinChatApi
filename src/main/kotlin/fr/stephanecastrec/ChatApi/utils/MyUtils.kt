package fr.stephanecastrec.ChatApi.utils

import java.security.MessageDigest
import java.util.concurrent.ThreadLocalRandom
import kotlin.streams.asSequence

private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun randomStr(): String {
    return ThreadLocalRandom.current()
            .ints(10L, 0, charPool.size)
            .asSequence()
            .map(charPool::get)
            .joinToString("")
}

fun hashString(input: String, type: String = "SHA-256"): String {
    val HEX_CHARS = "0123456789ABCDEF"
    val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
    val result = StringBuilder(bytes.size * 2)

    bytes.forEach {
        val i = it.toInt()
        result.append(HEX_CHARS[i shr 4 and 0x0f])
        result.append(HEX_CHARS[i and 0x0f])
    }

    return result.toString()
}