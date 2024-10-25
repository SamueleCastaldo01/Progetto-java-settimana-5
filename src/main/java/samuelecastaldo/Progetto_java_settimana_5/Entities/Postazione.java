package samuelecastaldo.Progetto_java_settimana_5.Entities;

import jakarta.persistence.*;
import samuelecastaldo.Progetto_java_settimana_5.Entities.enu.TipoPostazione;

@Entity
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue
    private long id;
    private String descrizione;
    private TipoPostazione tipo;
    private int n_max_persone;
    @ManyToOne   //un edificio può avere più postazioni, mentre una postazione è associata solo ad un edificio
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione() {}

    public Postazione(String descrizione, TipoPostazione tipo, int n_max_persone, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.n_max_persone = n_max_persone;
        this.edificio = edificio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoPostazione getTipo() {
        return tipo;
    }

    public void setTipo(TipoPostazione tipo) {
        this.tipo = tipo;
    }

    public int getN_max_persone() {
        return n_max_persone;
    }

    public void setN_max_persone(int n_max_persone) {
        this.n_max_persone = n_max_persone;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", n_max_persone=" + n_max_persone +
                ", edificio=" + edificio +
                '}';
    }
}
