/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.HoaDonDao;

import entity.HoaDonBanHang;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * Hiển thị Giao diện Form Danh sách thông tin hóa đơn đặt hàng
 *
 */
public class FrmHoaDonDatHang extends javax.swing.JPanel {

    private javax.swing.table.DefaultTableModel modelTBHoaDon;
    String tt = null;
    ArrayList<HoaDonBanHang> listHoaDon;

    /**
     * Creates new form FrmHoaDonBanHang
     */
    public FrmHoaDonDatHang() throws SQLException {
        initComponents();
        listHoaDon = new ArrayList<HoaDonBanHang>();
        try {
            connect.getInstance().connect();

            renderListHoaDon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearchHD = new javax.swing.JTextField();
        btnShowHD = new javax.swing.JButton();
        btnSearchHD = new javax.swing.JButton();
        btnThemHD = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        lblNumHD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();

        jPanel1.setBackground(java.awt.Color.white);

        txtSearchHD.setBackground(java.awt.Color.white);
        txtSearchHD.setText("Nhập mã hóa đơn...");
        txtSearchHD.setToolTipText("");
        txtSearchHD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchHDFocusGained(evt);
            }
        });

        btnShowHD.setBackground(new java.awt.Color(21, 151, 229));
        btnShowHD.setForeground(java.awt.Color.white);
        btnShowHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btnShowHD.setText("Hiển thị DS Hóa Đơn");
        btnShowHD.setToolTipText("");
        btnShowHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowHDMouseClicked(evt);
            }
        });
        btnShowHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowHDActionPerformed(evt);
            }
        });

        btnSearchHD.setBackground(new java.awt.Color(21, 151, 229));
        btnSearchHD.setForeground(java.awt.Color.white);
        btnSearchHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnSearchHD.setText("Tìm Kiếm");
        btnSearchHD.setToolTipText("");
        btnSearchHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchHD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseDragged(evt);
            }
        });
        btnSearchHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchHDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSearchHDMousePressed(evt);
            }
        });
        btnSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHDActionPerformed(evt);
            }
        });

        btnThemHD.setBackground(new java.awt.Color(21, 151, 229));
        btnThemHD.setForeground(java.awt.Color.white);
        btnThemHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add.png"))); // NOI18N
        btnThemHD.setText("Thêm Hóa Đơn");
        btnThemHD.setToolTipText("");
        btnThemHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemHDMouseClicked(evt);
            }
        });

        jLabel1.setText("Số Hóa Đơn: ");

        lblNumHD.setText("2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                        .addComponent(btnThemHD)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnShowHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumHD)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowHD, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblNumHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchHD, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnSearchHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbHoaDon.setBackground(java.awt.Color.white);
        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbHoaDon.setRowHeight(28);
        tbHoaDon.setShowGrid(true);
        tbHoaDon.setUpdateSelectionOnSort(false);
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Đọc dữ liệu hóa đơn từ database lên bảng
     */
    public void renderListHoaDon() {
        HoaDonDao hoaDonDao = new HoaDonDao();
        String[] title = {"MaHD", "Ngày Tạo", "Số lượng", "Tổng Tiền", "Tình Trạng", "Khách Hàng", "Nhân Viên", "Ghi Chú"};
        listHoaDon = hoaDonDao.getDsHoaDon();
        // System.out.print(listHoaDon.size());
        modelTBHoaDon = new DefaultTableModel(title, 0);
        for (HoaDonBanHang s : listHoaDon) {
            //  System.out.print(i++);
            String[] rowData = {
                s.getMaHD(), changeDateToString(s.getNgayLap()), String.valueOf(s.getSoLuong()),
                String.valueOf(s.getTongTien()), s.getTinhTrang(),
                s.getKhachHang().getTenKH(),
                s.getNhanVien().getTenNV(), s.getGhiChu()
            };
            modelTBHoaDon.addRow(rowData);
        }
        tbHoaDon.setModel(modelTBHoaDon);
        MyRenderer render = new MyRenderer();
        TableColumn col = new TableColumn();
        col = tbHoaDon.getColumnModel().getColumn(4);
        col.setCellRenderer(render);
        lblNumHD.setText(String.valueOf(listHoaDon.size()));

    }

    /**
     * Chuyển kiêu dữ liệu Date sang String
     */
    public String changeDateToString(Date date) {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateString = df.format(date);
        return dateString;
    }

    /**
     * Xóa model bảng đặt hàng
     */
    public void xoaModel() {
        DefaultTableModel del = (DefaultTableModel) tbHoaDon.getModel();
        del.getDataVector().removeAllElements();
    }

    private void txtSearchHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchHDFocusGained
        txtSearchHD.setText("");
    }//GEN-LAST:event_txtSearchHDFocusGained

    private void btnShowHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowHDMouseClicked

        rederAgain();
    }//GEN-LAST:event_btnShowHDMouseClicked

    private void btnSearchHDMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseDragged

    }//GEN-LAST:event_btnSearchHDMouseDragged

    private void btnSearchHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseClicked
        String text = txtSearchHD.getText();
        AtomicBoolean check = new AtomicBoolean();
        HoaDonDao hoaDonDao = new HoaDonDao();

        ArrayList<HoaDonBanHang> listHoaDon = hoaDonDao.getDsHoaDon();

        listHoaDon.forEach(s -> {
            if (s.getMaHD().toUpperCase().equals(text.toUpperCase())) {
                check.set(true);
                String[] title = {"MaHD", "Ngày Tạo", "Số lượng", "Tổng Tiền", "Tình Trạng", "Khách Hàng", "Nhân Viên", "Ghi Chú"};
                modelTBHoaDon = new DefaultTableModel(title, 0);
                String[] rowData = {
                    s.getMaHD(), changeDateToString(s.getNgayLap()), String.valueOf(s.getSoLuong()),
                    String.valueOf(s.getTongTien()), s.getTinhTrang(),
                    s.getKhachHang().getTenKH(),
                    s.getNhanVien().getTenNV(), s.getGhiChu()
                };
                modelTBHoaDon.addRow(rowData);
                tbHoaDon.setModel(modelTBHoaDon);

            }
        });
        if (!check.get()) {
            JOptionPane.showMessageDialog(btnSearchHD, "Không có Hóa Đơn có mã:" + text + " ");
        }
    }//GEN-LAST:event_btnSearchHDMouseClicked

    private void btnSearchHDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchHDMouseEntered

    private void btnSearchHDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_btnSearchHDMouseExited

    private void btnSearchHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHDMousePressed
        // TODO add your handling code here:

        btnShowHD.setBackground(new java.awt.Color(17, 60, 252));
    }//GEN-LAST:event_btnSearchHDMousePressed

    private void btnSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchHDActionPerformed

    private void btnThemHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemHDMouseClicked

    }//GEN-LAST:event_btnThemHDMouseClicked

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // lay ra row vua click
        int row = tbHoaDon.getSelectedRow();
        //lay ra MaHD
        String maHD = tbHoaDon.getValueAt(row, 0).toString();
        //JOptionPane.showMessageDialog(jPanel1, maHD);
        new FrmCT_HoaDonDatHang(maHD).setVisible(true);
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnShowHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchHD;
    private javax.swing.JButton btnShowHD;
    private javax.swing.JToggleButton btnThemHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNumHD;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtSearchHD;
    // End of variables declaration//GEN-END:variables
    /**
     * Thêm màu vào bảng hóa đơn để biết trạng thái của hóa đơn
     *
     */
    public class MyRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
            if (tbHoaDon.getModel().getValueAt(row, 4).equals("Đang Giao")) {
                cell.setForeground(new Color(228, 156, 6));
                cell.setBackground(new Color(255, 247, 231));

            } else if (tbHoaDon.getModel().getValueAt(row, 4).equals("Hoàn Thành")) {
                cell.setBackground(new Color(231, 251, 243));
                cell.setForeground(new Color(13, 180, 115));
            } else if (tbHoaDon.getModel().getValueAt(row, 4).equals("Trả Hàng")) {
                cell.setBackground(new Color(251, 233, 231));
                cell.setForeground(new Color(220, 53, 69));
            }
            return cell;
        }
    }

    /**
     * Tải lại danh sách hóa đơn
     */
    public void rederAgain() {
        listHoaDon.removeAll(listHoaDon);
        xoaModel();
        renderListHoaDon();
    }
}
