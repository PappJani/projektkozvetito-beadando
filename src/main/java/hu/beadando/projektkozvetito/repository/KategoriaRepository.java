package hu.beadando.projektkozvetito.repository;

import hu.beadando.projektkozvetito.model.Kategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriaRepository extends JpaRepository<Kategoria, Long> {
}