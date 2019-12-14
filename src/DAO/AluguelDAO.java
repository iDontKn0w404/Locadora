package DAO;

import Modelo.Aluguel;
import java.sql.*;
import DAO.*;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO extends ExecuteSQL{
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a){
        String sql = "insert into aluguel values(0,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setInt(2, a.getCodcliente());
            ps.setString(3, a.getData_aluguel());
            ps.setString(4, a.getHorario());
            ps.setString(5, a.getData_devolucao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e){
            return e.getMessage();
        }
    }
    
    
    public List<Aluguel> ListarAluguel() {
        String sql = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel";
        List<Aluguel> lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    

    public void Atualizar_Situacao(String situacao, int coddvd) {
        
    String sql = "update dvd set situacao = " + situacao + " where iddvd = " + coddvd + "";
    
    }
}
