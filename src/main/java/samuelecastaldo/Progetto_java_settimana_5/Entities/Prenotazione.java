package samuelecastaldo.Progetto_java_settimana_5.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate data_prenotazione;
    @ManyToOne  //una prenotazione può essere associata ad una sola postazione, ma una postazioni può avere più prenotazioni
    @JoinColumn(name = "id_postazione", nullable = false)
    private Postazione postazione;
    @ManyToOne  //una prenotazione è associata ad un solo utente, un utente può fare più prenotazioni diverse giornate
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public Prenotazione() {}

    public Prenotazione(long id, LocalDate data_prenotazione, Postazione postazione, Utente utente) {
        this.id = id;
        this.data_prenotazione = data_prenotazione;
        this.postazione = postazione;
        this.utente = utente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData_prenotazione() {
        return data_prenotazione;
    }

    public void setData_prenotazione(LocalDate data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", data_prenotazione=" + data_prenotazione +
                ", postazione=" + postazione +
                ", utente=" + utente +
                '}';
    }
}
