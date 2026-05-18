package hu.beadando.projektkozvetito.model;

import jakarta.persistence.*;

@Entity // Ez jelzi a Springnek, hogy ez egy adatbázis tábla lesz
public class Munkaado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nev;

  // A hirdető cégek lokációja, például Nyíregyháza, Nyírbátor, Mátészalka stb.
  private String szekhely;

  private String email;

  // Később ide kerül a kapcsolat a Projektekkel!

  // Üres konstruktor (a JPA-nak kötelező)
  public Munkaado() {
  }

  public Munkaado(String nev, String szekhely, String email) {
    this.nev = nev;
    this.szekhely = szekhely;
    this.email = email;
  }

  // Getterek és Setterek
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNev() { return nev; }
  public void setNev(String nev) { this.nev = nev; }

  public String getSzekhely() { return szekhely; }
  public void setSzekhely(String szekhely) { this.szekhely = szekhely; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}