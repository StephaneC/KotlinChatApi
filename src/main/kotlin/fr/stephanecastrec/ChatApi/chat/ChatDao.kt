package fr.stephanecastrec.ChatApi.chat

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatDao: CrudRepository<Message, String> {}