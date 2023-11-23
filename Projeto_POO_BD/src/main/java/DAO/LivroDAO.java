package DAO;


import Model.Autor;
import Model.Livro;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertLivro(Livro livro, Autor autorAux) {

        connectToDB();

        String sql = "INSERT INTO Livro (Nome,Autor,Ano_Lanc,genero,Autor_idAutor) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setString(3, String.valueOf(livro.getAnoLancamento()));
            pst.setString(4, livro.getGenero());
            //pst.setString(4, autorAux.getId());

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
    }

    //SELECT
    /*public ArrayList<Autor> selectAutor() {
        ArrayList<Autor> autores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Autor";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Autores: ");

            while (rs.next()) {

                Autor autorAux = new Autor(rs.getString("Nome"),rs.getString("Especializacao"));

                System.out.println("Nome = " + autorAux.getNome());
                System.out.println("Especialização = " + autorAux.getEspecializacao());
                System.out.println("--------------------------------");

                autores.add(autorAux);
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
        return autores;
    }*/
}


