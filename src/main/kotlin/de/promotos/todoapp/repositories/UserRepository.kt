package de.promotos.todoapp.repositories

import de.promotos.todoapp.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}