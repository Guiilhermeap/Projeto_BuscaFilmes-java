/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscafilmes;

/**
 *
 * @author geraldo.filho
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;

public class FilmesDAO {

    public void insere(Filmes flm) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement("insert into filmes (nome, ano, idCategoria) values (?,?,?)");
        stmt.setString(1, flm.getNome());
        stmt.setInt(2, flm.getAno());
        stmt.setInt(3, flm.getCategoria(). getId());

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void exclui(Filmes flm) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement("delete from filmes where id = ?");
        stmt.setInt(1, flm.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void altera(Filmes fml) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement("update filmes set nome = ?, ano = ?, idCategoria = ?  where id = ?");
        stmt.setString(1, fml.getNome());
        stmt.setInt(2, fml.getAno());
        stmt.setInt(3, fml.getCategoria().getId());
        stmt.setInt(4, fml.getId());

        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public ArrayList getAll() throws Exception {
        ArrayList lista = new ArrayList();
        try (Connection con = Conexao.getConexao()) {
            Statement st = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM filmes";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int i = rs.getInt("id");
                String n = rs.getString("nome");
                int an = rs.getInt("ano");
                int idCate = rs.getInt("idCategoria");
                CategoriaDAO cdao = new CategoriaDAO();
                Categoria cate = cdao.getPorId(idCate);
                Filmes flm = new Filmes(i, an, n, cate);
                lista.add(flm);
            }
            rs.close();
            st.close();
        }
        return lista;
    }
    
     public ArrayList getPorCategoria(int fkCid) throws Exception {
        ArrayList lista = new ArrayList();
        try (Connection con = Conexao.getConexao()) {
            Statement st = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM filmes where idCategoria=" + fkCid;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int i = rs.getInt("id");
                int an = rs.getInt("ano");
                String n = rs.getString("nome");
                int idCate = rs.getInt("idcategoria");
                CategoriaDAO  cdao = new CategoriaDAO();
                Categoria cid = cdao.getPorId(idCate);
                Filmes flm = new Filmes(i, an, n, cid);
                lista.add(flm);
            }
            rs.close();
            st.close();
        }
        return lista;
    }
     
     public ArrayList getPorAno(int anCid) throws Exception {
        ArrayList lista = new ArrayList();
        try (Connection con = Conexao.getConexao()) {
            Statement st = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM filmes where ano =" + anCid;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int i = rs.getInt("id");
                int an = rs.getInt("ano");
                String n = rs.getString("nome");
                int idCate = rs.getInt("idcategoria");
                CategoriaDAO  cdao = new CategoriaDAO();
                Categoria cid = cdao.getPorId(idCate);
                Filmes flm = new Filmes(i, an, n, cid);
                lista.add(flm);
            }
            rs.close();
            st.close();
        }
        return lista;
    }
       public ArrayList getAnos() throws Exception {
        ArrayList lista = new ArrayList();
        try (Connection con = Conexao.getConexao()) {
            Statement st = null;
            ResultSet rs = null;
            String sql = "SELECT distinct ano FROM filmes";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int i = rs.getInt("ano");
                lista.add(i);
            }
            rs.close();
            st.close();
        }
        return lista;
    }
     
    public Filmes getPorId(int id) throws Exception {
        Filmes cnt = null;
        Connection con = Conexao.getConexao();
        ResultSet rs = null;
        String sql = "SELECT * FROM filmes where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            int i = rs.getInt("id");
            String n = rs.getString("nome");
            int ano = rs.getInt("ano");
            int idCate = rs.getInt("idCategoria");
            CategoriaDAO fdao = new CategoriaDAO();
            Categoria cte = fdao.getPorId(idCate);
            cnt = new Filmes(i, ano, n, cte);
        }
        rs.close();
        stmt.close();
        con.close();
        return cnt;
       
    }
    
}