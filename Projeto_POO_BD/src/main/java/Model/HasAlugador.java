package Model;

public class HasAlugador extends Livro{


    public HasAlugador(String autor, int id, Integer anoLancamento, String genero,String titulo) {
        super(id, titulo, anoLancamento, genero, autor);
    }
}
