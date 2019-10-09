package ru.levchenko.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.service.models.Product;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findOneByOwnerId(Long id);

    Optional<Product> findOneByName(Long id);
}
