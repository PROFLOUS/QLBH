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
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FrmSanPham extends javax.swing.JPanel {

    public Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    public Border active_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 204, 255));
    public JButton[] buttons;
    public FrmBanHang frbh;
    ArrayList<DanhMucSP> dsDmSP;
    ArrayList<SanPham> dsSP;
    DanhMucSPDao dm_dao;
    SanPhamDao sp_dao;
    private DefaultTableModel dfSP_Model;
    private DefaultTableModel dfTkSP_Model;
    private DefaultTableModel dfDmSP_Model;
    private ArrayList<SanPham> dsTkSP;
    final JFileChooser fileDialog = new JFileChooser();
    JFrame cha = new JFrame();
    ImageIcon icon;

    /**
     * Creates new form FrmSanPham
     */
    public FrmSanPham() {
        initComponents();
        addBorder();
        
        frbh = new FrmBanHang();
        dsSP = new ArrayList<SanPham>();
        dsDmSP = new ArrayList<DanhMucSP>();
        dsTkSP = new ArrayList<SanPham>();
        dm_dao = new DanhMucSPDao();
        sp_dao = new SanPhamDao();
        upTblSP();
        upTblDM();
        upCbo_DM();
        Hide();

    }

    //láy thông tin trên textfield sản phẩm
    public SanPham restText() {
        String maSp = lbl_GetSp.getText().toString();
        String tenSp = txt_TenSp.getText().toString();
        String tenDm = cbo_Dm.getSelectedItem().toString();
        DanhMucSP dm = dm_dao.getDMByTen(tenDm);
        String mau = txt_MauSac.getText().toString();
        String size = txt_Size.getText().toString();
        int slKho = Integer.parseInt(txt_SlKho.getText());
        double donGia = Double.parseDouble(txt_DonGia.getText());
        String hinh = lbl_HinhAnh.getIcon().toString();

        return new SanPham(dm, maSp, tenSp, donGia, slKho, hinh, size, mau);
    }

    //láy thông tin trên textfield danh mục
    public DanhMucSP restTextDM() {
        String maDm = txt_MaDm.getText().toString();
        String tenDm = txt_TenDm.getText().toString();

        return new DanhMucSP(maDm, tenDm);

    }

    //kiểm tra du liệu nhập danh mục
    public boolean kiemTraDataDM() {
        String tenDM = txt_TenDm.getText().trim();
        // Tên danh mục phải là chữ
        if (!(tenDM.length() > 0 && tenDM.matches("[A-Za-z]+"))) {
            JOptionPane.showMessageDialog(this, "Tên Danh Mục phải là chữ");
            return false;
        }
        return true;
    }

    //Kiểm tra dữ liệu nhập
    public boolean kiemTraData() {

        String tenSP = txt_TenSp.getText().trim();
        String mau = txt_MauSac.getText().trim();
        String size = txt_Size.getText().trim();
        String slKho = txt_SlKho.getText().trim();
        
        String donGia = txt_DonGia.getText().trim();

        // Tên sản phẩm phải là chữ
        if (!(tenSP.length() > 0 && tenSP.matches("[A-Za-z]+"))) {
            JOptionPane.showMessageDialog(this, "Tên Sản Phẩm phải là chữ");
            return false;
        }

        //Mau phải là chữ
        if (!(mau.length() > 0 && mau.matches("[A-Za-z]+"))) {
            JOptionPane.showMessageDialog(this, "Mầu sắc phải là chữ");
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

        return true;
    }

    //xoa combobox
    public void xoaCBB() {
        int itCount = cbo_Dm.getItemCount();
        for (int i = 0; i < itCount; i++) {
            cbo_Dm.removeItemAt(0);
        }

    }

    //xoa model sản phẩm
    public void xoaModelSP() {
        DefaultTableModel del = (DefaultTableModel) tbl_Sp.getModel();
        del.getDataVector().removeAllElements();
    }

    //xóa model danh mục
    public void xoaModelDM() {
        DefaultTableModel del = (DefaultTableModel) tbl_DanhMuc.getModel();
        del.getDataVector().removeAllElements();
    }

    //xóa rong textfield danh mục
    public void xoaRongTextDm() {

        txt_MaDm.setText("");
        txt_TenDm.setText("");
        txt_TenDm.requestFocus();
    }
    //xóa rong textfield sản phẩm
    public void xoaRongTextSp() {
        
        txt_SlKho.setText("");

        txt_TenSp.setText("");
        txt_DonGia.setText("");
        txt_Size.setText("");
        txt_MauSac.setText("");
        lbl_GetSp.setText("");
        lbl_HinhAnh.setIcon(null);
        txt_TenSp.requestFocus();

    }
    //ẩn bớt cái nút
    public void Hide() {
//        cbb_TkGia.setEnabled(false);
//        cbb_TkDM.setEnabled(false);
//        txt_TkTenSp.setEnabled(false);
        btn_SuaDm.setEnabled(false);
        txt_MaDm.setEditable(false);
//        btn_SuaAnh.setVisible(false);
    }
    //đọc dữ liệu lên combobox danh mục
    public void upCbo_DM() {

        for (DanhMucSP dm : dsDmSP) {
            cbo_Dm.addItem(dm.getTenLoai());
//            cbb_TkDM.addItem(dm.getTenLoai());

        }
    }
    //đọc dữ liệu lên bảng sản phẩm
    public void upTblSP() {
        //bang san pham
        dfSP_Model = (DefaultTableModel) tbl_Sp.getModel();

        dsSP = sp_dao.getAllSP();
        for (SanPham sp : dsSP) {
            dfSP_Model.addRow(new Object[]{
                sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                sp.getDonGia(), sp.getHinhAnh()
            });
        }

    }
    
    //đọc dữ liệu lên bảng danh mục
    public void upTblDM() {
        dfDmSP_Model = (DefaultTableModel) tbl_DanhMuc.getModel();

        dsDmSP = dm_dao.getAllDM();
        for (DanhMucSP dm : dsDmSP) {
            dfDmSP_Model.addRow(new Object[]{
                dm.getMaloai(), dm.getTenLoai()
            });
        }
    }
    
    public void addBorder() {
        buttons = new JButton[2];
        //Form san pham
        buttons[0] = btn_tab_SanPham;
        buttons[1] = btn_tab_DMSanPham;
        
        setButtonBorder(btn_tab_SanPham);
        addAction();
    }
    //set border active

    public void setButtonBorder(JButton button) {
        button.setBorder(active_border);
        button.setForeground(Color.black);
    }

    //add even
    public void addAction() {
        for (JButton button : buttons) {
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JButton btn : buttons) {
                        btn.setBorder(default_border);
                        btn.setForeground(new Color(153, 153, 153));
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

        pnl_FormSanPham = new javax.swing.JPanel();
        lbl_text_SanPham = new javax.swing.JLabel();
        pnl_menuTab_SanPham = new javax.swing.JPanel();
        btn_tab_SanPham = new javax.swing.JButton();
        btn_tab_DMSanPham = new javax.swing.JButton();
        pnl_tab_FormSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sp = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_ThemSp = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
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

        pnl_FormSanPham.setBackground(new java.awt.Color(255, 255, 255));
        pnl_FormSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_SanPham.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_SanPham.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_SanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_SanPham.setText("Sản Phẩm");
        pnl_FormSanPham.add(lbl_text_SanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_menuTab_SanPham.setBackground(new java.awt.Color(255, 255, 255));

        btn_tab_SanPham.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_SanPham.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_SanPham.setForeground(new java.awt.Color(0, 0, 0));
        btn_tab_SanPham.setText("Sản Phẩm");
        btn_tab_SanPham.setBorder(null);
        btn_tab_SanPham.setContentAreaFilled(false);
        btn_tab_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_SanPhamMouseClicked(evt);
            }
        });
        btn_tab_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_SanPhamActionPerformed(evt);
            }
        });

        btn_tab_DMSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_DMSanPham.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_DMSanPham.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_DMSanPham.setText("Danh Mục Sản Phẩm");
        btn_tab_DMSanPham.setBorder(null);
        btn_tab_DMSanPham.setContentAreaFilled(false);
        btn_tab_DMSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_DMSanPhamMouseClicked(evt);
            }
        });
        btn_tab_DMSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tab_DMSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_menuTab_SanPhamLayout = new javax.swing.GroupLayout(pnl_menuTab_SanPham);
        pnl_menuTab_SanPham.setLayout(pnl_menuTab_SanPhamLayout);
        pnl_menuTab_SanPhamLayout.setHorizontalGroup(
            pnl_menuTab_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuTab_SanPhamLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tab_SanPham)
                .addGap(44, 44, 44)
                .addComponent(btn_tab_DMSanPham)
                .addContainerGap(771, Short.MAX_VALUE))
        );
        pnl_menuTab_SanPhamLayout.setVerticalGroup(
            pnl_menuTab_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_SanPhamLayout.createSequentialGroup()
                .addGroup(pnl_menuTab_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_tab_SanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btn_tab_DMSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormSanPham.add(pnl_menuTab_SanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        pnl_tab_FormSanPham.setBackground(new java.awt.Color(243, 244, 237));
        pnl_tab_FormSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Sp.setBackground(new java.awt.Color(255, 255, 255));
        tbl_Sp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Sp.setForeground(new java.awt.Color(0, 0, 0));
        tbl_Sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Danh Mục", "Màu Sắc", "Size", "Số Lượng", "Đơn Giá", "Hình Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Sp.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Sp.setRowHeight(30);
        tbl_Sp.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tbl_Sp.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_Sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Sp);
        if (tbl_Sp.getColumnModel().getColumnCount() > 0) {
            tbl_Sp.getColumnModel().getColumn(0).setMaxWidth(100);
            tbl_Sp.getColumnModel().getColumn(1).setMaxWidth(400);
            tbl_Sp.getColumnModel().getColumn(2).setMaxWidth(150);
            tbl_Sp.getColumnModel().getColumn(3).setMaxWidth(150);
            tbl_Sp.getColumnModel().getColumn(4).setMaxWidth(70);
            tbl_Sp.getColumnModel().getColumn(5).setMaxWidth(70);
            tbl_Sp.getColumnModel().getColumn(6).setMaxWidth(150);
            tbl_Sp.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        pnl_tab_FormSanPham.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1050, 290));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        btn_ThemSp.setBackground(new java.awt.Color(21, 151, 229));
        btn_ThemSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_ThemSp.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (2).png"))); // NOI18N
        btn_ThemSp.setText("Thêm ");
        btn_ThemSp.setBorder(null);
        btn_ThemSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ThemSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemSpMouseClicked(evt);
            }
        });

        btn_Luu.setBackground(new java.awt.Color(21, 151, 229));
        btn_Luu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Luu.setForeground(new java.awt.Color(255, 255, 255));
        btn_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_Luu.setText("Lưu ");
        btn_Luu.setBorder(null);
        btn_Luu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Luu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LuuMouseClicked(evt);
            }
        });
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        btn_Sua.setBackground(new java.awt.Color(21, 151, 229));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system-update.png"))); // NOI18N
        btn_Sua.setText("Cập Nhật");
        btn_Sua.setBorder(null);
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
        btn_Xoa.setBorder(null);
        btn_Xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });

        txtSearch.setForeground(new java.awt.Color(173, 194, 169));
        txtSearch.setText("Nhập mã, tên, sđt....");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(21, 151, 229));
        btnTimKiem.setForeground(java.awt.Color.white);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setToolTipText("Nhập mã. tên NCC để tìm kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.setEnabled(false);
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
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(btn_ThemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ThemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnl_tab_FormSanPham.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1050, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        lbl_HinhAnh.setBackground(new java.awt.Color(255, 255, 255));
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
        lbl_GetSp.setBorder(new javax.swing.border.MatteBorder(null));

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
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_MaSp)
                        .addGap(34, 34, 34)
                        .addComponent(lbl_GetSp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_MauSac)
                        .addGap(69, 69, 69)
                        .addComponent(txt_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_Size)
                        .addGap(104, 104, 104)
                        .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_DonGia)
                        .addGap(77, 77, 77)
                        .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lbl_TenSp)
                            .addGap(34, 34, 34)
                            .addComponent(txt_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lbl_DanhMuc)
                            .addGap(64, 64, 64)
                            .addComponent(cbo_Dm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_SlKho)
                        .addGap(40, 40, 40)
                        .addComponent(txt_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_SuaAnh)
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_MaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_GetSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbl_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbo_Dm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SlKho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pnl_tab_FormSanPham.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1050, 260));

        pnl_FormSanPham.add(pnl_tab_FormSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 630));

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

        jPanel2.setBackground(new java.awt.Color(243, 244, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 153, 255), null), "Tác Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btn_ThemDm.setBackground(new java.awt.Color(21, 151, 229));
        btn_ThemDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_ThemDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (1).png"))); // NOI18N
        btn_ThemDm.setText("Thêm");
        btn_ThemDm.setBorder(null);
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
        btn_SuaDm.setBorder(null);
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
        btn_XoaDm.setBorder(null);
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
        btn_LuuDm.setBorder(null);
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
                .addGap(30, 30, 30)
                .addComponent(btn_LuuDm, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_SuaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(txt_MaDm, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
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
                .addGap(44, 44, 44)
                .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(44, 44, 44))
        );
        pnl_tab_FormDMSanPhamLayout.setVerticalGroup(
            pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pnl_FormSanPham.add(pnl_tab_FormDMSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tab_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_SanPhamMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormSanPham.setVisible(true);
        pnl_tab_FormDMSanPham.setVisible(false);
        
    }//GEN-LAST:event_btn_tab_SanPhamMouseClicked

    private void btn_tab_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_SanPhamActionPerformed

    private void btn_tab_DMSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_DMSanPhamMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormSanPham.setVisible(false);
        pnl_tab_FormDMSanPham.setVisible(true);
        
    }//GEN-LAST:event_btn_tab_DMSanPhamMouseClicked

    private void btn_tab_DMSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_DMSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_DMSanPhamActionPerformed

    private void btn_ThemSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemSpMouseClicked
        xoaRongTextSp();
        btn_SuaAnh.setEnabled(true);

    }//GEN-LAST:event_btn_ThemSpMouseClicked

    private void btn_LuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuMouseClicked
        if (kiemTraData()) {
            SanPham sp = restText();
            if (sp_dao.themSP(sp)) {
                dfSP_Model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                    sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                    sp.getDonGia(), sp.getHinhAnh()
                });
                dsSP.removeAll(dsSP);
                xoaRongTextSp();
                xoaModelSP();
                upTblSP();
                
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(null, " đã có vui lòng nhập lại ");
            }
        }
    }//GEN-LAST:event_btn_LuuMouseClicked

    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        int r = tbl_Sp.getSelectedRow();
        String id = dfSP_Model.getValueAt(r, 0).toString();
        if (r != -1) {
            int tb = JOptionPane.showConfirmDialog(null, "Bạn  chắc chắn muốn xóa dòng này không?", "Detele", JOptionPane.YES_NO_OPTION);
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

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void btn_ThemDmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemDmMouseClicked
        xoaRongTextDm();

    }//GEN-LAST:event_btn_ThemDmMouseClicked

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
                xoaCBB();
                upCbo_DM();

                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(null, " đã có vui lòng nhập lại ");
            }
        }
    }//GEN-LAST:event_btn_LuuDmMouseClicked

    private void btn_LuuDmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuDmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LuuDmActionPerformed

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
                xoaModelSP();
                upTblSP();
                
                upCbo_DM();
                JOptionPane.showMessageDialog(this, "Cập nhật danh sách thành công");
            }
        }
    }//GEN-LAST:event_btn_SuaDmMouseClicked

    private void tbl_SpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SpMouseClicked
        int r = tbl_Sp.getSelectedRow();
        btn_SuaAnh.setEnabled(true);
        lbl_GetSp.setText(dfSP_Model.getValueAt(r, 0).toString());
        txt_TenSp.setText(dfSP_Model.getValueAt(r, 1).toString());
        cbo_Dm.setSelectedItem(dfSP_Model.getValueAt(r, 2).toString());
        txt_MauSac.setText(dfSP_Model.getValueAt(r, 3).toString());
        txt_Size.setText(dfSP_Model.getValueAt(r, 4).toString());
        
        txt_SlKho.setText(dfSP_Model.getValueAt(r, 5).toString());
        txt_DonGia.setText(dfSP_Model.getValueAt(r, 6).toString());
        String img = dfSP_Model.getValueAt(r, 7).toString();
        //System.out.println(img);
        //lbl_HinhAnh.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT)));
        //lbl_HinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
        lbl_HinhAnh.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_tbl_SpMouseClicked

    private void btn_SuaAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaAnhMouseClicked
        int returnVal = fileDialog.showOpenDialog(cha);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileDialog.getSelectedFile();
            lbl_HinhAnh.setIcon(new ImageIcon(file.getPath()));
            //System.out.println("file"+file.getPath());
        }
    }//GEN-LAST:event_btn_SuaAnhMouseClicked

    private void tbl_DanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhMucMouseClicked
        int r = tbl_DanhMuc.getSelectedRow();
        btn_SuaDm.setEnabled(true);
        txt_MaDm.setText(dfDmSP_Model.getValueAt(r, 0).toString());
        txt_TenDm.setText(dfDmSP_Model.getValueAt(r, 1).toString());

    }//GEN-LAST:event_tbl_DanhMucMouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
        //        txtSearch.setText("");
        //        txtSearch.setForeground(new java.awt.Color(26, 25, 25));
        //        btnTimKiem.setEnabled(true);
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        //        String query =  txtSearch.getText();
        //
        //        if(query.length() > 0){
            //            ArrayList<NhaCC> arr = SearchNCC(query);
            //            if(arr != null){
                //                renderDsNCC(SearchNCC(query));
                //                btnShow.setEnabled(true);
                //            }
            //
            //        }
        //        else{
            //            JOptionPane.showMessageDialog(btnTimKiem, "Bạn chưa nhập Mã, Tên, SĐT NCC");
            //            btnTimKiem.setEnabled(false);
            //            btnShow.setEnabled(false);
            //        }
    }//GEN-LAST:event_btnTimKiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_LuuDm;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_SuaAnh;
    private javax.swing.JButton btn_SuaDm;
    private javax.swing.JButton btn_ThemDm;
    private javax.swing.JButton btn_ThemSp;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaDm;
    private javax.swing.JButton btn_tab_DMSanPham;
    private javax.swing.JButton btn_tab_SanPham;
    private javax.swing.JComboBox<String> cbo_Dm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_GetSp;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel lbl_MaDanhMuc;
    private javax.swing.JLabel lbl_MaSp;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_Size;
    private javax.swing.JLabel lbl_SlKho;
    private javax.swing.JLabel lbl_TenDm;
    private javax.swing.JLabel lbl_TenSp;
    private javax.swing.JLabel lbl_text_SanPham;
    private javax.swing.JPanel pnl_FormSanPham;
    private javax.swing.JPanel pnl_menuTab_SanPham;
    private javax.swing.JPanel pnl_tab_FormDMSanPham;
    private javax.swing.JPanel pnl_tab_FormSanPham;
    private javax.swing.JTable tbl_DanhMuc;
    private javax.swing.JTable tbl_Sp;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_MaDm;
    private javax.swing.JTextField txt_MauSac;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_SlKho;
    private javax.swing.JTextField txt_TenDm;
    private javax.swing.JTextField txt_TenSp;
    // End of variables declaration//GEN-END:variables
}
