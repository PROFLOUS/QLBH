/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Connect.connect;
import dao.DanhMucSPDao;
import dao.SanPhamDao;
import entity.DanhMucSP;
import entity.SanPham;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Hiển thị Giao diện Form danh sách thông tin sản phẩm
 *
 */
public class FrmDsSp extends javax.swing.JPanel {

    ArrayList<DanhMucSP> dsDmSP;
    ArrayList<SanPham> dsSP;
    DanhMucSPDao dm_dao;
    SanPhamDao sp_dao;
    private DefaultTableModel dfSP_Model;
    final JFileChooser fileDialog = new JFileChooser("C:\\\\Users\\\\HP\\\\OneDrive\\\\Máy tính\\\\QLBH");
    JFrame cha = new JFrame();
    ImageIcon icon;

    public FrmDsSp() throws SQLException {
        initComponents();
        dsSP = new ArrayList<SanPham>();
        dm_dao = new DanhMucSPDao();
        sp_dao = new SanPhamDao();
        txt_SlKho.setEditable(false);
        try {
            connect.getInstance().connect();
            upTblSP();
            upCbo_DM();
        } catch (Exception e) {
            System.out.println("loll");
            e.printStackTrace();
        }
    }

    /**
     * Lấy dữ liệu nhập từ cái ô textfield
     */
    public SanPham restText() {
        String maSp = lbl_GetSp.getText().toString();
        String tenSp = txt_TenSp.getText().toString();
        String tenDm = cbo_Dm.getSelectedItem().toString();
        DanhMucSP dm = dm_dao.getDMByTen(tenDm);
        String mau = txt_MauSac.getText().toString();
        String size = txt_Size.getText().toString();
        double giaNhap = Double.parseDouble(txt_DonGia1.getText());
        int slKho = Integer.parseInt(txt_SlKho.getText());
        double donGia = Double.parseDouble(txt_DonGia.getText());
        String hinh = lbl_HinhAnh.getIcon().toString();

        return new SanPham(dm, tenSp, donGia, slKho, hinh, size, mau, giaNhap);
    }

    /**
     * Kiểm tra dữ liệu nhập
     */
    public boolean kiemTraData() {
        String tenSP = txt_TenSp.getText().trim();
        String mau = txt_MauSac.getText().trim();
        String size = txt_Size.getText().trim();
        String slKho = txt_SlKho.getText().trim();
        String donGia = txt_DonGia.getText().trim();
        String giaNhap = txt_DonGia1.getText().trim();
        // Tên sản phẩm phải là chữ
        if (tenSP.length() < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên Sản Phẩm");
            return false;
        }
        //Mau phải là chữ
        if (mau.length() < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập màu sắc");
            return false;
        }
        //size ko am
        if (!(size.length() > 0 && size.matches("[A-Za-z0-9 ]+"))) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm không được là số âm");
            return false;
        }
        //sl kho số ko âm
        if (slKho.length() > 0) {
            try {
                int x = Integer.parseInt(slKho);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                return false;
            }
        }
        //sl số ko âm
        //Đơn giá số ko âm
        if (donGia.length() > 0) {
            try {
                int x = Integer.parseInt(donGia);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Đơn Giá phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Đơn Giá phải nhập số nguyên dương");
                return false;
            }
        }
        // giá nhap số ko âm
        if (giaNhap.length() > 0) {
            try {
                int x = Integer.parseInt(giaNhap);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Giá Nhập phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Giá Nhập phải nhập số nguyên dương");
                return false;
            }
        }

        return true;
    }

    /**
     * Xóa model bảng thông tin sản phẩm
     */
    public void xoaModelSP() {
        DefaultTableModel del = (DefaultTableModel) tbl_Sp.getModel();
        del.getDataVector().removeAllElements();
    }

    /**
     * xóa trắng các ổ textfield
     */
    public void xoaRongTextSp() {
        txt_SlKho.setText("");
        txt_TenSp.setText("");
        txt_DonGia.setText("");
        txt_Size.setText("");
        txt_MauSac.setText("");
        lbl_GetSp.setText("");
        lbl_HinhAnh.setIcon(new ImageIcon("src\\imgVSicon\\image.png"));
        txt_TenSp.requestFocus();
        txt_DonGia1.setText("");
    }

    /**
     * Xóa dữ liệu danh mục sản phẩm trên combobox
     */
    public void xoaCBB() {
        int itCount = cbo_Dm.getItemCount();
        for (int i = 0; i < itCount; i++) {
            cbo_Dm.removeItemAt(0);
        }

    }

    /**
     * Đọc dữ liệu Danh mục từ database lên Combobox
     */
    public void upCbo_DM() {
        dsDmSP = dm_dao.getAllDM();
        for (DanhMucSP dm : dsDmSP) {
            cbo_Dm.addItem(dm.getTenLoai());
//            cbb_TkDM.addItem(dm.getTenLoai());
        }
    }

    /**
     * Đọc dữ liệu sản phẩm từ database lên bảng thông tin
     */
    public void upTblSP() {
        //bang san pham
        dfSP_Model = (DefaultTableModel) tbl_Sp.getModel();
        dsSP = sp_dao.getAllSP();

        for (SanPham sp : dsSP) {
            dfSP_Model.addRow(new Object[]{
                sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                sp.getDonGia(), sp.getGiaNhap(), sp.getHinhAnh()
            });
        }

    }

    /**
     * Tải lại dữ liệu danh sách sản phẩm
     */
    public void reLoad() {
        dsSP.removeAll(dsSP);
        xoaModelSP();
        upTblSP();
        dsDmSP.removeAll(dsDmSP);
        xoaCBB();
        upCbo_DM();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tab_FormSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sp = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        txtSearchsp = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_HinhAnh = new javax.swing.JLabel();
        btn_SuaAnh = new javax.swing.JButton();
        lbl_MaSp = new javax.swing.JLabel();
        lbl_GetSp = new javax.swing.JLabel();
        lbl_TenSp = new javax.swing.JLabel();
        txt_TenSp = new javax.swing.JTextField();
        lbl_MauSac = new javax.swing.JLabel();
        txt_MauSac = new javax.swing.JTextField();
        lbl_Size = new javax.swing.JLabel();
        txt_Size = new javax.swing.JTextField();
        lbl_DonGia = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        lbl_DanhMuc = new javax.swing.JLabel();
        cbo_Dm = new javax.swing.JComboBox<>();
        lbl_SlKho = new javax.swing.JLabel();
        txt_SlKho = new javax.swing.JTextField();
        lbl_DonGia1 = new javax.swing.JLabel();
        txt_DonGia1 = new javax.swing.JTextField();

        pnl_tab_FormSanPham.setBackground(new java.awt.Color(243, 244, 237));

        tbl_Sp.setForeground(new java.awt.Color(0, 0, 0));
        tbl_Sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Danh Mục", "Màu Sắc", "Size", "Số Lượng", "Đơn Giá", "Giá Nhập", "Hình Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Sp.setRowHeight(30);
        tbl_Sp.setShowGrid(true);
        tbl_Sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Sp);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        btn_Sua.setBackground(new java.awt.Color(21, 151, 229));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btn_Sua.setText("Cập Nhật");
        btn_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaMouseClicked(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(255, 102, 102));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });

        txtSearchsp.setForeground(new java.awt.Color(0, 0, 0));
        txtSearchsp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchspFocusGained(evt);
            }
        });
        txtSearchsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchspActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(21, 151, 229));
        btnTimKiem.setForeground(java.awt.Color.white);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setToolTipText("Nhập mã. tên NCC để tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtSearchsp, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Sua)
                .addGap(31, 31, 31)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchsp, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_HinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbl_HinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_HinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/image.png"))); // NOI18N
        lbl_HinhAnh.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 153, 255)));

        btn_SuaAnh.setBackground(new java.awt.Color(21, 151, 229));
        btn_SuaAnh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_SuaAnh.setForeground(new java.awt.Color(255, 255, 255));
        btn_SuaAnh.setText("Sửa ảnh");
        btn_SuaAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SuaAnh.setEnabled(false);
        btn_SuaAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaAnhMouseClicked(evt);
            }
        });

        lbl_MaSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MaSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaSp.setText("Mã Sản Phẩm ");

        lbl_GetSp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_GetSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_GetSp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_GetSp.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        lbl_TenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenSp.setText("Tên Sản Phẩm ");

        txt_TenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_TenSp.setForeground(new java.awt.Color(0, 0, 0));
        txt_TenSp.setToolTipText("");

        lbl_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MauSac.setText("Màu Sắc ");

        txt_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MauSac.setForeground(new java.awt.Color(0, 0, 0));
        txt_MauSac.setToolTipText("");

        lbl_Size.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_Size.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Size.setText("Size");

        txt_Size.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_Size.setForeground(new java.awt.Color(0, 0, 0));
        txt_Size.setToolTipText("");

        lbl_DonGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DonGia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DonGia.setText("Đơn Giá");

        txt_DonGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_DonGia.setForeground(new java.awt.Color(0, 0, 0));
        txt_DonGia.setToolTipText("");

        lbl_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DanhMuc.setText("Danh Mục");

        cbo_Dm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_Dm.setForeground(new java.awt.Color(0, 0, 0));

        lbl_SlKho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SlKho.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SlKho.setText("Số Lượng Kho");

        txt_SlKho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_SlKho.setForeground(new java.awt.Color(0, 0, 0));
        txt_SlKho.setToolTipText("");
        txt_SlKho.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        lbl_DonGia1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DonGia1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DonGia1.setText("Giá Nhập");

        txt_DonGia1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_DonGia1.setForeground(new java.awt.Color(0, 0, 0));
        txt_DonGia1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_SuaAnh)))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lbl_MaSp)
                            .addGap(34, 34, 34)
                            .addComponent(lbl_GetSp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lbl_DonGia)
                            .addGap(77, 77, 77)
                            .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(lbl_MauSac)
                            .addGap(69, 69, 69)
                            .addComponent(txt_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_DonGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txt_DonGia1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_Size)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_TenSp)
                                .addGap(34, 34, 34)
                                .addComponent(txt_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_SlKho)
                                .addGap(40, 40, 40)
                                .addComponent(txt_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_DanhMuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbo_Dm, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_MaSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_GetSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Size, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Size, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txt_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(lbl_DonGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbo_Dm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txt_DonGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_SuaAnh)))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout pnl_tab_FormSanPhamLayout = new javax.swing.GroupLayout(pnl_tab_FormSanPham);
        pnl_tab_FormSanPham.setLayout(pnl_tab_FormSanPhamLayout);
        pnl_tab_FormSanPhamLayout.setHorizontalGroup(
            pnl_tab_FormSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormSanPhamLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_tab_FormSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnl_tab_FormSanPhamLayout.setVerticalGroup(
            pnl_tab_FormSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormSanPhamLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_tab_FormSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_tab_FormSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SpMouseClicked
        int r = tbl_Sp.getSelectedRow();
        btn_SuaAnh.setEnabled(true);
        lbl_GetSp.setText(dfSP_Model.getValueAt(r, 0).toString());
        txt_TenSp.setText(dfSP_Model.getValueAt(r, 1).toString());
        cbo_Dm.setSelectedItem(dfSP_Model.getValueAt(r, 2).toString());
        txt_MauSac.setText(dfSP_Model.getValueAt(r, 3).toString());
        txt_Size.setText(dfSP_Model.getValueAt(r, 4).toString());
        txt_DonGia1.setText(dfSP_Model.getValueAt(r, 7).toString());
        txt_SlKho.setText(dfSP_Model.getValueAt(r, 5).toString());
        txt_DonGia.setText(dfSP_Model.getValueAt(r, 6).toString());
        String img = dfSP_Model.getValueAt(r, 8).toString();
        lbl_HinhAnh.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_tbl_SpMouseClicked

    private void btn_SuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaMouseClicked
        int r = tbl_Sp.getSelectedRow();
        btn_SuaAnh.setEnabled(true);
        if (r != -1) {
            btn_SuaAnh.setVisible(true);
            String maSP = dfSP_Model.getValueAt(r, 0).toString();
            System.out.println(maSP);
            String tenSP = txt_TenSp.getText().trim();
            String tenDm = cbo_Dm.getSelectedItem().toString();
            String mau = txt_MauSac.getText().trim();
            String hinh = lbl_HinhAnh.getIcon().toString();
            //System.out.println(hinh);
            String size = txt_Size.getText().trim();
            int sl = Integer.parseInt(txt_SlKho.getText().trim());
            double dg = Double.parseDouble(txt_DonGia.getText().trim());
            DanhMucSP dm = dm_dao.getDMByTen(tenDm);
            SanPham sp = new SanPham(dm, maSP, tenSP, dg, sl, hinh, size, mau);
            //System.out.println(sp.toString());
            if (sp_dao.updateSP(maSP, sp)) {
                xoaRongTextSp();
                dfSP_Model.setRowCount(0);
                dsSP = sp_dao.getAllSP();
                for (SanPham it : dsSP) {
                    dfSP_Model.addRow(new Object[]{
                        it.getMaSP(), it.getTenSP(), it.getDmsp().getTenLoai(),
                        it.getMauSac(), it.getSize(), it.getSoLuong(),
                        it.getDonGia(), it.getHinhAnh()
                    });
                }
                dsSP.removeAll(dsSP);
                xoaRongTextSp();
                xoaModelSP();
                upTblSP();

                upCbo_DM();
                JOptionPane.showMessageDialog(this, "Cập nhật danh sách thành công");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào!");
        }
    }//GEN-LAST:event_btn_SuaMouseClicked

    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        int r = tbl_Sp.getSelectedRow();
        String id = dfSP_Model.getValueAt(r, 0).toString();
        if (r != -1) {
            int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa Sản Phẩm này không?", "Detele", JOptionPane.YES_NO_OPTION);
            if (tb == JOptionPane.YES_OPTION) {
                dfSP_Model.removeRow(r);
                sp_dao.xoaSP(id);
                dsSP.removeAll(dsSP);
                xoaRongTextSp();
                xoaModelSP();
                upTblSP();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
    }//GEN-LAST:event_btn_XoaMouseClicked

    private void txtSearchspFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchspFocusGained
        // TODO add your handling code here:
        //        txtSearch.setText("");
        //        txtSearch.setForeground(new java.awt.Color(26, 25, 25));
        //        btnTimKiem.setEnabled(true);
    }//GEN-LAST:event_txtSearchspFocusGained

    private void txtSearchspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchspActionPerformed
        xoaModelSP();
        xoaRongTextSp();
        String text = txtSearchsp.getText().trim().toLowerCase();
        List<SanPham> list = sp_dao.SearchMaSpOrTenSp(text);
        for (SanPham sp : list) {
            dfSP_Model.addRow(new Object[]{
                sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                sp.getDonGia(), sp.getGiaNhap(), sp.getHinhAnh()});
        }

    }//GEN-LAST:event_txtSearchspActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        xoaModelSP();
        xoaRongTextSp();
        String text = txtSearchsp.getText().trim().toLowerCase();
        List<SanPham> list = sp_dao.SearchMaSpOrTenSp(text);
        for (SanPham sp : list) {
            dfSP_Model.addRow(new Object[]{
                sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                sp.getDonGia(), sp.getGiaNhap(), sp.getHinhAnh()});
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btn_SuaAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaAnhMouseClicked
        int returnVal = fileDialog.showOpenDialog(cha);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileDialog.getSelectedFile();
            lbl_HinhAnh.setIcon(new ImageIcon(file.getPath()));
            //System.out.println("file"+file.getPath());
        }
    }//GEN-LAST:event_btn_SuaAnhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_SuaAnh;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbo_Dm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_DonGia1;
    private javax.swing.JLabel lbl_GetSp;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel lbl_MaSp;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_Size;
    private javax.swing.JLabel lbl_SlKho;
    private javax.swing.JLabel lbl_TenSp;
    private javax.swing.JPanel pnl_tab_FormSanPham;
    private javax.swing.JTable tbl_Sp;
    private javax.swing.JTextField txtSearchsp;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_DonGia1;
    private javax.swing.JTextField txt_MauSac;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_SlKho;
    private javax.swing.JTextField txt_TenSp;
    // End of variables declaration//GEN-END:variables
}
