package samuelecastaldo.Progetto_java_settimana_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;
import samuelecastaldo.Progetto_java_settimana_5.exception.UsernameEsistenteException;
import samuelecastaldo.Progetto_java_settimana_5.repositories.UtenteRepository;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    //vado a lanciare un eccezione nel caso in cui lo username è già presente, anche se il controllo ci stava già di
    // default perché è un id
    public Utente saveUtente(Utente newUtente) {
        if(utenteRepository.findByUsername(newUtente.getUsername()).isPresent()) {
            throw new UsernameEsistenteException("Questo username è già presente");
        }
         return utenteRepository.save(newUtente);
    }
}
