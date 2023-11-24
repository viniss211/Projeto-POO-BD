package Model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoLancamento;
    private String genero;private int numCopias;

    public Livro(int id, String titulo,int anoLancamento,String genero ,String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;

    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
