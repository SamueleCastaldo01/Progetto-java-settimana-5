package samuelecastaldo.Progetto_java_settimana_5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Postazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Prenotazione;
import samuelecastaldo.Progetto_java_settimana_5.Entities.Utente;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

    Optional<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);
}
