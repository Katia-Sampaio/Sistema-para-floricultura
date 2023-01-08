package view;

import DAO.ClienteDAO;
import DAO.VendasDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.VendasCabecalho;

public class TelaCancelarVenda extends javax.swing.JFrame {


    public TelaCancelarVenda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeletar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFK_VENDA = new javax.swing.JTextField();
        btnBUSCARVENDA = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDS_MOTIVOCANCELAMENTO = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jButton5.setText("Fechar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deletar Venda");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("ID Venda:");

        txtFK_VENDA.setBackground(new java.awt.Color(255, 255, 153));
        txtFK_VENDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFK_VENDAActionPerformed(evt);
            }
        });
        txtFK_VENDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFK_VENDAKeyTyped(evt);
            }
        });

        btnBUSCARVENDA.setText("Buscar");
        btnBUSCARVENDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCARVENDAActionPerformed(evt);
            }
        });

        btnCANCELAR.setText("Ok");
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Motivo:"));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 153));

        txtDS_MOTIVOCANCELAMENTO.setBackground(new java.awt.Color(255, 255, 153));
        txtDS_MOTIVOCANCELAMENTO.setColumns(20);
        txtDS_MOTIVOCANCELAMENTO.setRows(5);
        jScrollPane2.setViewportView(txtDS_MOTIVOCANCELAMENTO);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Venda", "Cliente", "E-mail", "Telefone", "Vlr Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVenda);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFK_VENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBUSCARVENDA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnCANCELAR)
                .addGap(46, 46, 46)
                .addComponent(btnFechar)
                .addGap(0, 205, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFK_VENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUSCARVENDA))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCANCELAR)
                    .addComponent(btnFechar))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBUSCARVENDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCARVENDAActionPerformed
        int id = 0;
        boolean retorno = false;
        
        if(txtFK_VENDA.getText().trim().equals("")){
            return;
        }
        
        id = Integer.parseInt(txtFK_VENDA.getText());
        
        retorno = VendasDAO.ValidaVendaExistente(id);
        
        if(!retorno){
            JOptionPane.showMessageDialog(this,"Venda não encontrada.");
            return;
        }
        
        VendasCabecalho objVenda = new VendasCabecalho();
        Clientes objCliente = new Clientes();

        objVenda = VendasDAO.buscarVenda(id);
        objCliente = ClienteDAO.buscarDadosClientes(objVenda.getCodCliente());
        
        DefaultTableModel modelo = (DefaultTableModel) tblVenda.getModel();
        modelo.setRowCount(0);

        
        modelo.addRow(new String[]{
            String.valueOf(objVenda.getIdVenda()),
            objCliente.getNome(),
            objCliente.getEmail(),
            objCliente.getTelefone(),
            String.valueOf(objVenda.getValorVenda())
        });        
    }//GEN-LAST:event_btnBUSCARVENDAActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        int id = 0;
        String Motivo = "";
        boolean retorno = false;
        
        if ((txtFK_VENDA.getText().trim().isEmpty()) || (txtDS_MOTIVOCANCELAMENTO.getText().trim().isEmpty())){
            JOptionPane.showMessageDialog(this,"Campo obrigatório não preenchido!");
            return;
        }
        
        id = Integer.parseInt(txtFK_VENDA.getText());
        Motivo = txtDS_MOTIVOCANCELAMENTO.getText().trim();
        
        retorno = VendasDAO.CancelarVenda(id,Motivo);
        
        if(retorno){
            JOptionPane.showMessageDialog(this,"Venda cancelada com sucesso.");  
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Erro ao cancelar Venda.");  
        }
        
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();     
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtFK_VENDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFK_VENDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFK_VENDAActionPerformed

    private void txtFK_VENDAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFK_VENDAKeyTyped
        if (txtFK_VENDA.getText().length() >= 10) {
            evt.consume();

        }
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)){
            evt.consume();

        }
    }//GEN-LAST:event_txtFK_VENDAKeyTyped

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
            java.util.logging.Logger.getLogger(TelaCancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCancelarVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBUSCARVENDA;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextArea txtDS_MOTIVOCANCELAMENTO;
    private javax.swing.JTextField txtFK_VENDA;
    // End of variables declaration//GEN-END:variables
}
