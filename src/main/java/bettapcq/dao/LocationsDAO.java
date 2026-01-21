package bettapcq.dao;

import bettapcq.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationsDAO {
    private final EntityManager entityManager;

    public LocationsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location nuovaLocation) {
        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.aggiunta dell'entità al PersistentContext (la rendiamo "managed"):
        entityManager.persist(nuovaLocation);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("L'aggiunta della location con id " + nuovaLocation.getIdLocation() + " è avvenuta con successo!");
    }
}
