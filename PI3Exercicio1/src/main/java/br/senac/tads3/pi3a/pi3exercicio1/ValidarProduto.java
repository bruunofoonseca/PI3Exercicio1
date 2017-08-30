package br.senac.tads3.pi3a.pi3exercicio1;

/**
 *
 * @author BruunoFoonseca
 */
public class ValidarProduto {
    public static void validar(ProdutoModel prod) throws ProdutoException{
        
        if(prod == null){ // verificar se houve algum produto cadastrado
            throw new ProdutoException("Não foi informado nenhum produto");
        }
        
        if(prod.getNome() == null || "".equals(prod.getNome())){
            throw new ProdutoException("É necessario informar a NOME do produto");
        }
        
        if (prod.getCategorias()== null || "".equalsIgnoreCase(prod.getCategorias())){
            throw new ProdutoException("Não foi informado Categoria do produto");
        }
        
        if(prod.getValorCompra() == null || "".equals(prod.getValorCompra())){
            throw new ProdutoException("Não foi informado Valor de Compra do produto");
        }
        
        if(prod.getValorVenda() == null || "".equals(prod.getValorCompra())){
            throw new ProdutoException("Não foi informado Valor de Venda do produto");
        }
        
        if(prod.getDescricao() == null || "".equalsIgnoreCase(prod.getDescricao())){
           throw new ProdutoException("Não foi informado Descrição do produto");
        }
    }
}