package samuelecastaldo.Progetto_java_settimana_5.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String indirizzo;
    private String city;

    public Edificio(){}

    public Edificio(String nome, String indirizzo, String city) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
