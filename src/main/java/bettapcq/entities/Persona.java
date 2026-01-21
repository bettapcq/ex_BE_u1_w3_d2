package bettapcq.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    @Column(name = "id_persona")
    private UUID idPersona;
    @Column(name = "nome_persona")
    private String nomePersona;
    @Column(name = "cognome_persona")
    private String cognomePersona;
    @Column(name = "email")
    private String email;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @Column(name = "sesso")
    @Enumerated(EnumType.STRING)
    private TipiSesso sesso;


    @OneToMany(mappedBy = "partecipante")
    private List<Partecipazione> partecipazioni;

    public Persona() {

    }

    public Persona(String nomePersona, String cognomePersona, String email, LocalDate dataNascita, TipiSesso sesso) {
        this.nomePersona = nomePersona;
        this.cognomePersona = cognomePersona;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }

    public UUID getIdPersona() {
        return idPersona;
    }


    public String getNomePersona() {
        return nomePersona;
    }

    public void setNomePersona(String nomePersona) {
        this.nomePersona = nomePersona;
    }

    public String getCognomePersona() {
        return cognomePersona;
    }

    public void setCognomePersona(String cognomePersona) {
        this.cognomePersona = cognomePersona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public TipiSesso getSesso() {
        return sesso;
    }

    public void setSesso(TipiSesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nomePersona='" + nomePersona + '\'' +
                ", cognomePersona='" + cognomePersona + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso=" + sesso +
                '}';
    }
}
