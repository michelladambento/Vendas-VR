/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.michell.vendas.vr.views;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michell.vendas.vr.dtos.CustomerDTO;
import com.michell.vendas.vr.dtos.ResponseDTO;
import com.michell.vendas.vr.dtos.RetrieveAllCustomersResponseDTO;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author michell-bento
 */
public class RegisterCustomerForm extends javax.swing.JInternalFrame {
    
     private static final String CUSTOMER_URL = "http://localhost:8080/customer/";

    /**
     * Creates new form RegisterCustomerForm
     */
    public RegisterCustomerForm() {
        initComponents();
        loadCustomers();        
    }
    
       
    public void clearFields(){
        inputCode.setText(null);
        inputCustomerName.setText(null);
        inputPurchaseLimit.setText(null);
        inputClosingDate.cleanup();
        tableCustomer.clearSelection();
        inputClosingDate.setDate(null);
    }
    
    public void setInitNewFields(){
        inputCode.setEnabled(false);
        inputCustomerName.setEnabled(true);
        inputPurchaseLimit.setEnabled(true);
        inputClosingDate.setEnabled(true);
        inputSearchCostumer.setEnabled(true);

        btnDeleteCustomer.setEnabled(false);
        btnCancelCustomer.setEnabled(true);
        btnUpdateCustomer.setEnabled(false);
        btnSaveClient.setEnabled(true);
        btnNewCustomer.setEnabled(false);
    }
    
    public void setInitSaveFields(){
        inputCode.setEnabled(false);
        inputCustomerName.setEnabled(false);
        inputPurchaseLimit.setEnabled(false);
        inputClosingDate.setEnabled(false);
        inputSearchCostumer.setEnabled(false);

        btnDeleteCustomer.setEnabled(false);
        btnCancelCustomer.setEnabled(false);
        btnUpdateCustomer.setEnabled(false);
        btnSaveClient.setEnabled(false);
        btnNewCustomer.setEnabled(true);  
        
    }
    
    public void setInitEditFields(){
        inputCode.setEnabled(false);
        inputCustomerName.setEnabled(true);
        inputPurchaseLimit.setEnabled(true);
        inputClosingDate.setEnabled(true);
        inputSearchCostumer.setEnabled(true);
        
        btnDeleteCustomer.setEnabled(true);
        btnCancelCustomer.setEnabled(true);
        btnUpdateCustomer.setEnabled(true);
        btnSaveClient.setEnabled(false);
        btnNewCustomer.setEnabled(false);
    }
     
    public void setInitCancelFields(){
         setInitSaveFields();
     }
    
    
    public void loadCustomers(){
        RestTemplate restTemplate = new RestTemplate();

        RetrieveAllCustomersResponseDTO customersDto = restTemplate.exchange(
            CUSTOMER_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<RetrieveAllCustomersResponseDTO>() {}
        ).getBody();
        
        if (customersDto != null) {
                DefaultTableModel tableModelCustomers = (DefaultTableModel) tableCustomer.getModel();
                tableModelCustomers.setRowCount(0); //limpa os dados
                for (CustomerDTO customer : customersDto.getCustomers()) {                    
                    Long id = customer.getId();
                    String customerName = customer.getCustomerName();
                    LocalDate closingDate = customer.getClosingDateAt();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = closingDate.format(formatter);
                    Double purchaseLimit = customer.getPurchaseLimit();
                    tableModelCustomers.addRow(new Object[]{id, customerName,purchaseLimit,formattedDate});
                }
        }
        // imprimir no console
        if (customersDto != null) {
            System.out.println("Success: " + customersDto.getMessage().isSuccess());
            System.out.println("Details: " + customersDto.getMessage().getDetails());
            for (CustomerDTO customer : customersDto.getCustomers()) {
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Customer Name: " + customer.getCustomerName());
                System.out.println("Purchase Limit: " + customer.getPurchaseLimit());
                System.out.println("Closing Date: " + customer.getClosingDateAt());
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
        inputCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputCustomerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputPurchaseLimit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputClosingDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnDeleteCustomer = new javax.swing.JButton();
        btnCancelCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnSaveClient = new javax.swing.JButton();
        btnNewCustomer = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputSearchCostumer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("VR software");
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vr-icon-32.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setForeground(new java.awt.Color(255, 153, 0));

        jLabel5.setBackground(new java.awt.Color(255, 153, 0));
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cadastro de Clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inputCode.setEnabled(false);
        inputCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCodeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel2.setText("Nome do cliente");

        inputCustomerName.setEnabled(false);
        inputCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCustomerNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel3.setText("Limite de compra");

        inputPurchaseLimit.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel4.setText("Data de fechamento");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel6.setText("Código");

        inputClosingDate.setDateFormatString("dd/MM/yyyy");
        inputClosingDate.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("(dd/MM/yyyy)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(inputPurchaseLimit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputClosingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(inputCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(6, 6, 6)
                        .addComponent(inputPurchaseLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputClosingDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDeleteCustomer.setBackground(new java.awt.Color(255, 153, 102));
        btnDeleteCustomer.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash-icon-vr.png"))); // NOI18N
        btnDeleteCustomer.setText("Excluir");
        btnDeleteCustomer.setEnabled(false);
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnCancelCustomer.setBackground(new java.awt.Color(255, 153, 102));
        btnCancelCustomer.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnCancelCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear-icon-vr.png"))); // NOI18N
        btnCancelCustomer.setText("Cancelar");
        btnCancelCustomer.setEnabled(false);
        btnCancelCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setBackground(new java.awt.Color(255, 153, 102));
        btnUpdateCustomer.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnUpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil-icon-vr.png"))); // NOI18N
        btnUpdateCustomer.setText("Atualizar");
        btnUpdateCustomer.setEnabled(false);
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnSaveClient.setBackground(new java.awt.Color(255, 153, 0));
        btnSaveClient.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnSaveClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save-icon-3d-vr.png"))); // NOI18N
        btnSaveClient.setText("Salvar");
        btnSaveClient.setEnabled(false);
        btnSaveClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveClientActionPerformed(evt);
            }
        });

        btnNewCustomer.setBackground(new java.awt.Color(255, 153, 0));
        btnNewCustomer.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnNewCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus-icon-vr.png"))); // NOI18N
        btnNewCustomer.setText("NOVO");
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSaveClient, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveClient, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel1.setText("Pesquisa pelo nome do cliente");

        inputSearchCostumer.setEnabled(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon-vr.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(inputSearchCostumer))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addComponent(inputSearchCostumer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do cliente", "Limite de compra", "Data de fechamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);
        if (tableCustomer.getColumnModel().getColumnCount() > 0) {
            tableCustomer.getColumnModel().getColumn(0).setMinWidth(80);
            tableCustomer.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableCustomer.getColumnModel().getColumn(0).setMaxWidth(80);
            tableCustomer.getColumnModel().getColumn(2).setMinWidth(150);
            tableCustomer.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableCustomer.getColumnModel().getColumn(2).setMaxWidth(150);
            tableCustomer.getColumnModel().getColumn(3).setMinWidth(150);
            tableCustomer.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableCustomer.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCustomerNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_inputCustomerNameActionPerformed

    private void inputCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCodeActionPerformed

    private void btnSaveClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveClientActionPerformed
        
        RestTemplate restTemplate = new RestTemplate();
        
        Date date = inputClosingDate.getDate();
        Instant instant = date.toInstant();
        LocalDate closingDateAt = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        
        CustomerDTO customersDTO = new CustomerDTO();
        customersDTO.setCustomerName(inputCustomerName.getText());
        customersDTO.setPurchaseLimit(Double.parseDouble(inputPurchaseLimit.getText()));
        customersDTO.setClosingDateAt(closingDateAt);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<CustomerDTO> request = new HttpEntity<>(customersDTO, headers);
        try {
            
                ResponseEntity<ResponseDTO> response = restTemplate.exchange(
                CUSTOMER_URL,
                HttpMethod.POST,
                request,
                ResponseDTO.class
            ); 

            JOptionPane.showMessageDialog(this, response.getBody().getMessage().getDetails());
            loadCustomers();
            setInitSaveFields();
            clearFields();
            
        } catch (HttpServerErrorException e) {
            String errorMessage = extractErrorMessage(e.getResponseBodyAsString());
            JOptionPane.showMessageDialog(this, errorMessage, "Aviso de cliente já existente", JOptionPane.WARNING_MESSAGE);
        } catch (HeadlessException | RestClientException e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }       
      
    }//GEN-LAST:event_btnSaveClientActionPerformed

//    formatar mensagem da exception lançada do salvar e pra garantia do excluir apesar excluir nao precisa
    private String extractErrorMessage(String responseBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode messageNode = root.path("message");
            return messageNode.path("details").asText();
        } catch (IOException e) {
            return "Erro ao processar mensagem de erro: " + e.getMessage();
        }
    }   
    
    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        // TODO add your handling code here:
        setInitNewFields();
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void btnCancelCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCustomerActionPerformed
           setInitCancelFields();
           clearFields();
           
    }//GEN-LAST:event_btnCancelCustomerActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:        
        DefaultTableModel model = (DefaultTableModel)tableCustomer.getModel();
        int selectedRowIndex = tableCustomer.getSelectedRow();
        int qtdRows = tableCustomer.getSelectedRowCount();    
        if(qtdRows == 1){
            setInitEditFields();            
            inputCode.setText(model.getValueAt(selectedRowIndex, 0).toString());
            inputCustomerName.setText(model.getValueAt(selectedRowIndex, 1).toString());
            inputPurchaseLimit.setText(model.getValueAt(selectedRowIndex, 2).toString());
            String inputClosingDateAmerican = model.getValueAt(selectedRowIndex, 3).toString();
             try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = inputFormat.parse(inputClosingDateAmerican); 
                    inputClosingDate.setDate(date);
//                    inputClosingDate.setDateFormatString("dd/MM/yyyy");
                    
            } catch (ParseException ex) {
                  ex.printStackTrace();
            }
        }if(qtdRows > 1){
            JOptionPane.showMessageDialog(this, "Por favor selecione apenas um registro");
            
        }
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
       
        int selectedRowIndex = tableCustomer.getSelectedRow();
        int qtdRows = tableCustomer.getSelectedRowCount();
        if(qtdRows == 1){
            Date date = inputClosingDate.getDate();
            Instant instant = date.toInstant();
            LocalDate closingDateAt = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            DefaultTableModel model = (DefaultTableModel)tableCustomer.getModel();
            setInitEditFields();
            Long customerIdToUpdate = Long.parseLong(model.getValueAt(selectedRowIndex, 0).toString());
            RestTemplate restTemplate = new RestTemplate();
            
            
            CustomerDTO customersDTO = new CustomerDTO();
            customersDTO.setId(customerIdToUpdate);
            customersDTO.setCustomerName(inputCustomerName.getText());
            customersDTO.setPurchaseLimit(Double.parseDouble(inputPurchaseLimit.getText()));
            customersDTO.setClosingDateAt(closingDateAt);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
            
             HttpEntity<CustomerDTO> request = new HttpEntity<>(customersDTO, headers);
            try {
            
                ResponseEntity<ResponseDTO> response = restTemplate.exchange(
                CUSTOMER_URL,
                HttpMethod.PUT,
                request,
                ResponseDTO.class
            ); 

            JOptionPane.showMessageDialog(this, response.getBody().getMessage().getDetails());
            loadCustomers();
            setInitSaveFields();
            clearFields();
            
            } catch (HttpServerErrorException e) {
                String errorMessage = extractErrorMessage(e.getResponseBodyAsString());
                JOptionPane.showMessageDialog(this, errorMessage, "Aviso de cliente não encontrado", JOptionPane.WARNING_MESSAGE);
            } catch (HeadlessException | RestClientException e) {
                JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
            }    

        }if(qtdRows > 1){
            JOptionPane.showMessageDialog(this, "Por favor selecione apenas um registro");
        }
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
//        clearFields();
        DefaultTableModel model = (DefaultTableModel)tableCustomer.getModel();
        int selectedRowIndex = tableCustomer.getSelectedRow();
        int qtdRows = tableCustomer.getSelectedRowCount();
        if(qtdRows == 1){
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Você tem a certeza que deseja excluir esse cliente?",
                    "Confirmar Exclusão de Cliente",
                    JOptionPane.YES_NO_OPTION,
                    2,
                    null                  
                    );
            if (response == JOptionPane.YES_OPTION){
                setInitEditFields();
                Long customerId = Long.parseLong(model.getValueAt(selectedRowIndex, 0).toString());
                RestTemplate restTemplate = new RestTemplate();
                String urlDelete = CUSTOMER_URL + customerId + "/";
                
                  try {
                        // Enviar a solicitação DELETE e obter a resposta
                        ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(
                            urlDelete,
                            HttpMethod.DELETE,
                            HttpEntity.EMPTY,
                            ResponseDTO.class
                        );
                        ResponseDTO deleteResponse = responseEntity.getBody();
                        JOptionPane.showMessageDialog(this, deleteResponse.getMessage().getDetails());
                        loadCustomers();
                        setInitSaveFields();
                        clearFields();
                    } catch (HttpServerErrorException e) {
                        String errorMessage = extractErrorMessage(e.getResponseBodyAsString());
                        JOptionPane.showMessageDialog(this, errorMessage, "Aviso de cliente Busca de cliente", JOptionPane.WARNING_MESSAGE);
                    } catch (HeadlessException | RestClientException e) {
                        JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
                    } 
            }
        }if(qtdRows > 1){
            JOptionPane.showMessageDialog(this, "Por favor selecione apenas um registro");
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelCustomer;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnNewCustomer;
    private javax.swing.JButton btnSaveClient;
    private javax.swing.JButton btnUpdateCustomer;
    private com.toedter.calendar.JDateChooser inputClosingDate;
    private javax.swing.JTextField inputCode;
    private javax.swing.JTextField inputCustomerName;
    private javax.swing.JTextField inputPurchaseLimit;
    private javax.swing.JTextField inputSearchCostumer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCustomer;
    // End of variables declaration//GEN-END:variables
}
