package Model;

public class Pessoa {

    public Pessoa(String nome) {
        this.nome = nome;
    }

    private String nome;
    private int id;



    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
