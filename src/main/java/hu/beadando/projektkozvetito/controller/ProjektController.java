package hu.beadando.projektkozvetito.controller;

import hu.beadando.projektkozvetito.model.Projekt;
import hu.beadando.projektkozvetito.repository.ProjektRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projektek") // Ezen az URL-en lesz elérhető
public class ProjektController {

  private final ProjektRepository projektRepository;

  // A Spring automatikusan injektálja a repository-t (Dependency Injection)
  public ProjektController(ProjektRepository projektRepository) {
    this.projektRepository = projektRepository;
  }

  // CREATE (Létrehozás) - POST kérés
  @PostMapping
  public Projekt createProjekt(@RequestBody Projekt projekt) {
    return projektRepository.save(projekt);
  }

  // READ (Olvasás) - Az összes projekt lekérése - GET kérés
  @GetMapping
  public List<Projekt> getAllProjektek() {
    return projektRepository.findAll();
  }

  // READ (Olvasás) - Egyetlen projekt lekérése ID alapján
  @GetMapping("/{id}")
  public Projekt getProjektById(@PathVariable Long id) {
    return projektRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Projekt nem található ezzel az ID-val: " + id));
  }

  // UPDATE (Frissítés) - PUT kérés
  @PutMapping("/{id}")
  public Projekt updateProjekt(@PathVariable Long id, @RequestBody Projekt frissitettProjekt) {
    return projektRepository.findById(id)
        .map(projekt -> {
          projekt.setCim(frissitettProjekt.getCim());
          projekt.setLeiras(frissitettProjekt.getLeiras());
          projekt.setOraber(frissitettProjekt.getOraber());
          projekt.setTavmunka(frissitettProjekt.isTavmunka());
          return projektRepository.save(projekt);
        })
        .orElseThrow(() -> new RuntimeException("Projekt nem található!"));
  }

  // DELETE (Törlés) - DELETE kérés
  @DeleteMapping("/{id}")
  public void deleteProjekt(@PathVariable Long id) {
    projektRepository.deleteById(id);
  }
}