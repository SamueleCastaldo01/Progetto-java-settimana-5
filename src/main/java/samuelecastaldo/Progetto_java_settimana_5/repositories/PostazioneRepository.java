package samuelecastaldo.Progetto_java_settimana_5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.enu.TipoPostazione;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoAndEdificio_City(TipoPostazione tipo, String city);
}
