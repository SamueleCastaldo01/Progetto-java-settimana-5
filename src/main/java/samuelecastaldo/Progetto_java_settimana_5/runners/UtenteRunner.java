package samuelecastaldo.Progetto_java_settimana_5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;
import samuelecastaldo.Progetto_java_settimana_5.exception.UsernameEsistenteException;
import samuelecastaldo.Progetto_java_settimana_5.service.UtenteService;

@Component
public class UtenteRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        Utente mario = new Utente("mario", "Mario Rossi", "mario@gmail.com");
        Utente anna = new Utente("anna", "Anna Verdi", "anna@gmail.com");

        try {
            utenteService.saveUtente(mario);
            utenteService.saveUtente(anna);
        } catch (UsernameEsistenteException e) {
            System.out.println(e);
        }

    }
}
