/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import buscafilmes.Categoria;
import buscafilmes.CategoriaDAO;
import buscafilmes.Filmes;
import buscafilmes.FilmesDAO;

/**
 *
 * @author geraldo.filho
 */
public class ControleFilmes {

    public void inserir(int an, String cate, int ic) {
        try {
            CategoriaDAO cdao = new CategoriaDAO();
            Categoria c = cdao.getPorId(ic);
            FilmesDAO dao = new FilmesDAO();
            Filmes flm = new Filmes(an, cate, c);
            dao.insere(flm);
        } catch (Exception e) {
        }
    }

    public void alterar(int id, String cate, int ic, int an) {
        try {
            CategoriaDAO cdao = new CategoriaDAO();
            Categoria c = cdao.getPorId(ic);
            Filmes flm = new Filmes(id, an, cate, c);
            FilmesDAO dao = new FilmesDAO();
            dao.altera(flm);
        } catch (Exception e) {
        }
    }

    public void excluir(int id) {
        try {
            Filmes flm = new Filmes();
            flm.setId(id);
            FilmesDAO dao = new FilmesDAO();
            dao.exclui(flm);
        } catch (Exception e) {
        }
    }

    public Filmes getPorId(int i) {
        Filmes flm = null;
        try {
            FilmesDAO dao = new FilmesDAO();
            flm = dao.getPorId(i);
            return flm;
        } catch (Exception e) {
        }
        return flm;
    }

    public ArrayList getAll() {
        ArrayList lista = new ArrayList();
        try {
            FilmesDAO dao = new FilmesDAO();
            lista = dao.getAll();
        } catch (Exception e) {
            System.err.println("erro de filme");
        }
        return lista;
    }
    public ArrayList getAnos() {
        ArrayList lista = new ArrayList();
        try {
            FilmesDAO dao = new FilmesDAO();
            lista = dao.getAnos();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public ArrayList getPorCategoria(int i) {
        ArrayList lista = new ArrayList();
        try {
            FilmesDAO dao = new FilmesDAO();
            lista = dao.getPorCategoria(i);
        } catch (Exception e) {
        }
        return lista;
    }
    
    public ArrayList getPorAno(int i) {
        ArrayList lista = new ArrayList();
        try {
            FilmesDAO dao = new FilmesDAO();
            lista = dao.getPorAno(i);
        } catch (Exception e) {
        }
        return lista;
    }
}