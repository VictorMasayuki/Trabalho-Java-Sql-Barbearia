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
public class TelaGerenciamentoProdutos extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form TelaVendaProdutos
     */
    public TelaGerenciamentoProdutos() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    //Filtro de pesquisa para produtos
        private void filtrar(){
        String sql = "select idproduto as Id, nomeproduto as Nome, quantidade as Quantidade, valor as Valor from produto where nomeproduto like ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtVendaProdPesquisa.getText() + '%');
                rs=pst.executeQuery();
                tblVendaProd.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
        }  
    }
        
    //Set campos
        private void set_campos(){
            int setar = tblVendaProd.getSelectedRow();
            txtVendaProdId.setText(tblVendaProd.getModel().getValueAt(setar,0).toString());
            txtVendaProdNome.setText(tblVendaProd.getModel().getValueAt(setar,1).toString());
            txtVendaProdQtde.setText(tblVendaProd.getModel().getValueAt(setar,2).toString());
            txtVendaProdValor.setText(tblVendaProd.getModel().getValueAt(setar,3).toString());
            btnVendaProdCreate.setEnabled(false);
        }
        
    //Create produtos
    private void criar() {
        String sql = "insert into produto(nomeproduto, quantidade, valor) values(?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtVendaProdNome.getText());
            pst.setString(2, txtVendaProdQtde.getText());
            pst.setString(3, txtVendaProdValor.getText());
            if ((txtVendaProdNome.getText().isEmpty()) || (txtVendaProdQtde.getText().isEmpty()) || (txtVendaProdValor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Update produtos
        private void atualizar() {
            String sql = "update produto set nomeproduto=?, quantidade=?, valor=? where idproduto=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtVendaProdNome.getText());
                pst.setString(2, txtVendaProdQtde.getText());
                pst.setString(3, txtVendaProdValor.getText());
                pst.setString(4, txtVendaProdId.getText());

            if ((txtVendaProdNome.getText().isEmpty()) || (txtVendaProdQtde.getText().isEmpty()) || (txtVendaProdValor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                    limpar();
                    btnVendaProdCreate.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Delete usuarios
        private void deletar() {
            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja remover o produto?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                String sql = "delete from produto where idproduto=?";
                try {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, txtVendaProdId.getText());
                    int adicionado = pst.executeUpdate();
                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                        limpar();
                        btnVendaProdCreate.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }    
    
    private void limpar(){
        txtVendaProdPesquisa.setText(null);
        txtVendaProdNome.setText(null);
        txtVendaProdQtde.setText(null);
        txtVendaProdValor.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendaProd = new javax.swing.JTable();
        txtVendaProdPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        telausuarionome = new javax.swing.JLabel();
        txtVendaProdNome = new javax.swing.JTextField();
        telausuarionome1 = new javax.swing.JLabel();
        telausuarionome2 = new javax.swing.JLabel();
        txtVendaProdValor = new javax.swing.JTextField();
        txtVendaProdQtde = new javax.swing.JTextField();
        btnVendaProdCreate = new javax.swing.JButton();
        btnVendaProdUpdate = new javax.swing.JButton();
        btnVendaProdDelete = new javax.swing.JButton();
        txtVendaProdId = new javax.swing.JTextField();
        telausuarioid = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Tabela de vendas");
        setPreferredSize(new java.awt.Dimension(837, 509));

        tblVendaProd = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblVendaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVendaProd.getTableHeader().setResizingAllowed(false);
        tblVendaProd.getTableHeader().setReorderingAllowed(false);
        tblVendaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendaProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendaProd);

        txtVendaProdPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVendaProdPesquisaKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\victo\\Downloads\\NetBeans\\Icones\\icone pesquisar.png")); // NOI18N
        jLabel1.setText("jLabel1");

        telausuarionome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome.setText("Nome:");

        txtVendaProdNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVendaProdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendaProdNomeActionPerformed(evt);
            }
        });

        telausuarionome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome1.setText("Qtde:");

        telausuarionome2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome2.setText("Valor:");

        txtVendaProdValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVendaProdValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendaProdValorActionPerformed(evt);
            }
        });

        txtVendaProdQtde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVendaProdQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendaProdQtdeActionPerformed(evt);
            }
        });

        btnVendaProdCreate.setText("Cadastrar");
        btnVendaProdCreate.setToolTipText("Alterar");
        btnVendaProdCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaProdCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaProdCreateActionPerformed(evt);
            }
        });

        btnVendaProdUpdate.setText("Atualizar");
        btnVendaProdUpdate.setToolTipText("Alterar");
        btnVendaProdUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaProdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaProdUpdateActionPerformed(evt);
            }
        });

        btnVendaProdDelete.setText("Remover");
        btnVendaProdDelete.setToolTipText("Alterar");
        btnVendaProdDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVendaProdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaProdDeleteActionPerformed(evt);
            }
        });

        txtVendaProdId.setBackground(new java.awt.Color(60, 63, 65));
        txtVendaProdId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVendaProdId.setEnabled(false);

        telausuarioid.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioid.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtVendaProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVendaProdCreate)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telausuarionome1)
                                        .addComponent(telausuarionome2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(telausuarionome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVendaProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtVendaProdQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(txtVendaProdValor)))
                                .addGap(3, 3, 3)))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(telausuarioid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVendaProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnVendaProdUpdate)
                                .addGap(68, 68, 68)
                                .addComponent(btnVendaProdDelete)
                                .addGap(143, 143, 143)))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendaProdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVendaProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telausuarioid))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVendaProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telausuarionome))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVendaProdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telausuarionome1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVendaProdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telausuarionome2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVendaProdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendaProdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendaProdCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVendaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendaProdMouseClicked
        // Setar produtos
        set_campos();
    }//GEN-LAST:event_tblVendaProdMouseClicked

    private void txtVendaProdPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVendaProdPesquisaKeyReleased
        // filtrar
        filtrar(); 
    }//GEN-LAST:event_txtVendaProdPesquisaKeyReleased

    private void txtVendaProdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendaProdNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendaProdNomeActionPerformed

    private void txtVendaProdValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendaProdValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendaProdValorActionPerformed

    private void txtVendaProdQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendaProdQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendaProdQtdeActionPerformed

    private void btnVendaProdCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaProdCreateActionPerformed
        // Create cadastrar produtos
        criar();
    }//GEN-LAST:event_btnVendaProdCreateActionPerformed

    private void btnVendaProdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaProdUpdateActionPerformed
        // Update atualizar produtos
        atualizar();
    }//GEN-LAST:event_btnVendaProdUpdateActionPerformed

    private void btnVendaProdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaProdDeleteActionPerformed
        // Delete remover produtos
        deletar();
    }//GEN-LAST:event_btnVendaProdDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVendaProdCreate;
    private javax.swing.JButton btnVendaProdDelete;
    private javax.swing.JButton btnVendaProdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendaProd;
    private javax.swing.JLabel telausuarioid;
    private javax.swing.JLabel telausuarionome;
    private javax.swing.JLabel telausuarionome1;
    private javax.swing.JLabel telausuarionome2;
    private javax.swing.JTextField txtVendaProdId;
    private javax.swing.JTextField txtVendaProdNome;
    private javax.swing.JTextField txtVendaProdPesquisa;
    private javax.swing.JTextField txtVendaProdQtde;
    private javax.swing.JTextField txtVendaProdValor;
    // End of variables declaration//GEN-END:variables
}
