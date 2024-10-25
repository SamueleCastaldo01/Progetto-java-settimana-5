package samuelecastaldo.Progetto_java_settimana_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Edificio;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
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
        return postazioneRepository.save(newPostazione);
    }

    public List<Postazione> findAllPostazione() {
        return postazioneRepository.findAll();
    }
}
