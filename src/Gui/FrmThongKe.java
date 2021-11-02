/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class FrmThongKe extends javax.swing.JPanel {
public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
    /**
     * Creates new form FrmThongKe
     */
    public FrmThongKe() {
        initComponents();
        addBorder();
    }

     public void addBorder(){
        buttons = new JButton[4];
        
          buttons[0] =btn_tab_TKeDT;
        buttons[1] =btn_tab_TKeHBC;
        buttons[2] = btn_tab_TKeHT;
        buttons[3] = btn_tab_TKeKH;
        
        setButtonBorder(btn_tab_TKeDT);
   
        

        addAction();
    }
        //set border active
    public void setButtonBorder(JButton button){
//        for (JButton btn : buttons) {
//            btn.setBorder(default_border);
//            btn.setForeground(new Color(153,153,153));
//        }
        button.setBorder(active_border);
        button.setForeground(Color.black);
    }
    //add even
    public void addAction(){
        for (JButton button : buttons) {
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JButton btn : buttons) {
            btn.setBorder(default_border);
            btn.setForeground(new Color(153,153,153));
        }
        button.setBorder(active_border);
        button.setForeground(Color.black);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                   
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    
                }
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_FormThongKe = new javax.swing.JPanel();
        lbl_text_ThongKe = new javax.swing.JLabel();
        pnl_menuTab_ThongKe = new javax.swing.JPanel();
        btn_tab_TKeDT = new javax.swing.JButton();
        btn_tab_TKeHT = new javax.swing.JButton();
        btn_tab_TKeHBC = new javax.swing.JButton();
        btn_tab_TKeKH = new javax.swing.JButton();
        pnl_tab_Form_TKedt = new javax.swing.JPanel();
        pnl_tab_FormTKeht = new javax.swing.JPanel();
        pnl_tab_FormTKhbc = new javax.swing.JPanel();
        pnl_tab_FormTKkh = new javax.swing.JPanel();

        pnl_FormThongKe.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_ThongKe.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_ThongKe.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_ThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_ThongKe.setText("Thống Kê");
        pnl_FormThongKe.add(lbl_text_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_ThongKe.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_TKeDT.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TKeDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TKeDT.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_TKeDT.setText("Thống Kê Doanh Thu");
        btn_tab_TKeDT.setBorder(null);
        btn_tab_TKeDT.setContentAreaFilled(false);
        btn_tab_TKeDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TKeDTMouseClicked(evt);
            }
        });
        btn_tab_TKeDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_TKeDTActionPerformed(evt);
            }
        });

        btn_tab_TKeHT.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TKeHT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TKeHT.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_TKeHT.setText("Thống Kê Hàng Tồn Kho");
        btn_tab_TKeHT.setBorder(null);
        btn_tab_TKeHT.setContentAreaFilled(false);
        btn_tab_TKeHT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TKeHTMouseClicked(evt);
            }
        });

        btn_tab_TKeHBC.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TKeHBC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TKeHBC.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_TKeHBC.setText("Thống Kê Hàng Bán Chạy");
        btn_tab_TKeHBC.setBorder(null);
        btn_tab_TKeHBC.setContentAreaFilled(false);
        btn_tab_TKeHBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TKeHBCMouseClicked(evt);
            }
        });

        btn_tab_TKeKH.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TKeKH.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TKeKH.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_TKeKH.setText("Thông Kê Khách Hàng");
        btn_tab_TKeKH.setBorder(null);
        btn_tab_TKeKH.setContentAreaFilled(false);
        btn_tab_TKeKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TKeKHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_ThongKeLayout = new javax.swing.GroupLayout(pnl_menuTab_ThongKe);
        pnl_menuTab_ThongKe.setLayout(pnl_menuTab_ThongKeLayout);
        pnl_menuTab_ThongKeLayout.setHorizontalGroup(
            pnl_menuTab_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_ThongKeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_TKeDT)
                .addGap(44, 44, 44)
                .addComponent(btn_tab_TKeHT)
                .addGap(45, 45, 45)
                .addComponent(btn_tab_TKeHBC)
                .addGap(43, 43, 43)
                .addComponent(btn_tab_TKeKH)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        pnl_menuTab_ThongKeLayout.setVerticalGroup(
            pnl_menuTab_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_ThongKeLayout.createSequentialGroup()
                .addGroup(pnl_menuTab_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_tab_TKeKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tab_TKeDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btn_tab_TKeHT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tab_TKeHBC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormThongKe.add(pnl_menuTab_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        pnl_tab_Form_TKedt.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pnl_tab_Form_TKedtLayout = new javax.swing.GroupLayout(pnl_tab_Form_TKedt);
        pnl_tab_Form_TKedt.setLayout(pnl_tab_Form_TKedtLayout);
        pnl_tab_Form_TKedtLayout.setHorizontalGroup(
            pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_Form_TKedtLayout.setVerticalGroup(
            pnl_tab_Form_TKedtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnl_FormThongKe.add(pnl_tab_Form_TKedt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

        pnl_tab_FormTKeht.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnl_tab_FormTKehtLayout = new javax.swing.GroupLayout(pnl_tab_FormTKeht);
        pnl_tab_FormTKeht.setLayout(pnl_tab_FormTKehtLayout);
        pnl_tab_FormTKehtLayout.setHorizontalGroup(
            pnl_tab_FormTKehtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormTKehtLayout.setVerticalGroup(
            pnl_tab_FormTKehtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnl_FormThongKe.add(pnl_tab_FormTKeht, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

        pnl_tab_FormTKhbc.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout pnl_tab_FormTKhbcLayout = new javax.swing.GroupLayout(pnl_tab_FormTKhbc);
        pnl_tab_FormTKhbc.setLayout(pnl_tab_FormTKhbcLayout);
        pnl_tab_FormTKhbcLayout.setHorizontalGroup(
            pnl_tab_FormTKhbcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormTKhbcLayout.setVerticalGroup(
            pnl_tab_FormTKhbcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnl_FormThongKe.add(pnl_tab_FormTKhbc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

        pnl_tab_FormTKkh.setBackground(new java.awt.Color(153, 0, 51));

        javax.swing.GroupLayout pnl_tab_FormTKkhLayout = new javax.swing.GroupLayout(pnl_tab_FormTKkh);
        pnl_tab_FormTKkh.setLayout(pnl_tab_FormTKkhLayout);
        pnl_tab_FormTKkhLayout.setHorizontalGroup(
            pnl_tab_FormTKkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        pnl_tab_FormTKkhLayout.setVerticalGroup(
            pnl_tab_FormTKkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnl_FormThongKe.add(pnl_tab_FormTKkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1300, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_TKeDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeDTMouseClicked
        // TODO add your handling code here:
        pnl_tab_Form_TKedt.setVisible(true);
        pnl_tab_FormTKeht.setVisible(false);
        pnl_tab_FormTKhbc.setVisible(false);
        pnl_tab_FormTKkh.setVisible(false);
    }//GEN-LAST:event_btn_tab_TKeDTMouseClicked

    private void btn_tab_TKeDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_TKeDTActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_tab_TKeDTActionPerformed

    private void btn_tab_TKeHTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeHTMouseClicked
        // TODO add your handling code here:
        pnl_tab_Form_TKedt.setVisible(false);
        pnl_tab_FormTKeht.setVisible(true);
        pnl_tab_FormTKhbc.setVisible(false);
        pnl_tab_FormTKkh.setVisible(false);
    }//GEN-LAST:event_btn_tab_TKeHTMouseClicked

    private void btn_tab_TKeHBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeHBCMouseClicked
        // TODO add your handling code here:
        pnl_tab_Form_TKedt.setVisible(false);
        pnl_tab_FormTKeht.setVisible(false);
        pnl_tab_FormTKhbc.setVisible(true);
        pnl_tab_FormTKkh.setVisible(false);
    }//GEN-LAST:event_btn_tab_TKeHBCMouseClicked

    private void btn_tab_TKeKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeKHMouseClicked
        // TODO add your handling code here:
        pnl_tab_Form_TKedt.setVisible(false);
        pnl_tab_FormTKeht.setVisible(false);
        pnl_tab_FormTKhbc.setVisible(false);
        pnl_tab_FormTKkh.setVisible(true);
    }//GEN-LAST:event_btn_tab_TKeKHMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_TKeDT;
    private javax.swing.JButton btn_tab_TKeHBC;
    private javax.swing.JButton btn_tab_TKeHT;
    private javax.swing.JButton btn_tab_TKeKH;
    private javax.swing.JLabel lbl_text_ThongKe;
    private javax.swing.JPanel pnl_FormThongKe;
    private javax.swing.JPanel pnl_menuTab_ThongKe;
    private javax.swing.JPanel pnl_tab_FormTKeht;
    private javax.swing.JPanel pnl_tab_FormTKhbc;
    private javax.swing.JPanel pnl_tab_FormTKkh;
    private javax.swing.JPanel pnl_tab_Form_TKedt;
    // End of variables declaration//GEN-END:variables
}
