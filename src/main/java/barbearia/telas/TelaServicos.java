/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package barbearia.telas;

import java.sql.*;
import barbearia.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author victo
 */
public class TelaServicos extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private String tipo;
    /**
     * Creates new form TelaServicos
     */
    public TelaServicos() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void pesquisarCliente(){
        //OBS: VINCULAR O BANCO DE DADOS CLIENTE COM A TABELA AGENDAMENTO
        String sql = "select idcliente as Id ,cliente.nome as Nome, cliente.telefone as Telefone, agendamento.data_agendamento as Data, agendamento.hora_agendamento as Hora, agendamento.tipo_servico as Servico from cliente inner join agendamento on cliente.idcliente = agendamento.clienteid where cliente.nome like ?";  
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtServicoPesquisar.getText() + "%");
            rs=pst.executeQuery();
            tblServicos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setCampos(){
        int setar = tblServicos.getSelectedRow();
        txtServicoId.setText(tblServicos.getModel().getValueAt(setar, 0).toString());
        txtServicoClienteNome.setText(tblServicos.getModel().getValueAt(setar,1).toString());
        txtServicoClienteTelefone.setText(tblServicos.getModel().getValueAt(setar,2).toString());
        
        try {
        // Convertendo java.util.Date para java.sql.Date
        String dataString = tblServicos.getModel().getValueAt(setar, 3).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateUtil = sdf.parse(dataString);
        java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
        
        TelaClienteData.setDate(dateSql);
            } catch (Exception e) {
        }

        cboxServicoHora.setSelectedItem(tblServicos.getModel().getValueAt(setar,4).toString());
        
        String tiposervico = tblServicos.getModel().getValueAt(setar, 5).toString();
        if (tiposervico.equals("Cabelo")) {
            rbttncabelo.setSelected(true);
        } else if (tiposervico.equals("Barba")) {
            rbttnbarba.setSelected(true);
        } else if (tiposervico.equals("Combo")) {
            rbttncombo.setSelected(true);
        }
    }
    
    //Update de clientes e agendamento
        private void atualizarcliente() {
            String sql = "update cliente set nome=?, telefone=? where idcliente=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtServicoClienteNome.getText());
                pst.setString(2, txtServicoClienteTelefone.getText());
                pst.setString(3, txtServicoId.getText());
              
            //confirmar alteração de usuários
            if ((txtServicoClienteNome.getText().isEmpty()) || (txtServicoClienteTelefone.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Serviço de cliente alterado com sucesso!");
                    txtServicoClienteNome.setText(null);
                    txtServicoClienteTelefone.setText(null);
                    txtServicoId.setText(null);
                    btnServicoClienteUpdate.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

        private void atualizaragendamento() {
            String sql = "update agendamento set data_agendamento=?, hora_agendamento=?, tipo_servico=? where clienteid=?";
            try {
                pst = conexao.prepareStatement(sql);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String data = sdf.format(TelaClienteData.getDate());
                pst.setString(1, data);
                pst.setString(2, cboxServicoHora.getSelectedItem().toString());
                pst.setString(3, tipo);
                pst.setString(4, txtServicoId.getText());
              
            //confirmar alteração de usuários
            if ((TelaClienteData == null || cboxServicoHora.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Serviço de agendamento alterado com sucesso!");
                    TelaClienteData.setDate(null);
                    cboxServicoHora.setSelectedItem(null);
                    btnServicoClienteUpdate.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtServicoPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtServicoId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnServicoClienteDelete = new javax.swing.JButton();
        btnServicoClienteUpdate = new javax.swing.JButton();
        telausuarionome = new javax.swing.JLabel();
        telausuarioemail = new javax.swing.JLabel();
        telausuariotelefone = new javax.swing.JLabel();
        telausuarioendereco = new javax.swing.JLabel();
        txtServicoClienteNome = new javax.swing.JTextField();
        txtServicoClienteTelefone = new javax.swing.JTextField();
        telausuarionome1 = new javax.swing.JLabel();
        rbttncabelo = new javax.swing.JRadioButton();
        rbttnbarba = new javax.swing.JRadioButton();
        rbttncombo = new javax.swing.JRadioButton();
        TelaClienteData = new com.toedter.calendar.JDateChooser();
        cboxServicoHora = new javax.swing.JComboBox<>();
        btnServicoAgendamentoUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Serviços");
        setPreferredSize(new java.awt.Dimension(837, 509));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviços"));

        txtServicoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtServicoPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\victo\\Downloads\\NetBeans\\Icones\\icone pesquisar.png")); // NOI18N

        jLabel2.setText("*Id");

        txtServicoId.setEditable(false);

        tblServicos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone", "Data", "Hora", "Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblServicos.getTableHeader().setResizingAllowed(false);
        tblServicos.getTableHeader().setReorderingAllowed(false);
        tblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicos);

        btnServicoClienteDelete.setText("Remover");
        btnServicoClienteDelete.setToolTipText("Atualizar");
        btnServicoClienteDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicoClienteDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicoClienteDeleteActionPerformed(evt);
            }
        });

        btnServicoClienteUpdate.setText("Atualizar Cliente");
        btnServicoClienteUpdate.setToolTipText("Alterar");
        btnServicoClienteUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicoClienteUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicoClienteUpdateActionPerformed(evt);
            }
        });

        telausuarionome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome.setText("nome:");

        telausuarioemail.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioemail.setText("Data:");

        telausuariotelefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuariotelefone.setText("telefone:");

        telausuarioendereco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarioendereco.setText("Hora:");

        txtServicoClienteNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtServicoClienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicoClienteNomeActionPerformed(evt);
            }
        });

        txtServicoClienteTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtServicoClienteTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicoClienteTelefoneActionPerformed(evt);
            }
        });

        telausuarionome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telausuarionome1.setText("Serviço:");

        buttonGroup1.add(rbttncabelo);
        rbttncabelo.setText("Cabelo");
        rbttncabelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbttncabeloActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbttnbarba);
        rbttnbarba.setText("Barba");
        rbttnbarba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbttnbarbaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbttncombo);
        rbttncombo.setText("Combo");
        rbttncombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbttncomboActionPerformed(evt);
            }
        });

        cboxServicoHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:30", "14:00", "15:00", "15:30", "16:00", "16:30" }));

        btnServicoAgendamentoUpdate.setText("Atualizar Agendamento");
        btnServicoAgendamentoUpdate.setToolTipText("Alterar");
        btnServicoAgendamentoUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServicoAgendamentoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicoAgendamentoUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnServicoClienteUpdate)
                                .addGap(55, 55, 55)
                                .addComponent(btnServicoAgendamentoUpdate)
                                .addGap(307, 307, 307)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtServicoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServicoId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(telausuarionome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtServicoClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(telausuariotelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtServicoClienteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TelaClienteData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxServicoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnServicoClienteDelete)
                                        .addGap(26, 26, 26))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(telausuarionome1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(telausuarioendereco, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(telausuarioemail, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(14, 14, 14)
                                        .addComponent(rbttncabelo)
                                        .addGap(18, 18, 18)))
                                .addComponent(rbttnbarba)
                                .addGap(18, 18, 18)
                                .addComponent(rbttncombo)
                                .addGap(20, 20, 20))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServicoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServicoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telausuarioemail)
                            .addComponent(TelaClienteData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telausuarioendereco)
                            .addComponent(cboxServicoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telausuarionome1)
                            .addComponent(rbttncabelo)
                            .addComponent(rbttnbarba)
                            .addComponent(rbttncombo)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtServicoClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telausuarionome))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telausuariotelefone)
                            .addComponent(txtServicoClienteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnServicoAgendamentoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnServicoClienteDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnServicoClienteUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServicoPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicoPesquisarKeyReleased
        // Chamando PesquisarCliente
        pesquisarCliente();
    }//GEN-LAST:event_txtServicoPesquisarKeyReleased

    private void tblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicosMouseClicked
        // Método setarCampo
        setCampos();
    }//GEN-LAST:event_tblServicosMouseClicked

    private void btnServicoClienteDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicoClienteDeleteActionPerformed

        
    }//GEN-LAST:event_btnServicoClienteDeleteActionPerformed

    private void btnServicoClienteUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicoClienteUpdateActionPerformed
        // update clientes e agendamentos
        atualizarcliente();
    }//GEN-LAST:event_btnServicoClienteUpdateActionPerformed

    private void txtServicoClienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicoClienteNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicoClienteNomeActionPerformed

    private void txtServicoClienteTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicoClienteTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicoClienteTelefoneActionPerformed

    private void rbttncabeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbttncabeloActionPerformed
        // Atribuição de texto ao ser selecionado
        tipo = "Cabelo";
    }//GEN-LAST:event_rbttncabeloActionPerformed

    private void rbttnbarbaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbttnbarbaActionPerformed
        // Atribuição de texto ao ser selecionado
        tipo = "Barba";
    }//GEN-LAST:event_rbttnbarbaActionPerformed

    private void rbttncomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbttncomboActionPerformed
        // Atribuição de texto ao ser selecionado
        tipo = "Combo";
    }//GEN-LAST:event_rbttncomboActionPerformed

    private void btnServicoAgendamentoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicoAgendamentoUpdateActionPerformed
        // TODO add your handling code here:
        atualizaragendamento();
    }//GEN-LAST:event_btnServicoAgendamentoUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser TelaClienteData;
    private javax.swing.JButton btnServicoAgendamentoUpdate;
    private javax.swing.JButton btnServicoClienteDelete;
    private javax.swing.JButton btnServicoClienteUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboxServicoHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbttnbarba;
    private javax.swing.JRadioButton rbttncabelo;
    private javax.swing.JRadioButton rbttncombo;
    private javax.swing.JTable tblServicos;
    private javax.swing.JLabel telausuarioemail;
    private javax.swing.JLabel telausuarioendereco;
    private javax.swing.JLabel telausuarionome;
    private javax.swing.JLabel telausuarionome1;
    private javax.swing.JLabel telausuariotelefone;
    private javax.swing.JTextField txtServicoClienteNome;
    private javax.swing.JTextField txtServicoClienteTelefone;
    private javax.swing.JTextField txtServicoId;
    private javax.swing.JTextField txtServicoPesquisar;
    // End of variables declaration//GEN-END:variables
}
