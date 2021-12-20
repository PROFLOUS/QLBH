/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Connect.connect;
import dao.PanelSearch;
import dao.EventClick;
import dao.BanHangDao;
import dao.CT_HoaDonDao;

import dao.HoaDonDao;

import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.CT_HDBanHang;
import entity.CT_HDDatHang;
import entity.HoaDonBanHang;
import entity.HoaDonDatHang;
import entity.KhachHang;
import entity.NhaCC;
import entity.NhanVien;
import entity.SanPham;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author HP
 */
public class FrmDatHang extends javax.swing.JPanel {
   private JPopupMenu menu;
    private PanelSearch search;
    private JPopupMenu menu2;
    private PanelSearch search2;
    BanHangDao bhDao;
    KhachHangDao khDao;
    private DefaultTableModel dfbh_model;
    private ArrayList<SanPham>dstt = null;
    private ArrayList<SanPham>dssp;
    private int soLuongTon = 0;
    private int soLuong =0;
    SanPham sp = new SanPham();
    private Double tong;
    private int r;
    private int row;
    private String dvvc;
    //bien toan phan
    //click vao 1 san pham trong table lay ra ma san pham
   
    private String maSPClick = "";
    
    
    
    public FrmDatHang() {
        initComponents();
        setMemoric();
        bhDao = new BanHangDao();
        khDao = new KhachHangDao();
        dstt = new ArrayList<SanPham>();
        dssp = new  ArrayList<SanPham>();
        SanPham sp = new SanPham();
        
        jPanel2.setVisible(false);
        
       txt_KhuyenMai.setText("0");
        Hide();

        menu = new JPopupMenu();
        search = new PanelSearch();
        
        menu2 = new JPopupMenu();
        search2 = new PanelSearch();
        
        menu2.add(search2);
        menu2.setFocusable(false);
        
        
        menu.add(search);
        menu.setFocusable(false);

        search.addEventClick(new EventClick() {
            private double tongtien;
             @Override
            public void itemClick(NhaCC data) {
            }
            @Override
            public void itemClick(SanPham data) {
               
                dfbh_model = (DefaultTableModel) tbl_BanHang.getModel();
                //System.out.println("Click" +data.getTenSP());
                menu.setVisible(false);
                String maSp = (data.getMaSP());
                String tenSp = (data.getTenSP());
                String mau = (data.getMauSac());
                double donGia =( data.getDonGia());
                String size = (data.getSize());
                int soLuong = 1;
                double thanhTien = soLuong * donGia;
                
                SanPham sp = new SanPham(maSp, tenSp, donGia, soLuong, size, mau);
                
                //tao vi tri sp
                int vitri = vitriSP(sp);
                System.out.println(vitri);
                
                if(vitri >-1){
                    Integer sl = dstt.get(vitri).getSoLuong()+1;
                    dstt.get(vitri).setSoLuong(sl);
                    tongtien = sl * sp.getDonGia();
                    dfbh_model.setValueAt(sl, vitri, 3);
                    dfbh_model.setValueAt(tongtien, vitri, 5);
                }else{
                    try {
                        dstt.add(sp);
                    } catch (Exception e) {
                        System.out.println("loi add");
                        e.printStackTrace();
                    }
                    dfbh_model.addRow(new Object[]{
                        sp.getMaSP(),sp.getTenSP(),sp.getMauSac(),soLuong,sp.getDonGia(),thanhTien
                    });
                }
                TinhTong();
                

            }

            @Override
            public void itemClick(KhachHang data) {
                
            }

            private int vitriSP(SanPham sp) {
                int i =-1;
                try { 
                if(dstt.contains(sp)){
                    return dstt.indexOf(sp);
                }
                } catch (Exception e) {
                    e.printStackTrace();
                   
                }
                 return  i;
            }
        });
        
        //enven click chon khach hang
        search2.addEventClick(new EventClick() {
            @Override
            public void itemClick(SanPham data) {
            
            }
            @Override
            public void itemClick(NhaCC data) {
            }

            @Override
            public void itemClick(KhachHang data) {
               String maKh = data.getMaKH();
               String tenKh = data.getTenKH();
               String sDT = data.getSdt();
               String diaChi = data.getDiaChi();
               
               
               lbl_TenKh.setText(tenKh);
               lbl_maKh.setText(maKh);
               lbl_SDT.setText(sDT);
               lbl_SDT3.setText(diaChi);
               lbl_SDT5.setText(diaChi);
               lbl_SDT2.setText(sDT);
               lbl_SDT4.setText(sDT);
               jPanel1.setVisible(false);
               jPanel2.setVisible(true);
               menu2.setVisible(false);
               txt_Search_KH.setText("");
               
                

            }
        });
        
        
        
    }
    //xóa sảm phảm từ dơn hàng
    public void huy(int r){
        
        String masp = dstt.get(r).getMaSP();
        int index = -1;
        for(SanPham sp : dssp)
        {
            if(sp.getMaSP() == masp){
                index=dssp.indexOf(sp);
            break;
            }
        }
        
        
        dfbh_model.removeRow(r);
        dstt.remove(r);
    }
    //tính tổng tiền
    public void TinhTong(){        
        // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        
        tong =0.0;
        for( int i = 0;i<tbl_BanHang.getRowCount();i++){
            tong += Double.parseDouble( tbl_BanHang.getValueAt(i, 5).toString());
        }
        lbl_TongTien.setText(currencyVN.format(tong));
        lbl_TienPhaiTra.setText(currencyVN.format(tong));
//         txt_TienDua.setText(currencyVN.format(tong));              
    }
    //tính tiền thừ va cap nhat tien thua len giao dien
    //tienthua = tienkhachdua - tienphaitra
    public void TinhTienThua(){
           // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        
      String tienPhaiTra = lbl_TienPhaiTra.getText();
//      String tienKhachDua = txt_TienDua.getText();
//      Double tienThua = changeMoney(tienKhachDua) - changeMoney(tienPhaiTra);
//       lbl_TienThua.setText(currencyVN.format(tienThua));
    }
    
    //ẩn các nút chức năng
    public void Hide(){
        btn_XoaMatHang.setVisible(false);
        lbl_TextSL.setVisible(false);
        lbl_GiamSL.setVisible(false);
        lbl_TangSL.setVisible(false);
        
        txt_SuaSL.setVisible(false);
    }
            //set phim tat
        public void setMemoric(){
            btn_ThanhToan.setMnemonic(KeyEvent.VK_F1);
        }
      public void setKhachHangLenGui(KhachHang kh){
             String maKh = kh.getMaKH();
               String tenKh = kh.getTenKH();
               String sDT = kh.getSdt();
               
               lbl_TenKh.setText(tenKh);
               lbl_maKh.setText(maKh);
               lbl_SDT.setText(sDT);
              
//               lbl_XoaKh.setEnabled(true);
               btn_AddKh.setVisible(false);
               txt_Search_KH.setVisible(false);
               
                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFrame2 = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_MauSac1 = new javax.swing.JLabel();
        txt_tenNcc = new javax.swing.JTextField();
        lbl_Size1 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        lbl_TenSp1 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        btn_Luu1 = new javax.swing.JButton();
        btn_Xoa1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnl_FormBanHang = new javax.swing.JPanel();
        pnl_tab_Form_BangHang = new javax.swing.JPanel();
        pnl_ThanhToan = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        txt_Search_KH = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        btn_AddKh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_TenKh = new javax.swing.JLabel();
        lbl_SDT = new javax.swing.JLabel();
        lbl_maKh = new javax.swing.JLabel();
        lbl_maKh2 = new javax.swing.JLabel();
        lbl_maKh3 = new javax.swing.JLabel();
        lbl_SDT2 = new javax.swing.JLabel();
        lbl_SDT3 = new javax.swing.JLabel();
        lbl_SDT4 = new javax.swing.JLabel();
        lbl_SDT5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_BanHang = new javax.swing.JTable();
        pnl_textSearch = new javax.swing.JPanel();
        txt_Search_SP = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        btn_XoaMatHang = new javax.swing.JButton();
        txt_SuaSL = new javax.swing.JTextField();
        lbl_TextSL = new javax.swing.JLabel();
        lbl_GiamSL = new javax.swing.JLabel();
        lbl_TangSL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_KhuyenMai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_TienPhaiTra = new javax.swing.JLabel();
        txt_Ghichu = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();

        jFrame2.setUndecorated(true);
        jFrame2.setSize(new java.awt.Dimension(747, 318));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(90, 103, 121)));

        jPanel8.setBackground(new java.awt.Color(102, 153, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thêm Khách Hàng Mới ");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        lbl_MauSac1.setBackground(new java.awt.Color(203, 214, 225));
        lbl_MauSac1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_MauSac1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_MauSac1.setText("Số Điện Thoại");

        txt_tenNcc.setBackground(new java.awt.Color(255, 255, 255));
        txt_tenNcc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_tenNcc.setForeground(new java.awt.Color(0, 0, 0));
        txt_tenNcc.setToolTipText("");

        lbl_Size1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_Size1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_Size1.setText("Địa Chỉ ");

        txt_DiaChi.setBackground(new java.awt.Color(255, 255, 255));
        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_DiaChi.setForeground(new java.awt.Color(0, 0, 0));
        txt_DiaChi.setToolTipText("");

        lbl_TenSp1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenSp1.setForeground(new java.awt.Color(90, 103, 121));
        lbl_TenSp1.setText("Tên Khách Hàng ");

        txt_sdt.setBackground(new java.awt.Color(255, 255, 255));
        txt_sdt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_sdt.setForeground(new java.awt.Color(0, 0, 0));
        txt_sdt.setToolTipText("");

        btn_Luu1.setBackground(new java.awt.Color(21, 151, 229));
        btn_Luu1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Luu1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Luu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/clipboard.png"))); // NOI18N
        btn_Luu1.setText("Lưu");
        btn_Luu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Luu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Luu1MouseClicked(evt);
            }
        });
        btn_Luu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Luu1ActionPerformed(evt);
            }
        });

        btn_Xoa1.setBackground(new java.awt.Color(255, 102, 102));
        btn_Xoa1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btn_Xoa1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close (1).png"))); // NOI18N
        btn_Xoa1.setText("Thoát");
        btn_Xoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xoa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Xoa1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Luu1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_Xoa1)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_DiaChi)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TenSp1)
                                    .addComponent(lbl_Size1)
                                    .addComponent(txt_tenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_MauSac1)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_MauSac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_TenSp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lbl_Size1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Xoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Luu1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setPreferredSize(new java.awt.Dimension(1090, 700));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setViewportView(null);

        pnl_FormBanHang.setBackground(new java.awt.Color(92, 122, 234));
        pnl_FormBanHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_tab_Form_BangHang.setBackground(new java.awt.Color(243, 244, 237));
        pnl_tab_Form_BangHang.setPreferredSize(new java.awt.Dimension(1090, 720));
        pnl_tab_Form_BangHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_ThanhToan.setBackground(java.awt.Color.white);
        pnl_ThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_Search_KH.setBackground(new java.awt.Color(255, 255, 255));
        txt_Search_KH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Search_KH.setForeground(new java.awt.Color(153, 153, 153));
        txt_Search_KH.setText("Thêm Khách Hàng Vào Đơn");
        txt_Search_KH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(102, 153, 255)));
        txt_Search_KH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_Search_KHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Search_KHFocusLost(evt);
            }
        });
        txt_Search_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Search_KHMouseClicked(evt);
            }
        });
        txt_Search_KH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Search_KHKeyReleased(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search3.png"))); // NOI18N
        jButton11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(102, 153, 255)));
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btn_AddKh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add-user.png"))); // NOI18N
        btn_AddKh.setToolTipText("Thêm Khách Hàng Mới");
        btn_AddKh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddKhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt_Search_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_AddKh)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Search_KH)
                    .addComponent(btn_AddKh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbl_TenKh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenKh.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenKh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TenKh.setText("Tấn Đăng");
        lbl_TenKh.setToolTipText("");

        lbl_SDT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SDT.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SDT.setText("0952681254");

        lbl_maKh.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_maKh.setForeground(new java.awt.Color(51, 51, 51));
        lbl_maKh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_maKh.setText("NV005");

        lbl_maKh2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_maKh2.setForeground(new java.awt.Color(51, 51, 51));
        lbl_maKh2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_maKh2.setText("Địa Chỉ Giao Hàng");

        lbl_maKh3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_maKh3.setForeground(new java.awt.Color(51, 51, 51));
        lbl_maKh3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_maKh3.setText("Địa Chỉ Thanh Toán");

        lbl_SDT2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SDT2.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SDT2.setText("0952681254");

        lbl_SDT3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SDT3.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SDT3.setText("Quảng Bình, Phường Trúc Bạch, Quận Ba Đình, Hà Nội");

        lbl_SDT4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SDT4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SDT4.setText("0952681254");

        lbl_SDT5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SDT5.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SDT5.setText("Quảng Bình, Phường Trúc Bạch, Quận Ba Đình, Hà Nội");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/reload.png"))); // NOI18N
        jButton3.setToolTipText("Đổi Nhà Cung Cấp");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_maKh)
                    .addComponent(lbl_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TenKh))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_maKh2)
                    .addComponent(lbl_SDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_SDT3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_SDT5, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_SDT4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_maKh3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_maKh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_maKh2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_maKh3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_TenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_SDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_SDT3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_SDT4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_SDT5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 29, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnl_ThanhToanLayout = new javax.swing.GroupLayout(pnl_ThanhToan);
        pnl_ThanhToan.setLayout(pnl_ThanhToanLayout);
        pnl_ThanhToanLayout.setHorizontalGroup(
            pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnl_ThanhToanLayout.setVerticalGroup(
            pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_tab_Form_BangHang.add(pnl_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1050, 150));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null), "Thông Tin Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(102, 153, 255));
        jScrollPane2.setForeground(new java.awt.Color(51, 153, 255));

        tbl_BanHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_BanHang.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        tbl_BanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Màu", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_BanHang.setFocusable(false);
        tbl_BanHang.setRowHeight(30);
        tbl_BanHang.setShowGrid(true);
        tbl_BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BanHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_BanHang);
        if (tbl_BanHang.getColumnModel().getColumnCount() > 0) {
            tbl_BanHang.getColumnModel().getColumn(0).setMaxWidth(150);
            tbl_BanHang.getColumnModel().getColumn(1).setMaxWidth(400);
            tbl_BanHang.getColumnModel().getColumn(2).setMaxWidth(150);
            tbl_BanHang.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_BanHang.getColumnModel().getColumn(4).setMaxWidth(150);
            tbl_BanHang.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        pnl_textSearch.setBackground(new java.awt.Color(102, 153, 255));
        pnl_textSearch.setPreferredSize(new java.awt.Dimension(1090, 100));

        txt_Search_SP.setBackground(new java.awt.Color(102, 153, 255));
        txt_Search_SP.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_Search_SP.setForeground(new java.awt.Color(153, 204, 255));
        txt_Search_SP.setText("Thêm Sản Phẩm Vào Đơn Hàng");
        txt_Search_SP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Search_SP.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_Search_SP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_Search_SPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Search_SPFocusLost(evt);
            }
        });
        txt_Search_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Search_SPMouseClicked(evt);
            }
        });
        txt_Search_SP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Search_SPActionPerformed(evt);
            }
        });
        txt_Search_SP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Search_SPKeyReleased(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/search3.png"))); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btn_XoaMatHang.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btn_XoaMatHang.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaMatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/deleteB.png"))); // NOI18N
        btn_XoaMatHang.setToolTipText("Xóa sản phẩm khỏi đơn");
        btn_XoaMatHang.setBorder(null);
        btn_XoaMatHang.setContentAreaFilled(false);
        btn_XoaMatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_XoaMatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMatHangMouseClicked(evt);
            }
        });
        btn_XoaMatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaMatHangActionPerformed(evt);
            }
        });

        txt_SuaSL.setBackground(new java.awt.Color(102, 153, 255));
        txt_SuaSL.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_SuaSL.setForeground(new java.awt.Color(255, 255, 255));
        txt_SuaSL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SuaSL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_SuaSL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SuaSLFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SuaSLFocusLost(evt);
            }
        });
        txt_SuaSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_SuaSLMouseClicked(evt);
            }
        });
        txt_SuaSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SuaSLActionPerformed(evt);
            }
        });
        txt_SuaSL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SuaSLKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SuaSLKeyTyped(evt);
            }
        });

        lbl_TextSL.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TextSL.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TextSL.setText("Số lượng:");

        lbl_GiamSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/minus.png"))); // NOI18N
        lbl_GiamSL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_GiamSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_GiamSLMouseClicked(evt);
            }
        });

        lbl_TangSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add1.png"))); // NOI18N
        lbl_TangSL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_TangSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TangSLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_textSearchLayout = new javax.swing.GroupLayout(pnl_textSearch);
        pnl_textSearch.setLayout(pnl_textSearchLayout);
        pnl_textSearchLayout.setHorizontalGroup(
            pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textSearchLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton8)
                .addGap(0, 0, 0)
                .addComponent(txt_Search_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(lbl_TextSL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_GiamSL, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_TangSL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_XoaMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        pnl_textSearchLayout.setVerticalGroup(
            pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_textSearchLayout.createSequentialGroup()
                .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_textSearchLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_Search_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(pnl_textSearchLayout.createSequentialGroup()
                .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_textSearchLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_TextSL))
                    .addGroup(pnl_textSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_XoaMatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_textSearchLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_GiamSL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TangSL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tổng Tiền:");

        lbl_TongTien.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TongTien.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TongTien.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TongTien.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Khuyến mãi:");

        txt_KhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        txt_KhuyenMai.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_KhuyenMai.setForeground(new java.awt.Color(0, 0, 0));
        txt_KhuyenMai.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_KhuyenMai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_KhuyenMai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_KhuyenMaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_KhuyenMaiFocusLost(evt);
            }
        });
        txt_KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_KhuyenMaiMouseClicked(evt);
            }
        });
        txt_KhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_KhuyenMaiActionPerformed(evt);
            }
        });
        txt_KhuyenMai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_KhuyenMaiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_KhuyenMaiKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Khách Hàng Phải Trả:");

        lbl_TienPhaiTra.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TienPhaiTra.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TienPhaiTra.setForeground(new java.awt.Color(0, 102, 204));
        lbl_TienPhaiTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TienPhaiTra.setBorder(new javax.swing.border.MatteBorder(null));

        txt_Ghichu.setBackground(new java.awt.Color(255, 255, 255));
        txt_Ghichu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txt_Ghichu.setForeground(new java.awt.Color(153, 153, 153));
        txt_Ghichu.setText("Nhập ghi chú đơn hàng");
        txt_Ghichu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_Ghichu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_GhichuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_GhichuFocusLost(evt);
            }
        });
        txt_Ghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GhichuActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/pencil1.png"))); // NOI18N
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btn_ThanhToan.setBackground(new java.awt.Color(102, 153, 255));
        btn_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_ThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThanhToan.setText("Tạo Đơn");
        btn_ThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThanhToanMouseClicked(evt);
            }
        });
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_textSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txt_Ghichu))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5))
                                .addGap(77, 77, 77)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_TienPhaiTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_TongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_KhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(pnl_textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))))
        );

        pnl_tab_Form_BangHang.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1050, 510));

        pnl_FormBanHang.add(pnl_tab_Form_BangHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 690));

        jScrollPane1.setViewportView(pnl_FormBanHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Search_KHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_KHFocusGained
        if(txt_Search_KH.getText().equals("Thêm Khách Hàng Vào Đơn")){
            txt_Search_KH.setText("");
            txt_Search_KH.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_Search_KHFocusGained

    private void txt_Search_KHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_KHFocusLost
        if(txt_Search_KH.getText().equals("")){
            txt_Search_KH.setText("Thêm Khách Hàng Vào Đơn");
            txt_Search_KH.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_Search_KHFocusLost

    private void txt_Search_SPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_SPFocusGained
        if(txt_Search_SP.getText().equals("Thêm Sản Phẩm Vào Đơn Hàng")){
            txt_Search_SP.setText("");
            txt_Search_SP.setForeground(Color.white);
        }
    }//GEN-LAST:event_txt_Search_SPFocusGained

    private void txt_Search_SPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Search_SPFocusLost
        if(txt_Search_SP.getText().equals("")){
            txt_Search_SP.setText("Thêm Sản Phẩm Vào Đơn Hàng");
            txt_Search_SP.setForeground(Color.white);
        }
    }//GEN-LAST:event_txt_Search_SPFocusLost

    private void txt_Search_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Search_SPMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txt_Search_SP, 0, txt_Search_SP.getHeight());
        }
    }//GEN-LAST:event_txt_Search_SPMouseClicked

    private void txt_Search_SPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Search_SPActionPerformed
//        txt_Search_SP.requestFocus();
        //click enter neu khong co sp nao can tim hien thị thong bao
        if (search.getItemSize() < 1){
            JOptionPane.showMessageDialog(tbl_BanHang, "Không tìm thấy sản phẩm trong kho");
        }
        
        
    }//GEN-LAST:event_txt_Search_SPActionPerformed

    private void txt_Search_SPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_SPKeyReleased
        String text = txt_Search_SP.getText().trim().toLowerCase();
        search.setDataSP(bhDao.SearchMaSpOrTenSp(text));
        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu.show(txt_Search_SP, 0, txt_Search_SP.getHeight());
            //            
        } else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txt_Search_SPKeyReleased

//    private List<SanPham> search(String search) {
//        int limitData = 7;
//        List<DataSearch> list = new ArrayList<>();
//        
//        
//        return list;
//    }


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_XoaMatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMatHangMouseClicked
        
        r = tbl_BanHang.getSelectedRow();
        if (r!=-1){
            huy(r);
            txt_SuaSL.setText("");
            TinhTong();
//            lbl_TienThua.setText("0");
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa!");
        }
        
    }//GEN-LAST:event_btn_XoaMatHangMouseClicked

    private void btn_XoaMatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaMatHangActionPerformed
        
    }//GEN-LAST:event_btn_XoaMatHangActionPerformed

    private void tbl_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BanHangMouseClicked
        r = tbl_BanHang.getSelectedRow();
        dfbh_model = (DefaultTableModel) tbl_BanHang.getModel();
        
        if (r!=-1){
                String ssl= tbl_BanHang.getValueAt(r, 3).toString();
                txt_SuaSL.setText(ssl);
                btn_XoaMatHang.setVisible(true);
                lbl_TextSL.setVisible(true);
                lbl_GiamSL.setVisible(true);
                lbl_TangSL.setVisible(true);
                
                txt_SuaSL.setVisible(true);
                
                //lay ra ma sp vua click
                 maSPClick = tbl_BanHang.getValueAt(r, 0).toString();
            
        }
        
    }//GEN-LAST:event_tbl_BanHangMouseClicked

    
    //click vao thanh toan
    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
       
//        if(kiemTraTruocThanhToan()){
//           taoHoaDon();
//        }
        
        
       
        
    }//GEN-LAST:event_btn_ThanhToanMouseClicked

    //tao hoa don va luu va CSDL
    public void taoHoaDon(){
         //lay ra dc cac san pham dang ban
        List<SanPham> listSP =  getSpFromTB();
        //lay ra so luong cac san pham
        int slSanPham = 0;
        for(int i = 0; i < listSP.size(); i++){
            slSanPham+=listSP.get(i).getSoLuong();
        }

        //lay ra ma KHachHang 
        String ma =lbl_maKh.getText();
        KhachHang KH = khDao.getKHByMaKH(ma);
        
        //lay ra nhanVien thanh toan hoa don
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien NV = nvDao.getNVByMaTrangThai("online");
        
       
        
        String maHD = TaoMaHD();
      
       //lay tien khach dua
//       Double tienKhachDua = changeMoney(txt_TienDua.getText());
        String ghiChu="" ;
        String tinhTrang="Đang Giao";
        double tienKhachDua =0.0;
        double tienKhuyenMai= changeMoney(txt_KhuyenMai.getText());
        
        
        HoaDonBanHang hd = new HoaDonBanHang(maHD,slSanPham, tong,tienKhachDua, ghiChu,tienKhuyenMai, tinhTrang);
        hd.setKhachHang(KH);//them doi tuong KH vao HD
        hd.setNhanVien(NV);//them doi tuong NV vao HD
//        HoaDonBanHang hd = new HoaDonBanHang(maHD, slSanPham,tong, tienKhachDua, ghiChu,tienKhuyenMai);
        //them hoa don vao CSDL
        HoaDonDao hdDao = new HoaDonDao();
        hdDao.createHoaDonBH(hd);
//        HoaDonDatHang hdNew = hdDao.getHdNew();
//        System.out.print(hd);

        //tao ds doi tuong CT_HoaDon
        List<CT_HDBanHang> list_CTHD = new ArrayList<CT_HDBanHang>();
       
        for(int i = 0; i < listSP.size(); i++){
           int sl = listSP.get(i).getSoLuong();
           double donGia = listSP.get(i).getDonGia();
           CT_HDBanHang ct = new CT_HDBanHang(sl, donGia);
           
           //lay ra san pham bang maSP
           SanPhamDao spDao = new SanPhamDao();
           SanPham sp = spDao.findSPByMaSP(listSP.get(i).getMaSP());
           
           ct.setSanPham(sp);//them san pham vao CTHoaDon
           ct.setHoaDon(hd);

           list_CTHD.add(ct);

           //thuc hien cap nhat lai sl sanPham
           spDao.updateSLSP(listSP.get(i).getMaSP(), sl);
         
        }

        //them CTHoaDon vao csdl
        CT_HoaDonDao ctDao = new CT_HoaDonDao();
        for(int i = 0; i < list_CTHD.size(); i++){
            ctDao.createCTHoaDonBH(list_CTHD.get(i));
        }
        
        //in hoa don
        printBill(maHD);
        xoaTrang();
    }
    
    //kiem tra du lieu them nha cc moi
    public boolean kiemTraData() {
        String tenKh = txt_tenNcc.getText().trim();
        String sdt = txt_sdt.getText().trim();
        String diaChi = txt_DiaChi.getText().trim();

        String regexPhone = "^[0-9]{10}";
        //ten ncc 
        if (tenKh.length() <= 0) {
            JOptionPane.showMessageDialog(btn_Luu1, "Tên NCC không được để trống");
            return false;
        }
        if (diaChi.length() <= 0) {
            JOptionPane.showMessageDialog(btn_Luu1, "Địa chỉ NCC không được để trống");
            return false;
        }
        if (!sdt.matches(regexPhone)) {
            JOptionPane.showMessageDialog(btn_Luu1, "Số điện thoại có 10 số");
            return false;
        }
        return true;
    }
    
    //lay du lieu tu tef
    public KhachHang restText() {
        String tenKh = txt_tenNcc.getText().toString();
        String sdt = txt_sdt.getText().toString();
        String diachi = txt_DiaChi.getText().toString();
        return new KhachHang("", tenKh, sdt, diachi);
    }
    
    private void txt_Search_KHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_KHKeyReleased
        String text = txt_Search_KH.getText().trim().toLowerCase();
        search2.setDataKh(khDao.SearchMaOrTenOrSdt2(text));
        if (search2.getItemSize() > 0) {
            //  * 2 top and bot border
            menu2.show(txt_Search_KH, 0, txt_Search_KH.getHeight());
            //            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
        } else {
            menu2.setVisible(false);
        }
    }//GEN-LAST:event_txt_Search_KHKeyReleased

    private void txt_Search_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Search_KHMouseClicked
        if (search2.getItemSize() > 0) {
            menu2.show(txt_Search_KH, 0, txt_Search_KH.getHeight());
        }
        if(txt_Search_KH.getText().length()<0){
            menu2.setVisible(false);
        }
    }//GEN-LAST:event_txt_Search_KHMouseClicked

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
         if(kiemTraTruocThanhToan()){
           taoHoaDon();
        }
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

  
    //chuyen doi kieu tien te sang double
    //@param: 128.000 d
    //@return 128000
    public Double changeMoney(String money){
        if(money.length()>1){
            String newMoney = money.substring(0,money.length()-2).replace(".","");          
             return Double.parseDouble(newMoney); 
        }
           return 0.0;
    }
    private void txt_SuaSLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SuaSLFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLFocusGained

    private void txt_SuaSLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SuaSLFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLFocusLost

    private void txt_SuaSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SuaSLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLMouseClicked

    private void txt_SuaSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SuaSLActionPerformed
        //lay ra so luong san pham cua san pham dang can ban
        SanPhamDao  spDao = new SanPhamDao();
        SanPham sanPham = spDao.findSPByMaSP(maSPClick);
       

        int sl = Integer.parseInt(txt_SuaSL.getText().toString());
       
     
        
        if(sl + 1 > sanPham.getSoLuong()){
           JOptionPane.showMessageDialog(tbl_BanHang,"Sản phẩm trong kho không đủ số lượng!!");
        }
        else{
            //        txt_SuaSL.setText(String.valueOf(plus));
        tbl_BanHang.setValueAt(sl, r, 3);
        lbl_GiamSL.setEnabled(true);
        double donGia = Double.parseDouble( tbl_BanHang.getValueAt(r, 4).toString());
        tbl_BanHang.setValueAt(sl * donGia, r, 5);
        TinhTong();
        }

    }//GEN-LAST:event_txt_SuaSLActionPerformed

    private void txt_SuaSLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SuaSLKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLKeyReleased

    private void txt_SuaSLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SuaSLKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SuaSLKeyTyped

    private void lbl_GiamSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_GiamSLMouseClicked
        // TODO add your handling code here:
        if(txt_SuaSL.getText().equals("0")){
            lbl_GiamSL.setEnabled(false);
        }else{
            int minus = 0;
            int sl = Integer.parseInt(txt_SuaSL.getText().toString());
            
            if(sl-1>0){
                 minus = sl-1; 
                txt_SuaSL.setText(String.valueOf(minus));
                tbl_BanHang.setValueAt(minus, r, 3);
                double donGia = Double.parseDouble( tbl_BanHang.getValueAt(r, 4).toString());
                tbl_BanHang.setValueAt(minus * donGia, r, 5);
                lbl_GiamSL.setEnabled(true);
                TinhTong();    
            }
            
        }
    }//GEN-LAST:event_lbl_GiamSLMouseClicked

    private void lbl_TangSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TangSLMouseClicked
        //lay ra so luong san pham cua san pham dang can ban
        SanPhamDao  spDao = new SanPhamDao();
        SanPham sanPham = spDao.findSPByMaSP(maSPClick);
       

        int plus = 0;
        int sl = Integer.parseInt(txt_SuaSL.getText().toString());
     
        
        if(sl + 1 > sanPham.getSoLuong()){
           JOptionPane.showMessageDialog(tbl_BanHang,"Sản phẩm trong kho không đủ số lượng!!");
        }
        else{
            
               plus = sl+1; 
                txt_SuaSL.setText(String.valueOf(plus));
                tbl_BanHang.setValueAt(plus, r, 3);
                lbl_GiamSL.setEnabled(true);
                double donGia = Double.parseDouble( tbl_BanHang.getValueAt(r, 4).toString());
                tbl_BanHang.setValueAt(plus * donGia, r, 5);
                TinhTong();
        }
       
    }//GEN-LAST:event_lbl_TangSLMouseClicked

    private void txt_KhuyenMaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiFocusGained
           String money = txt_KhuyenMai.getText();
             
             txt_KhuyenMai.setText(String.valueOf(changeMoney(money)));
    }//GEN-LAST:event_txt_KhuyenMaiFocusGained

    private void txt_KhuyenMaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiFocusLost
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        Double money = Double.parseDouble(txt_KhuyenMai.getText());
        txt_KhuyenMai.setText(currencyVN.format(money));
    }//GEN-LAST:event_txt_KhuyenMaiFocusLost

    private void txt_KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_KhuyenMaiMouseClicked

    private void txt_KhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiActionPerformed
        //chuyen doi tien khuyenmai sang dinh dang tien te
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//        Double money = Double.parseDouble(txt_KhuyenMai.getText());
//        txt_KhuyenMai.setText(currencyVN.format(money));
//            txt_TienDua.requestFocus();
    }//GEN-LAST:event_txt_KhuyenMaiActionPerformed

    //nhap so tien khuyen mai
    //cap nhat lai so tien khach phai tra
    private void txt_KhuyenMaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiKeyReleased
        // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        
        //kiem tra tienKM nhap vao co chu hoac ky dac biet( không phải là số) 
       
            String tienKM = txt_KhuyenMai.getText().substring(0,txt_KhuyenMai.getText().length()-2).replace(".","");
                 
            if (!tienKM.matches("^[0-9]*$")) {
		JOptionPane.showMessageDialog(tbl_BanHang, "Không được nhập chữ hoặc ký tự đặc biệt");
		
            }
            else{
                Locale localeVN = new Locale("vi", "VN");
                  NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                 double tienKhuyenMai = Double.parseDouble(txt_KhuyenMai.getText());
                lbl_TienPhaiTra.setText(currencyVN.format(tong-tienKhuyenMai));
//                txt_TienDua.setText(currencyVN.format(tong-tienKhuyenMai));
            }
           
       
        
    }//GEN-LAST:event_txt_KhuyenMaiKeyReleased

    private void txt_KhuyenMaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_KhuyenMaiKeyTyped

    private void btn_AddKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddKhMouseClicked
//       new FrmThemKh().setVisible(true);
//        jPanel1.setVisible(false);
//        jPanel2.setVisible(true);
           jFrame2.setVisible(true);
           jFrame2.setResizable(false);
            jFrame2.setLocationRelativeTo(null);
            txt_tenNcc.requestFocus();
    }//GEN-LAST:event_btn_AddKhMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        lbl_maKh.setText("");
    }//GEN-LAST:event_jButton3MouseClicked

    private void txt_GhichuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_GhichuFocusGained
        if(txt_Ghichu.getText().equals("Nhập ghi chú đơn hàng")){
            txt_Ghichu.setText("");
            txt_Ghichu.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_GhichuFocusGained

    private void txt_GhichuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_GhichuFocusLost
        if(txt_Ghichu.getText().equals("")){
            txt_Ghichu.setText("Nhập ghi chú đơn hàng");
            txt_Ghichu.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_GhichuFocusLost

    private void txt_GhichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GhichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GhichuActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn_Luu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Luu1MouseClicked
        if (kiemTraData()) {
            KhachHang kh = restText();
            KhachHangDao khDao = new KhachHangDao();
            if (khDao.themKH(kh)) {
                KhachHang khNew = khDao.getKhNew();
                
                lbl_TenKh.setText(khNew.getTenKH());
               lbl_maKh.setText(khNew.getMaKH());
               lbl_SDT.setText(khNew.getSdt());
               lbl_SDT3.setText(khNew.getDiaChi());
               lbl_SDT5.setText(khNew.getDiaChi());
               lbl_SDT2.setText(khNew.getSdt());
               lbl_SDT4.setText(khNew.getSdt());
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                jFrame2.setVisible(false);
                jPanel1.setVisible(false);
               jPanel2.setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_Luu1MouseClicked

    private void btn_Luu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Luu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Luu1ActionPerformed

    private void btn_Xoa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Xoa1MouseClicked
        jFrame2.setVisible(false);
    }//GEN-LAST:event_btn_Xoa1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel btn_AddKh;
    private javax.swing.JButton btn_Luu1;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_Xoa1;
    private javax.swing.JButton btn_XoaMatHang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_GiamSL;
    private javax.swing.JLabel lbl_MauSac1;
    static javax.swing.JLabel lbl_SDT;
    static javax.swing.JLabel lbl_SDT2;
    static javax.swing.JLabel lbl_SDT3;
    static javax.swing.JLabel lbl_SDT4;
    static javax.swing.JLabel lbl_SDT5;
    private javax.swing.JLabel lbl_Size1;
    private javax.swing.JLabel lbl_TangSL;
    static javax.swing.JLabel lbl_TenKh;
    private javax.swing.JLabel lbl_TenSp1;
    private javax.swing.JLabel lbl_TextSL;
    private javax.swing.JLabel lbl_TienPhaiTra;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JLabel lbl_maKh;
    private javax.swing.JLabel lbl_maKh2;
    private javax.swing.JLabel lbl_maKh3;
    private javax.swing.JPanel pnl_FormBanHang;
    private javax.swing.JPanel pnl_ThanhToan;
    private javax.swing.JPanel pnl_tab_Form_BangHang;
    private javax.swing.JPanel pnl_textSearch;
    public javax.swing.JTable tbl_BanHang;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Ghichu;
    public static javax.swing.JTextField txt_KhuyenMai;
    public static javax.swing.JTextField txt_Search_KH;
    private javax.swing.JTextField txt_Search_SP;
    private javax.swing.JTextField txt_SuaSL;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenNcc;
    // End of variables declaration//GEN-END:variables

    //kiem tra dieu kien truoc khi thanh toan
    /**
    /@param no
    * @return boolean
    */
    private boolean kiemTraTruocThanhToan() {
        
        //kt khách hàng
        if (lbl_maKh.getText().length() == 0) {
            JOptionPane.showMessageDialog(tbl_BanHang, "Chưa có thông tin Khách Hàng!");
            return false;
        }
        
        //kiem tra table co san pham can ban nao chua
        if(tbl_BanHang.getRowCount()<=0){
            JOptionPane.showMessageDialog(tbl_BanHang, "Bạn chưa chọn sản phẩm để thanh toán");
            return false;
        }

        
        return true;
    }
    
    //lay danh sach cac san pham tren table
    /*
        @param 
        @return list<SanPham>
    */
    public List<SanPham> getSpFromTB(){
        List<SanPham> list = new ArrayList<SanPham>();
         for( int i = 0;i<tbl_BanHang.getRowCount();i++){
            
            String maSp = tbl_BanHang.getValueAt(i, 0).toString();
            String tenSp = tbl_BanHang.getValueAt(i, 1).toString();
            String mau = tbl_BanHang.getValueAt(i, 2).toString();
            String SL = tbl_BanHang.getValueAt(i, 3).toString();
            String donGia = tbl_BanHang.getValueAt(i, 4).toString();
                
            SanPham sp = new SanPham(maSp, tenSp, Double.parseDouble(donGia),Integer.parseInt(SL), mau );
            list.add(sp);
        }
        
        return list;
    }
    
    //SInh ma HoaDon tu dong
    /*
        @param
        @return String HDxxxxxx
    */
    public String TaoMaHD(){
        Random rand = new Random();
         int ranNum = rand.nextInt(100000000)+ 1;
         String maHD = "HD"+String.valueOf(ranNum);
         
         return maHD;
    }
    
      //Tạo hàm xuất hóa đơn
    public void printBill(String maHD){
        try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src\\Gui/rptHoaDon.jrxml");
            map.put("MaHD", maHD);
            JasperPrint p = JasperFillManager.fillReport(report,  map, connect.getConnection() );
            JasperViewer.viewReport(p, false);
           // JasperExportManager.exportReportToPdfFile(p, "test.pdf");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
           
        }
    }
    /**
     * xoa trang khi thuc hien clich vao thanh toan
     * @param 
     * @return 
     */
    public void xoaTrang(){
         txt_Search_SP.setText("Thêm Sản Phẩm Vào Đơn Hàng");
         txt_Search_SP.setForeground(Color.white);
         lbl_TongTien.setText("");
         txt_KhuyenMai.setText("0");
         lbl_TienPhaiTra.setText("");
//         txt_TienDua.setText("");
//         lbl_TienThua.setText("0");
         dfbh_model.setRowCount(0);
          lbl_TenKh.setText("");
               lbl_maKh.setText("");
               lbl_SDT.setText("");
//              txt_Ghichu.setText("Nhập ghi chú");
              txt_Search_KH.setText("Thêm Khách Hàng Vào Đơn");
              jPanel1.setVisible(true);
              jPanel2.setVisible(false);
              dstt.removeAll(dstt);
              btn_XoaMatHang.setVisible(false);
        lbl_TextSL.setVisible(false);
        lbl_GiamSL.setVisible(false);
        lbl_TangSL.setVisible(false);
        txt_SuaSL.setVisible(false);
    }

    
  
                
}
