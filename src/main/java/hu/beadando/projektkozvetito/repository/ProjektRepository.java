package hu.beadando.projektkozvetito.repository;

import hu.beadando.projektkozvetito.model.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjektRepository extends JpaRepository<Projekt, Long> {
}