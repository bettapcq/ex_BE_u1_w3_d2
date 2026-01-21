package bettapcq.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    @Column(name = "id_partecipazione")
    private UUID idPartecipazione;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipiStato stato;


    @ManyToOne
    @JoinColumn(name = "id_evento", unique = true, nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona partecipante;

}
