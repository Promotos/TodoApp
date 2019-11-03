package de.promotos.todoapp.repository

import de.promotos.todoapp.entity.User
import de.promotos.todoapp.repositories.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository) {

    @Test
    fun `When findByLogin then return User`() {
        val john = User("springJohn", "John", "Doe")
        entityManager.persist(john)
        entityManager.flush()
        val user = userRepository.findByLogin(john.login)
        assertThat(user).isEqualTo(john)
    }
}