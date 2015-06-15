/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tiago.silva
 */
public class Conexao {
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String USUARIO = "postgres";
    static final String SENHA = "agenda";
    static final String URL_SERVER = "jdbc:postgresql://localhost:5432/tcc";
    private Connection conn;
    public Conexao() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(URL_SERVER, USUARIO, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public Connection getConn() {
        return conn;
    }
 
    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
