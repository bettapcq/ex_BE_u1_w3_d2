package bettapcq.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private long idLocation;

    @Column(name = "nome_location")
    private String nomeLocation;

    @Column(name = "citta")
    private String città;


    @ManyToMany(mappedBy = "locations")
    private List<Partecipazione> partecipazioni;

    public Location() {

    }

    public Location(String nomeLocation, String città) {
        this.nomeLocation = nomeLocation;
        this.città = città;
    }

    public long getIdLocation() {
        return idLocation;
    }

    public String getNomeLocation() {
        return nomeLocation;
    }

    public void setNomeLocation(String nomeLocation) {
        this.nomeLocation = nomeLocation;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", nomeLocation='" + nomeLocation + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
