/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dao.KhachHangDao;
import entity.KhachHang;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FrmThemKh extends javax.swing.JFrame {
    private boolean clickThem = false;
    /**
     * Creates new form FrmThemNV
     */
    public FrmThemKh() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setClickThem() {
        this.clickThem = !this.clickThem;
    }

    public boolean isClickThem() {
        return clickThem;
    }
    
    public void getTen(){
        txt_TenKh.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        btnExit2 = new javax.swing.JToggleButton();
        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(243, 244, 237));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Khách Hàng Mới");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txt_TenKh.setBackground(new java.awt.Color(243, 244, 237));
        txt_TenKh.setForeground(new java.awt.Color(153, 153, 153));
        txt_TenKh.setText("Tên Khách Hàng");
        txt_TenKh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_TenKh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_TenKhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_TenKhFocusLost(evt);
            }
        });

        txt_Sdt.setBackground(new java.awt.Color(243, 244, 237));
        txt_Sdt.setForeground(new java.awt.Color(153, 153, 153));
        txt_Sdt.setText("Số Điện Thoại");
        txt_Sdt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_Sdt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SdtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SdtFocusLost(evt);
            }
        });

        txt_DiaChi.setBackground(new java.awt.Color(243, 244, 237));
        txt_DiaChi.setForeground(new java.awt.Color(153, 153, 153));
        txt_DiaChi.setText("Địa Chỉ");
        txt_DiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_DiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_DiaChiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_DiaChiFocusLost(evt);
            }
        });
        txt_DiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DiaChiActionPerformed(evt);
            }
        });

        btnExit2.setBackground(new java.awt.Color(255, 102, 102));
        btnExit2.setForeground(java.awt.Color.white);
        btnExit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btnExit2.setText("Thoát");
        btnExit2.setToolTipText("");
        btnExit2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExit2btnExitMouseClicked(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(21, 151, 229));
        btnThem.setForeground(java.awt.Color.white);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txt_TenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(txt_Sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExit2btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExit2btnExitMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnExit2btnExitMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked

       
//        FrmBanHang bh = new FrmBanHang();
//        FrmBanHang.txt_KhuyenMai.setText(FrmThemKh.txt_TenKh.getText());
//        FrmBanHang.lbl_SDT.setText(FrmThemKh.txt_Sdt.getText());
//        JOptionPane.showMessageDialog(this, "Thêm Thành Công");
//         System.out.println(txt_Sdt.getText());
//         System.out.println(FrmBanHang.txt_KhuyenMai.getText());
//         setVisible(false);
//              FrmBanHang.txt_Search_KH.setVisible(false);
//              FrmBanHang.btn_AddKh.setVisible(false);
        
       
            if(checkValu()){
               
                            String TenKH = txt_TenKh.getText();
                String sdt = txt_Sdt.getText();
                String diaChi = txt_DiaChi.getText();
                String maKH = TaoMaKH();

                KhachHangDao khDao = new KhachHangDao();
                KhachHang kh = new KhachHang(maKH, TenKH, sdt, diaChi);
                khDao.createKhachHang(kh);
                
               
                this.setVisible(false);
            }
            
           
        

    }//GEN-LAST:event_btnThemMouseClicked

    private void txt_DiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DiaChiActionPerformed

    private void txt_TenKhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TenKhFocusGained
        if(txt_TenKh.getText().equals("Tên Khách Hàng")){
            txt_TenKh.setText("");
            
        }
    }//GEN-LAST:event_txt_TenKhFocusGained

    private void txt_TenKhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TenKhFocusLost
        if(txt_TenKh.getText().equals("")){
            txt_TenKh.setText("Tên Khách Hàng");
            
        }
    }//GEN-LAST:event_txt_TenKhFocusLost

    private void txt_SdtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SdtFocusGained
        if(txt_Sdt.getText().equals("Số Điện Thoại")){
            txt_Sdt.setText("");
            
        }
    }//GEN-LAST:event_txt_SdtFocusGained

    private void txt_SdtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SdtFocusLost
        if(txt_Sdt.getText().equals("")){
            txt_Sdt.setText("Số Điện Thoại");
            
        }
    }//GEN-LAST:event_txt_SdtFocusLost

    private void txt_DiaChiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DiaChiFocusGained
        if(txt_DiaChi.getText().equals("Địa Chỉ")){
            txt_DiaChi.setText("");
        }
    }//GEN-LAST:event_txt_DiaChiFocusGained

    private void txt_DiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DiaChiFocusLost
        if(txt_DiaChi.getText().equals("")){
            txt_DiaChi.setText("Địa Chỉ");
        }
    }//GEN-LAST:event_txt_DiaChiFocusLost

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(FrmThemKh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmThemKh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmThemKh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmThemKh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmThemKh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExit2;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txt_DiaChi;
    public static final javax.swing.JTextField txt_Sdt = new javax.swing.JTextField();
    public static final javax.swing.JTextField txt_TenKh = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables

    //tao mã KH từ động
    /**
     * @param 
     * @return String - KHxxx
     */
    public String TaoMaKH(){
          Random rand = new Random();
         int ranNum = rand.nextInt(1000)+ 1;
        
         
         KhachHangDao khDao = new KhachHangDao();
       
        String maKH="";
         KhachHang kh = null;
        do {            
              maKH = "KH"+String.valueOf(ranNum);
               kh = khDao.getKHByMaKH(maKH);
        } while (kh!=null);
        
        
        
       
        
        
         return maKH;
        
       
    }
   
    public boolean checkValu(){
        
              String TenKH = txt_TenKh.getText();
            String sdt = txt_Sdt.getText();
            String diaChi = txt_DiaChi.getText();
           
            String regexPhone = "^[0-9]{10}";
           
            
           
            if (TenKH.length() <= 0 || TenKH.equals("Tên Khách Hàng")) {
		JOptionPane.showMessageDialog(txt_TenKh, "Bạn chưa nhập tên Khách hàng");
		return false;
            }
            if (sdt.length() <= 0 ) {
		JOptionPane.showMessageDialog(txt_TenKh, "Hãy nhập số điện thoại");			
		return false;
            }
            else if(!sdt.matches("^[0-9]{10}")){
                JOptionPane.showMessageDialog(txt_TenKh, "Số điện thoại có 10 chữ số ");			
		return false;
            }
           if(diaChi.length() <=0 || diaChi.equals("Địa Chỉ")){
		JOptionPane.showMessageDialog(txt_TenKh, "Địa chỉ NCC không được để trống");			
		return false;             
           }
           
           
           return true;
    }
}