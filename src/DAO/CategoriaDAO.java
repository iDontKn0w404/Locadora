package DAO;

import Modelo.Categoria;
import java.sql.*;

public class CategoriaDAO extends ExecuteSQL{
    
    public CategoriaDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Categoria(Categoria a) {
        String sql = "insert into categoria values(0,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            
            ps.setString(1, a.getNome());
            
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
