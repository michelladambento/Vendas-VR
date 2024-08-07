/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.michell.vendas.vr.views;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michell.vendas.vr.dtos.CustomerDTO;
import com.michell.vendas.vr.dtos.ProductDTO;

import com.michell.vendas.vr.dtos.ProductItemDTO;
import com.michell.vendas.vr.dtos.PurchaseOrderDTO;
import com.michell.vendas.vr.dtos.ResponseDTO;
import com.michell.vendas.vr.dtos.RetrieveAllCustomersDTO;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.DecimalFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author michell-bento
 */
public class RegisterPurchaserOrderForm extends javax.swing.JInternalFrame {
    
    private static final String PRODUCT_URL = "http://localhost:8080/product/";
    private static final String CUSTOMER_URL = "http://localhost:8080/customer/";
    private static final String PURCHASER_ORDER_URL = "http://localhost:8080/purchaserOrder/";
    
    PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
    CustomerDTO customerDtoToPurchaser = new CustomerDTO();
    ProductItemDTO productItemDTOToPurchaser = new ProductItemDTO();
    ProductDTO productDTOToPurchaser = new ProductDTO();
    
    
    ProductDialog productDialog = new ProductDialog(null,closable);

    /**
     * Creates new form RegisterProductForm
     */
    public RegisterPurchaserOrderForm() {
        initComponents();
        loadCustomers(); 
        loadProductsSelected();        
    }
    
    
   
    
    
  public void loadCustomers(){
        RestTemplate restTemplate = new RestTemplate();

        RetrieveAllCustomersDTO customersDto = restTemplate.exchange(CUSTOMER_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<RetrieveAllCustomersDTO>() {}
        ).getBody();
        
        if (customersDto != null) {
                DefaultTableModel tableModelCustomers = (DefaultTableModel) tableCustomerToPurchaser.getModel();
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
      
    }
  
  public void loadProductsSelected(){      
        List<ProductItemDTO> itens = productDialog.getProductItensDTOs();
        DefaultTableModel tableModelCustomers = (DefaultTableModel) tableProductSelected.getModel();
        tableModelCustomers.setRowCount(0); //limpa os dados
        double total = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        for (ProductItemDTO item : itens) {                    
            Long id = item.getProductId();
            String description = item.getDescription();
            Double price = item.getUnitPrice();
            Integer qtd = item.getQtd();
            tableModelCustomers.addRow(new Object[]{id, description, price, qtd});
            total += item.calculateTotalPrice();
        }
        purchaseTotal.setText("R$ " + df.format(total));
  }
  
  public void formInitial(){   
      purchaseLimitText.setText("R$ 000,00");
      inputCustomerNameToPurchaser.setText("XXXXXXXXXXXXXX");
      closingDateText.setText("dd/MM/yyyy");
      codeText.setText("xxxxxxxxxxxx");
      btnCancelAddCustomer.setEnabled(false);
      btnAddCustomer.setEnabled(false);
      nameOrder.setText("XXXXXXXXX");
      btnAddProduct.setEnabled(false);
      purchaseTotal.setText("R$ 0");
      btnSavePurchaserOrder.setEnabled(false);
      btnCancelPurchaserOrder.setEnabled(false);
      tableCustomerToPurchaser.setEnabled(true);
      tableCustomerToPurchaser.setVisible(true);
      tableCustomerToPurchaser.setOpaque(true);
      tableProductSelected.setEnabled(false);
      tableProductSelected.setVisible(false);
      tableProductSelected.setOpaque(false);
      btnRefresh.setEnabled(false);
              
      purchaseOrderDTO = new PurchaseOrderDTO();
      customerDtoToPurchaser = new CustomerDTO();
      productItemDTOToPurchaser = new ProductItemDTO();
      productDTOToPurchaser = new ProductDTO();
      productDialog = new ProductDialog(null,closable);
      
      loadCustomers(); 
      loadProductsSelected();   
      
  }
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelAddCustomer = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCustomerToPurchaser = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProductSelected = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        inputCustomerNameToPurchaser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        closingDateText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codeText = new javax.swing.JLabel();
        purchaseLimitText = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        purchaseTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nameOrder = new javax.swing.JLabel();
        btnSavePurchaserOrder = new javax.swing.JButton();
        btnCancelPurchaserOrder = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

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
        tableCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableCustomerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableCustomerKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("VR Software");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vr-icon-32.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 153, 0));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cadastro de Pedido de Compra");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCancelAddCustomer.setBackground(new java.awt.Color(255, 153, 102));
        btnCancelAddCustomer.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnCancelAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear-icon-vr.png"))); // NOI18N
        btnCancelAddCustomer.setText("Cancelar");
        btnCancelAddCustomer.setEnabled(false);
        btnCancelAddCustomer.setMaximumSize(new java.awt.Dimension(264, 68));
        btnCancelAddCustomer.setMinimumSize(new java.awt.Dimension(264, 68));
        btnCancelAddCustomer.setPreferredSize(new java.awt.Dimension(264, 38));
        btnCancelAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAddCustomerActionPerformed(evt);
            }
        });

        btnAddCustomer.setBackground(new java.awt.Color(255, 153, 0));
        btnAddCustomer.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus-icon-vr.png"))); // NOI18N
        btnAddCustomer.setText("Adicionar Cliente");
        btnAddCustomer.setEnabled(false);
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(btnCancelAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableCustomerToPurchaser.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCustomerToPurchaser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerToPurchaserMouseClicked(evt);
            }
        });
        tableCustomerToPurchaser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableCustomerToPurchaserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableCustomerToPurchaserKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableCustomerToPurchaser);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableProductSelected.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
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
        tableProductSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductSelectedMouseClicked(evt);
            }
        });
        tableProductSelected.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableProductSelectedKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableProductSelectedKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tableProductSelected);
        if (tableProductSelected.getColumnModel().getColumnCount() > 0) {
            tableProductSelected.getColumnModel().getColumn(0).setMinWidth(80);
            tableProductSelected.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableProductSelected.getColumnModel().getColumn(0).setMaxWidth(80);
            tableProductSelected.getColumnModel().getColumn(2).setMinWidth(150);
            tableProductSelected.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableProductSelected.getColumnModel().getColumn(2).setMaxWidth(150);
            tableProductSelected.getColumnModel().getColumn(3).setMinWidth(80);
            tableProductSelected.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableProductSelected.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inputCustomerNameToPurchaser.setText("XXXXXXXXXXXXXX");
        inputCustomerNameToPurchaser.setEnabled(false);
        inputCustomerNameToPurchaser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCustomerNameToPurchaserActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel4.setText("Data de fechamento");

        closingDateText.setFont(new java.awt.Font("Liberation Sans", 2, 14)); // NOI18N
        closingDateText.setForeground(new java.awt.Color(102, 102, 102));
        closingDateText.setText("dd/MM/yyyy");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel6.setText("Código:  ");

        codeText.setFont(new java.awt.Font("Liberation Sans", 2, 14)); // NOI18N
        codeText.setForeground(new java.awt.Color(102, 102, 102));
        codeText.setText("xxxxxxxxxxxx");

        purchaseLimitText.setFont(new java.awt.Font("Liberation Sans", 1, 52)); // NOI18N
        purchaseLimitText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        purchaseLimitText.setText("R$ 000,00");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Limite de compra ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputCustomerNameToPurchaser)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closingDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(purchaseLimitText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(257, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(inputCustomerNameToPurchaser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(closingDateText)
                    .addComponent(jLabel6)
                    .addComponent(codeText))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(purchaseLimitText)
                    .addContainerGap(56, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(123, Short.MAX_VALUE)))
        );

        purchaseTotal.setFont(new java.awt.Font("Liberation Sans", 1, 40)); // NOI18N
        purchaseTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        purchaseTotal.setText("XXXXXX");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TOTAL");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Dados do Pedido de Compra");

        nameOrder.setFont(new java.awt.Font("Liberation Sans", 1, 30)); // NOI18N
        nameOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameOrder.setText("XXXXXXXXX");

        btnSavePurchaserOrder.setBackground(new java.awt.Color(255, 153, 0));
        btnSavePurchaserOrder.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnSavePurchaserOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save-icon-3d-vr.png"))); // NOI18N
        btnSavePurchaserOrder.setText("Fechar Pedido");
        btnSavePurchaserOrder.setEnabled(false);
        btnSavePurchaserOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePurchaserOrderActionPerformed(evt);
            }
        });

        btnCancelPurchaserOrder.setBackground(new java.awt.Color(255, 153, 102));
        btnCancelPurchaserOrder.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnCancelPurchaserOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear-icon-vr.png"))); // NOI18N
        btnCancelPurchaserOrder.setText("Cancelar Pedido");
        btnCancelPurchaserOrder.setEnabled(false);
        btnCancelPurchaserOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelPurchaserOrderActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(255, 153, 0));
        btnAddProduct.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus-icon-vr.png"))); // NOI18N
        btnAddProduct.setText("Adicionar Produto");
        btnAddProduct.setEnabled(false);
        btnAddProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_refresh.png"))); // NOI18N
        btnRefresh.setEnabled(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSavePurchaserOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(482, 482, 482)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(purchaseTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelPurchaserOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(810, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(512, 512, 512)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(nameOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnSavePurchaserOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelPurchaserOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(purchaseTotal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(162, 162, 162))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(586, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAddCustomerActionPerformed
        btnCancelAddCustomer.setEnabled(false);
        btnAddCustomer.setEnabled(false);
        tableCustomerToPurchaser.setEnabled(true);
        purchaseLimitText.setText("R$ 000,00");
        inputCustomerNameToPurchaser.setText("XXXXXXXXXXXXXX");
        closingDateText.setText("dd/MM/yyyy");
        codeText.setText("xxxxxxxxxxxx");
        
        tableCustomerToPurchaser.getSelectionModel().clearSelection();
        tableCustomerToPurchaser.repaint();
    }//GEN-LAST:event_btnCancelAddCustomerActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        btnCancelAddCustomer.setEnabled(false);
        btnAddCustomer.setEnabled(false);
        tableCustomerToPurchaser.setEnabled(false);
        tableCustomerToPurchaser.getSelectionModel().clearSelection();
        tableCustomerToPurchaser.repaint();
        tableCustomerToPurchaser.setVisible(false);
        tableCustomerToPurchaser.setOpaque(false);
        
        tableProductSelected.setEnabled(true);
        tableProductSelected.setVisible(true);
        tableProductSelected.setOpaque(true);

        btnSavePurchaserOrder.setEnabled(true);
        btnCancelPurchaserOrder.setEnabled(true);
        btnAddProduct.setEnabled(true);
        btnRefresh.setEnabled(true);
        
        //Fazer utlitite
        String purchaseLimit = purchaseLimitText.getText().replaceAll("\\s+", "").replace("R$", "");  
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(closingDateText.getText(), formatter);
          
        customerDtoToPurchaser.setId(Long.parseLong(codeText.getText()));
        customerDtoToPurchaser.setCustomerName(inputCustomerNameToPurchaser.getText());
        customerDtoToPurchaser.setPurchaseLimit(Double.parseDouble(purchaseLimit));
        customerDtoToPurchaser.setClosingDateAt(date);
        nameOrder.setText(customerDtoToPurchaser.getCustomerName());      
        
       
    }//GEN-LAST:event_btnAddCustomerActionPerformed

   
    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked

    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCustomerKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tableCustomerKeyPressed

    private void tableCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCustomerKeyReleased

    }//GEN-LAST:event_tableCustomerKeyReleased

    private void tableProductSelectedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductSelectedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableProductSelectedMouseClicked

    private void tableProductSelectedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableProductSelectedKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableProductSelectedKeyPressed

    private void tableProductSelectedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableProductSelectedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tableProductSelectedKeyReleased

    private void inputCustomerNameToPurchaserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCustomerNameToPurchaserActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_inputCustomerNameToPurchaserActionPerformed

    private void tableCustomerToPurchaserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerToPurchaserMouseClicked
        DefaultTableModel model = (DefaultTableModel)tableCustomerToPurchaser.getModel();
        int selectedRowIndex = tableCustomerToPurchaser.getSelectedRow();
        int qtdRows = tableCustomerToPurchaser.getSelectedRowCount();  
        
        
        if(qtdRows == 1){
            btnAddCustomer.setEnabled(true);
            btnCancelAddCustomer.setEnabled(true);
            codeText.setText(model.getValueAt(selectedRowIndex, 0).toString());
            inputCustomerNameToPurchaser.setText(model.getValueAt(selectedRowIndex, 1).toString());
            purchaseLimitText.setText("R$ " + model.getValueAt(selectedRowIndex, 2).toString());
            closingDateText.setText(model.getValueAt(selectedRowIndex, 3).toString());
        }if(qtdRows > 1){
            JOptionPane.showMessageDialog(this, "Por favor selecione apenas um registro");
            
        }
    }//GEN-LAST:event_tableCustomerToPurchaserMouseClicked

    private void tableCustomerToPurchaserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCustomerToPurchaserKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tableCustomerToPurchaserKeyPressed

    private void tableCustomerToPurchaserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableCustomerToPurchaserKeyReleased
         DefaultTableModel model = (DefaultTableModel)tableCustomerToPurchaser.getModel();
        int selectedRowIndex = tableCustomerToPurchaser.getSelectedRow();
        int qtdRows = tableCustomerToPurchaser.getSelectedRowCount();  
        if(qtdRows == 1){
            btnAddCustomer.setEnabled(true);
            btnCancelAddCustomer.setEnabled(true);
            codeText.setText(model.getValueAt(selectedRowIndex, 0).toString());
            inputCustomerNameToPurchaser.setText(model.getValueAt(selectedRowIndex, 1).toString());
            purchaseLimitText.setText("R$ " + model.getValueAt(selectedRowIndex, 2).toString());
            closingDateText.setText(model.getValueAt(selectedRowIndex, 3).toString());
        }if(qtdRows > 1){
            JOptionPane.showMessageDialog(this, "Por favor selecione apenas um registro");
            
        }
    }//GEN-LAST:event_tableCustomerToPurchaserKeyReleased

    private void btnSavePurchaserOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePurchaserOrderActionPerformed

        purchaseOrderDTO.setCustomerId(customerDtoToPurchaser.getId());
        purchaseOrderDTO.setOrderDateAt(LocalDate.now());
        String purchaseTotalToStr = purchaseTotal.getText().replaceAll("\\s+", "").replace("R$", "").replace(",", ".");
        purchaseOrderDTO.setOrderTotal(Double.parseDouble(purchaseTotalToStr));            
        purchaseOrderDTO.setProductItens(productDialog.getProductItensDTOs());

        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        HttpEntity<PurchaseOrderDTO> request = new HttpEntity<>(purchaseOrderDTO, headers);
        try {
            
                ResponseEntity<ResponseDTO> response = restTemplate.exchange(
                PURCHASER_ORDER_URL,
                HttpMethod.POST,
                request,
                ResponseDTO.class
            ); 

        JOptionPane.showMessageDialog(this, response.getBody().getMessage().getDetails());
        
        formInitial();
            
        } catch (HttpServerErrorException e) {
            String errorMessage = extractErrorMessage(e.getResponseBodyAsString());
            JOptionPane.showMessageDialog(this, errorMessage, "Aviso de Pedido de compra", JOptionPane.WARNING_MESSAGE);
        } catch (HeadlessException | RestClientException e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }       
  
    }//GEN-LAST:event_btnSavePurchaserOrderActionPerformed
    
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
    private void btnCancelPurchaserOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelPurchaserOrderActionPerformed
        // ajustar limpar campos ao invés de fazer nova instancia
       formInitial();
    }//GEN-LAST:event_btnCancelPurchaserOrderActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        productDialog.show();
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadProductsSelected();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCancelAddCustomer;
    private javax.swing.JButton btnCancelPurchaserOrder;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSavePurchaserOrder;
    private javax.swing.JLabel closingDateText;
    private javax.swing.JLabel codeText;
    private javax.swing.JTextField inputCustomerNameToPurchaser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nameOrder;
    private javax.swing.JLabel purchaseLimitText;
    private javax.swing.JLabel purchaseTotal;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableCustomerToPurchaser;
    private javax.swing.JTable tableProductSelected;
    // End of variables declaration//GEN-END:variables
 
}
