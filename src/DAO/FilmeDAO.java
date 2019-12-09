package DAO;

import Modelo.Filme;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            ps.setString(6, a.getCapa());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e){
            return e.getMessage();
        }
    }
    public List<Filme> ConsultaCodigoFilme(String nome) {
        
        String sql = "select idfilme from filme where titulo = '" + nome + "'";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    public List<Filme> ListarComboFilme() {
        
        String sql = "select titulo from filme order by titulo ";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Filme a = new Filme();
                    a.setTitulo(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    public String Excluir_Filme(Filme a) {
        String sql = "delete from filme where idfilme = ? and titulo = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getTitulo());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
