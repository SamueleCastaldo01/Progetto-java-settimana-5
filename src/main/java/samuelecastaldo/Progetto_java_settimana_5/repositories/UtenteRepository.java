package samuelecastaldo.Progetto_java_settimana_5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {
    Optional<Utente> findByUsername(String username);
}
