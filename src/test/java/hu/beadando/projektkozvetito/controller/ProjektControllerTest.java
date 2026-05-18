package hu.beadando.projektkozvetito.controller;

import hu.beadando.projektkozvetito.model.Projekt;
import hu.beadando.projektkozvetito.repository.ProjektRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjektControllerTest {

  @Mock
  private ProjektRepository projektRepository;

  @InjectMocks
  private ProjektController projektController;

  @Test
  public void testGetAllProjektek() {
    Projekt tesztProjekt = new Projekt();
    tesztProjekt.setCim("Teszt Munka");
    when(projektRepository.findAll()).thenReturn(Arrays.asList(tesztProjekt));

    List<Projekt> eredmeny = projektController.getAllProjektek();

    assertEquals(1, eredmeny.size());
    assertEquals("Teszt Munka", eredmeny.get(0).getCim());
  }

  @Test
  public void testCreateProjekt() {
    Projekt ujProjekt = new Projekt();
    ujProjekt.setCim("Uj munka");
    when(projektRepository.save(any(Projekt.class))).thenReturn(ujProjekt);

    Projekt elmentettProjekt = projektController.createProjekt(ujProjekt);

    assertNotNull(elmentettProjekt);
    assertEquals("Uj munka", elmentettProjekt.getCim());
  }

  @Test
  public void testGetProjektById() {
    Projekt tesztProjekt = new Projekt();
    tesztProjekt.setCim("Keresett munka");
    // Mockoljuk, hogy az adatbázis megtalálja az 1-es ID-jú elemet
    when(projektRepository.findById(1L)).thenReturn(Optional.of(tesztProjekt));

    Projekt eredmeny = projektController.getProjektById(1L);

    assertEquals("Keresett munka", eredmeny.getCim());
  }

  @Test
  public void testUpdateProjekt() {
    Projekt meglevoProjekt = new Projekt();
    meglevoProjekt.setCim("Regi cim");

    Projekt frissitettAdatok = new Projekt();
    frissitettAdatok.setCim("Frissitett cim");

    when(projektRepository.findById(1L)).thenReturn(Optional.of(meglevoProjekt));
    when(projektRepository.save(any(Projekt.class))).thenReturn(meglevoProjekt);

    Projekt eredmeny = projektController.updateProjekt(1L, frissitettAdatok);

    assertEquals("Frissitett cim", eredmeny.getCim());
  }

  @Test
  public void testDeleteProjekt() {
    // Cselekvés: Törlünk egy elemet
    projektController.deleteProjekt(1L);

    // Ellenőrzés: Megnézzük, hogy a deleteById metódus pontosan egyszer lefutott-e az adatbázison
    verify(projektRepository, times(1)).deleteById(1L);
  }
}