package bettapcq.dao;

import bettapcq.entities.Evento;
import bettapcq.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    private final EntityManager entityManager;

    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //metodo save:

    public void save(Evento nuovoEvento) {
        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.aggiunta dell'entità al PersistentContext (la rendiamo "managed"):
        entityManager.persist(nuovoEvento);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("L'aggiunta dell' evento con id " + nuovoEvento.getId() + " è avvenuta con successo!");
    }

    //metodo getById:

    public Evento getById(long idToSearch) {
        //questo metodo ritorna direttamente un'entità "managed":
        Evento result = entityManager.find(Evento.class, idToSearch);
        if (result == null) throw new NotFoundException(idToSearch);
        return result;
    }

    //metodo deleteById:

    public void deleteById(long idToSearch) {
        //0.ricerca dell'Id nel DB (automaticamente "managed"):
        Evento result = this.getById(idToSearch);

        //1.richiesta nuova transazione:
        EntityTransaction transaction = entityManager.getTransaction();

        //2.avvio transazione:
        transaction.begin();

        //3.rimozione dell'entità dal PersistentContext:
        entityManager.remove(result);

        //4.committiamo la modifica nel DB:
        transaction.commit();

        //5.msg di avvenuta operazione:
        System.out.println("La rimozione dell' evento con id " + idToSearch + " è avvenuta con successo!");
    }
}
