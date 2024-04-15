package com.questionario.entities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    public Connection conexao() throws SQLException{
        Connection conexao = null;
        try{
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://ep-young-sunset-a5wzfu7a.us-east-2.aws.neon.tech/quest-teste?user=robertaokada144&password=6ftJSkox8iDF&sslmode=require", "robertaokada144", "6ftJSkox8iDF");
        } catch(ClassNotFoundException e) {
            System.out.println("Driver do banco não localizado");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco" + e.getMessage());
        } finally {
            if(conexao == null){
                System.out.println("A");
            }
            if (conexao != null) {
                System.out.println("Conectado");
                conexao.createStatement();
            }
        }
        return conexao;
    }
        
}

    