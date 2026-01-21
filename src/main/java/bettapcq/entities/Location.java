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


    @ManyToMany(mappedBy = "location")
    private List<Partecipazione> partecipazioni;

}
