package samuelecastaldo.Progetto_java_settimana_5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;
import samuelecastaldo.Progetto_java_settimana_5.service.PostazioneService;
import samuelecastaldo.Progetto_java_settimana_5.service.PrenotazioniService;
import samuelecastaldo.Progetto_java_settimana_5.service.UtenteService;

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


    }
}
