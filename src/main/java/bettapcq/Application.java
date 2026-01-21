package bettapcq;

import bettapcq.dao.EventiDAO;
import bettapcq.dao.LocationsDAO;
import bettapcq.dao.PartecipazioniDAO;
import bettapcq.dao.PersoneDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    //connessione al DB tramite apertura EntityManagerFactory:
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi2pu");

    public static void main(String[] args) {

        System.out.println("Hello world!");
//oggetto per la gestione delle comunicazioni con DB:
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //richiamo il DAO:
        EventiDAO eventiDAO = new EventiDAO(entityManager);
        LocationsDAO locationsDAO = new LocationsDAO(entityManager);
        PartecipazioniDAO partecipazioniDAO = new PartecipazioniDAO(entityManager);
        PersoneDAO personeDAO = new PersoneDAO(entityManager);


//        //creazione istanze:
//        Evento fieraPassito = new Evento("Fiera del Passito",
//                LocalDate.of(2026, 9, 21),
//                "Fiera internazionale del pregiato Passito di Caluso",
//                tipiEvento.PUBBLICO,
//                1500);
//        Evento mostraMAO = new Evento("I samurai, tra storia e leggende",
//                LocalDate.of(2026, 3, 10),
//                "Scopri una delle più antiche tradizioni Giapponesi al MAO",
//                tipiEvento.PRIVATO,
//                80);
//
//        Evento concertoJazz = new Evento("Serata Jazz sotto le stelle",
//                LocalDate.of(2026, 6, 21),
//                "Un'indimenticabile esibizione di musica jazz dal vivo in Piazza Castello",
//                tipiEvento.PUBBLICO,
//                120);
//
//        Evento workshopRobotica = new Evento("Workshop di Robotica Educativa",
//                LocalDate.of(2026, 4, 05),
//                "Laboratorio pratico per ragazzi e adulti nel museo della scienza",
//                tipiEvento.PUBBLICO,
//                50);
//
//        Evento cenaAlBuio = new Evento("Cena al buio",
//                LocalDate.of(2026, 5, 15),
//                "Un percorso gastronomico sensoriale esclusivo",
//                tipiEvento.PRIVATO,
//                150);

//        //agguinta rows del BD (METODO SAVE) :
//        eventiDAO.save(fieraPassito);
//        eventiDAO.save(mostraMAO);
//        eventiDAO.save(concertoJazz);
//        eventiDAO.save(workshopRobotica);
//        eventiDAO.save(cenaAlBuio);


// chiusura EntityManager, EntityManagerFactory:
        entityManager.close();
        entityManagerFactory.close();

    }


}
