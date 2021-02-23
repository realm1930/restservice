package be.vdab.restservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@Entity
@Table(name = "filialen")
public class Filiaal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private String gemeente;
    private BigDecimal omzet;

    public Filiaal(String naam, String gemeente, BigDecimal omzet) {
        this.naam = naam;
        this.gemeente = gemeente;
        this.omzet = omzet;
    }

    protected Filiaal() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public BigDecimal getOmzet() {
        return omzet;
    }
}
