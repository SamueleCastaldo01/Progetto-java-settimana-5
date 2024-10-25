package samuelecastaldo.Progetto_java_settimana_5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import samuelecastaldo.Progetto_java_settimana_5.service.PrenotazioniService;

@Component
@Order(4)
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioniService prenotazioniService;

    @Override
    public void run(String... args) throws Exception {

    }
}
