
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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;

public class CategoriaDAO {

    public void insere(Categoria cate) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement("insert into categoria (nome) values (?)");
        stmt.setString(1, cate.getNome());
        
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void exclui(Categoria cate) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement("delete from categoria where id = ?");
        stmt.setInt(1, cate.getId());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public void altera(Categoria cate) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = con.prepareStatement("update categoria set nome = ? where id = ?");
        stmt.setInt(2, cate.getId());
        stmt.setString(1, cate.getNome());
        
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public ArrayList getAll() throws Exception {
        ArrayList lista = new ArrayList();
        Connection con = Conexao.getConexao();
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM categoria";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            int i = rs.getInt("id");
            String c = rs.getString("nome");
            Categoria ctg = new Categoria(i, c);
            lista.add(ctg);
        }
        rs.close();
        st.close();
        con.close();
        return lista;
    }

    public Categoria getPorId(int id) throws Exception {
        Categoria cate = null;
        Connection con = Conexao.getConexao();
        ResultSet rs = null;
        String sql = "SELECT * FROM categoria where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            int i = rs.getInt("id");
            String c = rs.getString("nome");
            cate = new Categoria(i, c);
        }
        rs.close();
        stmt.close();
        con.close();
        return cate;
    }

}
