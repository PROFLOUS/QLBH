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
        upTblTkSP();
        upCbo_DM();
        Hide();

    }

    //tìm kiếm danh mục
    public void TKDmSP() {
        dm_dao = new DanhMucSPDao();
        String ma = cbb_TkDM.getSelectedItem().toString();
        ArrayList<SanPham> list = sp_dao.SearchDm(ma);
        System.out.println(ma);
        System.out.println(list.toString());
        if (!list.isEmpty()) {
            for (SanPham sp : list) {
                if (sp != null) {
                    dfTkSP_Model.addRow(new Object[]{
                        sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                        sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                        sp.getDonGia(), sp.getHinhAnh()
                    });
                }
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        } else {
            JOptionPane.showMessageDialog(this, "Danh mục chưa thêm vào sảm phẩm");
        }

    }

    //tìm kiếm Giá sản phẩm
    public void TKgiaSP() {

        if (cbb_TkGia.getSelectedIndex() == 0) {
            sp_dao = new SanPhamDao();
            List<SanPham> list = sp_dao.SearchGialte(100000);

            System.out.println(list.toString());
            for (SanPham sp : list) {
                dfTkSP_Model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                    sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                    sp.getDonGia(), sp.getHinhAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        } else if (cbb_TkGia.getSelectedIndex() == 1) {
            sp_dao = new SanPhamDao();
            List<SanPham> list = sp_dao.SearchGiaAnd(100000, 200000);
//        System.out.println(text);
//        System.out.println(list.toString());
            for (SanPham sp : list) {
                dfTkSP_Model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                    sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                    sp.getDonGia(), sp.getHinhAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        } else if (cbb_TkGia.getSelectedIndex() == 2) {
            sp_dao = new SanPhamDao();
            List<SanPham> list = sp_dao.SearchGiaAnd(200000, 300000);
//        System.out.println(text);
//        System.out.println(list.toString());
            for (SanPham sp : list) {
                dfTkSP_Model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                    sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                    sp.getDonGia(), sp.getHinhAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        } else if (cbb_TkGia.getSelectedIndex() == 3) {
            sp_dao = new SanPhamDao();
            List<SanPham> list = sp_dao.SearchGiaAnd(300000, 400000);
//        System.out.println(text);
//        System.out.println(list.toString());
            for (SanPham sp : list) {
                dfTkSP_Model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                    sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                    sp.getDonGia(), sp.getHinhAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        } else if (cbb_TkGia.getSelectedIndex() == 4) {
            sp_dao = new SanPhamDao();
            List<SanPham> list = sp_dao.SearchGiaGt(400000);
//        System.out.println(text);
//        System.out.println(list.toString());
            for (SanPham sp : list) {
                dfTkSP_Model.addRow(new Object[]{
                    sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                    sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                    sp.getDonGia(), sp.getHinhAnh()
                });
            }
            JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
        }

    }

    //tìm kiếm tên sản phẩm
    public void TKtenSP() {
        sp_dao = new SanPhamDao();
        String text = txt_TkTenSp.getText().toString();
        List<SanPham> list = sp_dao.SearchSp(text);
//        System.out.println(text);
//        System.out.println(list.toString());
        for (SanPham sp : list) {
            dfTkSP_Model.addRow(new Object[]{
                sp.getMaSP(), sp.getTenSP(), sp.getDmsp().getTenLoai(),
                sp.getMauSac(), sp.getSize(), sp.getSoLuong(),
                sp.getDonGia(), sp.getHinhAnh()
            });
        }
        JOptionPane.showMessageDialog(this, "Đã tìm thấy ");
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

    //kiểm tra du liệu nhập tìm kiếm 
    public boolean kiemTraDataTkSp() {
        String tenTk = txt_TkTenSp.getText().trim();
        // Tên danh mục phải là chữ
        if (!(tenTk.length() > 0 && tenTk.matches("[A-Za-z]+"))) {
            JOptionPane.showMessageDialog(this, "Tên Danh Mục phải là chữ");
            return false;
        }
        return true;
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
        String sl = txt_Sl.getText().trim();
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
        if (sl.length() > 0) {
            try {
                int x = Integer.parseInt(sl);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên dương");
                return false;
            }
        }
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

        int ittkCount = cbb_TkDM.getItemCount();
        for (int i = 0; i < ittkCount; i++) {
            cbb_TkDM.removeItemAt(0);
        }

    }

    //xoa model sản phẩm
    public void xoaModelSP() {
        DefaultTableModel del = (DefaultTableModel) tbl_Sp.getModel();
        del.getDataVector().removeAllElements();
    }
    //xóa model tksp
    public void xoaModelTksp() {
        DefaultTableModel del = (DefaultTableModel) tbl_TkSP.getModel();
        del.getDataVector().removeAllElements();
    }
    //xóa model danh mục
    public void xoaModelDM() {
        DefaultTableModel del = (DefaultTableModel) tbl_DanhMuc.getModel();
        del.getDataVector().removeAllElements();
    }
    // xóa rỏng textfield tìm kiếm sp
    public void xoaRongTextTk() {
        txt_TkTenSp.setText("");
        cbb_TkDM.setSelectedItem(null);
        cbb_TkGia.setSelectedItem(null);
        txt_TkTenSp.requestFocus();
    }
    //xóa rong textfield danh mục
    public void xoaRongTextDm() {

        txt_MaDm.setText("");
        txt_TenDm.setText("");
        txt_TenDm.requestFocus();
    }
    //xóa rong textfield sản phẩm
    public void xoaRongTextSp() {
        txt_Sl.setText("");
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
        cbb_TkGia.setEnabled(false);
        cbb_TkDM.setEnabled(false);
        txt_TkTenSp.setEnabled(false);
        btn_SuaDm.setEnabled(false);
        txt_MaDm.setEditable(false);
//        btn_SuaAnh.setVisible(false);
    }
    //đọc dữ liệu lên combobox danh mục
    public void upCbo_DM() {

        for (DanhMucSP dm : dsDmSP) {
            cbo_Dm.addItem(dm.getTenLoai());
            cbb_TkDM.addItem(dm.getTenLoai());

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
    //đọc dữ liệu lên bảng tìm kiém sp
    public void upTblTkSP() {

        //bảng tìm kiếm
        dfTkSP_Model = (DefaultTableModel) tbl_TkSP.getModel();
        for (SanPham sp : dsSP) {
            dfTkSP_Model.addRow(new Object[]{
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
        buttons = new JButton[3];
        //Form san pham
        buttons[0] = btn_tab_SanPham;
        buttons[1] = btn_tab_DMSanPham;
        buttons[2] = btn_tab_NhaCungCap;
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
        btn_tab_NhaCungCap = new javax.swing.JButton();
        pnl_tab_FormSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Sp = new javax.swing.JTable();
        btn_SuaAnh = new javax.swing.JButton();
        lbl_MaSp = new javax.swing.JLabel();
        txt_MauSac = new javax.swing.JTextField();
        lbl_MauSac = new javax.swing.JLabel();
        txt_TenSp = new javax.swing.JTextField();
        lbl_TenSp = new javax.swing.JLabel();
        lbl_DanhMuc = new javax.swing.JLabel();
        lbl_Size = new javax.swing.JLabel();
        txt_Size = new javax.swing.JTextField();
        txt_SlKho = new javax.swing.JTextField();
        lbl_SlKho = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        lbl_DonGia = new javax.swing.JLabel();
        txt_Sl = new javax.swing.JTextField();
        lbl_Sl = new javax.swing.JLabel();
        lbl_GetSp = new javax.swing.JLabel();
        lbl_HinhAnh = new javax.swing.JLabel();
        cbo_Dm = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_ThemSp = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        pnl_tab_FormDMSanPham = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DanhMuc = new javax.swing.JTable();
        txt_TenDm = new javax.swing.JTextField();
        lbl_MaDanhMuc = new javax.swing.JLabel();
        lbl_TenDm = new javax.swing.JLabel();
        txt_MaDm = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_ThemDm = new javax.swing.JButton();
        btn_SuaDm = new javax.swing.JButton();
        btn_XoaDm = new javax.swing.JButton();
        btn_LuuDm = new javax.swing.JButton();
        pnl_tab_FormTKSP = new javax.swing.JPanel();
        pnl_HinhAnh1 = new javax.swing.JPanel();
        lbl_TkHinhAnh = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_TkSP = new javax.swing.JTable();
        lbl_MaDanhMuc1 = new javax.swing.JLabel();
        txt_TkTenSp = new javax.swing.JTextField();
        cbo_TkTenSP = new javax.swing.JCheckBox();
        cbo_TkDM = new javax.swing.JCheckBox();
        cbo_TkGia = new javax.swing.JCheckBox();
        btn_Tim = new javax.swing.JButton();
        cbb_TkGia = new javax.swing.JComboBox<>();
        cbb_TkDM = new javax.swing.JComboBox<>();

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

        btn_tab_NhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        btn_tab_NhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_tab_NhaCungCap.setForeground(new java.awt.Color(153, 153, 153));
        btn_tab_NhaCungCap.setText("Tìm Kiếm Sản Phẩm");
        btn_tab_NhaCungCap.setBorder(null);
        btn_tab_NhaCungCap.setContentAreaFilled(false);
        btn_tab_NhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tab_NhaCungCapMouseClicked(evt);
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
                .addGap(45, 45, 45)
                .addComponent(btn_tab_NhaCungCap)
                .addContainerGap(588, Short.MAX_VALUE))
        );
        pnl_menuTab_SanPhamLayout.setVerticalGroup(
            pnl_menuTab_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuTab_SanPhamLayout.createSequentialGroup()
                .addGroup(pnl_menuTab_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_tab_SanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btn_tab_DMSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tab_NhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_FormSanPham.add(pnl_menuTab_SanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1090, 40));

        pnl_tab_FormSanPham.setBackground(new java.awt.Color(243, 244, 237));
        pnl_tab_FormSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Sp.setBackground(new java.awt.Color(255, 255, 255));
        tbl_Sp.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
        tbl_Sp.setRowHeight(35);
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

        pnl_tab_FormSanPham.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 262, 990, 367));

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
        pnl_tab_FormSanPham.add(btn_SuaAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 217, -1, -1));

        lbl_MaSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MaSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaSp.setText("Mã Sản Phẩm ");
        pnl_tab_FormSanPham.add(lbl_MaSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 31, -1, 31));

        txt_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MauSac.setForeground(new java.awt.Color(0, 0, 0));
        txt_MauSac.setToolTipText("");
        pnl_tab_FormSanPham.add(txt_MauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 82, 250, 31));

        lbl_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MauSac.setText("Màu Sắc ");
        pnl_tab_FormSanPham.add(lbl_MauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 82, -1, 31));

        txt_TenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_TenSp.setForeground(new java.awt.Color(0, 0, 0));
        txt_TenSp.setToolTipText("");
        pnl_tab_FormSanPham.add(txt_TenSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 31, 250, 31));

        lbl_TenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenSp.setText("Tên Sản Phẩm ");
        pnl_tab_FormSanPham.add(lbl_TenSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 31, -1, 31));

        lbl_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DanhMuc.setText("Danh Mục");
        pnl_tab_FormSanPham.add(lbl_DanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 82, -1, 31));

        lbl_Size.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_Size.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Size.setText("Size");
        pnl_tab_FormSanPham.add(lbl_Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 131, -1, 31));

        txt_Size.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_Size.setForeground(new java.awt.Color(0, 0, 0));
        txt_Size.setToolTipText("");
        pnl_tab_FormSanPham.add(txt_Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 135, 250, 31));

        txt_SlKho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_SlKho.setForeground(new java.awt.Color(0, 0, 0));
        txt_SlKho.setToolTipText("");
        pnl_tab_FormSanPham.add(txt_SlKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 135, 250, 31));

        lbl_SlKho.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SlKho.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SlKho.setText("Số Lượng Kho");
        pnl_tab_FormSanPham.add(lbl_SlKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 135, -1, 31));

        txt_DonGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_DonGia.setForeground(new java.awt.Color(0, 0, 0));
        txt_DonGia.setToolTipText("");
        pnl_tab_FormSanPham.add(txt_DonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 200, 250, 31));

        lbl_DonGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_DonGia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DonGia.setText("Đơn Giá");
        pnl_tab_FormSanPham.add(lbl_DonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 200, -1, 31));

        txt_Sl.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_Sl.setForeground(new java.awt.Color(0, 0, 0));
        txt_Sl.setToolTipText("");
        pnl_tab_FormSanPham.add(txt_Sl, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 200, 250, 31));

        lbl_Sl.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_Sl.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Sl.setText("Có Thể Bán");
        pnl_tab_FormSanPham.add(lbl_Sl, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 200, -1, 31));

        lbl_GetSp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lbl_GetSp.setForeground(new java.awt.Color(0, 0, 0));
        lbl_GetSp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnl_tab_FormSanPham.add(lbl_GetSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 31, 250, 31));

        lbl_HinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbl_HinhAnh.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 153, 255)));
        pnl_tab_FormSanPham.add(lbl_HinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 35, 150, 170));

        cbo_Dm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_Dm.setForeground(new java.awt.Color(0, 0, 0));
        pnl_tab_FormSanPham.add(cbo_Dm, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 80, 250, 33));

        jPanel1.setBackground(new java.awt.Color(243, 244, 237));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 153, 255)), "Tác Vụ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

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
        btn_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/download.png"))); // NOI18N
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
        btn_Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/repair-tool (1).png"))); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.setBorder(null);
        btn_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaMouseClicked(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(21, 151, 229));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/delete (1).png"))); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.setBorder(null);
        btn_Xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Luu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ThemSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btn_ThemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnl_tab_FormSanPham.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 250, 110, 380));

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

        txt_TenDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_TenDm.setForeground(new java.awt.Color(0, 0, 0));
        txt_TenDm.setToolTipText("");

        lbl_MaDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MaDanhMuc.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaDanhMuc.setText("Mã Danh mục");

        lbl_TenDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenDm.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenDm.setText("Tên Danh mục");

        txt_MaDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_MaDm.setForeground(new java.awt.Color(0, 0, 0));
        txt_MaDm.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(243, 244, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 153, 255), null), "Tác Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btn_ThemDm.setBackground(new java.awt.Color(21, 151, 229));
        btn_ThemDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_ThemDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/plus (1).png"))); // NOI18N
        btn_ThemDm.setText("Thêm Danh Mục ");
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
        btn_SuaDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/repair-tool (1).png"))); // NOI18N
        btn_SuaDm.setText("Sửa Thông Tin");
        btn_SuaDm.setBorder(null);
        btn_SuaDm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SuaDm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaDmMouseClicked(evt);
            }
        });

        btn_XoaDm.setBackground(new java.awt.Color(21, 151, 229));
        btn_XoaDm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_XoaDm.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/delete (1).png"))); // NOI18N
        btn_XoaDm.setText("Xóa Danh Mục");
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
        btn_LuuDm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/download.png"))); // NOI18N
        btn_LuuDm.setText("Lưu Thông Tin");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ThemDm, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(btn_SuaDm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LuuDm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_XoaDm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LuuDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ThemDm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_SuaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout pnl_tab_FormDMSanPhamLayout = new javax.swing.GroupLayout(pnl_tab_FormDMSanPham);
        pnl_tab_FormDMSanPham.setLayout(pnl_tab_FormDMSanPhamLayout);
        pnl_tab_FormDMSanPhamLayout.setHorizontalGroup(
            pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_MaDanhMuc)
                            .addComponent(lbl_TenDm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_TenDm, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(txt_MaDm))
                        .addGap(53, 53, 53))
                    .addGroup(pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_tab_FormDMSanPhamLayout.setVerticalGroup(
            pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormDMSanPhamLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_MaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(pnl_tab_FormDMSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TenDm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TenDm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pnl_FormSanPham.add(pnl_tab_FormDMSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 630));

        pnl_tab_FormTKSP.setBackground(new java.awt.Color(243, 244, 237));

        lbl_TkHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TkHinhAnh.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 153, 255)));

        javax.swing.GroupLayout pnl_HinhAnh1Layout = new javax.swing.GroupLayout(pnl_HinhAnh1);
        pnl_HinhAnh1.setLayout(pnl_HinhAnh1Layout);
        pnl_HinhAnh1Layout.setHorizontalGroup(
            pnl_HinhAnh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_TkHinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        pnl_HinhAnh1Layout.setVerticalGroup(
            pnl_HinhAnh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_TkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        tbl_TkSP.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tbl_TkSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm ", "Tên Sản Phẩm", "Danh Mục", "Màu Sắc", "Size", "Số Lượng", "Đơn Giá", "Hình Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_TkSP.setRowHeight(35);
        tbl_TkSP.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tbl_TkSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TkSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_TkSP);

        lbl_MaDanhMuc1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lbl_MaDanhMuc1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaDanhMuc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_MaDanhMuc1.setText("Tìm kiếm sản phẩm theo:");

        txt_TkTenSp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_TkTenSp.setForeground(new java.awt.Color(0, 0, 0));
        txt_TkTenSp.setToolTipText("");

        cbo_TkTenSP.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_TkTenSP.setForeground(new java.awt.Color(0, 0, 0));
        cbo_TkTenSP.setText("Tên Sản Phẩm");
        cbo_TkTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TkTenSPActionPerformed(evt);
            }
        });

        cbo_TkDM.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_TkDM.setForeground(new java.awt.Color(0, 0, 0));
        cbo_TkDM.setText("Danh Mục");
        cbo_TkDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TkDMActionPerformed(evt);
            }
        });

        cbo_TkGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbo_TkGia.setForeground(new java.awt.Color(0, 0, 0));
        cbo_TkGia.setText("Giá Cả");
        cbo_TkGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TkGiaActionPerformed(evt);
            }
        });

        btn_Tim.setBackground(new java.awt.Color(21, 151, 229));
        btn_Tim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Tim.setForeground(new java.awt.Color(255, 255, 255));
        btn_Tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search_1.png"))); // NOI18N
        btn_Tim.setText("Tìm");
        btn_Tim.setBorder(null);
        btn_Tim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Tim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimMouseClicked(evt);
            }
        });

        cbb_TkGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbb_TkGia.setForeground(new java.awt.Color(0, 0, 0));
        cbb_TkGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dưới 100K", "100K - 200K", "200K - 300K", "300K - 400K", "Trên 400K" }));
        cbb_TkGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_TkGiaActionPerformed(evt);
            }
        });

        cbb_TkDM.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbb_TkDM.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnl_tab_FormTKSPLayout = new javax.swing.GroupLayout(pnl_tab_FormTKSP);
        pnl_tab_FormTKSP.setLayout(pnl_tab_FormTKSPLayout);
        pnl_tab_FormTKSPLayout.setHorizontalGroup(
            pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
            .addComponent(lbl_MaDanhMuc1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tab_FormTKSPLayout.createSequentialGroup()
                .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_tab_FormTKSPLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_tab_FormTKSPLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(pnl_HinhAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_TkTenSP)
                            .addComponent(cbo_TkDM)
                            .addComponent(cbo_TkGia))
                        .addGap(109, 109, 109)
                        .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_TkTenSp)
                            .addComponent(cbb_TkGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbb_TkDM, 0, 340, Short.MAX_VALUE))))
                .addGap(110, 110, 110))
        );
        pnl_tab_FormTKSPLayout.setVerticalGroup(
            pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tab_FormTKSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_MaDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_tab_FormTKSPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_HinhAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_tab_FormTKSPLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TkTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_TkTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_TkDM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_TkDM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnl_tab_FormTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_TkGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_TkGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_FormSanPham.add(pnl_tab_FormTKSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 630));

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
        pnl_tab_FormTKSP.setVisible(false);
    }//GEN-LAST:event_btn_tab_SanPhamMouseClicked

    private void btn_tab_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_SanPhamActionPerformed

    private void btn_tab_DMSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_DMSanPhamMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormSanPham.setVisible(false);
        pnl_tab_FormDMSanPham.setVisible(true);
        pnl_tab_FormTKSP.setVisible(false);
    }//GEN-LAST:event_btn_tab_DMSanPhamMouseClicked

    private void btn_tab_DMSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tab_DMSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tab_DMSanPhamActionPerformed

    private void btn_tab_NhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tab_NhaCungCapMouseClicked
        // TODO add your handling code here:
        pnl_tab_FormSanPham.setVisible(false);
        pnl_tab_FormDMSanPham.setVisible(false);
        pnl_tab_FormTKSP.setVisible(true);
    }//GEN-LAST:event_btn_tab_NhaCungCapMouseClicked

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
                xoaModelTksp();
                upTblTkSP();
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
                xoaModelTksp();
                upTblTkSP();
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
                upTblTkSP();
                upCbo_DM();
                JOptionPane.showMessageDialog(this, "Cập nhật danh sách thành công");
            }
        }
    }//GEN-LAST:event_btn_SuaDmMouseClicked

    private void cbo_TkDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TkDMActionPerformed
        if (cbo_TkDM.isSelected()) {
            cbb_TkDM.setEnabled(true);
        } else {
            cbb_TkDM.setEnabled(false);
        }
    }//GEN-LAST:event_cbo_TkDMActionPerformed

    private void cbo_TkGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TkGiaActionPerformed
        if (cbo_TkGia.isSelected()) {
            cbb_TkGia.setEnabled(true);
        } else {
            cbb_TkGia.setEnabled(false);
        }
    }//GEN-LAST:event_cbo_TkGiaActionPerformed

    private void btn_TimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimMouseClicked

        xoaModelTksp();
        if (cbo_TkTenSP.isSelected()) {
            if (kiemTraDataTkSp()) {
                TKtenSP();
            }

        } else if (cbo_TkDM.isSelected()) {
            TKDmSP();
        } else if (cbo_TkGia.isSelected()) {
            TKgiaSP();
        } else {
            xoaModelTksp();
            upTblTkSP();
        }


    }//GEN-LAST:event_btn_TimMouseClicked

    private void tbl_SpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SpMouseClicked
        int r = tbl_Sp.getSelectedRow();
        btn_SuaAnh.setEnabled(true);
        lbl_GetSp.setText(dfSP_Model.getValueAt(r, 0).toString());
        txt_TenSp.setText(dfSP_Model.getValueAt(r, 1).toString());
        cbo_Dm.setSelectedItem(dfSP_Model.getValueAt(r, 2).toString());
        txt_MauSac.setText(dfSP_Model.getValueAt(r, 3).toString());
        txt_Size.setText(dfSP_Model.getValueAt(r, 4).toString());
        txt_Sl.setText(dfSP_Model.getValueAt(r, 5).toString());
        txt_SlKho.setText(dfSP_Model.getValueAt(r, 5).toString());
        txt_DonGia.setText(dfSP_Model.getValueAt(r, 6).toString());
        String img = dfSP_Model.getValueAt(r, 7).toString();
        //System.out.println(img);
        //lbl_HinhAnh.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT)));
        //lbl_HinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource(img)));
        lbl_HinhAnh.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_tbl_SpMouseClicked

    private void cbb_TkGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_TkGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_TkGiaActionPerformed

    private void tbl_TkSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TkSPMouseClicked
        int r = tbl_TkSP.getSelectedRow();
        txt_TkTenSp.setText(dfTkSP_Model.getValueAt(r, 1).toString());
        cbb_TkDM.setSelectedItem(dfTkSP_Model.getValueAt(r, 2).toString());
        String img = dfTkSP_Model.getValueAt(r, 7).toString();
        lbl_TkHinhAnh.setIcon(new ImageIcon(img));


    }//GEN-LAST:event_tbl_TkSPMouseClicked

    private void cbo_TkTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TkTenSPActionPerformed
        if (cbo_TkTenSP.isSelected()) {
            txt_TkTenSp.setEnabled(true);
        } else {
            txt_TkTenSp.setEnabled(false);
        }
    }//GEN-LAST:event_cbo_TkTenSPActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_LuuDm;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_SuaAnh;
    private javax.swing.JButton btn_SuaDm;
    private javax.swing.JButton btn_ThemDm;
    private javax.swing.JButton btn_ThemSp;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaDm;
    private javax.swing.JButton btn_tab_DMSanPham;
    private javax.swing.JButton btn_tab_NhaCungCap;
    private javax.swing.JButton btn_tab_SanPham;
    private javax.swing.JComboBox<String> cbb_TkDM;
    private javax.swing.JComboBox<String> cbb_TkGia;
    private javax.swing.JComboBox<String> cbo_Dm;
    private javax.swing.JCheckBox cbo_TkDM;
    private javax.swing.JCheckBox cbo_TkGia;
    private javax.swing.JCheckBox cbo_TkTenSP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_GetSp;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel lbl_MaDanhMuc;
    private javax.swing.JLabel lbl_MaDanhMuc1;
    private javax.swing.JLabel lbl_MaSp;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_Size;
    private javax.swing.JLabel lbl_Sl;
    private javax.swing.JLabel lbl_SlKho;
    private javax.swing.JLabel lbl_TenDm;
    private javax.swing.JLabel lbl_TenSp;
    private javax.swing.JLabel lbl_TkHinhAnh;
    private javax.swing.JLabel lbl_text_SanPham;
    private javax.swing.JPanel pnl_FormSanPham;
    private javax.swing.JPanel pnl_HinhAnh1;
    private javax.swing.JPanel pnl_menuTab_SanPham;
    private javax.swing.JPanel pnl_tab_FormDMSanPham;
    private javax.swing.JPanel pnl_tab_FormSanPham;
    private javax.swing.JPanel pnl_tab_FormTKSP;
    private javax.swing.JTable tbl_DanhMuc;
    private javax.swing.JTable tbl_Sp;
    private javax.swing.JTable tbl_TkSP;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_MaDm;
    private javax.swing.JTextField txt_MauSac;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_Sl;
    private javax.swing.JTextField txt_SlKho;
    private javax.swing.JTextField txt_TenDm;
    private javax.swing.JTextField txt_TenSp;
    private javax.swing.JTextField txt_TkTenSp;
    // End of variables declaration//GEN-END:variables
}
