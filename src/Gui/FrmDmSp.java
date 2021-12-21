/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import dao.DanhMucSPDao;
import dao.SanPhamDao;
import entity.DanhMucSP;
import entity.SanPham;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Hiển thị Giao diện Form Danh Mục Sản Phẩm
 *
 */
public class FrmDmSp extends javax.swing.JPanel {

    ArrayList<DanhMucSP> dsDmSP;
    ArrayList<SanPham> dsSP;
    DanhMucSPDao dm_dao;
    SanPhamDao sp_dao;
    private DefaultTableModel dfSP_Model;
    private DefaultTableModel dfDmSP_Model;

    /**
     * Creates new form FrmDmSp
     */
    public FrmDmSp() {
        initComponents();
        dsSP = new ArrayList<SanPham>();
        dsDmSP = new ArrayList<DanhMucSP>();

        dm_dao = new DanhMucSPDao();
        sp_dao = new SanPhamDao();
        upTblDM();

    }

    /**
     * Láy thông tin danh mục từ ô nhập liệu
     *
     */
    public DanhMucSP restTextDM() {
        String maDm = txt_MaDm.getText().toString();
        String tenDm = txt_TenDm.getText().toString();
        return new DanhMucSP(maDm, tenDm);

    }

    /**
     * Kiểm tra dữ liệu có hợp lệ hay không
     *
     */
    public boolean kiemTraDataDM() {
        String tenDM = txt_TenDm.getText().trim();
        // Tên danh mục phải là chữ
        if (!(tenDM.length() > 0 && tenDM.matches("[A-Za-z]+"))) {
            JOptionPane.showMessageDialog(this, "Tên Danh Mục phải là chữ");
            return false;
        }
        return true;
    }

    /**
     * Xóa model bản danh mục sản phẩm
     *
     */
    public void xoaModelDM() {
        DefaultTableModel del = (DefaultTableModel) tbl_DanhMuc.getModel();
        del.getDataVector().removeAllElements();
    }

    /**
     * Xóa trắng các textfield
     *
     */
    public void xoaRongTextDm() {

        txt_MaDm.setText("");
        txt_TenDm.setText("");
        txt_TenDm.requestFocus();
    }

    /**
     * Đọc dữ liệu lên bảng danh mục sản phẩm
     *
     */
    public void upTblDM() {
        dfDmSP_Model = (DefaultTableModel) tbl_DanhMuc.getModel();

        dsDmSP = dm_dao.getAllDM();
        for (DanhMucSP dm : dsDmSP) {
            dfDmSP_Model.addRow(new Object[]{
                dm.getMaloai(), dm.getTenLoai()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tab_FormDMSanPham = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DanhMuc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_ThemDm = new javax.swing.JButton();
        btn_SuaDm = new javax.swing.JButton();
        btn_XoaDm = new javax.swing.JButton();
        btn_LuuDm = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_MaDanhMuc = new javax.swing.JLabel();
        txt_MaDm = new javax.swing.JTextField();
        lbl_TenDm = new javax.swing.JLabel();
        txt_TenDm = new javax.swing.JTextField();

        pnl_tab_FormDMSanPham.setBackground(new java.awt.Color(243, 244, 237));

        tbl_DanhMuc.setBackground(new java.awt.Color(255, 255, 255));
        tbl_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tbl_DanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        tbl_DanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Danh Mục", "Tên Danh Mục Sản Phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_DanhMuc.setRowHeight(35);
        tbl_DanhMuc.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tbl_DanhMuc.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_DanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhMucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_DanhMuc);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null), "Tác Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btn_ThemDm.setBackground(new java.awt.Color(21, 151, 229));
        btn_ThemDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_ThemDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (1).png"))); // NOI18N
        btn_ThemDm.setText("Thêm");
        btn_ThemDm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ThemDm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemDmMouseClicked(evt);
            }
        });

        btn_SuaDm.setBackground(new java.awt.Color(21, 151, 229));
        btn_SuaDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_SuaDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_SuaDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btn_SuaDm.setText("Cập Nhật");
        btn_SuaDm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SuaDm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaDmMouseClicked(evt);
            }
        });

        btn_XoaDm.setBackground(new java.awt.Color(255, 102, 102));
        btn_XoaDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_XoaDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_XoaDm.setText("Xóa");
        btn_XoaDm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_XoaDm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaDmMouseClicked(evt);
            }
        });

        btn_LuuDm.setBackground(new java.awt.Color(21, 151, 229));
        btn_LuuDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_LuuDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_LuuDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_LuuDm.setText("Lưu");
        btn_LuuDm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LuuDm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LuuDmMouseClicked(evt);
            }
        });
        btn_LuuDm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuDmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ThemDm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_LuuDm, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_SuaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_XoaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LuuDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SuaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_MaDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MaDanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaDanhMuc.setText("Mã Danh mục");

        txt_MaDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MaDm.setForeground(new java.awt.Color(0, 0, 0));
        txt_MaDm.setToolTipText("");

        lbl_TenDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenDm.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenDm.setText("Tên Danh mục");

        txt_TenDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_TenDm.setForeground(new java.awt.Color(0, 0, 0));
        txt_TenDm.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_MaDanhMuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_MaDm, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(92, 92, 92)
                .addComponent(lbl_TenDm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TenDm, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_TenDm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_TenDm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_MaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_MaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_tab_FormDMSanPhamLayout = new javax.swing.GroupLayout(pnl_tab_FormDMSanPham);
        pnl_tab_FormDMSanPham.setLayout(pnl_tab_FormDMSanPhamLayout);
        pnl_tab_FormDMSanPhamLayout.setHorizontalGroup(
            pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(25, 25, 25))
        );
        pnl_tab_FormDMSanPhamLayout.setVerticalGroup(
            pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1102, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_tab_FormDMSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_tab_FormDMSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_DanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhMucMouseClicked
        int r = tbl_DanhMuc.getSelectedRow();
        btn_SuaDm.setEnabled(true);
        txt_MaDm.setText(dfDmSP_Model.getValueAt(r, 0).toString());
        txt_TenDm.setText(dfDmSP_Model.getValueAt(r, 1).toString());
    }//GEN-LAST:event_tbl_DanhMucMouseClicked

    private void btn_ThemDmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemDmMouseClicked
        xoaRongTextDm();
    }//GEN-LAST:event_btn_ThemDmMouseClicked

    private void btn_SuaDmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaDmMouseClicked
        int r = tbl_DanhMuc.getSelectedRow();
        btn_SuaDm.setEnabled(true);
        if (r != -1) {
            btn_SuaDm.setEnabled(true);
            String maDm = dfDmSP_Model.getValueAt(r, 0).toString();
            String tenDm = txt_TenDm.getText().trim();
            DanhMucSP dm = new DanhMucSP(maDm, tenDm);
            if (dm_dao.updateDM(maDm, dm)) {
                xoaRongTextDm();
                dfDmSP_Model.setRowCount(0);
                dsDmSP = dm_dao.getAllDM();
                for (DanhMucSP dmsp : dsDmSP) {
                    dfDmSP_Model.addRow(new Object[]{
                        dmsp.getMaloai(), dmsp.getTenLoai()
                    });
                }
                dsDmSP.removeAll(dsDmSP);
                xoaRongTextDm();
                xoaModelDM();
                upTblDM();

                JOptionPane.showMessageDialog(this, "Cập nhật danh sách thành công");
            }
        }
    }//GEN-LAST:event_btn_SuaDmMouseClicked

    private void btn_XoaDmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaDmMouseClicked
        int r = tbl_DanhMuc.getSelectedRow();
        String id = dfDmSP_Model.getValueAt(r, 0).toString();
        if (r != -1) {
            int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa dòng này không?", "Detele", JOptionPane.YES_NO_OPTION);
            if (tb == JOptionPane.YES_OPTION) {

                if (dm_dao.xoaDM(id)) {
                    dfDmSP_Model.removeRow(r);
                    dsDmSP.removeAll(dsDmSP);
                    xoaRongTextDm();
                    xoaModelDM();
                    upTblDM();
                } else {
                    JOptionPane.showMessageDialog(null, "Danh mục không thể xóa!");
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
    }//GEN-LAST:event_btn_XoaDmMouseClicked

    private void btn_LuuDmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuDmMouseClicked
        if (kiemTraDataDM()) {
            DanhMucSP dm = restTextDM();
            if (dm_dao.themDM(dm)) {
                dfDmSP_Model.addRow(new Object[]{
                    dm.getMaloai(), dm.getTenLoai()
                });
                dsDmSP.removeAll(dsDmSP);
                xoaRongTextDm();
                xoaModelDM();
                upTblDM();
//                xoaCBB();
//                upCbo_DM();

                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(null, " đã có vui lòng nhập lại ");
            }
        }
    }//GEN-LAST:event_btn_LuuDmMouseClicked

    private void btn_LuuDmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuDmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuDmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LuuDm;
    private javax.swing.JButton btn_SuaDm;
    private javax.swing.JButton btn_ThemDm;
    private javax.swing.JButton btn_XoaDm;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_MaDanhMuc;
    private javax.swing.JLabel lbl_TenDm;
    private javax.swing.JPanel pnl_tab_FormDMSanPham;
    private javax.swing.JTable tbl_DanhMuc;
    private javax.swing.JTextField txt_MaDm;
    private javax.swing.JTextField txt_TenDm;
    // End of variables declaration//GEN-END:variables
}
