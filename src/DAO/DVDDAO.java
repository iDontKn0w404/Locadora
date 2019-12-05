package DAO;

import Modelo.DVD;
import java.sql.*;

public class DVDDAO extends ExecuteSQL{
    
    public DVDDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_DVD(DVD a) {
        String sql = "insert into dvd values(0,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setString(2, a.getSituacao());
            ps.setDouble(3, a.getPreco());
            ps.setString(4, a.getData_compra());
            
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
