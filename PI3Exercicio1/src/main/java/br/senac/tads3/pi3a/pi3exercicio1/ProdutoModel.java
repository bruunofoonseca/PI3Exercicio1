/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author BruunoFoonseca
 */

public class ProdutoModel {
    
  private int id;

  private String nome;

  private String descricao;

  private BigDecimal valorCompra;

  private BigDecimal valorVenda;

  private String categorias;

  private Date dtCadastro;
  
  public ProdutoModel() {
    
  }

  public ProdutoModel(int id, String nome, String descricao, BigDecimal valorCompra, BigDecimal valorVenda, String categorias, Date dtCadastro) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.valorCompra = valorCompra;
    this.valorVenda = valorVenda;
    this.categorias = categorias;
    this.dtCadastro = dtCadastro;
  }

  public ProdutoModel(String nome, String descricao, BigDecimal valorCompra, BigDecimal valorVenda, String categorias, Date dtCadastro) {
    this.nome = nome;
    this.descricao = descricao;
    this.valorCompra = valorCompra;
    this.valorVenda = valorVenda;
    this.categorias = categorias;
    this.dtCadastro = dtCadastro;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getValorCompra() {
    return valorCompra;
  }

  public void setValorCompra(BigDecimal valorCompra) {
    this.valorCompra = valorCompra;
  }

  public BigDecimal getValorVenda() {
    return valorVenda;
  }

  public void setValorVenda(BigDecimal valorVenda) {
    this.valorVenda = valorVenda;
  }

  public String getCategorias() {
    return categorias;
  }

  public void setCategorias(String categorias) {
    this.categorias = categorias;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }

}