/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import buscafilmes.UsarioLogin;
import buscafilmes.UsuarioDAO;

/**
 *
 * @author geraldo.filho
 */
public class ControleLogin {

    public boolean login(String nome, String senha) {
        boolean resp;
        UsarioLogin u = new UsarioLogin(nome, senha);
        UsuarioDAO dao = new UsuarioDAO();
        resp = dao.login(u);
        return resp;
    }

}
