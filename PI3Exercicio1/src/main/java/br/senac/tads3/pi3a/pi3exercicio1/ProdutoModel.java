/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.util.Date;

/**
 *
 * @author BruunoFoonseca
 */

public class ProdutoModel {
    private int id;
    private String nome, descricao, categorias;
    private double valorCompra, valorVenda;
    private Date data;
    
    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setCategorias(String categorias){
        this.categorias = categorias;
    }
    public String getCategorias(){
        return this.categorias;
    }
    public void setCompra(double valorCompra){
        this.valorCompra = valorCompra;
    }
    public double getCompra(){
        return this.valorCompra;
    }
    public void setVenda(double valorVenda){
        this.valorVenda = valorVenda;
    }
    public double getVenda(){
        return this.valorVenda;
    }
    public void setData(Date data){
        this.data = data;
    }
    public Date getData(){
        return this.data;
    }
}