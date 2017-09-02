/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.pi3exercicio1;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author diogo.sfelix
 */
public class TelaPesquisa extends JFrame {
    
    TelaEditar formEditarProduto = new TelaEditar();
    
    // pega o ultimo resultado
    String ultimaPesq = null;
    List<ProdutoModel> resultado;
    
    public TelaPesquisa() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setRowCount(0);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCampoPesquisa = new javax.swing.JTextField();
        botaoLocalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisar Produto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pesquisar de Produto");

        jLabel2.setText("Nome:");

        botaoLocalizar.setText("Localizar");
        botaoLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLocalizarActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Categoria", "Valor Compra", "Valor Venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoLocalizar)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoExcluir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLocalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoEditar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void botaoLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLocalizarActionPerformed
        // codigo abaixo realiza a pesquisa do produto
        
        // inicializando a pesquisa com resultado padrao
        boolean resultadoPesquisa = false;
        
        // pegando o que foi digitado no campo de pesquisa
        ultimaPesq = txtCampoPesquisa.getText();
        
        try {
            resultadoPesquisa = refreshList();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Falhou ao obter a busca", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoLocalizarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed

        try {
            // obtem a linha selecionada na tabela
            final int row = tblProdutos.getSelectedRow();
            
            // verifica se ha linha selecionada
            if(row >= 0){
                // obtem a linha selecionada na tabela
                int id = resultado.get(row).getId();
                
                //solicita ao services obter o produto
                ProdutoModel produto = ProdutoService.obterProduto(id);
                
                formEditarProduto.dispose();
                formEditarProduto = new TelaEditar();
                formEditarProduto.setProduto(produto);
                formEditarProduto.setTitle(produto.getNome());
                formEditarProduto.setVisible(true);
                formEditarProduto.setLocationRelativeTo(null);
                formEditarProduto.toFront();
            }
            
        } catch (Exception e) {
            // se ocorrer algum erro tecnico mostra no console
            e.printStackTrace();
            // exibe mensagem de erro generica para usuario
            JOptionPane.showMessageDialog(rootPane, "Não é possivel" 
                    + " exibir os dados do produto", 
                    "Erro ao abrir detalhes",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
         
        if(tblProdutos.getSelectedRow() >= 0){
            // obtem a linha do produto selecionado
            final int row = tblProdutos.getSelectedRow();
            
            // obtem o nome do produto, para pedir a confirmação exclusao
            String nome = (String) tblProdutos.getValueAt(row, 1);
           
            // exibindo caixa de dialogo, solicitando ação
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirmar Exclusão", "Excluir Produto", JOptionPane.YES_NO_OPTION);
            
            // verificando a resposta do usuario
            if(resposta == JOptionPane.YES_OPTION){
                try {
                    // obter o id do roduto
                    int id = resultado.get(row).getId();
                    
                    // chama a classe serviço para excluir o item
                    ProdutoService.excluirProduto(id);
                    this.refreshList();
                    
                } catch (Exception e) {
                    // se ocorre erro, mostra no console o erro,
                    // esconde do usuario
                    e.printStackTrace();
                    // exibi mensagem de erro ao usuario
                    JOptionPane.showConfirmDialog(rootPane, e.getMessage(), "Falha na exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
                
        }  
    }//GEN-LAST:event_botaoExcluirActionPerformed

    // ira atualiza a lista de produtos
    public boolean refreshList() throws ProdutoException, Exception{
        
        resultado = ProdutoService.localizarProduto(ultimaPesq);
        
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        
        // vai limpar a lista, mesmo se não encontrar resultado
        modelo.setRowCount(0);
        
        if(resultado == null || resultado.size() <= 0){
            return false;
        }
        
        for (int i = 0; i < resultado.size(); i++) {
            ProdutoModel prod = resultado.get(i);
            if(prod != null){
                Object[] row = new Object[4];
                row[0] = prod.getNome();
                row[1] = prod.getCategorias();
                row[2] = prod.getValorCompra();
                row[3] = prod.getValorVenda();
                modelo.addRow(row);
            }    
        }
        
        return true;
    }
    
    // abre um internal frame centralizado na tela
     public void openFrameInCenter(JInternalFrame jif){
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoLocalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCampoPesquisa;
    // End of variables declaration//GEN-END:variables
}
