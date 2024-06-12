/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package barbearia.telas;

import barbearia.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author victo
 */
public class TelaClienteVenda extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form TelaClienteVenda
     */
    public TelaClienteVenda() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    //Filtro de pesquisa para produtos
        private void filtrar(){
        String sql = "select idproduto as Id, nomeproduto as Nome, quantidade as Quantidade, valor as Valor from produto where nomeproduto like ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCliVendaProdPesquisa.getText() + '%');
                rs=pst.executeQuery();
                tblCliVendaProd.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
        }  
    }
        
    //Set campos
        private void set_campos(){
            int setar = tblCliVendaProd.getSelectedRow();
            txtCliVendaProdId.setText(tblCliVendaProd.getModel().getValueAt(setar,0).toString());
            txtCliVendaProdNome.setText(tblCliVendaProd.getModel().getValueAt(setar,1).toString());
            txtCliVendaProdQtde.setText(tblCliVendaProd.getModel().getValueAt(setar,2).toString());
            txtCliVendaProdValor.setText(tblCliVendaProd.getModel().getValueAt(setar,3).toString());
        }

        //TERMINAR DE PROGRAMAR A QUANTIDADE COMPRADA
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telausuarioid = new javax.swing.JLabel();
        btnCliVendaProdCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliVendaProd = new javax.swing.JTable();
        txtCliVendaProdPesquisa = new javax.swing.JTextField();
        txtCliVendaProdId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        telausuarionome = new javax.swing.JLabel();
        txtCliVendaProdNome = new javax.swing.JTextField();
        telausuarionome2 = new javax.swing.JLabel();
        txtCliVendaProdValor = new javax.swing.JTextField();
        txtCliVendaProdQtdeDesejada = new javax.swing.JTextField();
        telausuarionome3 = new javax.swing.JLabel();
        telausuarionome4 = new javax.swing.JLabel();
        txtCliVendaProdQtde = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(837, 509));

        telausuarioid.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioid.setText("Id:");

        btnCliVendaProdCompra.setText("Comprar");
        btnCliVendaProdCompra.setToolTipText("Alterar");
        btnCliVendaProdCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliVendaProdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliVendaProdCompraActionPerformed(evt);
            }
        });

        tblCliVendaProd = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCliVendaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdProduto", "Nome", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliVendaProd.getTableHeader().setResizingAllowed(false);
        tblCliVendaProd.getTableHeader().setReorderingAllowed(false);
        tblCliVendaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCliVendaProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliVendaProd);

        txtCliVendaProdPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliVendaProdPesquisaKeyReleased(evt);
            }
        });

        txtCliVendaProdId.setBackground(new java.awt.Color(60, 63, 65));
        txtCliVendaProdId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCliVendaProdId.setEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\victo\\Downloads\\NetBeans\\Icones\\icone pesquisar.png")); // NOI18N
        jLabel1.setText("jLabel1");

        telausuarionome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome.setText("Nome:");

        txtCliVendaProdNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCliVendaProdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliVendaProdNomeActionPerformed(evt);
            }
        });

        telausuarionome2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome2.setText("Valor:");

        txtCliVendaProdValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCliVendaProdValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliVendaProdValorActionPerformed(evt);
            }
        });

        txtCliVendaProdQtdeDesejada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCliVendaProdQtdeDesejada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliVendaProdQtdeDesejadaActionPerformed(evt);
            }
        });

        telausuarionome3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome3.setText("Quantidade desejada:");

        telausuarionome4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome4.setText("Qtde:");

        txtCliVendaProdQtde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCliVendaProdQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliVendaProdQtdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCliVendaProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telausuarionome)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telausuarionome4)
                                .addComponent(telausuarionome2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCliVendaProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(299, 299, 299)
                                .addComponent(telausuarioid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCliVendaProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCliVendaProdValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliVendaProdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(telausuarionome3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliVendaProdQtdeDesejada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCliVendaProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliVendaProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliVendaProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telausuarioid)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliVendaProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telausuarionome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliVendaProdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telausuarionome2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telausuarionome4)
                    .addComponent(txtCliVendaProdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCliVendaProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliVendaProdQtdeDesejada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telausuarionome3))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliVendaProdPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliVendaProdPesquisaKeyReleased
        // filtrar
        filtrar();
    }//GEN-LAST:event_txtCliVendaProdPesquisaKeyReleased

    private void btnCliVendaProdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliVendaProdCompraActionPerformed
        // Create cadastrar produtos

    }//GEN-LAST:event_btnCliVendaProdCompraActionPerformed

    private void tblCliVendaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCliVendaProdMouseClicked
        // Setar produtos
        set_campos();
    }//GEN-LAST:event_tblCliVendaProdMouseClicked

    private void txtCliVendaProdValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliVendaProdValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliVendaProdValorActionPerformed

    private void txtCliVendaProdQtdeDesejadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliVendaProdQtdeDesejadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliVendaProdQtdeDesejadaActionPerformed

    private void txtCliVendaProdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliVendaProdNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliVendaProdNomeActionPerformed

    private void txtCliVendaProdQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliVendaProdQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliVendaProdQtdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliVendaProdCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliVendaProd;
    private javax.swing.JLabel telausuarioid;
    private javax.swing.JLabel telausuarionome;
    private javax.swing.JLabel telausuarionome2;
    private javax.swing.JLabel telausuarionome3;
    private javax.swing.JLabel telausuarionome4;
    private javax.swing.JTextField txtCliVendaProdId;
    private javax.swing.JTextField txtCliVendaProdNome;
    private javax.swing.JTextField txtCliVendaProdPesquisa;
    private javax.swing.JTextField txtCliVendaProdQtde;
    private javax.swing.JTextField txtCliVendaProdQtdeDesejada;
    private javax.swing.JTextField txtCliVendaProdValor;
    // End of variables declaration//GEN-END:variables
}