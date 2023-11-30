package org.example;

import java.sql.SQLException;
import java.util.Collections;

import DAO.*;
import Exceptions.DadoInvalidoException;
import Model.Autor;
import Model.Emprestimo;
import Model.Leitor;
import Model.Livro;

import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String checar(String novo, String velho){
        if(novo == null){
            novo = velho;
        }
        return novo;
    }
    public static void main(String[] args) throws DadoInvalidoException {


        Scanner sc = new Scanner(System.in);


        AutorDAO autorDAO = new AutorDAO();
        LeitorDAO leitorDAO =new LeitorDAO();
        HasAlugadorDAO hasAlugadorDAO = new HasAlugadorDAO();
        EmprestimoDAO emprestimoDAO =new EmprestimoDAO();
        Autor autorAux = new Autor("", "", "");
        Livro livroAux = new Livro(0, "", 0, "", "");
        int idAux;
        LivroDAO livroDAO = new LivroDAO();
        Leitor leitorAux = new Leitor("","","");
        boolean controle = true;

        int entrada = 0;
        //Cadastrar novos livros, autores, pessoas novas na biblioteca e manipular estes dados (pesquisa por autor, e genero)
        //Permitir mostrar os dados de livros e de usuarios da biblio
        //cadastrar emprestimos que diminua o num de cópias

        while (controle) {
            System.out.println("Bem vindo ao sistema da biblioteca Old Pages");
            System.out.println("1 - Cadastrar novo livro");
            System.out.println("2 - Listagem de livros da Biblioteca");
            System.out.println("3 - Cadastrar novo Autor");
            System.out.println("4 - Listagem de Autores");
            System.out.println("5 - Remover Livro do Sistema");
            System.out.println("6 - Cadastrar novo leitor");
            System.out.println("7 - Editar dados de leitor");
            System.out.println("8 - Realizar emprestimo de livro");
            System.out.println("9 - Editar emprestimo de livro");
            System.out.println("10 - Visualizar empréstimos");
            System.out.println("11 - Sair");

            entrada = sc.nextInt();

            switch (entrada) {
                case 1:

                    sc.nextLine();
                    System.out.println("Titulo: ");
                    livroAux.setTitulo(sc.nextLine());
                    try {
                        System.out.println("Ano de publicação: ");
                        livroAux.setAnoLancamento(sc.nextInt());
                        sc.nextLine();
                        if (livroAux.getAnoLancamento() < 0 || livroAux.getAnoLancamento() > 2023) {
                            throw new DadoInvalidoException();
                        }

                    } catch (Exception e) {
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


                    } catch (Exception e) {
                        break;

                    }

                case 2: //Mostrar livros da biblioteca
                    livroDAO.selectLivro();
                    break;
                case 3: //Cadastrar novo Autor
                    sc.nextLine();
                    System.out.println("Nome do Autor:");
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
                case 5:
                    System.out.println("Digite o ID do livro que deseja excluir");
                    livroDAO.selectLivro();
                    idAux = sc.nextInt();
                    livroDAO.deleteLivro(idAux);
                    System.out.println("Livro exluido do sistema");
                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Caso queira manter algum dado apenas tecle Enter");
                    System.out.println("Qual o ID da pessoa que gostaria de editar?");
                    idAux = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Novo nome:");
                    String nome = sc.nextLine();
                    //nome = checar(nome, leitorAux.getNome() );

                    System.out.println("Novo cpf:");

                    String cpf = sc.nextLine();
                    //cpf = checar(cpf, leitorAux.getCpf() );

                    System.out.println("Novo telefone:");

                    String telefone = sc.nextLine();
                    //telefone = checar(telefone, leitorAux.getTelefone() );


                    Leitor leitorUpdate = new Leitor(nome,cpf,telefone);
                    leitorDAO.updateLeitor(idAux,leitorUpdate);
                    break;
                case 8: //Aqui eu faço emprestimo e edito infos vão para tabelas hasalugador e emprestimos
                    sc.nextLine();

                    System.out.println("Livro a ser alugado: ");
                    String nomeLivro = sc.nextLine();
                    System.out.println("Nome do Autor");
                    String nomeAutor = sc.nextLine();
                    System.out.println("Data de empréstimo");
                    String dataPega = sc.nextLine();
                    System.out.println("Data a devolver");
                    String dataDevolve = sc.nextLine();

                    Emprestimo emprestimoAux= new Emprestimo();

                    livroAux.setTitulo(nomeLivro);
                    livroAux.setAutor(nomeAutor);

                    emprestimoAux.setDataAluga(dataPega);
                    emprestimoAux.setDataDevolve(dataDevolve);
                    System.out.println("Id do Leitor:");
                    int id = sc.nextInt();
                    System.out.println(livroAux.getAutor());
                    System.out.println(livroAux.getTitulo());
                    emprestimoDAO.insertEmprestimo(emprestimoAux,id);
                    hasAlugadorDAO.insertHasAlugador(livroAux,id);
                    break;
                case 9: //Aqui edito

                    System.out.println("Id do Leitor: ");
                    int idEdit = sc.nextInt();
                    System.out.println("Houve multa? 1 para sim e 0 para não");
                    int multaI = sc.nextInt();

                    System.out.println("Valor da multa");
                    float valorMulta = sc.nextFloat();
                    Emprestimo emprestimoAUX = new Emprestimo();
                    emprestimoAUX.setTemMulta(multaI);
                    emprestimoAUX.setValorMulta(valorMulta);
                    emprestimoAUX.setId(idEdit);

                    emprestimoDAO.updateEmprestimo(emprestimoAUX,idEdit);
                    break;
                case 10:
                    try {
                        hasAlugadorDAO.selectHasAlugador();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 11:

                    controle = false;
                    break;
            }
            System.out.println("Encerrando...");

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