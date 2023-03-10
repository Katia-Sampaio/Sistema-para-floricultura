package view;

import DAO.AnaliticoDAO;
import DAO.VendasDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.VendasItem;


public class RelatorioAnalitico extends javax.swing.JFrame {
    public int CodVenda = 0;
    
    public RelatorioAnalitico() {
        initComponents();
    }
    public RelatorioAnalitico(int CodVenda) {
            initComponents();
            
            this.CodVenda = CodVenda;
            
            ArrayList<VendasItem> ListaItens = AnaliticoDAO.listar(CodVenda);
            
             DefaultTableModel modelo = (DefaultTableModel) tbITENS.getModel();
            modelo.setRowCount(0);
            
            for(VendasItem Item : ListaItens){
                modelo.addRow(new String[]{String.valueOf(Item.getIdVenda()),
                    String.valueOf (Item.getCodProduto()),
                    VendasDAO.RetornaNomeProduto(Item.getCodProduto()),
                    String.valueOf(Item.getQtMovimento()),
                    String.valueOf (Item.getVlUnitario()),
                    String.valueOf(Item.getVlTotal())});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbITENS = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Vendas (Analítico)");

        tbITENS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cod Venda", "Cod Produto", "Produto", "Quantidade", "Vl Unitário", "Vl total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbITENS.setToolTipText("");
        jScrollPane1.setViewportView(tbITENS);
        if (tbITENS.getColumnModel().getColumnCount() > 0) {
            tbITENS.getColumnModel().getColumn(0).setResizable(false);
            tbITENS.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbITENS.getColumnModel().getColumn(1).setResizable(false);
            tbITENS.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbITENS.getColumnModel().getColumn(2).setResizable(false);
            tbITENS.getColumnModel().getColumn(2).setPreferredWidth(220);
            tbITENS.getColumnModel().getColumn(3).setResizable(false);
            tbITENS.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbITENS.getColumnModel().getColumn(4).setResizable(false);
            tbITENS.getColumnModel().getColumn(4).setPreferredWidth(90);
            tbITENS.getColumnModel().getColumn(5).setResizable(false);
            tbITENS.getColumnModel().getColumn(5).setPreferredWidth(90);
        }

        jToggleButton1.setText("Voltar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioAnalitico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioAnalitico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tbITENS;
    // End of variables declaration//GEN-END:variables
}
