/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.NhaCCDao;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhaCC;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmHeThong extends javax.swing.JPanel {
    private ArrayList<TaiKhoan> listTK = new ArrayList<TaiKhoan>();
    TaiKhoanDao tkDao = new TaiKhoanDao();
     private javax.swing.table.DefaultTableModel modelTbTK;
     //chua ds  NV tuong ung tung chi so index trong jcomboNV
     private List<NhanVien> listNV = new ArrayList<NhanVien>();
     
     
   public  Border default_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,153,153));
   public Border active_border = BorderFactory.createMatteBorder(0, 0   , 3, 0, new Color(153,204,255));
   public JButton [] buttons;
    /**
     * Creates new form FrmHeThong
     */
    public FrmHeThong() {
        initComponents();
        listTK = tkDao.getDsTaiKhoan();
        try {
            connect.getInstance().connect();
        } catch (SQLException ex) {
            Logger.getLogger(FrmHeThong.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         // renderDsTK(listTK);
          renderJCB();
          setButtonBorder(btn_tab_HeThong);
    }
    
     //dua du lieu TaiKhoan len Table
	private void renderDsTK(ArrayList<TaiKhoan> arr) {
		
                 String[] title = { "Tên Tài Khoản", "Mật Khẩu", "Tên Quyền", "Trạng Thái", "Nhân Viên"};
		 
                modelTbTK = new DefaultTableModel(title,0);
		for(TaiKhoan s : arr) {
			String[] rowData = {
				s.getTenTaiKhoan(),s.getMatKhau(),s.getTenQuyen(),s.getTrangThai(),s.getNhanVien().getTenNV()
			};
                       
			modelTbTK.addRow(rowData);
		}
               
		tbTaiKhoan.setModel(modelTbTK);
           
	}
        
        public void renderDsTKAgain() {
		
                 String[] title = { "Tên Tài Khoản", "Mật Khẩu", "Tên Quyền", "Trạng Thái", "Nhân Viên"};
		 
                modelTbTK = new DefaultTableModel(title,0);
              modelTbTK.setRowCount(0);
              TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
                ArrayList<TaiKhoan> arr = taiKhoanDao.getDsTaiKhoan();
		for(TaiKhoan s : arr) {
			String[] rowData = {
				s.getTenTaiKhoan(),s.getMatKhau(),s.getTenQuyen(),s.getTrangThai(),s.getNhanVien().getTenNV()
			};
                       
			modelTbTK.addRow(rowData);
		}
               
		tbTaiKhoan.setModel(modelTbTK);
           
	}

//    public void addBorder(){
//        buttons = new JButton[2];
//        
//        //Form san pham
//        buttons[0] = btn_tab_dsncc;
//        buttons[1] = btn_tab_tkncc;
//        
//   
//        setButtonBorder(btn_tab_HeThong);
//
//        addAction();
//    }
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

        jPanel3 = new javax.swing.JPanel();
        pnl_FormHeThong = new javax.swing.JPanel();
        lbl_text_HeThong = new javax.swing.JLabel();
        pnl_menuTab_HeThong = new javax.swing.JPanel();
        btn_tab_HeThong = new javax.swing.JButton();
        pnl_tab_FormHeThong = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTK = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        lblTK1 = new javax.swing.JLabel();
        lblQuyen = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblTK4 = new javax.swing.JLabel();
        jcbNhanVien1 = new javax.swing.JComboBox<>();
        jcbTenQuyen = new javax.swing.JComboBox<>();
        txtMatKhau = new javax.swing.JTextField();
        jcbTrangThai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTaiKhoan = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLuu1 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(1090, 700));

        pnl_FormHeThong.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormHeThong.setPreferredSize(new java.awt.Dimension(1090, 700));
        pnl_FormHeThong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_HeThong.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_HeThong.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_HeThong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_HeThong.setText("Hệ Thống");
        pnl_FormHeThong.add(lbl_text_HeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_HeThong.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_HeThong.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_HeThong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_HeThong.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_HeThong.setText("Quản lý tài khoản");
        btn_tab_HeThong.setBorder(null);
        btn_tab_HeThong.setContentAreaFilled(false);
        btn_tab_HeThong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_HeThongMouseClicked(evt);
            }
        });
        btn_tab_HeThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_HeThongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_HeThongLayout = new javax.swing.GroupLayout(pnl_menuTab_HeThong);
        pnl_menuTab_HeThong.setLayout(pnl_menuTab_HeThongLayout);
        pnl_menuTab_HeThongLayout.setHorizontalGroup(
            pnl_menuTab_HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_HeThongLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_HeThong)
                .addContainerGap(906, Short.MAX_VALUE))
        );
        pnl_menuTab_HeThongLayout.setVerticalGroup(
            pnl_menuTab_HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_HeThongLayout.createSequentialGroup()
                .addComponent(btn_tab_HeThong, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_FormHeThong.add(pnl_menuTab_HeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        pnl_tab_FormHeThong.setBackground(new java.awt.Color(243, 244, 237));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTK.setText("Tên Tài Khoản :");

        txtTaiKhoan.setForeground(new java.awt.Color(66, 63, 62));
        txtTaiKhoan.setText("nhập tài khoản...");
        txtTaiKhoan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTaiKhoanFocusGained(evt);
            }
        });

        lblTK1.setText("Mật khẩu:");

        lblQuyen.setText("Tên quyền :");

        lblTrangThai.setText("Trạng thái :");

        lblTK4.setText("Nhân Viên :");

        jcbNhanVien1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbTenQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMatKhau.setForeground(new java.awt.Color(66, 63, 62));
        txtMatKhau.setText("mật khẩu...");
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
        });

        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTK)
                    .addComponent(lblTK1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTrangThai)
                        .addGap(18, 18, 18)
                        .addComponent(jcbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQuyen)
                        .addGap(18, 18, 18)
                        .addComponent(jcbTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTK4)
                        .addGap(18, 18, 18)
                        .addComponent(jcbNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTK)
                            .addComponent(lblQuyen)
                            .addComponent(lblTK4)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrangThai)
                            .addComponent(jcbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTK1))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbTaiKhoan.setRowHeight(26);
        tbTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTaiKhoan);

        btnXoa.setBackground(new java.awt.Color(21, 151, 229));
        btnXoa.setForeground(java.awt.Color.white);
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/close (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(21, 151, 229));
        btnCapNhat.setForeground(java.awt.Color.white);
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/system-update.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseClicked(evt);
            }
        });

        btnLuu1.setBackground(new java.awt.Color(21, 151, 229));
        btnLuu1.setForeground(java.awt.Color.white);
        btnLuu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVsicon/clipboard.png"))); // NOI18N
        btnLuu1.setText("Lưu");
        btnLuu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuu1.setEnabled(false);
        btnLuu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuu1MouseClicked(evt);
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

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_tab_FormHeThongLayout = new javax.swing.GroupLayout(pnl_tab_FormHeThong);
        pnl_tab_FormHeThong.setLayout(pnl_tab_FormHeThongLayout);
        pnl_tab_FormHeThongLayout.setHorizontalGroup(
            pnl_tab_FormHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormHeThongLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_tab_FormHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                    .addGroup(pnl_tab_FormHeThongLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        pnl_tab_FormHeThongLayout.setVerticalGroup(
            pnl_tab_FormHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormHeThongLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tab_FormHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnl_FormHeThong.add(pnl_tab_FormHeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1090, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_HeThongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_HeThongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_HeThongMouseClicked

    private void btn_tab_HeThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_HeThongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_HeThongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTaiKhoanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaiKhoanFocusGained
        // TODO add your handling code here:
        txtTaiKhoan.setText("");
       txtTaiKhoan.setForeground(new java.awt.Color(26, 25, 25));
    }//GEN-LAST:event_txtTaiKhoanFocusGained

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        // TODO add your handling code here:
        txtMatKhau.setText("");
     txtMatKhau.setForeground(new java.awt.Color(26, 25, 25));
         
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void tbTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoanMouseClicked
                int row = tbTaiKhoan.getSelectedRow();
               if(row != -1){
                    setColorInput();
                    txtTaiKhoan.setEnabled(false);
                    txtTaiKhoan.setText(tbTaiKhoan.getValueAt(row, 0).toString());
                    txtMatKhau.setText(tbTaiKhoan.getValueAt(row, 1).toString());
                    String TenQuyen = tbTaiKhoan.getValueAt(row, 2).toString();
                    if(TenQuyen.toUpperCase().equals("Nhân viên".toUpperCase())){
                        jcbTenQuyen.setSelectedIndex(0);
                    }
                    else if(TenQuyen.toUpperCase().equals("Quản lý".toUpperCase())){
                        jcbTenQuyen.setSelectedIndex(1);
                    }
                    
                    
                    
                     String TrangThai = tbTaiKhoan.getValueAt(row, 3).toString();
                
                    if(TrangThai.toLowerCase().equals("đã khóa")){
                        jcbTrangThai.setSelectedIndex(1);
                    }
                    else if(TrangThai.toUpperCase().equals("Hoạt động".toUpperCase())){
                        jcbTrangThai.setSelectedIndex(0);
                    }
                    
                    
                     String NhanVien = tbTaiKhoan.getValueAt(row, 4).toString();
                      try {
                    NhanVienDao nvDao = new NhanVienDao();
                    ArrayList<NhanVien> listNV = nvDao.getAllNV();
                    
                     for(int i =0; i < listNV.size(); i++) {
				if(listNV.get(i).getTenNV().toUpperCase().equals(NhanVien.toUpperCase())){
                                    jcbNhanVien1.setSelectedIndex(i);
                                    break;
                                }
			}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
               }
    }//GEN-LAST:event_tbTaiKhoanMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
       txtTaiKhoan.setEnabled(true);
       btnLuu1.setEnabled(true);
       txtTaiKhoan.requestFocus();
         xoaRong();
        
    }//GEN-LAST:event_btnThemMouseClicked

    //su kien clich vao Update
    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked
                if(checkValue()){
                    String username = txtTaiKhoan.getText();
                   String passWorld = txtMatKhau.getText();
                   String tenQuyen = jcbTenQuyen.getSelectedItem().toString().toLowerCase();
                   String trangThai = jcbTrangThai.getSelectedItem().toString().toLowerCase();
                   
                   TaiKhoan tk = new TaiKhoan(passWorld, tenQuyen, trangThai, username);
                   if(tkDao.updateTaiKhoan(tk)){
                        String[] title = { "Tên Tài Khoản", "Mật Khẩu", "Tên Quyền", "Trạng Thái", "Nhân Viên"};
                        modelTbTK = new DefaultTableModel(title,0);
                        tbTaiKhoan.setModel(modelTbTK);
                       TaiKhoanDao tkd = new TaiKhoanDao();
                       ArrayList<TaiKhoan> list = tkd.getDsTaiKhoan();
                       renderDsTK(list);
                       JOptionPane.showMessageDialog(btnThem, "Cập nhật thành công!!");
                   }
                }
    }//GEN-LAST:event_btnCapNhatMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        	int row = tbTaiKhoan.getSelectedRow();
			if(row >= 0) {
				String tenTK = tbTaiKhoan.getValueAt(row, 0).toString();
				if(tkDao.deleteTaiKhoan(tenTK)) {
					modelTbTK.removeRow(row);
					xoaRong();
					JOptionPane.showMessageDialog(btnThem, "Xóa thành công");
				}
				
			}
    }//GEN-LAST:event_btnXoaMouseClicked

    //click vao luu
    private void btnLuu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuu1MouseClicked
        String tenTk = txtTaiKhoan.getText().trim();
        String pass = txtMatKhau.getText().trim();
        String tenQuyen = jcbTenQuyen.getSelectedItem().toString().toLowerCase();
        String trangThai = jcbTrangThai.getSelectedItem().toString().toLowerCase();
        int tenNvIdx = jcbNhanVien1.getSelectedIndex();
        NhanVien nv = listNV.get(tenNvIdx);
        
        if(checkValue()&& checkNVandUserName() ){
           TaiKhoan tk = new TaiKhoan(pass, tenQuyen, trangThai, tenTk);
            tk.setNhanVien(nv);
            if(tkDao.createTaiKhoan(tk)){
               
                
                //cap nhat lai table
                  Object[] row = {tk.getTenTaiKhoan(),
                     tk.getMatKhau(), tk.getTenQuyen(), tk.getTrangThai(), tk.getNhanVien().getTenNV()};
                    modelTbTK.addRow(row);
                    xoaRong();
                    btnLuu1.setEnabled(false);
                     JOptionPane.showMessageDialog(btnThem, "Thêm thành công !!");
            }
        }
     
              
    }//GEN-LAST:event_btnLuu1MouseClicked
    public boolean checkNVandUserName(){
         //kiem tra ten dang nhap da ton tai chuwa
          String tenTk = txtTaiKhoan.getText().trim();
              TaiKhoanDao tkDao = new TaiKhoanDao();
              TaiKhoan tk = tkDao.findTKByUserName(tenTk);
              if(tk!=null){
                  JOptionPane.showMessageDialog(btnThem, "Tên đăng nhập đã tồn tài trong hệ thống.");
                  return false;
              }
                //lay ra chi so index trong jcbNV
                //kiem tra nv da co tk chua
                //1 nv chi co 1 tk
              int idxNV = jcbNhanVien1.getSelectedIndex();
               TaiKhoan taikhoan = tkDao.findTKByMaNV(listNV.get(idxNV).getMaNV());
               if(taikhoan!=null){
                   JOptionPane.showMessageDialog(btnThem, "Nhân viên đã có tài khoản trong hệ thống.\n Mỗi nhân viên chỉ có thể đăng ký 1 tài khoản.");
                   return false;
               }
        
        return true;
    }
    
    public boolean checkValue(){
            
            
           
              
            //check mật khẩu từ 6-18 ký tự và không có ký tự đặc biệt
            ///^[a-z0-9_-]{6,18}$/
            String passWorld = txtMatKhau.getText().trim();
             String regexPasWorld = "^[a-z0-9_-]{6,18}$";//check mail
              if ( !passWorld.matches("^[a-z0-9_-]{6,18}$")) {
		JOptionPane.showMessageDialog(btnThem, "Mật khẩu 6-18 ký tự và không chứa ký tự đặc biệt");
		return false;
                }
             
              //kiem tra ten ng dung
             //  /^[a-z0-9_-]{3,16}$/
             String tenTk = txtTaiKhoan.getText().trim();
              if ( !tenTk.matches("^[a-zA-Z0-9_-]{3,16}$")) {
		JOptionPane.showMessageDialog(btnThem, "Tên đăng nhập từ 3-16 ký tự và không chứa ký tự đặc biệt");
		return false;
                }
              
             
              
          
            return true;
        }
        
        public  void xoaRong(){
              txtTaiKhoan.setText("");
              txtMatKhau.setText("");
        }
     //set color cho the input
        public void setColorInput(){
             txtTaiKhoan.setForeground(new java.awt.Color(26, 25, 25));
             txtMatKhau.setForeground(new java.awt.Color(26, 25, 25));                    
        }
        
        //render jcombobox len giao dien
        public void renderJCB(){
 
                jcbTenQuyen.removeAllItems();
                jcbTenQuyen.addItem("Nhân viên");
                jcbTenQuyen.addItem("Quản lý");
                
                jcbTrangThai.removeAllItems();
                jcbTrangThai.addItem("Hoạt động");
                jcbTrangThai.addItem("Đã khóa");
                
                //lay ra ds Ten nhan ven dua len jcombobox
                try {
                    NhanVienDao nvDao = new NhanVienDao();
                    listNV = nvDao.getAllNV();
                    System.out.println("Gui.FrmHeThong.renderJCB()"+listNV);
                     jcbNhanVien1.removeAllItems();
                     for(NhanVien nv : listNV) {
                         
			jcbNhanVien1.addItem(nv.getTenNV());
                       
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_tab_HeThong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbNhanVien1;
    private javax.swing.JComboBox<String> jcbTenQuyen;
    private javax.swing.JComboBox<String> jcbTrangThai;
    private javax.swing.JLabel lblQuyen;
    private javax.swing.JLabel lblTK;
    private javax.swing.JLabel lblTK1;
    private javax.swing.JLabel lblTK4;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lbl_text_HeThong;
    private javax.swing.JPanel pnl_FormHeThong;
    private javax.swing.JPanel pnl_menuTab_HeThong;
    private javax.swing.JPanel pnl_tab_FormHeThong;
    private javax.swing.JTable tbTaiKhoan;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
