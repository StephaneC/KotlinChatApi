package fr.stephanecastrec.ChatApi.users

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersDao: CrudRepository<User, String> {}