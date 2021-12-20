/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.toedter.calendar.JTextFieldDateEditor;
import dao.CaLamDao;
import dao.ChucVuDao;
import dao.LuongDao;
import dao.NhanVienDao;
import entity.CaLam;
import entity.ChucVu;
import entity.Luong;
import entity.NhanVien;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmCaLam extends javax.swing.JPanel {

    private DefaultTableModel dfCL_Model;
    private DefaultTableModel dfNV2_Model;
    ArrayList<CaLam> dsCa;
    ArrayList<NhanVien> dsNv;
    ArrayList<Luong> dsLuong;
    ArrayList<ChucVu> dsCv;
    CaLamDao ca_dao;
    NhanVienDao nv_dao;
    LuongDao l_dao;
    ChucVuDao cv_dao;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public FrmCaLam() {
        initComponents();
        dsCa = new ArrayList<CaLam>();
        ca_dao = new CaLamDao();
        nv_dao = new NhanVienDao();
        dsNv = new ArrayList<NhanVien>();
        dsLuong = new ArrayList<Luong>();
        dsCv = new ArrayList<ChucVu>();
        cv_dao = new ChucVuDao();
        l_dao = new LuongDao();
        upTblCaLam();
        upTblNV2();
        upCbo_NV();
        Date date = new Date();
        jDateChooser1.setDate(date);

        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser1.getDateEditor();
        editor.setEditable(false);

    }

    //kiem tra ngày làm
    public boolean kiemTraDate() {
        Date dateTime = jDateChooser1.getDate();
        Date date = new Date();
        if (!(dateTime.getTime() > date.getTime())) {
            JOptionPane.showMessageDialog(this, "Ngày vào làm phải sau hoặc bằng ngày hiện tại!");
            return false;
        }
        return true;
    }

    //dọc dữ liêu lên cbo nhân vien
    public void upCbo_NV() {
//        dsNv = nv_dao.getAllNV();
        for (NhanVien nv : dsNv) {
            cbo_MaNv.addItem(nv.getMaNV());
        }
    }

    //đọc dữ liệu lên bảg nhân viên 2
    public void upTblNV2() {
        dfNV2_Model = (DefaultTableModel) tbl_NV_2.getModel();
        dsNv = nv_dao.getAllNV();
        for (NhanVien nv : dsNv) {
            dfNV2_Model.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(), nv.getChucVu().getTenCV()
            });
        }
    }

    //xoá rổng textfield ca làm
    public void xoaRongTextCa() {
        txt_MaCa.setText("");

    }

    public CaLam restText() {

        String maCa = txt_MaCa.getText().toString();
        String maNv = cbo_MaNv.getSelectedItem().toString();
        String buoi = cbo_Buoi.getSelectedItem().toString();
        NhanVien nv = nv_dao.getNVByMaNV(maNv);
        String dateTime = (String) formatter.format(jDateChooser1.getDate());
        System.out.println(dateTime);
        return new CaLam(maCa, nv, buoi, java.sql.Date.valueOf(dateTime));
    }

    public void xoaModelCa() {
        DefaultTableModel del = (DefaultTableModel) tbl_CaLam.getModel();
        del.getDataVector().removeAllElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tab_FormCaLam = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CaLam = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_ThemCa = new javax.swing.JButton();
        btn_LuuCa = new javax.swing.JButton();
        btn_XoaCa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_NV_2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lbl_MaCa = new javax.swing.JLabel();
        txt_MaCa = new javax.swing.JTextField();
        lbl_MauSac1 = new javax.swing.JLabel();
        cbo_MaNv = new javax.swing.JComboBox<>();
        lbl_DanhMuc = new javax.swing.JLabel();
        cbo_Buoi = new javax.swing.JComboBox<>();
        lbl_MauSac2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        pnl_tab_FormCaLam.setBackground(new java.awt.Color(243, 244, 237));

        tbl_CaLam.setForeground(new java.awt.Color(0, 0, 0));
        tbl_CaLam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Ca Làm", "Mã Nhân Viên", "Tên Nhân Viên", "Buổi", "Ngày Làm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_CaLam.setRowHeight(35);
        tbl_CaLam.setShowGrid(true);
        tbl_CaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CaLamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CaLam);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null), "Tác Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btn_ThemCa.setBackground(new java.awt.Color(21, 151, 229));
        btn_ThemCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_ThemCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (2).png"))); // NOI18N
        btn_ThemCa.setText("Thêm ");
        btn_ThemCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ThemCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemCaMouseClicked(evt);
            }
        });

        btn_LuuCa.setBackground(new java.awt.Color(21, 151, 229));
        btn_LuuCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_LuuCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_LuuCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_LuuCa.setText("Lưu ");
        btn_LuuCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LuuCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LuuCaMouseClicked(evt);
            }
        });
        btn_LuuCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuCaActionPerformed(evt);
            }
        });

        btn_XoaCa.setBackground(new java.awt.Color(255, 102, 102));
        btn_XoaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_XoaCa.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_XoaCa.setText("Xóa");
        btn_XoaCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_XoaCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaCaMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/refresh (3).png"))); // NOI18N
        jButton1.setToolTipText("Tải lại danh sách ");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ThemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btn_LuuCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_XoaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LuuCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tbl_NV_2.setForeground(new java.awt.Color(0, 0, 0));
        tbl_NV_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Tên Chức Vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_NV_2.setRowHeight(35);
        tbl_NV_2.setShowGrid(true);
        tbl_NV_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NV_2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_NV_2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        lbl_MaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MaCa.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaCa.setText("Mã Ca Làm");

        txt_MaCa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MaCa.setForeground(new java.awt.Color(0, 0, 0));
        txt_MaCa.setToolTipText("");

        lbl_MauSac1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MauSac1.setText("Mã Nhân Viên");

        cbo_MaNv.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_MaNv.setForeground(new java.awt.Color(0, 0, 0));

        lbl_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DanhMuc.setText("Buổi");

        cbo_Buoi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_Buoi.setForeground(new java.awt.Color(0, 0, 0));
        cbo_Buoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Chiều", "Tối" }));

        lbl_MauSac2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MauSac2.setText("Ngày Làm:");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_DanhMuc)
                        .addGap(101, 101, 101)
                        .addComponent(cbo_Buoi, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_MaCa)
                        .addGap(56, 56, 56)
                        .addComponent(txt_MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_MauSac1)
                    .addComponent(lbl_MauSac2))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(cbo_MaNv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbl_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbo_Buoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_MauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_MaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(lbl_MauSac2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout pnl_tab_FormCaLamLayout = new javax.swing.GroupLayout(pnl_tab_FormCaLam);
        pnl_tab_FormCaLam.setLayout(pnl_tab_FormCaLamLayout);
        pnl_tab_FormCaLamLayout.setHorizontalGroup(
            pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormCaLamLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_tab_FormCaLamLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        pnl_tab_FormCaLamLayout.setVerticalGroup(
            pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormCaLamLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tab_FormCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_tab_FormCaLam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_tab_FormCaLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_CaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CaLamMouseClicked
        int r = tbl_CaLam.getSelectedRow();
        
        txt_MaCa.setText(dfCL_Model.getValueAt(r, 0).toString());
        cbo_MaNv.setSelectedItem(dfCL_Model.getValueAt(r, 1).toString());
        cbo_Buoi.setSelectedItem(dfCL_Model.getValueAt(r, 3));
        jDateChooser1.setDate(java.sql.Date.valueOf(dfCL_Model.getValueAt(r, 4).toString()));

    }//GEN-LAST:event_tbl_CaLamMouseClicked

    private void btn_ThemCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemCaMouseClicked
        xoaRongTextCa();
        //        btn_SuaAnh.setEnabled(true);
    }//GEN-LAST:event_btn_ThemCaMouseClicked
    //đọc dữ liệu lên bảng ca làm
    public void upTblCaLam() {
        dfCL_Model = (DefaultTableModel) tbl_CaLam.getModel();
        dsCa = ca_dao.getAllCaLam();
        for (CaLam ca : dsCa) {
            dfCL_Model.addRow(new Object[]{
                ca.getMaCa(), ca.getNV().getMaNV(), ca.getNV().getTenNV(), ca.getBuoi(), ca.getNgayLam()
            });
        }

    }
    private void btn_LuuCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuCaMouseClicked
        if (kiemTraDate()) {
            CaLam ca = restText();
            if (ca_dao.themCa(ca)) {
                dfCL_Model.addRow(new Object[]{
                    ca.getMaCa(), ca.getNV().getMaNV(), ca.getNV().getTenNV(), ca.getBuoi(), ca.getNgayLam()
                });

                dsCa.removeAll(dsCa);
                xoaRongTextCa();
                xoaModelCa();
                upTblCaLam();
//            xoaModelLuong();
//            upTblLuong();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(null, " đã có vui lòng nhập lại ");
            }
        }

    }//GEN-LAST:event_btn_LuuCaMouseClicked

    private void btn_LuuCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuCaActionPerformed

    private void btn_XoaCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaCaMouseClicked
        int r = tbl_CaLam.getSelectedRow();
        String id = dfCL_Model.getValueAt(r, 0).toString();
        if (r != -1) {
            int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa dòng này không?", "Detele", JOptionPane.YES_NO_OPTION);
            if (tb == JOptionPane.YES_OPTION) {
                dfCL_Model.removeRow(r);
                ca_dao.xoaCa(id);
                dsCa.removeAll(dsCa);
                xoaRongTextCa();
                xoaModelCa();
                upTblCaLam();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }

    }//GEN-LAST:event_btn_XoaCaMouseClicked

    private void tbl_NV_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NV_2MouseClicked
        int r = tbl_NV_2.getSelectedRow();
        cbo_MaNv.setSelectedItem(dfNV2_Model.getValueAt(r, 0).toString());
    }//GEN-LAST:event_tbl_NV_2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dsCa.removeAll(dsCa);
        xoaModelCa();
        upTblCaLam();
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LuuCa;
    private javax.swing.JButton btn_ThemCa;
    private javax.swing.JButton btn_XoaCa;
    private javax.swing.JComboBox<String> cbo_Buoi;
    private javax.swing.JComboBox<String> cbo_MaNv;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_MaCa;
    private javax.swing.JLabel lbl_MauSac1;
    private javax.swing.JLabel lbl_MauSac2;
    private javax.swing.JPanel pnl_tab_FormCaLam;
    private javax.swing.JTable tbl_CaLam;
    private javax.swing.JTable tbl_NV_2;
    private javax.swing.JTextField txt_MaCa;
    // End of variables declaration//GEN-END:variables
}
