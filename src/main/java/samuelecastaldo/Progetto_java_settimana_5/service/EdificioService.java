package samuelecastaldo.Progetto_java_settimana_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Edificio;
import samuelecastaldo.Progetto_java_settimana_5.repositories.EdificioRepository;

import java.util.List;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public Edificio saveEdificio(Edificio newEdificio) {
        System.out.println("Edificio salvato: " +newEdificio);
        return edificioRepository.save(newEdificio);
    }

    public List<Edificio> findAllEdifici() {
        return edificioRepository.findAll();
    }
}
