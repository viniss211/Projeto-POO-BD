package DAO;


import Model.Livro;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertLivro(Livro livro) {

        connectToDB();

        String sql = "INSERT INTO Livro (Nome,Ano_Lanc,genero,Autor_nomeAutor) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, livro.getTitulo());
            pst.setString(2, String.valueOf(livro.getAnoLancamento()));
            pst.setString(3, livro.getGenero());
            pst.setString(4, livro.getAutor());


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

    //UPDATE
    /*public boolean updateLivro(int id, Livro livro) {
        connectToDB();
        String sql = "UPDATE Livro SET Nome=?,Especializacao=? where idAutor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setString(3, String.valueOf(livro.getAnoLancamento()));
            pst.setString(4, livro.getGenero());

            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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

    //DELETE
    /*public boolean deleteAutor(int id) {
        connectToDB();
        String sql = "DELETE FROM Autor where idAutor=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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
    }*/

    //SELECT
    public ArrayList<Livro> selectLivro() {
        ArrayList<Livro> livros = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Livro";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Livros da biblioteca: ");

            while (rs.next()) {

                Livro livroAux = new Livro(rs.getInt("idlivro"),rs.getString("Nome"),rs.getInt("Ano_Lanc"),rs.getString("genero"),rs.getString("Autor_nomeAutor"));
                System.out.println("ID = " + livroAux.getId());
                System.out.println("Titulo = " + livroAux.getTitulo());
                System.out.println("Ano de publicação = " + livroAux.getAnoLancamento());
                System.out.println("Gênero Literário = " + livroAux.getGenero());
                System.out.println("Autor = " + livroAux.getAutor());
                System.out.println("--------------------------------");

                livros.add(livroAux);
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
        return livros;
    }
}


