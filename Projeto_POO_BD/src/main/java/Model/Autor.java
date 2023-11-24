package Model;

public class Autor extends Pessoa{
    private String genero;
    private String tipoLiteratura;

    public Autor(String nome,String genero, String tipoLiteratura) {
        super(nome);

        this.genero = genero;
        this.tipoLiteratura = tipoLiteratura;
    }

    public String getTipoLiteratura() {
        return tipoLiteratura;
    }

    public void setTipoLiteratura(String tipoLiteratura) {
        this.tipoLiteratura = tipoLiteratura;
    }

    public String getEspecializacao() {
        return genero;
    }

    public void setEspecializacao(String especializacao) {
        this.genero = especializacao;
    }

}
