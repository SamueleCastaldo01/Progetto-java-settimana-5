package samuelecastaldo.Progetto_java_settimana_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Edificio;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.enu.TipoPostazione;
import samuelecastaldo.Progetto_java_settimana_5.exception.PostazioneNonTrovataException;
import samuelecastaldo.Progetto_java_settimana_5.repositories.PostazioneRepository;

import java.util.List;

@Service
public class PostazioneService {
    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public Postazione savePostazione(Postazione newPostazione) {
        System.out.println("Postazione Salvata: " + newPostazione);
        return postazioneRepository.save(newPostazione);
    }

    public List<Postazione> findAllPostazione() {
        return postazioneRepository.findAll();
    }

    public List<Postazione> findByTipoAndCity(TipoPostazione tipoPost, String city) {
        List<Postazione> result = postazioneRepository.findByTipoAndEdificio_City(tipoPost, city);
        if(result.isEmpty()) {
            throw new PostazioneNonTrovataException("Nessuna postazione trovata");
        }
        return result;
    }

}
