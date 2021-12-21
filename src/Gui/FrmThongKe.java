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
        
        buttons[2] = btn_tab_TKeKH;
        buttons[3] = btn_tab_TQTK;
        
        setButtonBorder(btn_tab_TQTK);
   
        

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
        btn_tab_TKeHBC = new javax.swing.JButton();
        btn_tab_TKeKH = new javax.swing.JButton();
        btn_tab_TQTK = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        frmTongQuanBaoCao1 = new Gui.FrmTongQuanBaoCao();
        frmTkeDoanhThu1 = new Gui.FrmTkeDoanhThu();
        frmTkeHangBanChay1 = new Gui.FrmTkeHangBanChay();
        frmTkeKhachHang1 = new Gui.FrmTkeKhachHang();

        setPreferredSize(new java.awt.Dimension(1090, 28));

        pnl_FormThongKe.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_ThongKe.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_ThongKe.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_ThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_ThongKe.setText("Thống Kê");
        pnl_FormThongKe.add(lbl_text_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_ThongKe.setBackground(new java.awt.Color(255, 255, 255));
        pnl_menuTab_ThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_tab_TKeDT.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TKeDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TKeDT.setForeground(new java.awt.Color(153, 153, 153));
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
        pnl_menuTab_ThongKe.add(btn_tab_TKeDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 0, -1, 36));

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
        pnl_menuTab_ThongKe.add(btn_tab_TKeHBC, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 0, -1, 36));

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
        pnl_menuTab_ThongKe.add(btn_tab_TKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 0, -1, 36));

        btn_tab_TQTK.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TQTK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TQTK.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_TQTK.setText("Tổng Quan Thống Kê");
        btn_tab_TQTK.setBorder(null);
        btn_tab_TQTK.setContentAreaFilled(false);
        btn_tab_TQTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TQTKMouseClicked(evt);
            }
        });
        btn_tab_TQTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_TQTKActionPerformed(evt);
            }
        });
        pnl_menuTab_ThongKe.add(btn_tab_TQTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 0, -1, 36));

        pnl_FormThongKe.add(pnl_menuTab_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        jTabbedPane1.addTab("tab4", frmTongQuanBaoCao1);
        jTabbedPane1.addTab("tab1", frmTkeDoanhThu1);
        jTabbedPane1.addTab("tab2", frmTkeHangBanChay1);
        jTabbedPane1.addTab("tab3", frmTkeKhachHang1);

        pnl_FormThongKe.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 1090, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_FormThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_FormThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_TKeDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeDTMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btn_tab_TKeDTMouseClicked

    private void btn_tab_TKeDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_TKeDTActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_tab_TKeDTActionPerformed

    private void btn_tab_TKeHBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeHBCMouseClicked
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(2);
         FrmTkeHangBanChay fr = new FrmTkeHangBanChay();
        fr.locBieuDo();
    }//GEN-LAST:event_btn_tab_TKeHBCMouseClicked

    private void btn_tab_TKeKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TKeKHMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        FrmTkeKhachHang fr = new FrmTkeKhachHang(); 
        fr.locBieuDo();
        
    }//GEN-LAST:event_btn_tab_TKeKHMouseClicked

    private void btn_tab_TQTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TQTKMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_tab_TQTKMouseClicked

    private void btn_tab_TQTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_TQTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_TQTKActionPerformed
    public void renderAgianTkKh(){
        frmTkeKhachHang1.locBieuDo();
        
    }
     public void renderAgianTongQuan(){
        frmTongQuanBaoCao1.renderData();
        
    }
    public void renderAgianTkSp(){
        frmTkeHangBanChay1.locBieuDo();
        
    }
    
    public void renderAgianTkDt(){
        frmTkeDoanhThu1.loadAgain();
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_tab_TKeDT;
    public static javax.swing.JButton btn_tab_TKeHBC;
    public static javax.swing.JButton btn_tab_TKeKH;
    private javax.swing.JButton btn_tab_TQTK;
    private Gui.FrmTkeDoanhThu frmTkeDoanhThu1;
    private Gui.FrmTkeHangBanChay frmTkeHangBanChay1;
    private Gui.FrmTkeKhachHang frmTkeKhachHang1;
    private Gui.FrmTongQuanBaoCao frmTongQuanBaoCao1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_text_ThongKe;
    private javax.swing.JPanel pnl_FormThongKe;
    public static javax.swing.JPanel pnl_menuTab_ThongKe;
    // End of variables declaration//GEN-END:variables
}
