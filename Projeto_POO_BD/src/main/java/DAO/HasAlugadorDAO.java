package DAO;

import Model.Autor;
import Model.HasAlugador;
import Model.Livro;

import java.sql.SQLException;
import java.util.ArrayList;

public class HasAlugadorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou



    //INSERT
    public boolean insertHasAlugador(Livro livro,int id) {

        connectToDB();

        String sql = "INSERT INTO Livro_has_Alugador (Livro_Autor_nomeAutor, Leitor_idLeitor, Titulo) VALUES (?,?,?)";
        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, livro.getAutor());
            pst.setString(2, String.valueOf(id));
            pst.setString(3, livro.getTitulo());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }


    //SELECT
    public ArrayList<HasAlugador> selectHasAlugador() throws SQLException {
        ArrayList<HasAlugador> listaEmprestimos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Livro_has_Alugador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Emprestimos: ");

            while (rs.next()) {

                HasAlugador hasAlugadorAux = new HasAlugador(rs.getString("Livro_Autor_nomeAutor"),rs.getInt("Leitor_idLeitor"),0,"",rs.getString("Titulo"));

                System.out.println("Nome Autor = " + hasAlugadorAux.getAutor());
                System.out.println("ID Leitor = " + hasAlugadorAux.getId());
                System.out.println("Nome Livro = " + hasAlugadorAux.getTitulo());
                System.out.println("--------------------------------");

                listaEmprestimos.add(hasAlugadorAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaEmprestimos;
    }
}



