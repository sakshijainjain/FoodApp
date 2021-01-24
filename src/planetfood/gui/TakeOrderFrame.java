/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.gui;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import planetfood.dao.CategoryDao;
import planetfood.dao.OrderDao;
import planetfood.dao.ProductDao;
import planetfood.pojo.OrderDetails;
import planetfood.pojo.OrderPojo;
import planetfood.pojo.ProductPojo;
import planetfood.pojo.User;
import planetfood.pojo.UserProfile;

/**
 *
 * @author user
 */
public class TakeOrderFrame extends javax.swing.JFrame {

    private HashMap<String,String> categories;
  private HashMap<String,ProductPojo> productList;
  private ArrayList <OrderDetails> orderList=new ArrayList<OrderDetails>();
  private ProductPojo p;
  private String catId;
   private String prodId;
   private String catName;
 private double subTotal;
private double  actualTotal;
private double  grandTotal;
private double  discountAmount;
private double  gstAmount;
private double  discountPer;
private String OrdId;
private DefaultTableModel model;
    public TakeOrderFrame() {
        initComponents();
            this.setLocationRelativeTo(null);
        lblName.setText("hello "+UserProfile.getUserName());
        loadProductDetails();
    }
    private void loadProductDetails() {
        try{
        jcCatName.removeAllItems();
        categories=CategoryDao.getAllCategories();
        for(String catName:categories.keySet())
            jcCatName.addItem(catName);
        OrdId=OrderDao.getNewId();
        txtOrdId.setText(OrdId);
        String Discount = null;
        do{
            Discount =JOptionPane.showInputDialog("How much discount?");
            try{
            discountPer=Double.parseDouble(Discount);
            txtDiscount.setText("Discount("+discountPer+"%)");
            break;
           
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,"Enter numeric discount","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            }
        }while(true);
       }
           catch(SQLException ex){
                        JOptionPane.showMessageDialog(null,"Exception in DB","Error",JOptionPane.ERROR_MESSAGE);
                        }
        
     }
   public void clearAll(){
     txtDiscount.setText("");
     txtSubTotal.setText("");
     txtGSTAmt.setText("");
     txtGrandTotal.setText("");
     txtQuantity.setText("");
     DefaultTableModel model=(DefaultTableModel)tab.getModel();
     for(int i=model.getRowCount()-1;i>=0;i--){
     model.removeRow(i);
     }
     orderList.clear();
     subTotal=actualTotal=grandTotal=0;
     }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        jcProdId = new javax.swing.JComboBox<>();
        jcCatName = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtProdPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtOrdId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        txtGSTAmt = new javax.swing.JTextField();
        txtGrandTotal = new javax.swing.JTextField();
        btnPayBill = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAKE ORDER PANEL");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose Product to Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Category");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product Id");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Name");

        jcProdId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProdIdActionPerformed(evt);
            }
        });

        jcCatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCatNameActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product Price");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");

        btnAddToCart.setBackground(new java.awt.Color(0, 153, 153));
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("ADD TO CART");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jcCatName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcProdId, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProdName)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcProdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcCatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT ID", "PRODUCT NAME", "PRICE", "QUANTITY", "AMOUNT"
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
        jScrollPane1.setViewportView(tab);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FOOD BASKET");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Order Id");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("sub Total");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Discount");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("GST Amt.");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Grand Total");

        btnPayBill.setBackground(new java.awt.Color(0, 153, 153));
        btnPayBill.setForeground(new java.awt.Color(255, 255, 255));
        btnPayBill.setText("Pay Bill");
        btnPayBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOrdId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubTotal)
                            .addComponent(txtDiscount)
                            .addComponent(txtGSTAmt)
                            .addComponent(txtGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                .addGap(54, 54, 54))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnPayBill)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtOrdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGSTAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPayBill)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BASKET INFO");

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCancelOrder.setBackground(new java.awt.Color(0, 153, 153));
        btnCancelOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("jLabel14");

        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblName)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btnBack)
                                .addGap(131, 131, 131)
                                .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(lblLogout))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCancelOrder))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void jcCatNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCatNameActionPerformed
         try{
       String catName=jcCatName.getSelectedItem().toString();
       String catId=categories.get(catName);
       productList=ProductDao.getProductsByCategory(catId);
       jcProdId.removeAllItems();
       for(String prodId: productList.keySet())
             jcProdId.addItem(prodId);
       }
       catch(SQLException ex){
            JOptionPane.showMessageDialog(null, " DB error in opening connection", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

       }
    }//GEN-LAST:event_jcCatNameActionPerformed

    private void jcProdIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProdIdActionPerformed
        try
       {
       String catName=jcCatName.getSelectedItem().toString();
       String catId=categories.get(catName);
       productList=ProductDao.getProductsByCategory(catId);
       
       for(ProductPojo prodId:productList.values()){
            if(prodId.getProdid().equals(jcProdId.getSelectedItem())){
              
               txtProdName.setText(prodId.getProdname());
               txtProdPrice.setText(prodId.getProdprice().toString());
          }
           
      }
      
   }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, " DB error in opening connection", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

       }
    }//GEN-LAST:event_jcProdIdActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
       clearAll();
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
   
    String quantity =txtQuantity.getText();
    if(quantity.isEmpty()){
     JOptionPane.showMessageDialog(null,"plz set quantity","error",JOptionPane.ERROR_MESSAGE);
     return;
   }
 DefaultTableModel model=(DefaultTableModel)tab.getModel();
 String price=txtProdPrice.getText();
 Object[] rows=new Object[5];
 prodId=jcProdId.getSelectedItem().toString();
 rows[0]=jcProdId.getSelectedItem().toString();
 rows[1]=txtProdName.getText();
 rows[2]=price;
 rows[3]=quantity;
 double amount=Double.parseDouble(price)*Double.parseDouble(quantity);
 rows[4]=amount;

 model.addRow(rows);
 actualTotal=actualTotal+amount;
 subTotal=actualTotal;
        System.out.println("subtotal before discount"+subTotal);
        discountAmount=Math.round(discountPer*subTotal/100.0);
        txtDiscount.setText(String.valueOf(discountAmount));
        System.out.println("discount:"+discountAmount);
        subTotal=Math.round(subTotal-discountAmount);
        txtSubTotal.setText(String.valueOf(subTotal));
        System.out.println("subtotal after discount:"+subTotal);
        gstAmount=Math.round(5*subTotal/100.0);
        txtGSTAmt.setText(String.valueOf(gstAmount));
        
        grandTotal=Math.round(subTotal+gstAmount);
        txtGrandTotal.setText(String.valueOf(grandTotal));
        OrderDetails obj=new OrderDetails();
        obj.setOrdId(OrdId);
        obj.setProdId(prodId);
        obj.setQuantity(Double.parseDouble(quantity));
        obj.setCost(amount);
        orderList.add(obj);
        txtQuantity.setText("");

    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnPayBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayBillActionPerformed
         OrderPojo obj=new OrderPojo();
        obj.setOrdId(OrdId);
        java.util.Date today=new java.util.Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy"); 
        obj.setOrdDate(sdf.format(today));
        obj.setGst(5.0);
        obj.setGstAmount(gstAmount);
        obj.setGrandTotal(grandTotal);
        obj.setDiscount(discountAmount);
        obj.setOrdAmount(subTotal);
        obj.setUserId(User.getUserId());
        String msg="your bill details\nBill Amount:RS"+actualTotal;
        msg+="\nDiscount:"+discountAmount;
        msg+="\nAmount:"+grandTotal;
        JOptionPane.showMessageDialog(null, msg);
        try
        {
        boolean status=OrderDao.addOrder(obj,orderList);
        if(status){
        JOptionPane.showMessageDialog(null,"order placed successully","success",JOptionPane.INFORMATION_MESSAGE);
        clearAll();
        }
        }
      catch(SQLException  e){
          JOptionPane.showMessageDialog(null,"error in db","error!",JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
      } 
        catch (ParseException ex) { 
            Logger.getLogger(TakeOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } 
         
    }//GEN-LAST:event_btnPayBillActionPerformed

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
               LoginFrame loginframe=new LoginFrame();
       loginframe.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        // TODO add your handling code here:
         lblLogout.setForeground(Color.yellow);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        // TODO add your handling code here:
         lblLogout.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
            CashierOptionsFrame loginframe=new CashierOptionsFrame();
       loginframe.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnPayBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcCatName;
    private javax.swing.JComboBox<String> jcProdId;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tab;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtGSTAmt;
    private javax.swing.JTextField txtGrandTotal;
    private javax.swing.JTextField txtOrdId;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProdPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
