package hu.beadando.projektkozvetito.model;

import jakarta.persistence.*;

@Entity
public class Projekt {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cim;
  private String leiras;
  private Integer oraber;
  private boolean tavmunka;

  // Összekötés a Munkaado táblával
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "munkaado_id")
  private Munkaado munkaado;

  // Összekötés a Kategoria táblával
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "kategoria_id")
  private Kategoria kategoria;

  public Projekt() {
  }

  // Getterek és Setterek
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getCim() { return cim; }
  public void setCim(String cim) { this.cim = cim; }

  public String getLeiras() { return leiras; }
  public void setLeiras(String leiras) { this.leiras = leiras; }

  public Integer getOraber() { return oraber; }
  public void setOraber(Integer oraber) { this.oraber = oraber; }

  public boolean isTavmunka() { return tavmunka; }
  public void setTavmunka(boolean tavmunka) { this.tavmunka = tavmunka; }

  public Munkaado getMunkaado() { return munkaado; }
  public void setMunkaado(Munkaado munkaado) { this.munkaado = munkaado; }

  public Kategoria getKategoria() { return kategoria; }
  public void setKategoria(Kategoria kategoria) { this.kategoria = kategoria; }
}