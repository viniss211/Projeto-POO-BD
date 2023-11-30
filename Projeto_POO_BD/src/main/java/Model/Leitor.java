package Model;

public class Leitor extends Pessoa{

    private String cpf;
    private String telefone;
    public Leitor(String nome,String cpf,String telefone) {
        super(nome);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }


}
