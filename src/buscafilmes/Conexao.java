/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscafilmes;


/**
 *
 * @author geraldo.filho
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (Exception e) {
            System.err.println("Problemas ao carregar o driver: " + e.getMessage());
        }
        String url = "jdbc:ucanaccess://D:/BuscaFilmes/Database2.accdb";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Problemas ao abrir a conexao com o BD: " + e.getMessage());
        }
        return con;
    }
}