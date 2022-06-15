/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscafilmes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author geraldo.filho
 */
public class UsuarioDAO {

    public boolean login(UsarioLogin u) {
        boolean resp = false;
        try {
            Connection con = Conexao.getConexao();
            ResultSet rs = null;
            String sql = "SELECT * FROM usuarios where nome = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                resp = true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
        }

        return resp;

    }
}
