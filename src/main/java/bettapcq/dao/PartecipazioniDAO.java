package bettapcq.dao;

import bettapcq.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioniDAO {
    private final EntityManager entityManager;

    public PartecipazioniDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione nuovaPartecipazione) {
        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.aggiunta dell'entità al PersistentContext (la rendiamo "managed"):
        entityManager.persist(nuovaPartecipazione);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("L'aggiunta della partecipazione con id " + nuovaPartecipazione.getIdPartecipazione() + " è avvenuta con successo!");
    }
}
