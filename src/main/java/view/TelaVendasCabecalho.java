package view;

import DAO.VendasDAO;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import model.VendasCabecalho;
import model.VendasItem;


public class TelaVendasCabecalho extends javax.swing.JFrame {
    TelaVendasItens VendasItens = null;
    TelaBuscaCliente BuscaCli = null;
    ArrayList<VendasItem> listaItens = new ArrayList<VendasItem>();
    
    // Incluindo o JFrame como objeto para que seja possível manipular a grade ao incluir o item.
    TelaVendasCabecalho VendasCab = this;
    
    public TelaVendasCabecalho() {
        initComponents();
        Date DataAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String DataVenda = formato.format(DataAtual);
        txtDH_VENDA.setText(DataVenda);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblITENS = new javax.swing.JTable();
        btnDeletarItem = new javax.swing.JButton();
        btnIncluirItem = new javax.swing.JButton();
        btnAlterarItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPK_ID = new javax.swing.JTextField();
        txtFK_CLIENTE = new javax.swing.JTextField();
        btnBUSCAPROD = new javax.swing.JButton();
        txtVL_VENDA = new javax.swing.JTextField();
        txtDH_VENDA = new javax.swing.JTextField();
        txtDS_NOME = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens da Venda"));

        tblITENS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblITENS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Produto", "Desc.Prod.", "Qtde. Item", "Valor Unit", "Valor Total", "Valor Desc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblITENS);

        btnDeletarItem.setText("Deletar");
        btnDeletarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarItemActionPerformed(evt);
            }
        });

        btnIncluirItem.setText("Incluir");
        btnIncluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirItemActionPerformed(evt);
            }
        });

        btnAlterarItem.setText("Alterar");
        btnAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDeletarItem, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAlterarItem, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnIncluirItem))
                .addGap(6, 6, 6))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterarItem, btnDeletarItem, btnIncluirItem});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIncluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAlterarItem, btnDeletarItem, btnIncluirItem});

        jLabel1.setText("ID Venda:");

        jLabel2.setText("Cliente");

        jLabel3.setText("Valor Total");

        jLabel4.setText("Data/Hora ");

        txtPK_ID.setEnabled(false);

        txtFK_CLIENTE.setBackground(new java.awt.Color(255, 255, 204));
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
        txtFK_CLIENTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFK_CLIENTEKeyTyped(evt);
            }
        });

        btnBUSCAPROD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa_icon.png"))); // NOI18N
        btnBUSCAPROD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCAPRODActionPerformed(evt);
            }
        });

        txtVL_VENDA.setEditable(false);
        txtVL_VENDA.setBackground(new java.awt.Color(255, 255, 255));
        txtVL_VENDA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVL_VENDA.setEnabled(false);
        txtVL_VENDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVL_VENDAActionPerformed(evt);
            }
        });

        txtDH_VENDA.setEditable(false);
        txtDH_VENDA.setBackground(new java.awt.Color(255, 255, 255));
        txtDH_VENDA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDH_VENDA.setEnabled(false);

        txtDS_NOME.setEditable(false);

        btnIncluir.setText("Confirmar");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(245, 245, 245))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtVL_VENDA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txtFK_CLIENTE)
                            .addComponent(txtPK_ID)
                            .addComponent(txtDH_VENDA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBUSCAPROD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDS_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPK_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFK_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVL_VENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDH_VENDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBUSCAPROD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtDS_NOME)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnIncluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar?",
            "Saída", JOptionPane.YES_NO_OPTION);
        if(resultado == JOptionPane.YES_OPTION){
            this.dispose();
            //TelaMenuVendas frame = new TelaMenuVendas();
            //frame.setLocationRelativeTo(null);
            //frame.setVisible(true);
            
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        int CodigoCliente = 0;
        double ValorDaVenda = 0;
        boolean retorno = false;
        
        Date DataAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String DataVenda = formato.format(DataAtual);
        txtDH_VENDA.setText(DataVenda);
        
        if(txtFK_CLIENTE.getText() .isEmpty()){
            JOptionPane.showMessageDialog(this, "O campo (ID do Cliente) não pode estar vazio");
            return;

        }
                
        if (listaItens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não é possível incluir uma venda sem itens!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(txtVL_VENDA.getText() .isEmpty()){
            JOptionPane.showMessageDialog(this, "O campo (Valor da Venda) não pode estar vazio");
            return;
        }
        
        CodigoCliente = Integer.parseInt(txtFK_CLIENTE.getText());
        ValorDaVenda = Double.parseDouble(txtVL_VENDA.getText());
        DataVenda = txtDH_VENDA.getText();
        
        VendasCabecalho objCabecalho = new VendasCabecalho(CodigoCliente, ValorDaVenda, DataAtual,listaItens);
        
        retorno = VendasDAO.salvar(objCabecalho);
        
        if(retorno){
            JOptionPane.showMessageDialog(this, "Venda incluída com sucesso!");
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao incluir venda.");
        }
        
        this.dispose();
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void txtVL_VENDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVL_VENDAActionPerformed

    }//GEN-LAST:event_txtVL_VENDAActionPerformed

    private void txtFK_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFK_CLIENTEActionPerformed

    }//GEN-LAST:event_txtFK_CLIENTEActionPerformed

    private void btnAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarItemActionPerformed
        int linha = -1;
        
        linha = tblITENS.getSelectedRow();
        
        if(linha < 0){
            JOptionPane.showMessageDialog(this, "Selecione o item a ser alterado.");
            return;
        }
        
        VendasItem item = listaItens.get(linha);

        this.VendasItens = new TelaVendasItens(item, VendasCab, linha);
        
        VendasItens.setLocationRelativeTo(null);
        VendasItens.show();   
    }//GEN-LAST:event_btnAlterarItemActionPerformed

    private void btnIncluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirItemActionPerformed
        VendasItem item = new VendasItem();
        
        if (VendasItens == null || !VendasItens.isDisplayable()) {
            this.VendasItens = new TelaVendasItens(item, VendasCab);
        }
        VendasItens.setLocationRelativeTo(null);
        VendasItens.show();        
    }//GEN-LAST:event_btnIncluirItemActionPerformed
 
    
    private void btnDeletarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarItemActionPerformed
        int linhaSelecionada = tblITENS.getSelectedRow();
        listaItens.remove(linhaSelecionada);
        ambientarGrade();
    }//GEN-LAST:event_btnDeletarItemActionPerformed

    private void txtFK_CLIENTEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFK_CLIENTEKeyTyped
        if (txtFK_CLIENTE.getText().length() >= 10) {
            evt.consume();

        }
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_SLASH)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFK_CLIENTEKeyTyped

    private void btnBUSCAPRODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCAPRODActionPerformed
        this.BuscaCli = new TelaBuscaCliente(VendasCab);
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

    public void ambientarGrade() {
        DefaultTableModel model = (DefaultTableModel) tblITENS.getModel();
        model.setRowCount(0);

        int size = listaItens.size();
        
        double TotalVenda = 0.00;
        
        for (int i = 0; i < size; i++) {
            VendasItem item = listaItens.get(i);

            if (item != null) {
                Object[] row = new Object[6];

                row[0] = item.getCodProduto();
                row[1] = VendasDAO.RetornaNomeProduto(item.getCodProduto());
                row[2] = item.getQtMovimento();
                row[3] = item.getVlUnitario();
                row[4] = item.getVlTotal();
                row[5] = item.getVlDesconto();
                
                model.addRow(row);
                TotalVenda += item.getVlTotal();
            }
        }
        
        txtVL_VENDA.setText(String.valueOf(TotalVenda));
    }   
          
    

    
    
    
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
            java.util.logging.Logger.getLogger(TelaVendasCabecalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendasCabecalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendasCabecalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendasCabecalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendasCabecalho().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarItem;
    private javax.swing.JButton btnBUSCAPROD;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletarItem;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnIncluirItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblITENS;
    private javax.swing.JTextField txtDH_VENDA;
    public javax.swing.JTextField txtDS_NOME;
    public javax.swing.JTextField txtFK_CLIENTE;
    private javax.swing.JTextField txtPK_ID;
    private javax.swing.JTextField txtVL_VENDA;
    // End of variables declaration//GEN-END:variables

    
  

    
}
