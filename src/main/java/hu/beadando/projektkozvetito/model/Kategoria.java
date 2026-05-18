package hu.beadando.projektkozvetito.model;

import jakarta.persistence.*;

@Entity
public class Kategoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nev; // pl. "Szoftverfejlesztés", "Grafika"

  public Kategoria() {
  }

  public Kategoria(String nev) {
    this.nev = nev;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNev() { return nev; }
  public void setNev(String nev) { this.nev = nev; }
}