package Model;

public class Autor extends Pessoa{
    private String especializacao;

    public Autor(String nome,String especializacao) {
        this.setNome(nome);
        this.especializacao = especializacao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

}
