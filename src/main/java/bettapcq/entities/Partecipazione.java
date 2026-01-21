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

    public UUID getIdPartecipazione() {
        return idPartecipazione;
    }

    public void setIdPartecipazione(UUID idPartecipazione) {
        this.idPartecipazione = idPartecipazione;
    }

    public TipiStato getStato() {
        return stato;
    }

    public void setStato(TipiStato stato) {
        this.stato = stato;
    }

    public Persona getPartecipante() {
        return partecipante;
    }

    public void setPartecipante(Persona partecipante) {
        this.partecipante = partecipante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "idPartecipazione=" + idPartecipazione +
                ", stato=" + stato +
                ", evento=" + evento +
                ", partecipante=" + partecipante +
                '}';
    }
}
