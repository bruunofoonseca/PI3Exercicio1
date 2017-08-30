/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aron
 */
public class ConexaoDB {
    protected static Connection obterConexao() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/sample","app","app");
        
        return conn;
    }
}
