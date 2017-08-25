/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author BruunoFoonseca
 */
public class DBProduto {
    private static int numProdutos = 0;
    
    private static final List<ProdutoModel> listaProdutos = new ArrayList<>();
    
    // Inserindo Produto
    public static void inserir(ProdutoModel prod)
        throws Exception{
        
        prod.setID(numProdutos++);
        listaProdutos.add(prod);
    }

    // realiza a atualização do produto , com id e dados
    public static void atualiza(ProdutoModel produtoProcura)
            throws Exception{
        
        if(produtoProcura != null && !listaProdutos.isEmpty()){
            for(ProdutoModel produtoLi : listaProdutos){
                if (produtoLi != null && Objects.equals(produtoLi.getID(), produtoProcura.getID())){
                    produtoLi.setNome(produtoProcura.getNome());
                    produtoLi.setDescricao(produtoProcura.getDescricao());
                    produtoLi.setData(produtoProcura.getData());
                    produtoLi.setVenda(produtoProcura.getVenda());
                    produtoLi.setCompra(produtoProcura.getCompra());
                    produtoLi.setCategorias(produtoProcura.getCategorias());
                    break;
                }
            }
        }
    }

    // Localizar ou listar todos os Produto
    public static List<ProdutoModel> listarTodosProdutos()
            throws Exception{
        // ira retorna a lista do objeto produto
        return listaProdutos;
    }

    public static List<ProdutoModel> listarSomentePalavra(String valor)
        throws Exception {

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
    
    public static ProdutoModel obter(Integer id)
        throws Exception{
        
        if(id != null && ! listaProdutos.isEmpty()){
            for (int i = 0; i < listaProdutos.size(); i++) {
                if(listaProdutos.get(i) != null && Objects.equals(listaProdutos.get(i).getID(), id)){
                    return listaProdutos.get(i);
                }
            }
        }
        
        return null;
    }

    // excluir
    public static void excluir(Integer id) throws Exception {
        if(id != null && !listaProdutos.isEmpty()){
            for(int i = 0; i < listaProdutos.size(); i++){
                ProdutoModel prod = listaProdutos.get(i);
                if(prod != null && Objects.equals(prod.getID(), id)){
                    listaProdutos.remove(i);
                    break;
                }
            }
        }
    }
}