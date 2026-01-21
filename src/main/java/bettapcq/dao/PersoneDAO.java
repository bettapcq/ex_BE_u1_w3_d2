package bettapcq.dao;


import bettapcq.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersoneDAO {
    private final EntityManager entityManager;

    public PersoneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona nuovaPersona) {
        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.aggiunta dell'entità al PersistentContext (la rendiamo "managed"):
        entityManager.persist(nuovaPersona);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("L'aggiunta della persona con id " + nuovaPersona.getIdPersona() + " è avvenuta con successo!");
    }
}
