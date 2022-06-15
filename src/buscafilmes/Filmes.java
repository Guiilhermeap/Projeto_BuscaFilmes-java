/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscafilmes;

/**
 *
 * @author Guilherme
 */
public class Filmes {
    private int id;
    private int ano;
    private String nome;
    private Categoria categoria;
    
    public Filmes (){
        
    }

    public Filmes(int id, int ano, String nome, Categoria cate) {
        this.id = id;
        this.ano = ano;
        this.nome = nome;
        this.categoria = cate;
    }

    public Filmes(int ano, String nome, Categoria cate) {
        this.ano = ano;
        this.nome = nome;
        this.categoria = cate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}