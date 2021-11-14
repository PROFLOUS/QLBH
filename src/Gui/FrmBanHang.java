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
import entity.HoaDonBanHang;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author HP
 */
public class FrmBanHang extends javax.swing.JPanel {
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
    
    //bien toan phan
    //click vao 1 san pham trong table lay ra ma san pham
   
    private String maSPClick = "";
    
    
    public FrmBanHang() {
        initComponents();
        bhDao = new BanHangDao();
        khDao = new KhachHangDao();
        dstt = new ArrayList<SanPham>();
        dssp = new  ArrayList<SanPham>();
        SanPham sp = new SanPham();
        
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
                    System.out.println("loi");
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
               
               lbl_TenKh.setText(tenKh);
               lbl_maKh.setText(maKh);
               lbl_SDT.setText(sDT);
               menu2.setVisible(false);
               lbl_XoaKh.setEnabled(true);
               btn_AddKh.setVisible(false);
               txt_Search_KH.setVisible(false);
                System.out.println(lbl_TenKh.getText());
                

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
         txt_TienDua.setText(currencyVN.format(tong));              
    }
    //tính tiền thừ va cap nhat tien thua len giao dien
    //tienthua = tienkhachdua - tienphaitra
    public void TinhTienThua(){
           // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        
      String tienPhaiTra = lbl_TienPhaiTra.getText();
      String tienKhachDua = txt_TienDua.getText();
      Double tienThua = changeMoney(tienKhachDua) - changeMoney(tienPhaiTra);
       lbl_TienThua.setText(currencyVN.format(tienThua));
    }
    
    //ẩn các nút chức năng
    public void Hide(){
        btn_XoaMatHang.setVisible(false);
        lbl_TextSL.setVisible(false);
        lbl_GiamSL.setVisible(false);
        lbl_TangSL.setVisible(false);
        
        txt_SuaSL.setVisible(false);
    }
            
        
      public void setKhachHangLenGui(KhachHang kh){
             String maKh = kh.getMaKH();
               String tenKh = kh.getTenKH();
               String sDT = kh.getSdt();
               
               lbl_TenKh.setText(tenKh);
               lbl_maKh.setText(maKh);
               lbl_SDT.setText(sDT);
              
               lbl_XoaKh.setEnabled(true);
               btn_AddKh.setVisible(false);
               txt_Search_KH.setVisible(false);
               
                
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_FormBanHang = new javax.swing.JPanel();
        lbl_text_BanHang = new javax.swing.JLabel();
        pnl_tab_Form_BangHang = new javax.swing.JPanel();
        pnl_ThanhToan = new javax.swing.JPanel();
        txt_Search_KH = new javax.swing.JTextField();
        lbl_TenKh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_TienPhaiTra = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_TienThua = new javax.swing.JLabel();
        txt_Ghichu = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        txt_TienDua = new javax.swing.JTextField();
        lbl_SDT = new javax.swing.JLabel();
        lbl_Ket = new javax.swing.JLabel();
        lbl_XoaKh = new javax.swing.JLabel();
        lbl_maKh = new javax.swing.JLabel();
        lbl_TenKh1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_KhuyenMai = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_AddKh = new javax.swing.JLabel();
        btn_ThanhToan = new javax.swing.JButton();
        pnl_textSearch = new javax.swing.JPanel();
        txt_Search_SP = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        btn_XoaMatHang = new javax.swing.JButton();
        txt_SuaSL = new javax.swing.JTextField();
        lbl_TextSL = new javax.swing.JLabel();
        lbl_GiamSL = new javax.swing.JLabel();
        lbl_TangSL = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_BanHang = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1090, 700));

        pnl_FormBanHang.setBackground(new java.awt.Color(243, 244, 237));
        pnl_FormBanHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_text_BanHang.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lbl_text_BanHang.setForeground(new java.awt.Color(0, 153, 204));
        lbl_text_BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text_BanHang.setText("Bán Hàng");
        pnl_FormBanHang.add(lbl_text_BanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 138, 30));

        pnl_tab_Form_BangHang.setBackground(new java.awt.Color(51, 153, 255));
        pnl_tab_Form_BangHang.setPreferredSize(new java.awt.Dimension(1090, 720));
        pnl_tab_Form_BangHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_ThanhToan.setBackground(java.awt.Color.white);
        pnl_ThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(102, 153, 255)));

        txt_Search_KH.setBackground(new java.awt.Color(255, 255, 255));
        txt_Search_KH.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_Search_KH.setForeground(new java.awt.Color(153, 153, 153));
        txt_Search_KH.setText("Thêm Khách Hàng Vào Đơn");
        txt_Search_KH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
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

        lbl_TenKh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_TenKh.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenKh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tổng Tiền:");

        lbl_TongTien.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TongTien.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TongTien.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Khách Hàng Phải Trả:");

        lbl_TienPhaiTra.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TienPhaiTra.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TienPhaiTra.setForeground(new java.awt.Color(0, 102, 204));
        lbl_TienPhaiTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tiền Khách Đưa:");

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tiền Thừa:");

        lbl_TienThua.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TienThua.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TienThua.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TienThua.setText("0");
        lbl_TienThua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_TienThuaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lbl_TienThuaKeyTyped(evt);
            }
        });

        txt_Ghichu.setBackground(new java.awt.Color(255, 255, 255));
        txt_Ghichu.setFont(new java.awt.Font("Consolas", 0, 15)); // NOI18N
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

        txt_TienDua.setBackground(new java.awt.Color(255, 255, 255));
        txt_TienDua.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_TienDua.setForeground(new java.awt.Color(0, 0, 0));
        txt_TienDua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_TienDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_TienDua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_TienDuaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_TienDuaFocusLost(evt);
            }
        });
        txt_TienDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TienDuaMouseClicked(evt);
            }
        });
        txt_TienDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TienDuaActionPerformed(evt);
            }
        });
        txt_TienDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TienDuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TienDuaKeyTyped(evt);
            }
        });

        lbl_SDT.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbl_SDT.setForeground(new java.awt.Color(0, 0, 0));

        lbl_Ket.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_Ket.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Ket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Ket.setText("-");

        lbl_XoaKh.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lbl_XoaKh.setForeground(new java.awt.Color(0, 0, 0));
        lbl_XoaKh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_XoaKh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/close.png"))); // NOI18N
        lbl_XoaKh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_XoaKh.setEnabled(false);
        lbl_XoaKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_XoaKhMouseClicked(evt);
            }
        });

        lbl_maKh.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_maKh.setForeground(new java.awt.Color(255, 255, 255));
        lbl_maKh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbl_TenKh1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_TenKh1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenKh1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TenKh1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));

        jLabel14.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
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

        btn_AddKh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add-user.png"))); // NOI18N
        btn_AddKh.setToolTipText("Thêm Khách Hàng Mới");
        btn_AddKh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AddKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AddKhMouseClicked(evt);
            }
        });

        btn_ThanhToan.setBackground(new java.awt.Color(102, 153, 255));
        btn_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_ThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThanhToan.setText("Thanh Toán");
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

        javax.swing.GroupLayout pnl_ThanhToanLayout = new javax.swing.GroupLayout(pnl_ThanhToan);
        pnl_ThanhToan.setLayout(pnl_ThanhToanLayout);
        pnl_ThanhToanLayout.setHorizontalGroup(
            pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThanhToanLayout.createSequentialGroup()
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Search_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_TenKh1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                            .addComponent(lbl_Ket, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lbl_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_Ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                        .addComponent(btn_AddKh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addComponent(lbl_XoaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addComponent(lbl_TenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(275, 275, 275)
                                .addComponent(lbl_maKh, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_TienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TienDua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_ThanhToanLayout.createSequentialGroup()
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5))
                        .addGap(164, 384, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_ThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                        .addComponent(lbl_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        pnl_ThanhToanLayout.setVerticalGroup(
            pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_AddKh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Search_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThanhToanLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbl_maKh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_XoaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                                .addComponent(lbl_TenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_ThanhToanLayout.createSequentialGroup()
                                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbl_Ket)
                                                    .addComponent(lbl_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(lbl_TenKh1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16))))
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_TienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(lbl_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnl_tab_Form_BangHang.add(pnl_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 350, 1110, 310));

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
        btn_XoaMatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/delete.png"))); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(lbl_TextSL)
                .addGap(18, 18, 18)
                .addComponent(lbl_GiamSL, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_TangSL)
                .addGap(29, 29, 29)
                .addComponent(btn_XoaMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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
                .addContainerGap()
                .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_textSearchLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnl_textSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SuaSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TextSL)
                            .addComponent(lbl_GiamSL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TangSL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_XoaMatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_tab_Form_BangHang.add(pnl_textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(102, 153, 255)));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        pnl_tab_Form_BangHang.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1090, 300));

        pnl_FormBanHang.add(pnl_tab_Form_BangHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1090, 760));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_FormBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txt_TienDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TienDuaActionPerformed
       TinhTienThua();
       btn_XoaMatHang.setEnabled(false);
    }//GEN-LAST:event_txt_TienDuaActionPerformed

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
        // TODO add your handling code here:
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
        System.out.println("ok ");
        r = tbl_BanHang.getSelectedRow();
        if (r!=-1){
            huy(r);
            txt_SuaSL.setText("");
            TinhTong();
            lbl_TienThua.setText("0");
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

    private void txt_TienDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienDuaKeyReleased
       
//            String txtTienThua = txt_TienDua.getText().toString();
////            txt_TienDua.setText("");
//            double dblByr = Double.parseDouble(txtTienThua);
//            DecimalFormat df = new DecimalFormat("### ### ###");
//            //txt_TienDua.setText(df.format(dblByr));
//
//            System.out.println(df.format(dblByr).toString());
    }//GEN-LAST:event_txt_TienDuaKeyReleased

    private void lbl_TienThuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_TienThuaKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            TinhTienThua();
//            btn_XoaMatHang.setEnabled(true);
//        }
    }//GEN-LAST:event_lbl_TienThuaKeyPressed

    private void txt_TienDuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienDuaKeyTyped
        if(Character.isLetter(evt.getKeyChar()))
            evt.consume();
        else{
            try {
                Double.parseDouble(txt_TienDua.getText()+evt.getKeyChar());
            } catch (NumberFormatException e) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_TienDuaKeyTyped

    
    //click vao thanh toan
    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
       
        if(kiemTraTruocThanhToan()){
           taoHoaDon();
        }
        
        
       
        
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
       // System.out.print(slSanPham);
        //lay ra ma KHachHang thong qua sdt
        String sdt = lbl_SDT.getText();
        KhachHang KH = khDao.SearchKhBySDT(sdt);
    
        //lay ra nhanVien thanh toan hoa don
        NhanVienDao nvDao = new NhanVienDao();
        NhanVien NV = nvDao.getNVByMaTrangThai("online");
       
        
        String maHD = TaoMaHD();
      
       //lay tien khach dua
       Double tienKhachDua = changeMoney(txt_TienDua.getText());
       Double tienKhuyenMai = changeMoney(txt_KhuyenMai.getText());
       String ghiChu = txt_Ghichu.getText();
        if(ghiChu.equals("Nhập ghi chú đơn hàng")){
            ghiChu = " ";
        }
        HoaDonBanHang hd = new HoaDonBanHang(maHD, slSanPham,tong, tienKhachDua, ghiChu,tienKhuyenMai);
        hd.setKhachHang(KH);//them doi tuong KH vao HD
        hd.setNhanVien(NV);//them doi tuong NV vao HD
//        System.out.print(hd);

        //tao ds doi tuong CT_HoaDon
        List<CT_HDBanHang> list_CTHD = new ArrayList<CT_HDBanHang>();
       
        for(int i = 0; i < listSP.size(); i++){
           int sl = listSP.get(i).getSoLuong();
           Double donGia = listSP.get(i).getDonGia();
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
        
        
        //them hoa don vao CSDL
        HoaDonDao hdDao = new HoaDonDao();
        hdDao.createHoaDonBH(hd);
        
        //them CTHoaDon vao csdl
        CT_HoaDonDao ctDao = new CT_HoaDonDao();
        for(int i = 0; i < list_CTHD.size(); i++){
            ctDao.createCTHoaDonBH(list_CTHD.get(i));
        }
        
        //in hoa don
        printBill(maHD);
        xoaTrang();
       
    }
    private void txt_Search_KHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_KHKeyReleased
        String text = txt_Search_KH.getText().trim().toLowerCase();
        search2.setDataKh(khDao.SearchKh(text));
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

    private void lbl_TienThuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_TienThuaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_TienThuaKeyTyped

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void lbl_XoaKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_XoaKhMouseClicked
               lbl_TenKh.setText("");
               lbl_maKh.setText("");
               lbl_SDT.setText("");
              txt_Search_KH.setVisible(true);
              btn_AddKh.setVisible(true);
               
              
    }//GEN-LAST:event_lbl_XoaKhMouseClicked

    //focus ra khoi input
    //chuyen string thanh kieu tien te
    private void txt_TienDuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienDuaFocusLost
         Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
          Double money = Double.parseDouble(txt_TienDua.getText());
         txt_TienDua.setText(currencyVN.format(money));
        TinhTienThua();
       
    }//GEN-LAST:event_txt_TienDuaFocusLost

    //focus vao tien khach dua
    //chuyen kieu tien te sang string de co the chinh sua dc
    private void txt_TienDuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienDuaFocusGained
             String money = txt_TienDua.getText();
             
             txt_TienDua.setText(String.valueOf(changeMoney(money)));
    }//GEN-LAST:event_txt_TienDuaFocusGained
   
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
    private void txt_TienDuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TienDuaMouseClicked
        
    }//GEN-LAST:event_txt_TienDuaMouseClicked

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
        
        int sl = Integer.parseInt(txt_SuaSL.getText().toString());
//        txt_SuaSL.setText(String.valueOf(plus));
        tbl_BanHang.setValueAt(sl, r, 3);
        lbl_GiamSL.setEnabled(true);
        double donGia = Double.parseDouble( tbl_BanHang.getValueAt(r, 4).toString());
        tbl_BanHang.setValueAt(sl * donGia, r, 5);
        TinhTong();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_KhuyenMaiActionPerformed

    //nhap so tien khuyen mai
    //cap nhat lai so tien khach phai tra
    private void txt_KhuyenMaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiKeyReleased
        // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
        // đơn vị tiền tệ của Việt Nam là đồng
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        
        
        double tienKhuyenMai = Double.parseDouble(txt_KhuyenMai.getText());
        lbl_TienPhaiTra.setText(currencyVN.format(tong-tienKhuyenMai));
         txt_TienDua.setText(currencyVN.format(tong-tienKhuyenMai));
    }//GEN-LAST:event_txt_KhuyenMaiKeyReleased

    private void txt_KhuyenMaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KhuyenMaiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_KhuyenMaiKeyTyped

    private void btn_AddKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AddKhMouseClicked
       new FrmThemKh().setVisible(true);
    }//GEN-LAST:event_btn_AddKhMouseClicked

    private void txt_GhichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GhichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GhichuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel btn_AddKh;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_XoaMatHang;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_GiamSL;
    private javax.swing.JLabel lbl_Ket;
    static javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TangSL;
    static javax.swing.JLabel lbl_TenKh;
    private javax.swing.JLabel lbl_TenKh1;
    private javax.swing.JLabel lbl_TextSL;
    private javax.swing.JLabel lbl_TienPhaiTra;
    private javax.swing.JLabel lbl_TienThua;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JLabel lbl_XoaKh;
    private javax.swing.JLabel lbl_maKh;
    private javax.swing.JLabel lbl_text_BanHang;
    private javax.swing.JPanel pnl_FormBanHang;
    private javax.swing.JPanel pnl_ThanhToan;
    private javax.swing.JPanel pnl_tab_Form_BangHang;
    private javax.swing.JPanel pnl_textSearch;
    public javax.swing.JTable tbl_BanHang;
    private javax.swing.JTextField txt_Ghichu;
    public static javax.swing.JTextField txt_KhuyenMai;
    public static javax.swing.JTextField txt_Search_KH;
    private javax.swing.JTextField txt_Search_SP;
    private javax.swing.JTextField txt_SuaSL;
    private javax.swing.JTextField txt_TienDua;
    // End of variables declaration//GEN-END:variables

    //kiem tra dieu kien truoc khi thanh toan
    /**
    /@param no
    * @return boolean
    */
    private boolean kiemTraTruocThanhToan() {
        
        //kiem tra table co san pham can ban nao chua
        if(tbl_BanHang.getRowCount()<=0){
            JOptionPane.showMessageDialog(tbl_BanHang, "Bạn chưa chọn sản phẩm để thanh toán");
            return false;
        }
        //kiem tra tien khach dua co nho hon tien thanh toan khong
        String tienPhaiTra = lbl_TienPhaiTra.getText();
        String tienKhachDua = txt_TienDua.getText();
        if( changeMoney(tienKhachDua) - changeMoney(tienPhaiTra) < 0){
            JOptionPane.showMessageDialog(tbl_BanHang, "Tiền khách đưa nhỏ hơn tiền cần thanh toán");
            return false;
        }
        
        //neu chua chon khach hang
        else if(lbl_TenKh.getText().length()==0){
             JOptionPane.showMessageDialog(tbl_BanHang, "Chưa nhập thông tin khách hàng!!");
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
         txt_TienDua.setText("");
         lbl_TienThua.setText("0");
         dfbh_model.setRowCount(0);
          lbl_TenKh.setText("");
               lbl_maKh.setText("");
               lbl_SDT.setText("");
              txt_Search_KH.setVisible(true);
              btn_AddKh.setVisible(true);
              txt_Ghichu.setText("Nhập ghi chú");
              txt_Search_KH.setText("Thêm Khách Hàng Vào Đơn");
    }

    
  
                
}
