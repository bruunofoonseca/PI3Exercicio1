/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author BruunoFoonseca
 */
public class DBProduto extends ConexaoDB{
    
    
    
public static List<ProdutoModel> listar() {

    String query = "SELECT id, nome, descricao,vl_compra, vl_venda, categoria,dt_cadastro FROM produto";

    List<ProdutoModel> lista = null;
    try (Connection conn = obterConexao();
	    PreparedStatement stmt = conn.prepareStatement(query);
	    ResultSet resultados = stmt.executeQuery()) {

      lista = new ArrayList<ProdutoModel>();
      while (resultados.next()) {
	ProdutoModel p = new ProdutoModel();
	p.setId(resultados.getLong("id"));
	p.setNome(resultados.getString("nome"));
	p.setDescricao(resultados.getString("descricao"));
	p.setValorCompra(resultados.getBigDecimal("vl_compra"));
	p.setValorVenda(resultados.getBigDecimal("vl_venda"));
	p.setCategorias(resultados.getString("categoria"));
	p.setDtCadastro(resultados.getTimestamp("dt_cadastro"));
	lista.add(p);
      }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex.getMessage());
    }
    return lista;
   }

 public static ProdutoModel obter(long id) {
    String query = "SELECT id, nome, descricao, "
	    + "vl_compra, vl_venda, categoria, "
	    + "dt_cadastro FROM produto "
	    + "WHERE id = ?";

    ProdutoModel prod = null;
    try (Connection conn = obterConexao();
	    PreparedStatement stmt = conn.prepareStatement(query)) {

      stmt.setLong(1, id);
      try (ResultSet resultados = stmt.executeQuery()) {

	if (resultados.next()) {
	  prod = new ProdutoModel();
	  prod.setId(resultados.getLong("id"));
	  prod.setNome(resultados.getString("nome"));
	  prod.setDescricao(resultados.getString("descricao"));
	  prod.setValorCompra(resultados.getBigDecimal("vl_compra"));
	  prod.setValorVenda(resultados.getBigDecimal("vl_venda"));
	  prod.setCategorias(resultados.getString("categoria"));
	  prod.setDtCadastro(resultados.getTimestamp("dt_cadastro"));
	}
      }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex.getMessage());
    }
    return prod;
  }
 
   public static void excluir(long id){
     
     
      String query = "DELETE FROM PRODUTO WHERE ID = ?";
      
      try (Connection conn = obterConexao()){
              PreparedStatement stmt = conn.prepareStatement(query);
              stmt.setLong(1, id);
              int contadorDeExclusao = stmt.executeUpdate();
      }      
      
      catch(SQLException ex){
              System.err.println(ex.getMessage());
              }
      catch (ClassNotFoundException ex){
              System.err.println(ex.getMessage());
              }
          
      }
   public static void alterarProduto(long id){
              ProdutoModel p = obter(id);
       
              String identification = Long.toString(id);
       
       String query = "UPDATE PRODUTO SET  NOME = ?, DESCRICAO = ?, VL_COMPRA = ?, VL_VENDA = ?, CATEGORIA = ?, DT_CADASTRO = ? WHERE ID = ?";
       
       try (Connection conn = obterConexao()){
              PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, p.getNome());
                stmt.setString(2, p.getDescricao());
                stmt.setBigDecimal(3, p.getValorCompra());
                stmt.setBigDecimal(4, p.getValorVenda());
                stmt.setString(5, p.getCategorias());
                stmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
                stmt.setString(7, identification);
              int contadorDeColunasAfetadas = stmt.executeUpdate();
      }      
      
      catch(SQLException ex){
              System.err.println(ex.getMessage());
              }
      catch (ClassNotFoundException ex){
              System.err.println(ex.getMessage());
              }
          
   
   }
      
     public static void inserirProduto(ProdutoModel p) {

    String query = "INSERT INTO produto (nome, descricao, vl_compra, vl_venda, categoria, dt_cadastro) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = obterConexao()) {
      conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
      try (PreparedStatement stmt
	      = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	stmt.setString(1, p.getNome());
	stmt.setString(2, p.getDescricao());
	stmt.setBigDecimal(3, p.getValorCompra());
	stmt.setBigDecimal(4, p.getValorVenda());
	stmt.setString(5, p.getCategorias());
	stmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));

	stmt.executeUpdate();

	// ResultSet para recuperar o ID gerado automaticamente no banco de dados.
	// Neste exemplo, o ID é gerado automaticamente.
	try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	  if (generatedKeys.next()) {
	    long idNovo = generatedKeys.getLong(1);
	    p.setId(idNovo);
	    System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));

	    // Executar próximos INSERTs USANDO O ID novo.
	  }

	}
	conn.commit();
      } catch (SQLException ex) {
	conn.rollback();
	System.err.println(ex.getMessage());
      }

    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex.getMessage());
    }

  }
    public static List<ProdutoModel> listarSomentePalavra(String valor)
        throws Exception {
        List<ProdutoModel> listaProdutos = listar();
        List<ProdutoModel> listaResultadoProdutos = new ArrayList<>();
        
        if(valor != null && !listaProdutos.isEmpty()){
            
            for (ProdutoModel prodLista : listaProdutos){
                if(prodLista != null && prodLista.getNome() != null){
                    if(prodLista.getNome().toUpperCase().contains(valor.toUpperCase())){
                        listaResultadoProdutos.add(prodLista);
                    }
                }
            }
            
        }
        
        return listaResultadoProdutos;
    }
    
    public static long retornaId(String nomeDoProduto)throws Exception {
        long id = 0;
        List<ProdutoModel> listaProdutos = listar();
        
        
        if(nomeDoProduto != null && !listaProdutos.isEmpty()){
            
            for (ProdutoModel prodLista : listaProdutos){
                if(prodLista != null && prodLista.getNome() != null){
                    if(prodLista.getNome().toUpperCase().contains(nomeDoProduto.toUpperCase())){
                       id = prodLista.getId();
                    }
                }
            }
            
        }
        
        return id;
    }
    }
