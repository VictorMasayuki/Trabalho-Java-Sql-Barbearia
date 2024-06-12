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

public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    //Read usuarios
    private void consultar() {
        String sql = "select * from cliente where idcliente=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txttelaclienteid.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txttelaclientenome.setText(rs.getString(2));
                txttelaclientetelefone.setText(rs.getString(3));
                txttelaclientelogin.setText(rs.getString(4));
                txttelaclientesenha.setText(rs.getString(5));
                comboboxclienteperfil.setSelectedItem(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Create usuarios
    private void criar() {
        String sql = "insert into cliente(idcliente, nome, telefone, login, senha, perfil) values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txttelaclienteid.getText());
            pst.setString(2, txttelaclientenome.getText());
            pst.setString(3, txttelaclientetelefone.getText());
            pst.setString(4, txttelaclientelogin.getText());
            pst.setString(5, txttelaclientesenha.getText());
            pst.setString(6, comboboxclienteperfil.getSelectedItem().toString());
            if ((txttelaclienteid.getText().isEmpty()) || (txttelaclientenome.getText().isEmpty()) || (txttelaclientelogin.getText().isEmpty()) || (txttelaclientesenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Update usuarios
    private void atualizar() {
        String sql = "update cliente set nome=?, telefone=?, login=?, senha=?, perfil=? where idcliente=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txttelaclientenome.getText());
            pst.setString(2, txttelaclientetelefone.getText());
            pst.setString(3, txttelaclientelogin.getText());
            pst.setString(4, txttelaclientesenha.getText());
            pst.setString(5, comboboxclienteperfil.getSelectedItem().toString());
            pst.setString(6, txttelaclienteid.getText());

            //confirmar alteração de usuários
            if ((txttelaclienteid.getText().isEmpty()) || (txttelaclientenome.getText().isEmpty()) || (txttelaclientelogin.getText().isEmpty()) || (txttelaclientesenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Delete usuarios
    private void deletar() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            String sql = "delete from cliente where idcliente=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txttelaclienteid.getText());
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                     limpar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void limpar(){
            txttelaclienteid.setText(null);
            txttelaclientenome.setText(null);
            txttelaclientetelefone.setText(null);
            txttelaclientelogin.setText(null);
            txttelaclientesenha.setText(null);
            comboboxclienteperfil.setSelectedItem(null);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telausuarioid = new javax.swing.JLabel();
        telausuarionome = new javax.swing.JLabel();
        telausuariotelefone = new javax.swing.JLabel();
        telausuariologin = new javax.swing.JLabel();
        telausuariosenha = new javax.swing.JLabel();
        telausuarioperfil = new javax.swing.JLabel();
        txttelaclientenome = new javax.swing.JTextField();
        txttelaclientetelefone = new javax.swing.JTextField();
        txttelaclientelogin = new javax.swing.JTextField();
        txttelaclientesenha = new javax.swing.JTextField();
        comboboxclienteperfil = new javax.swing.JComboBox<>();
        btnclientecreate = new javax.swing.JButton();
        btnclienteread = new javax.swing.JButton();
        btnclienteupdate = new javax.swing.JButton();
        btnclientedelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txttelaclienteid = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cliente");
        setPreferredSize(new java.awt.Dimension(837, 509));

        telausuarioid.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioid.setText("id:");

        telausuarionome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome.setText("nome:");

        telausuariotelefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuariotelefone.setText("telefone:");

        telausuariologin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuariologin.setText("login/email:");

        telausuariosenha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuariosenha.setText("senha:");

        telausuarioperfil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioperfil.setText("perfil:");

        txttelaclientenome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelaclientenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelaclientenomeActionPerformed(evt);
            }
        });

        txttelaclientetelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelaclientetelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelaclientetelefoneActionPerformed(evt);
            }
        });

        txttelaclientelogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttelaclientelogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelaclienteloginActionPerformed(evt);
            }
        });

        txttelaclientesenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboboxclienteperfil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxclienteperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "cliente", "recepcao" }));

        btnclientecreate.setText("Criar");
        btnclientecreate.setToolTipText("Adicionar");
        btnclientecreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclientecreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientecreateActionPerformed(evt);
            }
        });

        btnclienteread.setText("Consultar");
        btnclienteread.setToolTipText("Consultar");
        btnclienteread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclienteread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientereadActionPerformed(evt);
            }
        });

        btnclienteupdate.setText("Atualizar");
        btnclienteupdate.setToolTipText("Alterar");
        btnclienteupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclienteupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclienteupdateActionPerformed(evt);
            }
        });

        btnclientedelete.setText("Remover");
        btnclientedelete.setToolTipText("Apagar");
        btnclientedelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclientedelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientedeleteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("Tabela de cadastro de clientes");

        txttelaclienteid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnclientecreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(95, 95, 95)
                        .addComponent(btnclienteread, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(102, 102, 102)
                        .addComponent(btnclienteupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(btnclientedelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(telausuariologin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttelaclientelogin))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(telausuarioid)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttelaclienteid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(telausuarionome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttelaclientenome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(telausuariotelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttelaclientetelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(telausuariosenha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttelaclientesenha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telausuarioperfil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboboxclienteperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))))
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telausuarioid)
                            .addComponent(txttelaclienteid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telausuarionome)
                            .addComponent(txttelaclientenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telausuarioperfil)
                            .addComponent(comboboxclienteperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telausuariotelefone)
                            .addComponent(txttelaclientetelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telausuariologin)
                        .addComponent(txttelaclientelogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telausuariosenha)
                        .addComponent(txttelaclientesenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclientecreate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclienteread, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclienteupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclientedelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnclientecreate, btnclientedelete, btnclienteread, btnclienteupdate});

        setBounds(0, 0, 838, 509);
    }// </editor-fold>//GEN-END:initComponents

    private void txttelaclientetelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelaclientetelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelaclientetelefoneActionPerformed

    private void txttelaclienteloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelaclienteloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelaclienteloginActionPerformed

    private void btnclientereadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientereadActionPerformed
        // Read
        consultar();
    }//GEN-LAST:event_btnclientereadActionPerformed

    private void btnclientecreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientecreateActionPerformed
        // Create
        criar();
    }//GEN-LAST:event_btnclientecreateActionPerformed

    private void txttelaclientenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelaclientenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelaclientenomeActionPerformed

    private void btnclienteupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclienteupdateActionPerformed
        // Update
        atualizar();
    }//GEN-LAST:event_btnclienteupdateActionPerformed

    private void btnclientedeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientedeleteActionPerformed
        // Delete
        deletar();
    }//GEN-LAST:event_btnclientedeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclientecreate;
    private javax.swing.JButton btnclientedelete;
    private javax.swing.JButton btnclienteread;
    private javax.swing.JButton btnclienteupdate;
    private javax.swing.JComboBox<String> comboboxclienteperfil;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel telausuarioid;
    private javax.swing.JLabel telausuariologin;
    private javax.swing.JLabel telausuarionome;
    private javax.swing.JLabel telausuarioperfil;
    private javax.swing.JLabel telausuariosenha;
    private javax.swing.JLabel telausuariotelefone;
    private javax.swing.JTextField txttelaclienteid;
    private javax.swing.JTextField txttelaclientelogin;
    private javax.swing.JTextField txttelaclientenome;
    private javax.swing.JTextField txttelaclientesenha;
    private javax.swing.JTextField txttelaclientetelefone;
    // End of variables declaration//GEN-END:variables
}
