/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class FrmKhachHang extends javax.swing.JPanel {
   public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
    /**
     * Creates new form FrmKhachHang
     */
    public FrmKhachHang() {
        initComponents();
        jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 13));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.setRowHeight(25);
        addBorder();
    }

    public void addBorder(){
        buttons = new JButton[2];
        
        //Form san pham
        buttons[0] = btn_tab_TK_KhachHang;
        buttons[1] = btn_tab_KhachHang;
        
        setButtonBorder(btn_tab_KhachHang);
        
   
        

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

        pnl_FormKhachHang = new javax.swing.JPanel();
        lbl_text_KhachHang = new javax.swing.JLabel();
        pnl_menuTab_KhachHang = new javax.swing.JPanel();
        btn_tab_KhachHang = new javax.swing.JButton();
        btn_tab_TK_KhachHang = new javax.swing.JButton();
        pnl_tab_FormKhachHang = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        pnl_tab_FormTKKhachHang = new javax.swing.JPanel();

        pnl_FormKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_KhachHang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_KhachHang.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_KhachHang.setText("Khách Hàng");
        pnl_FormKhachHang.add(lbl_text_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_KhachHang.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_KhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_KhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_KhachHang.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_KhachHang.setText("Thông Tin Khách Hàng");
        btn_tab_KhachHang.setBorder(null);
        btn_tab_KhachHang.setContentAreaFilled(false);
        btn_tab_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_KhachHangMouseClicked(evt);
            }
        });
        btn_tab_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_KhachHangActionPerformed(evt);
            }
        });

        btn_tab_TK_KhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_TK_KhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_TK_KhachHang.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_TK_KhachHang.setText("Tìm Kiếm Khách Hàng");
        btn_tab_TK_KhachHang.setBorder(null);
        btn_tab_TK_KhachHang.setContentAreaFilled(false);
        btn_tab_TK_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_TK_KhachHangMouseClicked(evt);
            }
        });
        btn_tab_TK_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_TK_KhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_KhachHangLayout = new javax.swing.GroupLayout(pnl_menuTab_KhachHang);
        pnl_menuTab_KhachHang.setLayout(pnl_menuTab_KhachHangLayout);
        pnl_menuTab_KhachHangLayout.setHorizontalGroup(
            pnl_menuTab_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_KhachHangLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_KhachHang)
                .addGap(69, 69, 69)
                .addComponent(btn_tab_TK_KhachHang)
                .addContainerGap(648, Short.MAX_VALUE))
        );
        pnl_menuTab_KhachHangLayout.setVerticalGroup(
            pnl_menuTab_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_KhachHangLayout.createSequentialGroup()
                .addGroup(pnl_menuTab_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_tab_TK_KhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btn_tab_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormKhachHang.add(pnl_menuTab_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        pnl_tab_FormKhachHang.setBackground(new java.awt.Color(229, 229, 229));
        pnl_tab_FormKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));
        jPanel1.setForeground(new java.awt.Color(199, 190, 162));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/down-arrow (1).png"))); // NOI18N
        jLabel3.setText("Xuất file");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 13, 111, 40));

        jButton1.setBackground(new java.awt.Color(0, 136, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (2).png"))); // NOI18N
        jButton1.setText("Thêm mới");
        jButton1.setPreferredSize(new java.awt.Dimension(132, 40));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 13, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 136, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/repair-tool.png"))); // NOI18N
        jButton2.setText("Sửa");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 13, -1, 40));

        jButton3.setBackground(new java.awt.Color(0, 136, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/trash.png"))); // NOI18N
        jButton3.setText("Xóa");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 13, -1, 40));

        pnl_tab_FormKhachHang.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Kh", "Tên KH", "Số Điện Thoại", "Địa Chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/right-arrow 2.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/prevous.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnl_tab_FormKhachHang.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 980, 550));

        pnl_FormKhachHang.add(pnl_tab_FormKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        pnl_tab_FormTKKhachHang.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout pnl_tab_FormTKKhachHangLayout = new javax.swing.GroupLayout(pnl_tab_FormTKKhachHang);
        pnl_tab_FormTKKhachHang.setLayout(pnl_tab_FormTKKhachHangLayout);
        pnl_tab_FormTKKhachHangLayout.setHorizontalGroup(
            pnl_tab_FormTKKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        pnl_tab_FormTKKhachHangLayout.setVerticalGroup(
            pnl_tab_FormTKKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        pnl_FormKhachHang.add(pnl_tab_FormTKKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1090, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_KhachHangMouseClicked
        pnl_tab_FormTKKhachHang.setVisible(false);
        pnl_tab_FormKhachHang.setVisible(true);
    }//GEN-LAST:event_btn_tab_KhachHangMouseClicked

    private void btn_tab_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_KhachHangActionPerformed

    private void btn_tab_TK_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_TK_KhachHangMouseClicked
        pnl_tab_FormTKKhachHang.setVisible(true);
        pnl_tab_FormKhachHang.setVisible(false);
    }//GEN-LAST:event_btn_tab_TK_KhachHangMouseClicked

    private void btn_tab_TK_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_TK_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_TK_KhachHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tab_KhachHang;
    private javax.swing.JButton btn_tab_TK_KhachHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_text_KhachHang;
    private javax.swing.JPanel pnl_FormKhachHang;
    private javax.swing.JPanel pnl_menuTab_KhachHang;
    private javax.swing.JPanel pnl_tab_FormKhachHang;
    private javax.swing.JPanel pnl_tab_FormTKKhachHang;
    // End of variables declaration//GEN-END:variables
}
