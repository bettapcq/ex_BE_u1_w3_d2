package bettapcq.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

//annotazioni:
@Entity
@Table(name = "eventi")

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "dataEvento")
    private LocalDate dataEvento;

    @Column(name = "descrizione", columnDefinition = "TEXT")
    private String descrizione;

    @Column(name = "tipoEvento")
    @Enumerated(EnumType.STRING)
    private tipiEvento tipoEvento;

    @Column(name = "numeroMassimoPartecipanti")
    private long numeroMassimoPartecipanti;


    //costruttore vuoto:
    public Evento() {

    }

    //costruttore classico:
    public Evento(String titolo, LocalDate dataEvento, String descrizione, tipiEvento tipoEvento, long numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public tipiEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(tipiEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
