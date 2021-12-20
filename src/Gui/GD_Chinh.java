/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.FrmTkeDoanhThu.jButton2;
import static Gui.FrmTkeDoanhThu.jComboBox1;
import static Gui.FrmTkeDoanhThu.jPanel5;
import static Gui.FrmTkeDoanhThu.jPanel6;
import static Gui.FrmTkeDoanhThu.jPanel7;


import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import dao.ImageHelper;
import dao.NhanVienDao;
import dao.PanelSearch;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author HP
 */
public class GD_Chinh extends javax.swing.JFrame {

    public Border default_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 153, 153));
    public Border active_border = BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(153, 204, 255));
    public JButton[] buttons;

    private JTableHeader heder;
    private String quyen = null;

    /**
     * Creates new form GD_Chinh
     */
    public GD_Chinh() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        renderAccountGui();//render ten nhan vien dang dang nhap
        quyen = lbl_title_TaiKhoan1.getText();
          Image icon = Toolkit.getDefaultToolkit().getImage("src\\imgVSicon\\icon.png");  
         this.setIconImage(icon); 
        this.setTitle("DADSOFT");
        if(quyen.equals("Nhân viên")){
            pnl_button_HeThong.setVisible(false);
            pnl_button_NhanVien.setVisible(false);
            
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Ngày");
            jComboBox1.setEnabled(false);

            jButton2.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
            jPanel7.setVisible(false);
            
//            jComboBox1_1.removeAllItems();
//            jComboBox1_1.addItem("Ngày");
            
//            cb2.removeAllItems();
//            cb2.addItem("Ngày");
            
            
        }
//        pnl_TranGDChinh1.display(new FrmTongQuan());

//        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
    }

    
   
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Main = new javax.swing.JPanel();
        pnl_Menu_main = new javax.swing.JPanel();
        pnl_Menu_logo = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnl_Menu_button = new javax.swing.JPanel();
        pnl_button_TongQuan = new javax.swing.JPanel();
        lbl_logo_TongQuan = new javax.swing.JLabel();
        lbl_title_TongQuan = new javax.swing.JLabel();
        pnl_button_BanHang = new javax.swing.JPanel();
        lbl_logo_BanHang = new javax.swing.JLabel();
        lbl_title_BanHang = new javax.swing.JLabel();
        pnl_button_SanPham = new javax.swing.JPanel();
        lbl_logo_SanPham = new javax.swing.JLabel();
        lbl_title_SanPham = new javax.swing.JLabel();
        pnl_button_KhachHang = new javax.swing.JPanel();
        lbl_logo_KhachHang = new javax.swing.JLabel();
        lbl_title_KhachHang = new javax.swing.JLabel();
        pnl_button_NhanVien = new javax.swing.JPanel();
        lbl_logo_NhanVien = new javax.swing.JLabel();
        lbl_title_NhanVien = new javax.swing.JLabel();
        pnl_button_HoaDon = new javax.swing.JPanel();
        lbl_logo_HoaDon = new javax.swing.JLabel();
        lbl_title_HoaDon = new javax.swing.JLabel();
        pnl_button_HeThong = new javax.swing.JPanel();
        lbl_logo_HeThong = new javax.swing.JLabel();
        lbl_title_HeThong = new javax.swing.JLabel();
        pnl_ThongTinTaiKhoan = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lbl_icon_TaiKhoan = new javax.swing.JLabel();
        lbl_title_TaiKhoan = new javax.swing.JLabel();
        lbl_title_TaiKhoan1 = new javax.swing.JLabel();
        pnl_button_NhaCungCap = new javax.swing.JPanel();
        lbl_logo_NCC = new javax.swing.JLabel();
        lbl_title_NCC = new javax.swing.JLabel();
        btn_active_TTTK = new javax.swing.JButton();
        pnl_button_ThongKe1 = new javax.swing.JPanel();
        lbl_logo_ThongKe1 = new javax.swing.JLabel();
        lbl_title_ThongKe1 = new javax.swing.JLabel();
        pnl_button_DatHang = new javax.swing.JPanel();
        lbl_logo_BanHang1 = new javax.swing.JLabel();
        lbl_title_BanHang1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        frmTongQuan1 = new Gui.FrmTongQuan();
        frmSanPham1 = new Gui.FrmSanPham();
        frmBanHang1 = new Gui.FrmBanHang();
        frmKhachHang1 = new Gui.FrmKhachHang();
        frmNhanVien1 = new Gui.FrmNhanVien();
        try {
            frmNhaCungCap1 = new Gui.FrmNhaCungCap();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        try {
            frmHoaDon1 = new Gui.FrmHoaDon();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        frmHeThong1 = new Gui.FrmHeThong();
        frmThongKe1 = new Gui.FrmThongKe();
        frmThongTinTaiKhoan1 = new Gui.FrmThongTinTaiKhoan();
        frmDatHang1 = new Gui.FrmDatHang();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_Main.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Menu_main.setBackground(new java.awt.Color(153, 204, 255));
        pnl_Menu_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Menu_logo.setBackground(new java.awt.Color(153, 204, 255));

        lbl_logo.setFont(new java.awt.Font("Berlin Sans FB Demi", 2, 85)); // NOI18N
        lbl_logo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setText("DAD ");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fashion");

        javax.swing.GroupLayout pnl_Menu_logoLayout = new javax.swing.GroupLayout(pnl_Menu_logo);
        pnl_Menu_logo.setLayout(pnl_Menu_logoLayout);
        pnl_Menu_logoLayout.setHorizontalGroup(
            pnl_Menu_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_Menu_logoLayout.setVerticalGroup(
            pnl_Menu_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Menu_logoLayout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pnl_Menu_main.add(pnl_Menu_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 130));

        pnl_Menu_button.setBackground(new java.awt.Color(153, 204, 255));

        pnl_button_TongQuan.setBackground(new java.awt.Color(255, 255, 255));
        pnl_button_TongQuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_TongQuanMouseClicked(evt);
            }
        });

        lbl_logo_TongQuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_TongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/house.png"))); // NOI18N

        lbl_title_TongQuan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_TongQuan.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_TongQuan.setText("Tổng Quản");

        javax.swing.GroupLayout pnl_button_TongQuanLayout = new javax.swing.GroupLayout(pnl_button_TongQuan);
        pnl_button_TongQuan.setLayout(pnl_button_TongQuanLayout);
        pnl_button_TongQuanLayout.setHorizontalGroup(
            pnl_button_TongQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_TongQuanLayout.createSequentialGroup()
                .addComponent(lbl_logo_TongQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_TongQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        );
        pnl_button_TongQuanLayout.setVerticalGroup(
            pnl_button_TongQuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_TongQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_TongQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_BanHang.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_BanHangMouseClicked(evt);
            }
        });

        lbl_logo_BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_BanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/trade.png"))); // NOI18N

        lbl_title_BanHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_BanHang.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_BanHang.setText("Bán Hàng");

        javax.swing.GroupLayout pnl_button_BanHangLayout = new javax.swing.GroupLayout(pnl_button_BanHang);
        pnl_button_BanHang.setLayout(pnl_button_BanHangLayout);
        pnl_button_BanHangLayout.setHorizontalGroup(
            pnl_button_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_BanHangLayout.createSequentialGroup()
                .addComponent(lbl_logo_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnl_button_BanHangLayout.setVerticalGroup(
            pnl_button_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_BanHang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_BanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_SanPham.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_SanPhamMouseClicked(evt);
            }
        });

        lbl_logo_SanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_SanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/checklist.png"))); // NOI18N

        lbl_title_SanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_SanPham.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_SanPham.setText("Sản Phẩm");

        javax.swing.GroupLayout pnl_button_SanPhamLayout = new javax.swing.GroupLayout(pnl_button_SanPham);
        pnl_button_SanPham.setLayout(pnl_button_SanPhamLayout);
        pnl_button_SanPhamLayout.setHorizontalGroup(
            pnl_button_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_SanPhamLayout.createSequentialGroup()
                .addComponent(lbl_logo_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnl_button_SanPhamLayout.setVerticalGroup(
            pnl_button_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_KhachHang.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_KhachHangMouseClicked(evt);
            }
        });

        lbl_logo_KhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/target.png"))); // NOI18N

        lbl_title_KhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_KhachHang.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_KhachHang.setText("Khách Hàng");

        javax.swing.GroupLayout pnl_button_KhachHangLayout = new javax.swing.GroupLayout(pnl_button_KhachHang);
        pnl_button_KhachHang.setLayout(pnl_button_KhachHangLayout);
        pnl_button_KhachHangLayout.setHorizontalGroup(
            pnl_button_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_KhachHangLayout.createSequentialGroup()
                .addComponent(lbl_logo_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnl_button_KhachHangLayout.setVerticalGroup(
            pnl_button_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_NhanVien.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_NhanVienMouseClicked(evt);
            }
        });

        lbl_logo_NhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/employee.png"))); // NOI18N

        lbl_title_NhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_NhanVien.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_NhanVien.setText("Nhân Viên");

        javax.swing.GroupLayout pnl_button_NhanVienLayout = new javax.swing.GroupLayout(pnl_button_NhanVien);
        pnl_button_NhanVien.setLayout(pnl_button_NhanVienLayout);
        pnl_button_NhanVienLayout.setHorizontalGroup(
            pnl_button_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_NhanVienLayout.createSequentialGroup()
                .addComponent(lbl_logo_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnl_button_NhanVienLayout.setVerticalGroup(
            pnl_button_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_HoaDon.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_HoaDonMouseClicked(evt);
            }
        });

        lbl_logo_HoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/bill 1.png"))); // NOI18N

        lbl_title_HoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_HoaDon.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_HoaDon.setText("Hóa Đơn");

        javax.swing.GroupLayout pnl_button_HoaDonLayout = new javax.swing.GroupLayout(pnl_button_HoaDon);
        pnl_button_HoaDon.setLayout(pnl_button_HoaDonLayout);
        pnl_button_HoaDonLayout.setHorizontalGroup(
            pnl_button_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_HoaDonLayout.createSequentialGroup()
                .addComponent(lbl_logo_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnl_button_HoaDonLayout.setVerticalGroup(
            pnl_button_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_HeThong.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_HeThong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_HeThongMouseClicked(evt);
            }
        });

        lbl_logo_HeThong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_HeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/system.png"))); // NOI18N

        lbl_title_HeThong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_HeThong.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_HeThong.setText("Hệ Thống");

        javax.swing.GroupLayout pnl_button_HeThongLayout = new javax.swing.GroupLayout(pnl_button_HeThong);
        pnl_button_HeThong.setLayout(pnl_button_HeThongLayout);
        pnl_button_HeThongLayout.setHorizontalGroup(
            pnl_button_HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_HeThongLayout.createSequentialGroup()
                .addComponent(lbl_logo_HeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_HeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnl_button_HeThongLayout.setVerticalGroup(
            pnl_button_HeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_HeThong, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_HeThong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_ThongTinTaiKhoan.setBackground(new java.awt.Color(153, 204, 255));
        pnl_ThongTinTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_ThongTinTaiKhoanMouseClicked(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/logout (1).png"))); // NOI18N
        btnExit.setToolTipText("Đăng xuất");
        btnExit.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 102), new java.awt.Color(255, 0, 51)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        lbl_icon_TaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        lbl_icon_TaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_icon_TaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_icon_TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/user.png"))); // NOI18N

        lbl_title_TaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_title_TaiKhoan.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_TaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title_TaiKhoan.setText("Tấn Đăng");

        lbl_title_TaiKhoan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_title_TaiKhoan1.setForeground(new java.awt.Color(255, 0, 51));
        lbl_title_TaiKhoan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title_TaiKhoan1.setText("ADMIN");

        javax.swing.GroupLayout pnl_ThongTinTaiKhoanLayout = new javax.swing.GroupLayout(pnl_ThongTinTaiKhoan);
        pnl_ThongTinTaiKhoan.setLayout(pnl_ThongTinTaiKhoanLayout);
        pnl_ThongTinTaiKhoanLayout.setHorizontalGroup(
            pnl_ThongTinTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThongTinTaiKhoanLayout.createSequentialGroup()
                .addComponent(lbl_icon_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_ThongTinTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_title_TaiKhoan)
                    .addComponent(lbl_title_TaiKhoan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_ThongTinTaiKhoanLayout.setVerticalGroup(
            pnl_ThongTinTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThongTinTaiKhoanLayout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(lbl_title_TaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_TaiKhoan1)
                .addContainerGap())
            .addComponent(lbl_icon_TaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_NhaCungCap.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_NhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_NhaCungCapMouseClicked(evt);
            }
        });

        lbl_logo_NCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_NCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/inventory.png"))); // NOI18N

        lbl_title_NCC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_NCC.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_NCC.setText("Nhà Cung Cấp");

        javax.swing.GroupLayout pnl_button_NhaCungCapLayout = new javax.swing.GroupLayout(pnl_button_NhaCungCap);
        pnl_button_NhaCungCap.setLayout(pnl_button_NhaCungCapLayout);
        pnl_button_NhaCungCapLayout.setHorizontalGroup(
            pnl_button_NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_NhaCungCapLayout.createSequentialGroup()
                .addComponent(lbl_logo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_NCC)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnl_button_NhaCungCapLayout.setVerticalGroup(
            pnl_button_NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_NCC, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_NCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_active_TTTK.setContentAreaFilled(false);
        btn_active_TTTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_active_TTTKActionPerformed(evt);
            }
        });

        pnl_button_ThongKe1.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_ThongKe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_ThongKe1MouseClicked(evt);
            }
        });

        lbl_logo_ThongKe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_ThongKe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/analytics.png"))); // NOI18N

        lbl_title_ThongKe1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_ThongKe1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_ThongKe1.setText("Thống Kê");

        javax.swing.GroupLayout pnl_button_ThongKe1Layout = new javax.swing.GroupLayout(pnl_button_ThongKe1);
        pnl_button_ThongKe1.setLayout(pnl_button_ThongKe1Layout);
        pnl_button_ThongKe1Layout.setHorizontalGroup(
            pnl_button_ThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_ThongKe1Layout.createSequentialGroup()
                .addComponent(lbl_logo_ThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_ThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnl_button_ThongKe1Layout.setVerticalGroup(
            pnl_button_ThongKe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_ThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_ThongKe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_button_DatHang.setBackground(new java.awt.Color(153, 204, 255));
        pnl_button_DatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_button_DatHangMouseClicked(evt);
            }
        });

        lbl_logo_BanHang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo_BanHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/smartphone (1).png"))); // NOI18N

        lbl_title_BanHang1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_title_BanHang1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_title_BanHang1.setText("Đặt Hàng");

        javax.swing.GroupLayout pnl_button_DatHangLayout = new javax.swing.GroupLayout(pnl_button_DatHang);
        pnl_button_DatHang.setLayout(pnl_button_DatHangLayout);
        pnl_button_DatHangLayout.setHorizontalGroup(
            pnl_button_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_button_DatHangLayout.createSequentialGroup()
                .addComponent(lbl_logo_BanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title_BanHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnl_button_DatHangLayout.setVerticalGroup(
            pnl_button_DatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo_BanHang1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lbl_title_BanHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_Menu_buttonLayout = new javax.swing.GroupLayout(pnl_Menu_button);
        pnl_Menu_button.setLayout(pnl_Menu_buttonLayout);
        pnl_Menu_buttonLayout.setHorizontalGroup(
            pnl_Menu_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_button_TongQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_DatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_HeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnl_button_ThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnl_Menu_buttonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnl_ThongTinTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_active_TTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_Menu_buttonLayout.setVerticalGroup(
            pnl_Menu_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Menu_buttonLayout.createSequentialGroup()
                .addComponent(pnl_button_TongQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_DatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_HeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_button_ThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnl_Menu_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_ThongTinTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_active_TTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnl_Menu_main.add(pnl_Menu_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 570));

        pnl_Main.add(pnl_Menu_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 700));

        jTabbedPane1.addTab("tab3", frmTongQuan1);
        jTabbedPane1.addTab("tab4", frmSanPham1);
        jTabbedPane1.addTab("tab2", frmBanHang1);
        jTabbedPane1.addTab("tab4", frmKhachHang1);
        jTabbedPane1.addTab("tab5", frmNhanVien1);
        jTabbedPane1.addTab("tab6", frmNhaCungCap1);
        jTabbedPane1.addTab("tab7", frmHoaDon1);
        jTabbedPane1.addTab("tab8", frmHeThong1);
        jTabbedPane1.addTab("tab11", frmThongKe1);
        jTabbedPane1.addTab("tab10", frmThongTinTaiKhoan1);
        jTabbedPane1.addTab("tab11", frmDatHang1);

        pnl_Main.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, -32, 1090, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_active_TTTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_active_TTTKActionPerformed

    }//GEN-LAST:event_btn_active_TTTKActionPerformed

    private void pnl_button_NhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_NhaCungCapMouseClicked

        jTabbedPane1.setSelectedIndex(5);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(Color.white);

        btn_active_TTTK.setBorder(null);
    }//GEN-LAST:event_pnl_button_NhaCungCapMouseClicked

    private void pnl_ThongTinTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ThongTinTaiKhoanMouseClicked

        jTabbedPane1.setSelectedIndex(9);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(BorderFactory.createMatteBorder(0, 8, 0, 0, new Color(3, 65, 143)));
        //        pnl_ThongTinTaiKhoan.setBackground(Color.white);

        //new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160))
    }//GEN-LAST:event_pnl_ThongTinTaiKhoanMouseClicked


    private void pnl_button_ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_ThongKeMouseClicked
        // TODO add your handling code here:
//        pnl_FormTongQuan.setVisible(false);
//        frmBanHang1.setVisible(false);
//        frmKhachHang1.setVisible(false);
//        frmSanPham2.setVisible(false);
//        frmNhanVien1.setVisible(false);
//        pnl_FormHoaDon.setVisible(false);
//        frmHeThong1.setVisible(false);
//        frmThongKe1.setVisible(true);
//        frmThongTinTaiKhoan1.setVisible(false);
//        frmNhaCungCap1.setVisible(false);
        frmThongKe1.renderAgianTkKh();
        frmThongKe1.renderAgianTongQuan();
        frmThongKe1.renderAgianTkSp();
        jTabbedPane1.setSelectedIndex(8);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(Color.white);
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
    }//GEN-LAST:event_pnl_button_ThongKeMouseClicked


    private void pnl_button_HeThongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_HeThongMouseClicked
        // TODO add your handling code here:
//        pnl_FormTongQuan.setVisible(false);
//        frmBanHang1.setVisible(false);
//        frmKhachHang1.setVisible(false);
//        frmSanPham2.setVisible(false);
//        frmNhanVien1.setVisible(false);
//        pnl_FormHoaDon.setVisible(false);
//        frmHeThong1.setVisible(true);
//        frmThongKe1.setVisible(false);
//        frmThongTinTaiKhoan1.setVisible(false);
//        frmNhaCungCap1.setVisible(false);
        
//render lai giaoDien
        frmHeThong1.renderDsTKAgain();
        String quyen = lbl_title_TaiKhoan1.getText();
        if(quyen.equals("Nhân viên")){
            JOptionPane.showMessageDialog(rootPane, "Bạn đang đăng nhập quyền nhân viên nên không thể mở!\n Hãy đăng nhập quyển Quản lý!!");
        }
        else{
              jTabbedPane1.setSelectedIndex(7);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(Color.white);
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
        }
      
    }//GEN-LAST:event_pnl_button_HeThongMouseClicked

    private void pnl_button_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_HoaDonMouseClicked
         try {

             frmHoaDon1.renderAgian();
             frmHoaDon1.renderAgianHDnhap();
             frmHoaDon1.renderAgianHD();
  
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "ERRO");
        }


        jTabbedPane1.setSelectedIndex(6);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(Color.white);
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
    }//GEN-LAST:event_pnl_button_HoaDonMouseClicked

    private void pnl_button_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_NhanVienMouseClicked
        quyen = lbl_title_TaiKhoan1.getText();
        if(quyen.equals("Nhân viên")){
            
            JOptionPane.showMessageDialog(rootPane, "Bạn đang đăng nhập quyền nhân viên nên không thể mở!\n Hãy đăng nhập quyển Quản lý!!");
            
        }
        else{
             jTabbedPane1.setSelectedIndex(4);
            pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
            pnl_button_BanHang.setBackground(new Color(153, 204, 255));
            pnl_button_SanPham.setBackground(new Color(153, 204, 255));
            pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
            pnl_button_NhanVien.setBackground(Color.white);
            pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
            pnl_button_HeThong.setBackground(new Color(153, 204, 255));
            pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
            pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
            pnl_button_DatHang.setBackground(new Color(153, 204, 255));
            btn_active_TTTK.setBorder(null);
        }
       
    }//GEN-LAST:event_pnl_button_NhanVienMouseClicked

    private void pnl_button_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_KhachHangMouseClicked

        jTabbedPane1.setSelectedIndex(3);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(Color.white);
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
    }//GEN-LAST:event_pnl_button_KhachHangMouseClicked

    private void pnl_button_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_SanPhamMouseClicked
        frmSanPham1.renderAgian();
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(Color.white);
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_pnl_button_SanPhamMouseClicked

    private void pnl_button_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_BanHangMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(Color.white);
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
    }//GEN-LAST:event_pnl_button_BanHangMouseClicked

    private void pnl_button_TongQuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_TongQuanMouseClicked

        jTabbedPane1.setSelectedIndex(0);
        pnl_button_TongQuan.setBackground(Color.white);
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);

    }//GEN-LAST:event_pnl_button_TongQuanMouseClicked

    //click vao thoat -> man hinh dang nhap
    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
    

            int opcion = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất không?", "Đăng Xuất", JOptionPane.YES_NO_OPTION);

                if (opcion == 0) { //The ISSUE is here
                           
                            NhanVienDao nvDao = new NhanVienDao();
                            NhanVien nv = nvDao.getNVByMaTrangThai("online");
                            nvDao.upadateTrangThai("offline", nv.getMaNV());
                            this.setVisible(false);
                            new FrmDangNhap().setVisible(true);

                } else {
                   System.out.print("no");
                }
    }//GEN-LAST:event_btnExitMouseClicked
    //click vao dau tich de dong frame
    //cap nhat nhung NV co trangthai online->offline
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
           
        try {
            NhanVienDao nvDao = new NhanVienDao();
                            NhanVien nv = nvDao.getNVByMaTrangThai("online");
                            nvDao.upadateTrangThai("offline", nv.getMaNV());
        } catch (Exception e) {
            System.out.print("Loi ngoai le. khong sao");
        }
    }//GEN-LAST:event_formWindowClosing

    private void pnl_button_ThongKe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_ThongKe1MouseClicked
        
        frmThongKe1.renderAgianTkKh();
        frmThongKe1.renderAgianTongQuan();
        frmThongKe1.renderAgianTkSp();
        frmThongKe1.renderAgianTkDt();
        
        jTabbedPane1.setSelectedIndex(8);
        pnl_button_DatHang.setBackground(new Color(153, 204, 255));
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(Color.white);
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);
    }//GEN-LAST:event_pnl_button_ThongKe1MouseClicked

    private void pnl_button_DatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_button_DatHangMouseClicked
        jTabbedPane1.setSelectedIndex(10);
        pnl_button_DatHang.setBackground(Color.white);
        pnl_button_TongQuan.setBackground(new Color(153, 204, 255));
        pnl_button_BanHang.setBackground(new Color(153, 204, 255));
        pnl_button_SanPham.setBackground(new Color(153, 204, 255));
        pnl_button_KhachHang.setBackground(new Color(153, 204, 255));
        pnl_button_NhanVien.setBackground(new Color(153, 204, 255));
        pnl_button_HoaDon.setBackground(new Color(153, 204, 255));
        pnl_button_HeThong.setBackground(new Color(153, 204, 255));
        pnl_button_ThongKe1.setBackground(new Color(153, 204, 255));
        pnl_button_NhaCungCap.setBackground(new Color(153, 204, 255));
        btn_active_TTTK.setBorder(null);

    }//GEN-LAST:event_pnl_button_DatHangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GD_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        try {
//            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            FlatLightFlatIJTheme.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_Chinh().setVisible(true);
            }
        });
    }
    
    //lay ra ten nv va chuc vu nhanVien dang online
    public void renderAccountGui(){
        try {
             NhanVienDao  nvDao = new NhanVienDao();
            NhanVien nv = nvDao.getNVByMaTrangThai("online");
     
            lbl_title_TaiKhoan.setText(xuLyTen(nv.getTenNV()));
            TaiKhoanDao tkDao = new TaiKhoanDao();
            TaiKhoan tk = tkDao.findTKByMaNV(nv.getMaNV());
       
        if(tk.getTenQuyen().toLowerCase().equals("quản lý")){
            lbl_title_TaiKhoan1.setText("Quản lý");
        }
        else{
             lbl_title_TaiKhoan1.setText("Nhân viên");
        }
        
         //set img cho phan dang nhap
            if(nv.getImg() != null){
                 try {
                 
                    Image img = ImageHelper.createImgFromByArray(nv.getImg(), "jpg");
                    Image imgResize = ImageHelper.resize(img, 40, 40);
                  
                    lbl_icon_TaiKhoan.setIcon(new ImageIcon(imgResize));
                  //  employeeImg = nv.getImg();
                } catch (IOException ex) {
                    Logger.getLogger(FrmDsNV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                 lbl_icon_TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/user.png"))); // NOI18N
               //   employeeImg = nv.getImg();
            }
        } catch (Exception e) {
            System.out.print("Gap loi roi");
        }
        
        
    }
    
         
        //Nguyen Hoang Anh -> Hoang anh
    public String xuLyTen(String s){
        if(countString(s) > 1){
            String newStr = s.substring(xuatHienLan2DauCach(s)+1, s.length());
            return newStr;
        }
        
        return s;
    }
    
    //lay ra vi tri xuat hien thu 2 cua dau cach
    public int xuatHienLan2DauCach(String s){
        int count = 0;
      for(int i = s.length()-1; i >= 0; i--){
          if(s.charAt(i) == ' '){
              count++;
          }
          if(count == 2){
              return i;
          }
      }
    return -1;
    }
    
    //dem so khoang trang trong String
   public  int countString(String input) {
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(input);
        int spaceCount = 0;
        while (matcher.find()) {
            spaceCount++;
        }
   return spaceCount;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btn_active_TTTK;
    private Gui.FrmBanHang frmBanHang1;
    private Gui.FrmDatHang frmDatHang1;
    private Gui.FrmHeThong frmHeThong1;
    private Gui.FrmHoaDon frmHoaDon1;
    private Gui.FrmKhachHang frmKhachHang1;
    private Gui.FrmNhaCungCap frmNhaCungCap1;
    private Gui.FrmNhanVien frmNhanVien1;
    private Gui.FrmSanPham frmSanPham1;
    private Gui.FrmThongKe frmThongKe1;
    private Gui.FrmThongTinTaiKhoan frmThongTinTaiKhoan1;
    private Gui.FrmTongQuan frmTongQuan1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_icon_TaiKhoan;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logo_BanHang;
    private javax.swing.JLabel lbl_logo_BanHang1;
    private javax.swing.JLabel lbl_logo_HeThong;
    private javax.swing.JLabel lbl_logo_HoaDon;
    private javax.swing.JLabel lbl_logo_KhachHang;
    private javax.swing.JLabel lbl_logo_NCC;
    private javax.swing.JLabel lbl_logo_NhanVien;
    private javax.swing.JLabel lbl_logo_SanPham;
    private javax.swing.JLabel lbl_logo_ThongKe1;
    private javax.swing.JLabel lbl_logo_TongQuan;
    private javax.swing.JLabel lbl_title_BanHang;
    private javax.swing.JLabel lbl_title_BanHang1;
    private javax.swing.JLabel lbl_title_HeThong;
    private javax.swing.JLabel lbl_title_HoaDon;
    private javax.swing.JLabel lbl_title_KhachHang;
    private javax.swing.JLabel lbl_title_NCC;
    private javax.swing.JLabel lbl_title_NhanVien;
    private javax.swing.JLabel lbl_title_SanPham;
    private javax.swing.JLabel lbl_title_TaiKhoan;
    public static javax.swing.JLabel lbl_title_TaiKhoan1;
    private javax.swing.JLabel lbl_title_ThongKe1;
    private javax.swing.JLabel lbl_title_TongQuan;
    private javax.swing.JPanel pnl_Main;
    private javax.swing.JPanel pnl_Menu_button;
    private javax.swing.JPanel pnl_Menu_logo;
    private javax.swing.JPanel pnl_Menu_main;
    private javax.swing.JPanel pnl_ThongTinTaiKhoan;
    private javax.swing.JPanel pnl_button_BanHang;
    private javax.swing.JPanel pnl_button_DatHang;
    private javax.swing.JPanel pnl_button_HeThong;
    private javax.swing.JPanel pnl_button_HoaDon;
    private javax.swing.JPanel pnl_button_KhachHang;
    private javax.swing.JPanel pnl_button_NhaCungCap;
    private javax.swing.JPanel pnl_button_NhanVien;
    private javax.swing.JPanel pnl_button_SanPham;
    private javax.swing.JPanel pnl_button_ThongKe1;
    private javax.swing.JPanel pnl_button_TongQuan;
    // End of variables declaration//GEN-END:variables
}
