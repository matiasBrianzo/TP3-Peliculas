package usuario.example.tp3_pelculas.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String urlfoto;
    private String resena;
    private String actor;
    private String director;

    public Pelicula(String titulo, String urlfoto, String resena, String actor, String director) {
        this.titulo = titulo;
        this.urlfoto = urlfoto;
        this.resena = resena;
        this.actor = actor;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
