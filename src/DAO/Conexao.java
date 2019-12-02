package DAO;

import java.sql.*;
import javax.swing.JOptionPane;
//import Connection;

public class Conexao {
    
    public static Connection AbrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysqk.jdbc.Driver");
            String url = "jdbc:mysql://localhost/locadora";
            con = DriverManager.getConnection(url, "root", "123");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro na Conexão com o Banco", 
                    "Vídeo Locadora", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
        return con;
    }
    
    public static void FecharConexao(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
