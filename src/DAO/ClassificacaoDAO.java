
package DAO;

import Modelo.Classificacao;
import java.sql.*;

public class ClassificacaoDAO extends ExecuteSQL{
    
    public ClassificacaoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Classificacao(Classificacao a) {
        String sql = "insert into classificacao values(0,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            
            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
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
