package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConnectionDAO {
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    String database = "projeto_bd_poo";
    String user = "root";
    String password = "Viniotaku1!";
    String url;

    public ConnectionDAO() {
        this.url = "jdbc:mysql://localhost:3306/" + this.database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    }

    public void connectToDB() {
        try {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexao deu certo!");
        } catch (SQLException var2) {
            System.out.println("Erro: " + var2.getMessage());
        }

    }
}
