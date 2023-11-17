package org.example;


import DAO.AutorDAO;
import Model.Autor;

public class Main {
    public static void main(String[] args) {
        Autor a1 = new Autor();
        a1.setNome("elias");
        a1.setEspecializacao("Terrror");
        AutorDAO autorDAO = new AutorDAO();

        //autorDAO.insertAutor(a1);
        a1.setNome("Alfredin");
        a1.setEspecializacao("almoco");
        autorDAO.updateAutor(1,a1);
        autorDAO.deleteAutor(2);

    }
}