/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.CaLamDao;
import dao.ChucVuDao;
import dao.LuongDao;
import dao.NhanVienDao;
import entity.CaLam;
import entity.ChucVu;
import entity.Luong;
import entity.NhanVien;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmNhanVien extends javax.swing.JPanel {
    public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
   private DefaultTableModel dfCL_Model;
   private DefaultTableModel dfNV2_Model;
   private DefaultTableModel dfLuong_Model;
   ArrayList<CaLam> dsCa;
   ArrayList<NhanVien> dsNv;
    ArrayList<Luong> dsLuong;
    ArrayList<ChucVu> dsCv;
    CaLamDao ca_dao;
    NhanVienDao nv_dao;
    LuongDao l_dao;
    ChucVuDao cv_dao;

    /**
     * Creates new form FrmNhanVien
     */
    public FrmNhanVien() {
        initComponents();
        addBorder();
    }
    
    public void addBorder(){
        buttons = new JButton[3];
        
          buttons[0] =btn_tab_NV;
        buttons[1] =btn_tab_CaLam;
        buttons[2] = btn_tab_Luong;
        
        
        setButtonBorder(btn_tab_NV);
        
   
        

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

        pnl_FormNhanVien = new javax.swing.JPanel();
        lbl_text_NhanVien = new javax.swing.JLabel();
        pnl_menuTab_NhanVien = new javax.swing.JPanel();
        btn_tab_NV = new javax.swing.JButton();
        btn_tab_CaLam = new javax.swing.JButton();
        btn_tab_Luong = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        frmDsNV2 = new Gui.FrmDsNV();
        frmCaLam2 = new Gui.FrmCaLam();
        frmLuong2 = new Gui.FrmLuong();

        pnl_FormNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormNhanVien.setMinimumSize(new java.awt.Dimension(1090, 700));
        pnl_FormNhanVien.setPreferredSize(new java.awt.Dimension(1090, 700));
        pnl_FormNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_NhanVien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_NhanVien.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_NhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_NhanVien.setText("Nhân Viên");
        pnl_FormNhanVien.add(lbl_text_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_NhanVien.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_NV.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_NV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_NV.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_NV.setText("Thông Tin Nhân Viên");
        btn_tab_NV.setBorder(null);
        btn_tab_NV.setContentAreaFilled(false);
        btn_tab_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_NVMouseClicked(evt);
            }
        });
        btn_tab_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_NVActionPerformed(evt);
            }
        });

        btn_tab_CaLam.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_CaLam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_CaLam.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_CaLam.setText("Ca Làm");
        btn_tab_CaLam.setBorder(null);
        btn_tab_CaLam.setContentAreaFilled(false);
        btn_tab_CaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_CaLamMouseClicked(evt);
            }
        });

        btn_tab_Luong.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_Luong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_Luong.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_Luong.setText("Lương");
        btn_tab_Luong.setBorder(null);
        btn_tab_Luong.setContentAreaFilled(false);
        btn_tab_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_LuongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_NhanVienLayout = new javax.swing.GroupLayout(pnl_menuTab_NhanVien);
        pnl_menuTab_NhanVien.setLayout(pnl_menuTab_NhanVienLayout);
        pnl_menuTab_NhanVienLayout.setHorizontalGroup(
            pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_NhanVienLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_NV)
                .addGap(58, 58, 58)
                .addComponent(btn_tab_CaLam)
                .addGap(65, 65, 65)
                .addComponent(btn_tab_Luong)
                .addContainerGap(664, Short.MAX_VALUE))
        );
        pnl_menuTab_NhanVienLayout.setVerticalGroup(
            pnl_menuTab_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tab_CaLam, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btn_tab_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_tab_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_FormNhanVien.add(pnl_menuTab_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 50));

        jTabbedPane1.addTab("tab1", frmDsNV2);
        jTabbedPane1.addTab("tab2", frmCaLam2);
        jTabbedPane1.addTab("tab3", frmLuong2);

        pnl_FormNhanVien.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1090, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_NVMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        
    }//GEN-LAST:event_btn_tab_NVMouseClicked

    private void btn_tab_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_NVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_NVActionPerformed

    private void btn_tab_CaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_CaLamMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_btn_tab_CaLamMouseClicked

    private void btn_tab_LuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_LuongMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        
    }//GEN-LAST:event_btn_tab_LuongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_CaLam;
    private javax.swing.JButton btn_tab_Luong;
    private javax.swing.JButton btn_tab_NV;
    private Gui.FrmCaLam frmCaLam2;
    private Gui.FrmDsNV frmDsNV2;
    private Gui.FrmLuong frmLuong2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_text_NhanVien;
    private javax.swing.JPanel pnl_FormNhanVien;
    private javax.swing.JPanel pnl_menuTab_NhanVien;
    // End of variables declaration//GEN-END:variables
}
