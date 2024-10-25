package samuelecastaldo.Progetto_java_settimana_5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
