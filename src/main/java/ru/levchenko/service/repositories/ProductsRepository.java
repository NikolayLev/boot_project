package ru.levchenko.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.service.models.Product;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findOneByOwnerId(Long id);

    Optional<Product> findOneByName(Long id);

    List<Product> findAllByStatus(State state);

    List<Product> findAllByStatusAndOwner(State state, User user);
}
