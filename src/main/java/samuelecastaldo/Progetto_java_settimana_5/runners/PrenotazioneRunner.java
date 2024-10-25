package samuelecastaldo.Progetto_java_settimana_5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Prenotazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;
import samuelecastaldo.Progetto_java_settimana_5.service.PostazioneService;
import samuelecastaldo.Progetto_java_settimana_5.service.PrenotazioniService;
import samuelecastaldo.Progetto_java_settimana_5.service.UtenteService;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(4)
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioniService prenotazioniService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneService postazioneService;

    @Override
    public void run(String... args) throws Exception {
        //mi vado a prendere degli utenti e delle postazioni, in questo modo posso simulare delle prenotazioni
        //questa cosa che sto facendo non si deve fare mai. Bisogna sempre filtrare, oppure esplode tutto
        List<Utente> utentidb = utenteService.findAllUtenti(); //mi vado a prendere tutti gli utenti del db
        List<Postazione> postazionidb = postazioneService.findAllPostazione(); //mi vado a prendere tutte le postazioni nel db

        //qui in teoria dovrei fare dei controlli, prima di fare questo
        //ma nel mio caso non ci possono essere errori, perché ho gestito i runnare anche attraverso Order
        //questi elementi sicuramente sono presenti
        Utente primoUtente = utentidb.get(0);
        Utente secondoUtente = utentidb.get(1);
        Postazione primaPostazione = postazionidb.get(0);
        Postazione secondaPostazione = postazionidb.get(2);
        Postazione terzaPostazione = postazionidb.get(3);
        LocalDate data1 = LocalDate.of(2024, 10, 10);
        LocalDate data2 = LocalDate.of(2024, 10, 11);
        LocalDate data3 = LocalDate.of(2024, 10, 12);

        Prenotazione pren1 = new Prenotazione(data1, primaPostazione, primoUtente);
        Prenotazione pren2 = new Prenotazione(data2, secondaPostazione, secondoUtente);
        Prenotazione pren3 = new Prenotazione(data3, terzaPostazione, primoUtente);
        Prenotazione pren4 = new Prenotazione(data2, primaPostazione, primoUtente);
        Prenotazione pren5 = new Prenotazione(data1, secondaPostazione, primoUtente); //qui dovrebbe dare errore

        try {
            prenotazioniService.savePrenotazione(pren1);
            prenotazioniService.savePrenotazione(pren2);
            prenotazioniService.savePrenotazione(pren3);
            prenotazioniService.savePrenotazione(pren4);
            prenotazioniService.savePrenotazione(pren5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
