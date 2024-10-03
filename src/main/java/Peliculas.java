import lombok.Data;

@Data

public class Peliculas {
    private String id;
    private String titulo;
    private String anio;
    private String director;
    private String genero;

    public Peliculas(String id, String titulo, String anio, String director, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
    }
}
