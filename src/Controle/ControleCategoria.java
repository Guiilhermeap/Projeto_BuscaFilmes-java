/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import buscafilmes.*;
import buscafilmes.CategoriaDAO;
import java.util.ArrayList;

/**
 *
 * @author geraldo.filho
 */
public class ControleCategoria {

    public void inserir(String c) {
        try {
            Categoria cate = new Categoria(c);
            CategoriaDAO dao = new CategoriaDAO();
            dao.insere(cate);
        } catch (Exception e) {
        }
    }

    public void alterar(int id, String nome) {
        try {
            Categoria cate = new Categoria(id, nome);
            CategoriaDAO dao = new CategoriaDAO();
            dao.altera(cate);
        } catch (Exception e) {
        }
    }

    public void excluir(int id, String c) {
        try {
            Categoria cate = new Categoria(id, c);
            CategoriaDAO dao = new CategoriaDAO();
            dao.exclui(cate);
        } catch (Exception e) {
        }
    }

    public Categoria getPorId(int id) {
        Categoria cate = null;
        try {
            CategoriaDAO dao = new CategoriaDAO();
            cate = dao.getPorId(id);
            return cate;
        } catch (Exception e) {
        }
        return cate;
    }

    public ArrayList getAll() {
        ArrayList lista = new ArrayList();
        try {
            CategoriaDAO dao = new CategoriaDAO();
            lista = dao.getAll();
        } catch (Exception e) {
        }
        return lista;
    }
}
