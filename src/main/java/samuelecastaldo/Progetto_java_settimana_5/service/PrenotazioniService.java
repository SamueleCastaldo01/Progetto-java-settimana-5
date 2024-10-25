package samuelecastaldo.Progetto_java_settimana_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Prenotazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;
import samuelecastaldo.Progetto_java_settimana_5.repositories.PrenotazioneRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioniService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioniService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    //allora qui dovrei fare i vari controlli, per la data e se è libero prima di prenotare
    //ci vorrebbe anche un update nel caso in cui ci sta una libera, e l'utente ha la possibilità di inserirsi
    public Prenotazione savePrenotazione(Prenotazione newPrenotazione) {
        Utente us = newPrenotazione.getUtente();
        LocalDate dataPrenotazione = newPrenotazione.getData_prenotazione();

        //qui vado a fare il controllo utente e data, non deve avere più prenotazioni nell stesso giorno
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findByUtenteAndDataPrenotazione(us, dataPrenotazione);

        //controllo effettivo
        if(prenotazioneEsistente.isPresent()) {
            throw new IllegalArgumentException("L'utente " +us.getNomeCompleto() + "ha già la prenotazione in quella data " + newPrenotazione.getData_prenotazione());
        }

        return prenotazioneRepository.save(newPrenotazione);
    }

}
