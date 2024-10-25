package samuelecastaldo.Progetto_java_settimana_5.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Edificio;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.enu.TipoPostazione;
import samuelecastaldo.Progetto_java_settimana_5.exception.PostazioneNonTrovataException;
import samuelecastaldo.Progetto_java_settimana_5.service.EdificioService;
import samuelecastaldo.Progetto_java_settimana_5.service.PostazioneService;

import java.util.List;

@Component
@Order(3)
public class PostazioneRunner implements CommandLineRunner {

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        List<Edificio> edifici = edificioService.findAllEdifici(); //vado a prendere tutti gli edifici dal database
        // sta meglio mai farla, perché se abbiamo un milione di edifici esplode tutto.

        //qui in teoria ci vorebbe un controllo per vedere se ci sono almeno più di 5 elementi
        List<Edificio> primi5 = edifici.subList(0, 5);

        //qui dentro andiamo a creare 3 postazioni per ogni edificio
        for(Edificio edificio : primi5) {
            for(int i = 1; i<=3; i++) {
                Postazione postazione = new Postazione();
                postazione.setDescrizione("Postazione " + i + " in " + edificio.getNome());
                postazione.setTipo(TipoPostazione.OPENSPACE);
                postazione.setN_max_persone(5);
                postazione.setEdificio(edificio);

                postazioneService.savePostazione(postazione);
            }
        }

        //la prova la faccio qui per scocciature, basta che funziona. Anche se sta scritto che deve essere l'utente a farlo
        try {
            List<Postazione> resultPostazioni = postazioneService.findByTipoAndCity(TipoPostazione.OPENSPACE, "Napoli");
            for (Postazione postazione : resultPostazioni) {
                System.out.println(postazione);
            }
        } catch (PostazioneNonTrovataException e) {
            System.out.println(e.getMessage());
        }




    }
}
