package ru.levchenko.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.levchenko.service.models.User;

import java.util.Optional;
@Component
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);

}
