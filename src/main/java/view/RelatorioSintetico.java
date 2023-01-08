/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.SinteticoDAO;
import DAO.VendasDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import model.RelSintetico;


public class RelatorioSintetico extends javax.swing.JFrame {
    TelaBuscaCliente BuscaCli = null;
    RelatorioSintetico RelSintetico = this;
    
    public RelatorioSintetico() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtFK_CLIENTE = new javax.swing.JTextField();
        txtDS_NOME = new javax.swing.JTextField();
        btnCONFIRMAR = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        chkVerCanceladas = new javax.swing.JCheckBox();
        btnBUSCAPROD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorio = new javax.swing.JTable();
        btnRelAnalitico = new javax.swing.JButton();
        txtTOTAL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Vendas (Sintético)");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Cliente");

        txtFK_CLIENTE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFK_CLIENTE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFK_CLIENTEFocusLost(evt);
            }
        });
        txtFK_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFK_CLIENTEActionPerformed(evt);
            }
        });

        txtDS_NOME.setEditable(false);
        txtDS_NOME.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCONFIRMAR.setText("Prosseguir");
        btnCONFIRMAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONFIRMARActionPerformed(evt);
            }
        });

        btnCANCELAR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCANCELAR.setText("Cancelar");
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        chkVerCanceladas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkVerCanceladas.setText("Ver vendas canceladas");
        chkVerCanceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVerCanceladasActionPerformed(evt);
            }
        });

        btnBUSCAPROD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa_icon.png"))); // NOI18N
        btnBUSCAPROD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCAPRODActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 588, Short.MAX_VALUE)
                        .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkVerCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 561, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFK_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBUSCAPROD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDS_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFK_CLIENTE)
                    .addComponent(txtDS_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUSCAPROD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVerCanceladas)
                .addGap(239, 239, 239)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Filtro", jPanel1);

        tblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Venda", "Dh.Venda", "Cliente", "Nome", "Qt.Itens", "Valor total", "Canc.?", "Motivo Canc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRelatorio);
        if (tblRelatorio.getColumnModel().getColumnCount() > 0) {
            tblRelatorio.getColumnModel().getColumn(0).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblRelatorio.getColumnModel().getColumn(1).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(2).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblRelatorio.getColumnModel().getColumn(3).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(3).setPreferredWidth(220);
            tblRelatorio.getColumnModel().getColumn(4).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(4).setPreferredWidth(70);
            tblRelatorio.getColumnModel().getColumn(5).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(5).setPreferredWidth(90);
            tblRelatorio.getColumnModel().getColumn(6).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblRelatorio.getColumnModel().getColumn(7).setResizable(false);
            tblRelatorio.getColumnModel().getColumn(7).setPreferredWidth(220);
        }

        btnRelAnalitico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRelAnalitico.setText("Zoom Venda (Analítico)");
        btnRelAnalitico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelAnaliticoActionPerformed(evt);
            }
        });

        txtTOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTOTALActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Vendas(R$):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnRelAnalitico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTOTAL)
                    .addComponent(btnRelAnalitico, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Resultado", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRelAnaliticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelAnaliticoActionPerformed
        int linha = tblRelatorio.getSelectedRow();
        
        int FK_VENDA = Integer.parseInt(tblRelatorio.getValueAt(linha,0).toString()); 
        
        RelatorioAnalitico frame = new RelatorioAnalitico(FK_VENDA); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
              
    }//GEN-LAST:event_btnRelAnaliticoActionPerformed

    private void btnCONFIRMARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONFIRMARActionPerformed
        int IdCli = 0;
        boolean VerCanceladas = false;
        ArrayList<RelSintetico> listaRelatorio = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        VerCanceladas=chkVerCanceladas.isSelected();
        
                
        if(txtFK_CLIENTE.getText().trim().equals("")){        
            listaRelatorio = SinteticoDAO.buscarRelatorio(VerCanceladas);

        }else{
            IdCli = Integer.parseInt(txtFK_CLIENTE.getText());
            
            
            boolean retorno = VendasDAO.ValidaClienteExistente(IdCli);
            
            if(!retorno){
                JOptionPane.showMessageDialog(this,"Cliente não encontrado.","Erro no cliente",WARNING_MESSAGE);
                txtDS_NOME.setText("");
                return;
            }
            
            listaRelatorio = SinteticoDAO.buscarRelatorioFiltros(VerCanceladas, IdCli);   
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblRelatorio.getModel();
        modelo.setRowCount(0);
        
        for(RelSintetico Relatorio : listaRelatorio){
            modelo.addRow(new String[]{String.valueOf(Relatorio.getIdVenda()),
                formato.format(Relatorio.getDataVenda()),
                String.valueOf(Relatorio.getCodCliente()),
                Relatorio.getNomeCliente(),
                String.valueOf(Relatorio.getQtProdutos()),
                String.valueOf(Relatorio.getValorVenda()),
                String.valueOf(Relatorio.getDS_CANCELADO()),
                String.valueOf(Relatorio.getDS_MOTIVOCANCELAMENTO())});
        }
        
        ambientarGrade();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnCONFIRMARActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        this.dispose();   
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void chkVerCanceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVerCanceladasActionPerformed
        
    }//GEN-LAST:event_chkVerCanceladasActionPerformed

    private void txtFK_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFK_CLIENTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFK_CLIENTEActionPerformed

    private void txtTOTALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTOTALActionPerformed
        
    }//GEN-LAST:event_txtTOTALActionPerformed

    private void btnBUSCAPRODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCAPRODActionPerformed
        this.BuscaCli = new TelaBuscaCliente(RelSintetico);
        BuscaCli.setLocationRelativeTo(null);
        BuscaCli.show();
    }//GEN-LAST:event_btnBUSCAPRODActionPerformed

    private void txtFK_CLIENTEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFK_CLIENTEFocusLost
        boolean retorno = false;
        int CodCliente = 0;
        String NomeCliente = "";
        
        if(!txtFK_CLIENTE.getText().trim().equals("")){
            CodCliente = Integer.parseInt(txtFK_CLIENTE.getText().trim());
            
            retorno = VendasDAO.ValidaClienteExistente(CodCliente);
            
            if(!retorno){
                JOptionPane.showMessageDialog(this,"Cliente não encontrado.","Erro no cliente",WARNING_MESSAGE);
                txtDS_NOME.setText("");
            }else{
                NomeCliente = VendasDAO.RetornaNomeCliente(CodCliente);
                txtDS_NOME.setText(NomeCliente);                        
            }
        }else{
            txtDS_NOME.setText("");
        } 
    }//GEN-LAST:event_txtFK_CLIENTEFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioSintetico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioSintetico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioSintetico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioSintetico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioSintetico().setVisible(true);
            }
        });
    }
    
    public void ambientarGrade() {
        DefaultTableModel model = (DefaultTableModel) tblRelatorio.getModel();
        
        int size = model.getRowCount();
        
        double TotalVenda = 0.00;
        
        for (int i = 0; i < size; i++) {
            TotalVenda += Double.parseDouble((String) model.getValueAt(i,5));
        }
        
        
        txtTOTAL.setText(String.valueOf(TotalVenda));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBUSCAPROD;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnCONFIRMAR;
    private javax.swing.JButton btnRelAnalitico;
    private javax.swing.JCheckBox chkVerCanceladas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tblRelatorio;
    public javax.swing.JTextField txtDS_NOME;
    public javax.swing.JTextField txtFK_CLIENTE;
    private javax.swing.JTextField txtTOTAL;
    // End of variables declaration//GEN-END:variables
}
