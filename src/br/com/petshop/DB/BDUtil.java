/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class BDUtil {
    
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String BD = "postgres";
    private static final String SCHEMA = "?searchpath=lab2_petshop"; // leave empty for none schema
    private static final String URL = "jdbc:postgresql://"+HOST+":"+PORT+"/"+BD+SCHEMA;
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    
    public static Connection getConnection() {
        Connection conexao = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) {
            System.err.println("Erro de sistema: Classe do driver não encontrada.");
            throw new RuntimeException(e);
        } catch(SQLException e) {
            System.err.println("Erro de sistema: Problema na conexão com o banco.");
            throw new RuntimeException(e);
        }
        return conexao;
    }
    
}
