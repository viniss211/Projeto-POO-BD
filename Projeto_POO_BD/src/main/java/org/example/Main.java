package org.example;
import java.util.Collections;

import DAO.AutorDAO;
import DAO.LivroDAO;
import Exceptions.DadoInvalidoException;
import Model.Autor;
import Model.Livro;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        AutorDAO autorDAO = new AutorDAO();
        Autor autorAux = new Autor("","","");
        Livro livroAux = new Livro(0,"",0,"","");
        int idAux;
        LivroDAO livroDAO = new LivroDAO();
        boolean controle = true;
        int entrada=0;
        //Cadastrar novos livros, autores, pessoas novas na biblioteca e manipular estes dados (pesquisa por autor, e genero)
        //Permitir mostrar os dados de livros e de usuarios da biblio
        //cadastrar emprestimos que diminua o num de cópias

        while (controle){
            System.out.println("Bem vindo ao sistema da biblioteca Old Pages");
            System.out.println("1 - Cadastrar novo livro");
            System.out.println("2 - Listagem de livros da Biblioteca");
            System.out.println("3 - Cadastrar novo Autor");
            System.out.println("4 - Listagem de Autores");
            System.out.println("5 - Remover Livro do Sistema");
            System.out.println("6 - Sair");
            entrada = sc.nextInt();

        switch (entrada){
            case 1:

                sc.nextLine();
                System.out.println("Titulo: ");
                livroAux.setTitulo(sc.nextLine());
                try {
                    System.out.println("Ano de publicação: ");
                    livroAux.setAnoLancamento(sc.nextInt());
                    sc.nextLine();
                    if(livroAux.getAnoLancamento()  < 0 || livroAux.getAnoLancamento()>2023) {
                        throw new DadoInvalidoException();
                    }

                }catch (Exception e ){
                    break; // Parando a execução de salvar os valores

                }
                System.out.println("Genero Literário:");
                livroAux.setGenero(sc.next());
                sc.nextLine();
                System.out.println("Autor: ");
                try {
                    livroAux.setAutor(sc.nextLine());
                    System.out.println(livroAux.getTitulo());
                    System.out.println(livroAux.getAnoLancamento());
                    System.out.println(livroAux.getGenero());
                    System.out.println(livroAux.getAutor());
                    livroDAO.insertLivro(livroAux);
                    throw new DadoInvalidoException();

                }catch (Exception e ){
                    break; // Parando a execução de salvar os valores

                }


            case 2: //Mostrar livros da biblioteca
                livroDAO.selectLivro();
                break;
            case 3: //Cadastrar novo Autor
                sc.nextLine();
                System.out.println("Nome do Autor:" );
                autorAux.setNome(sc.nextLine());

                System.out.println("Especialização: ");
                autorAux.setEspecializacao(sc.nextLine());

                System.out.println("Literatura Nacional ou Estrangeira: ");
                autorAux.setTipoLiteratura(sc.nextLine());

                autorDAO.insertAutor(autorAux);

                break;
            case 4:

                autorDAO.selectAutor();
                break;
            case 6:
                System.out.println("Encerrando...");
                controle=false;
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