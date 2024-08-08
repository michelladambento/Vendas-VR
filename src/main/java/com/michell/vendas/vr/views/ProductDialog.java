/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.michell.vendas.vr.views;

import com.michell.vendas.vr.dtos.ProductDTO;
import com.michell.vendas.vr.dtos.ProductItemDTO;
import com.michell.vendas.vr.dtos.RetrieveAllProductsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author michell-bento
 */
public class ProductDialog extends javax.swing.JDialog {
    
     
    private static final String PRODUCT_URL = "http://localhost:8080/product/";
    
    private List<ProductItemDTO> productItensDTOs = new ArrayList<>();
    
    public List<ProductItemDTO> getProductItensDTOs() {
        return productItensDTOs;
    }

    public void setProductItensDTOs(List<ProductItemDTO> productItensDTOs) {
        this.productItensDTOs = productItensDTOs;
    }
    
  
    /**
     * Creates new form ProductDialog
     */
    public ProductDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);        
        initComponents();
        loadProducts();         
    }
    
    
    public void loadProducts(){
        RestTemplate restTemplate = new RestTemplate();

        RetrieveAllProductsDTO productsDto = restTemplate.exchange(PRODUCT_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<RetrieveAllProductsDTO>() {}
        ).getBody();
        
        if (productsDto != null) {
                DefaultTableModel tableModelCustomers = (DefaultTableModel) tableProductDialog.getModel();
                tableModelCustomers.setRowCount(0); //limpa os dados
                for (ProductDTO product : productsDto.getProducts()) {                    
                    Long id = product.getId();
                    String description = product.getDescription();
                    Double price = product.getPrice();
                    tableModelCustomers.addRow(new Object[]{false, id, description, price});
                }
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

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductDialog = new javax.swing.JTable();
        btnAddProducts = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VR-Software");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 153, 0));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lista De Produtos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableProductDialog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "Código", "Descrição", "Preço", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductDialogMouseClicked(evt);
            }
        });
        tableProductDialog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableProductDialogKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableProductDialog);
        if (tableProductDialog.getColumnModel().getColumnCount() > 0) {
            tableProductDialog.getColumnModel().getColumn(0).setMinWidth(80);
            tableProductDialog.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableProductDialog.getColumnModel().getColumn(0).setMaxWidth(80);
            tableProductDialog.getColumnModel().getColumn(1).setMinWidth(80);
            tableProductDialog.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableProductDialog.getColumnModel().getColumn(1).setMaxWidth(80);
            tableProductDialog.getColumnModel().getColumn(3).setMinWidth(150);
            tableProductDialog.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableProductDialog.getColumnModel().getColumn(3).setMaxWidth(150);
            tableProductDialog.getColumnModel().getColumn(4).setMinWidth(100);
            tableProductDialog.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableProductDialog.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btnAddProducts.setBackground(new java.awt.Color(255, 153, 0));
        btnAddProducts.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnAddProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus-icon-vr.png"))); // NOI18N
        btnAddProducts.setText("Incluir produtos");
        btnAddProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("* Atenção o campo Qtd é editável");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableProductDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductDialogMouseClicked

    }//GEN-LAST:event_tableProductDialogMouseClicked

    private void tableProductDialogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableProductDialogKeyReleased

    }//GEN-LAST:event_tableProductDialogKeyReleased

    private void btnAddProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductsActionPerformed
        
        DefaultTableModel model = (DefaultTableModel)tableProductDialog.getModel();
       
        int qtdRows = tableProductDialog.getSelectedRowCount();
        int selectedRowIndex = tableProductDialog.getSelectedRow();// TODO add your handling code here:
        for (int row = 0; row < tableProductDialog.getRowCount(); row++) {
            Boolean isSelected = (Boolean) tableProductDialog.getValueAt(row, 0);
            if (isSelected) {
                ProductItemDTO item = new ProductItemDTO();
                item.setProductId(Long.parseLong(model.getValueAt(row, 1).toString())); 
                item.setDescription(model.getValueAt(row, 2).toString());
                item.setUnitPrice(Double.parseDouble(model.getValueAt(row, 3).toString()));
                
                Object valueAt = model.getValueAt(row, 4);
                if (valueAt != null){
                    String valueAtToString = valueAt.toString();
                     if (!valueAtToString.trim().isEmpty()) {
                            item.setQtd(Integer.parseInt(valueAtToString));
                            productItensDTOs.add(item);
                            tableProductDialog.setValueAt(false, row, 0);
                            dispose();  // TODO bug se tiver mais que selecionado vazio fecha o modal ajustar 
                     }else{
                        JOptionPane.showMessageDialog(this, "O campo Qtd está vazio!", "campo vazio", JOptionPane.WARNING_MESSAGE); 
                     }
                }else{
                    JOptionPane.showMessageDialog(this, "O campo Qtd está vazio!", "campo vazio", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnAddProductsActionPerformed

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
            java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductDialog dialog = new ProductDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProductDialog;
    // End of variables declaration//GEN-END:variables

}
