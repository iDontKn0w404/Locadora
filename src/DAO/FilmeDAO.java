package DAO;

import Modelo.Filme;
import java.sql.*;

public class FilmeDAO extends ExecuteSQL{
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a) {
        String sql = "insert into filme values(0,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setString(7, a.getCapa());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e){
            return e.getMessage();
        }
    }
    
}
