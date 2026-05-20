package hu.beadando.projektkozvetito.controller;

import hu.beadando.projektkozvetito.model.Kategoria;
import hu.beadando.projektkozvetito.repository.KategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kategoriak")
public class KategoriaController {

  @Autowired
  private KategoriaRepository kategoriaRepository;

  // LEKÉRÉS (GET) - Összes kategória listázása
  @GetMapping
  public List<Kategoria> getAllKategoria() {
    return kategoriaRepository.findAll();
  }

  // LÉTREHOZÁS (POST) - Új kategória mentése
  @PostMapping
  public Kategoria createKategoria(@RequestBody Kategoria kategoria) {
    return kategoriaRepository.save(kategoria);
  }

  // UPDATE (PUT) - Létező kategória módosítása ID alapján
  @PutMapping("/{id}")
  public Kategoria updateKategoria(@PathVariable Long id, @RequestBody Kategoria frissitettKategoria) {
    return kategoriaRepository.findById(id)
        .map(kategoria -> {
          kategoria.setNev(frissitettKategoria.getNev());
          return kategoriaRepository.save(kategoria);
        })
        .orElseThrow(() -> new RuntimeException("Kategoria nem talalhato ezzel az id-val: " + id));
  }
}