package Model;

public class Autor extends Pessoa{
    private String genero;

    public Autor(String nome,String especializacao) {
        this.setNome(nome);
        this.genero = genero;
    }

    public String getEspecializacao() {
        return genero;
    }

    public void setEspecializacao(String especializacao) {
        this.genero = especializacao;
    }

}
