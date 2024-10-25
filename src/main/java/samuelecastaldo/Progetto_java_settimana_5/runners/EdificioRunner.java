package samuelecastaldo.Progetto_java_settimana_5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Edificio;
import samuelecastaldo.Progetto_java_settimana_5.service.EdificioService;

@Component
@Order(1)
public class EdificioRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        Edificio ed1 = new Edificio("ed1", "Indirizzo 1", "Napoli");
        Edificio ed2 = new Edificio("ed2", "Indirizzo 2", "Roma");
        Edificio ed3 = new Edificio("ed3", "Indirizzo 3", "Milano");
        Edificio ed4 = new Edificio("ed4", "Indirizzo 4", "Torino");
        Edificio ed5 = new Edificio("ed5", "Indirizzo 5", "Genova");
        Edificio ed6 = new Edificio("ed6", "Indirizzo 6", "Caserta");
        Edificio ed7 = new Edificio("ed7", "Indirizzo 7", "Venezia");
        Edificio ed8 = new Edificio("ed8", "Indirizzo 8", "Firenze");

        edificioService.saveEdificio(ed1);
        edificioService.saveEdificio(ed2);
        edificioService.saveEdificio(ed3);
        edificioService.saveEdificio(ed4);
        edificioService.saveEdificio(ed5);
        edificioService.saveEdificio(ed6);
        edificioService.saveEdificio(ed7);
        edificioService.saveEdificio(ed8);
    }
}
