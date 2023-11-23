package org.example;


import DAO.AutorDAO;
import DAO.LivroDAO;
import Model.Autor;
import Model.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Autor a1 = new Autor("","");


        AutorDAO autorDAO = new AutorDAO();
        Autor autorAux = new Autor("","");
        Livro livroAux = new Livro();
        LivroDAO livroDAO = new LivroDAO();
        boolean controle = true;
        int entrada=0;
        //Cadastrar novos livros, autores, pessoas novas na biblioteca e manipular estes dados (pesquisa por autor, e genero)
        //Permitir mostrar os dados de livros e de usuarios da biblio
        //cadastrar emprestimos que diminua o num de cópias


        while (controle){
            System.out.println("BEM VINDO AO SISTEMA DA BIBLIOTECA ENTRE PÁGINAS");
            System.out.println("1 - Cadastrar novo Livro");

            System.out.println("5 - Sair");
            entrada=sc.nextInt();
            switch (entrada){
                case 1://caso cadastra livro
                    System.out.println("Titulo: ");
                    livroAux.setTitulo(sc.next());
                    System.out.println("Autor: ");
                    livroAux.setAutor(sc.next());
                    a1.setNome(livroAux.getAutor());
                    sc.nextLine();
                    System.out.println("Ano de lançamento: ");
                    livroAux.setAnoLancamento(sc.nextInt());
                    System.out.println("Gênero Literário: ");
                    livroAux.setGenero(sc.next());
                    a1.setEspecializacao(livroAux.getGenero());

                    autorDAO.insertAutor(a1);
                    livroDAO.insertLivro(livroAux, a1);


                    System.out.println(livroAux.getTitulo());
                    System.out.println(livroAux.getAutor());
                    System.out.println(livroAux.getGenero());
                    System.out.println(livroAux.getAnoLancamento());
                    break;
                case 2: // Apresenta livros do sistema
                case 5:
                    controle = false;
                    System.out.println("Fechando Sistema...");
                    break;
            }
        }

























        /*Autor a1 = new Autor("Sergio","Terror");
        Autor a2 = new Autor("Lucas","Romance");

        AutorDAO autorDAO = new AutorDAO();

        autorDAO.insertAutor(a1);
        //autorDAO.insertAutor(a2);

        a1.setNome("Alfredin");
        a1.setEspecializacao("almoco");
        autorDAO.updateAutor(1,a1);
        autorDAO.deleteAutor(2);
        autorDAO.selectAutor();*/
    }
}