/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.util.List;


/**
 *
 * @author BruunoFoonseca
 */
public class ProdutoService {
    // Inserir produto
    public static void inserirProduto(ProdutoModel produto)
            throws ProdutoException, DataSourceException {

        // estou validando se houve algum erro no objeto ProdutoModel
        ValidarProduto.validar(produto);

        try {
            //Chama Função do DB
            DBProduto.inserirProduto(produto);
        } catch (Exception e) {
            
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    /*public static void atualizarProduto(ProdutoModel prod)
    throws ProdutoException, DataSourceException{
        try {
            //Chama função do BD
            DBProduto.atualizarProduto(prod);
        } catch (Exception e) {
            // imprimir erro tecnico no console
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    */
    public static List<ProdutoModel> localizarProduto(String nomeProd)
                throws ProdutoException, DataSourceException{
        try {
            // Exceção vai verificar se houve preenchimento do campo de pesquisa
            // caso tenha algo digitado traz resultado
            if (nomeProd == null || "".equals(nomeProd)) {
                //Chama função do DB
                return DBProduto.listar();
            }else{
                return DBProduto.listarSomentePalavra(nomeProd);
            } 
        } catch (Exception e) {
            throw new DataSourceException("Erro na fonte de dados, e");
        }
    }
    
    public static ProdutoModel obterProduto (Integer id)
        throws ProdutoException, DataSourceException {
            
        try {
            //Chama Função do DB
            return DBProduto.obter(id);
        } catch (Exception e) {
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    // excluir produto
    public static void excluirProduto(long id) throws ProdutoException, DataSourceException{
        
        try {
            //Chama Função do DB
            DBProduto.excluir(id);
        } catch (Exception e) {
            
            // imprimir algum erro caso não consiga excluir
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }   
    }   
    
    public static long obterId(String nomeDoProduto)throws ProdutoException, DataSourceException{
        
        try {
            //Chama Função do DB
            return DBProduto.retornaId(nomeDoProduto);
        } catch (Exception e) {
            
            // imprimir algum erro caso não consiga excluir
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }   
    }
}  