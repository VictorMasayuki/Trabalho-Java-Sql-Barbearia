/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package barbearia.telas;

/**
 *
 * @author victo
 */
import java.sql.*;
import barbearia.dal.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class TelaUsuario extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
        }
        
        private void criar() {
        String sql = "insert into cadastro(nomecadastro, telefonecadastro, email, endereco) values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txttelausuarionome.getText());
            pst.setString(2, txttelausuariotelefone.getText());
            pst.setString(3, txttelausuarioemail.getText());
            pst.setString(4, txttelausuarioendereco.getText());
            if ((txttelausuarionome.getText().isEmpty()) || (txttelausuariotelefone.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        //Filtro de pesquisa para usuários
        private void filtrar(){
        String sql = "select idcadastro as Id, nomecadastro as Nome, telefonecadastro as Telefone, email as Email, endereco as Endereço from cadastro where nomecadastro like ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txttelausuariopesquisa.getText() + '%');
                rs=pst.executeQuery();
                tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
        }  
    }
    
        //Set campos
        private void set_campos(){
            int setar = tblUsuarios.getSelectedRow();
            txttelausuarioid.setText(tblUsuarios.getModel().getValueAt(setar,0).toString());
            txttelausuarionome.setText(tblUsuarios.getModel().getValueAt(setar,1).toString());
            txttelausuariotelefone.setText(tblUsuarios.getModel().getValueAt(setar,2).toString());
            txttelausuarioemail.setText(tblUsuarios.getModel().getValueAt(setar,3).toString());
            txttelausuarioendereco.setText(tblUsuarios.getModel().getValueAt(setar,4).toString());
            btnusuariocreate.setEnabled(false);
        }
        
        //Update usuarios
        private void atualizar() {
            String sql = "update cadastro set nomecadastro=?, telefonecadastro=?, email=?, endereco=? where idcadastro=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txttelausuarionome.getText());
                pst.setString(2, txttelausuariotelefone.getText());
                pst.setString(3, txttelausuarioemail.getText());
                pst.setString(4, txttelausuarioendereco.getText());
                pst.setString(5, txttelausuarioid.getText());
              
            //confirmar alteração de usuários
            if ((txttelausuarionome.getText().isEmpty()) || (txttelausuariotelefone.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
                    limpar();
                    btnusuariocreate.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        //Delete usuarios
        private void deletar() {
            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                String sql = "delete from cadastro where idcadastro=?";
                try {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, txttelausuarioid.getText());
                    int adicionado = pst.executeUpdate();
                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                        limpar();
                        btnusuariocreate.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
        
        //Limpar textos
        private void limpar(){
            txttelausuariopesquisa.setText(null);
            txttelausuarioid.setText(null);
            txttelausuarionome.setText(null);
            txttelausuariotelefone.setText(null);
            txttelausuarioemail.setText(null);
            txttelausuarioendereco.setText(null);
            ((DefaultTableModel) tblUsuarios.getModel()).setRowCount(0);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telausuarionome = new javax.swing.JLabel();
        telausuarioemail = new javax.swing.JLabel();
        telausuariotelefone = new javax.swing.JLabel();
        telausuarioendereco = new javax.swing.JLabel();
        txttelausuariotelefone = new javax.swing.JTextField();
        txttelausuarionome = new javax.swing.JTextField();
        txttelausuarioendereco = new javax.swing.JTextField();
        txttelausuarioemail = new javax.swing.JTextField();
        btnusuarioupdate = new javax.swing.JButton();
        btnusuariocreate = new javax.swing.JButton();
        btnusuariodelete = new javax.swing.JButton();
        txttelausuariopesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txttelausuarioid = new javax.swing.JTextField();
        telausuarioid = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuário");

        telausuarionome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome.setText("nome:");

        telausuarioemail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioemail.setText("email:");

        telausuariotelefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuariotelefone.setText("telefone:");

        telausuarioendereco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioendereco.setText("endereço:");

        txttelausuariotelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelausuariotelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelausuariotelefoneActionPerformed(evt);
            }
        });

        txttelausuarionome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelausuarionome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelausuarionomeActionPerformed(evt);
            }
        });

        txttelausuarioendereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelausuarioendereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelausuarioenderecoActionPerformed(evt);
            }
        });

        txttelausuarioemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelausuarioemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelausuarioemailActionPerformed(evt);
            }
        });

        btnusuarioupdate.setText("Atualizar");
        btnusuarioupdate.setToolTipText("Atualizar");
        btnusuarioupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuarioupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuarioupdateActionPerformed(evt);
            }
        });

        btnusuariocreate.setText("Cadastrar");
        btnusuariocreate.setToolTipText("Alterar");
        btnusuariocreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuariocreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuariocreateActionPerformed(evt);
            }
        });

        btnusuariodelete.setText("Remover");
        btnusuariodelete.setToolTipText("Apagar");
        btnusuariodelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuariodelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuariodeleteActionPerformed(evt);
            }
        });

        txttelausuariopesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelausuariopesquisaActionPerformed(evt);
            }
        });
        txttelausuariopesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelausuariopesquisaKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\victo\\Downloads\\NetBeans\\Icones\\icone pesquisar.png")); // NOI18N
        jLabel1.setText("jLabel1");

        tblUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone", "Email", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setFocusable(false);
        tblUsuarios.getTableHeader().setResizingAllowed(false);
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        tblUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblUsuariosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        txttelausuarioid.setBackground(new java.awt.Color(60, 63, 65));
        txttelausuarioid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelausuarioid.setEnabled(false);

        telausuarioid.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioid.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(telausuarioendereco)
                        .addGap(12, 12, 12)
                        .addComponent(txttelausuarioendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txttelausuariopesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(telausuariotelefone))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(telausuarioemail)
                                        .addComponent(telausuarionome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttelausuariotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txttelausuarioemail, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttelausuarionome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(telausuarioid)
                                    .addGap(18, 18, 18)
                                    .addComponent(txttelausuarioid, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnusuariocreate)
                .addGap(58, 58, 58)
                .addComponent(btnusuarioupdate)
                .addGap(53, 53, 53)
                .addComponent(btnusuariodelete)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelausuariopesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telausuarionome)
                    .addComponent(txttelausuarionome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelausuarioid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telausuarioid))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telausuarioemail)
                    .addComponent(txttelausuarioemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telausuariotelefone)
                    .addComponent(txttelausuariotelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelausuarioendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telausuarioendereco))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnusuariocreate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnusuariodelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnusuarioupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelausuariotelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelausuariotelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelausuariotelefoneActionPerformed

    private void txttelausuarionomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelausuarionomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelausuarionomeActionPerformed

    private void txttelausuarioenderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelausuarioenderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelausuarioenderecoActionPerformed

    private void txttelausuarioemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelausuarioemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelausuarioemailActionPerformed

    private void btnusuariocreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuariocreateActionPerformed
        // Create cadastrar usuarios
        criar();
    }//GEN-LAST:event_btnusuariocreateActionPerformed

    private void txttelausuariopesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelausuariopesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelausuariopesquisaActionPerformed

    private void txttelausuariopesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelausuariopesquisaKeyReleased
        // Chamar o filtrar
        filtrar();
    }//GEN-LAST:event_txttelausuariopesquisaKeyReleased

    private void tblUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUsuariosKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblUsuariosKeyReleased

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // Setar campos
        set_campos();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnusuarioupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuarioupdateActionPerformed
        // Update usuarios
        atualizar();
    }//GEN-LAST:event_btnusuarioupdateActionPerformed

    private void btnusuariodeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuariodeleteActionPerformed
        // Delete usuarios
        deletar();
    }//GEN-LAST:event_btnusuariodeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnusuariocreate;
    private javax.swing.JButton btnusuariodelete;
    private javax.swing.JButton btnusuarioupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JLabel telausuarioemail;
    private javax.swing.JLabel telausuarioendereco;
    private javax.swing.JLabel telausuarioid;
    private javax.swing.JLabel telausuarionome;
    private javax.swing.JLabel telausuariotelefone;
    private javax.swing.JTextField txttelausuarioemail;
    private javax.swing.JTextField txttelausuarioendereco;
    private javax.swing.JTextField txttelausuarioid;
    private javax.swing.JTextField txttelausuarionome;
    private javax.swing.JTextField txttelausuariopesquisa;
    private javax.swing.JTextField txttelausuariotelefone;
    // End of variables declaration//GEN-END:variables
}
