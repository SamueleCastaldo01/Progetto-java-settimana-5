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
    //un controllo che devo fare è che un altro utente in quel giorno non si può prenotare alla stessa postazione allo stesso giorno
    public Prenotazione savePrenotazione(Prenotazione newPrenotazione) {
        Utente us = newPrenotazione.getUtente();
        LocalDate dataPrenotazione = newPrenotazione.getData_prenotazione();

        //controllo se la prenotazione è libera
        //se è null allora vuol dire che è libera
        //Se è presente ma utente è null allora pure vuol dire che è libera e quindi può andare avanti
        Optional<Prenotazione> prenotazioneLibera = prenotazioneRepository.findByDataPrenotazione(dataPrenotazione);

        //questo proprio il controllo che ho scritto sopra per fare la verifica
        //Se questa condizione è vera allora viene lanciata l'eccezione
        if(prenotazioneLibera.isPresent() && prenotazioneLibera.get().getUtente() !=null) {
            throw new IllegalArgumentException("La prenotazione per la data " + dataPrenotazione + " risulta già occupata");
        }

        //qui vado a fare il controllo utente e data, non deve avere più prenotazioni nell stesso giorno
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findByUtenteAndDataPrenotazione(us, dataPrenotazione);

        //controllo effettivo
        if(prenotazioneEsistente.isPresent()) {
            throw new IllegalArgumentException("L'utente " +us.getNomeCompleto() + "ha già la prenotazione in quella data " + newPrenotazione.getData_prenotazione());
        }

        System.out.println("Prenotazione salvata: " +newPrenotazione);
        return prenotazioneRepository.save(newPrenotazione);
    }

}
