/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import dao.PanelSearch;
import dao.EventClick;
import dao.BanHangDao;
import dao.KhachHangDao;
import entity.KhachHang;
import entity.SanPham;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


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
    private int tong;
    private int r;
   
    
  
    
    
    
    /**
     * Creates new form FrmBanHang
     * @param sp
     * @return 
     */
    
    
    public FrmBanHang() {
        initComponents();
        bhDao = new BanHangDao();
        khDao = new KhachHangDao();
        
        
        dstt = new ArrayList<SanPham>();
        dssp = new  ArrayList<SanPham>();
        SanPham sp = new SanPham();
        
       
        
        
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
            public void itemClick(SanPham data) {
               
                dfbh_model = (DefaultTableModel) tbl_BanHang.getModel();
                System.out.println("Click" +data.getTenSP());
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
            public void itemClick(KhachHang data) {
               String maKh = data.getMaKH();
               String tenKh = data.getTenKH();
               String sDT = data.getSdt();
               
               lbl_TenKh.setText(tenKh);
               lbl_maKh.setText(maKh);
               lbl_SDT.setText(sDT);
               menu2.setVisible(false);
               lbl_XoaKh.setEnabled(true);
//               txt_Search_KH.setEnabled(false);
               txt_Search_KH.setVisible(false);

            }
        });
        
        
        
    }
    public void getTex(String vl){
        lbl_TenKh.setText(vl);
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
        DecimalFormat x = new DecimalFormat("###,###,###");
        tong =0;
        for( int i = 0;i<tbl_BanHang.getRowCount();i++){
            tong += Double.parseDouble( tbl_BanHang.getValueAt(i, 5).toString());
        }
        System.out.println("tong"+tong);
        lbl_TongTien.setText(x.format(tong));
        lbl_TienPhaiTra.setText(x.format(tong));
//        lbl_TongTien.setText(String.valueOf(tong));
//        lbl_TienPhaiTra.setText(String.valueOf(tong));
        
        
    }
    //tính tiền thừ
    public void TinhTienThua(){
        DecimalFormat x = new DecimalFormat("###,###,###");
        double d = 3.76628729;
        double tienThua = 0;
        double tienTra = tong;
        double tienDua = Double.valueOf(txt_TienDua.getText().toString());
        
        tienThua = tienDua-tienTra;
        System.out.println("tienthua"+tienThua);
        lbl_TienThua.setText(x.format(tienThua));
    }
    //ẩn các nút chức năng
    public void Hide(){
        btn_XoaMatHang.setVisible(false);
        lbl_TextSL.setVisible(false);
        lbl_GiamSL.setVisible(false);
        lbl_TangSL.setVisible(false);
        
        txt_SuaSL.setVisible(false);
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
        btn_ThanhToan = new javax.swing.JButton();
        txt_TienDua = new javax.swing.JTextField();
        lbl_SDT = new javax.swing.JLabel();
        lbl_Ket = new javax.swing.JLabel();
        lbl_XoaKh = new javax.swing.JLabel();
        lbl_maKh = new javax.swing.JLabel();
        lbl_TenKh1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_TienDua1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        pnl_tab_Form_BangHang.setBackground(new java.awt.Color(102, 153, 255));
        pnl_tab_Form_BangHang.setPreferredSize(new java.awt.Dimension(1090, 720));
        pnl_tab_Form_BangHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_ThanhToan.setBackground(new java.awt.Color(255, 255, 255));
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

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/pencil1.png"))); // NOI18N
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btn_ThanhToan.setBackground(new java.awt.Color(102, 153, 255));
        btn_ThanhToan.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
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

        txt_TienDua1.setBackground(new java.awt.Color(255, 255, 255));
        txt_TienDua1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txt_TienDua1.setForeground(new java.awt.Color(0, 0, 0));
        txt_TienDua1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_TienDua1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 153, 255)));
        txt_TienDua1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_TienDua1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_TienDua1FocusLost(evt);
            }
        });
        txt_TienDua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TienDua1MouseClicked(evt);
            }
        });
        txt_TienDua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TienDua1ActionPerformed(evt);
            }
        });
        txt_TienDua1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TienDua1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TienDua1KeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVSicon/add-user.png"))); // NOI18N
        jLabel2.setToolTipText("Thêm Khách Hàng Mới");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_ThanhToanLayout = new javax.swing.GroupLayout(pnl_ThanhToan);
        pnl_ThanhToan.setLayout(pnl_ThanhToanLayout);
        pnl_ThanhToanLayout.setHorizontalGroup(
            pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                        .addComponent(lbl_TenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_Ket, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbl_TenKh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_XoaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 28, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_maKh, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txt_Search_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThanhToanLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(lbl_TienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThanhToanLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_TienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14))
                        .addGap(177, 177, 177)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TienDua1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnl_ThanhToanLayout.setVerticalGroup(
            pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Search_KH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TienDua1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_TenKh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                    .addComponent(lbl_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_Ket, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_TenKh1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_XoaKh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThanhToanLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbl_maKh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_TienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThanhToanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pnl_ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ThanhToanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pnl_tab_Form_BangHang.add(pnl_ThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 350, 1080, 310));

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

        tbl_BanHang.setBackground(new java.awt.Color(51, 51, 51));
        tbl_BanHang.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        tbl_BanHang.setForeground(new java.awt.Color(0, 0, 0));
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
        tbl_BanHang.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_BanHang.setRowHeight(30);
        tbl_BanHang.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tbl_BanHang.setSelectionForeground(new java.awt.Color(255, 255, 255));
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
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
        search.setDataSP(bhDao.SearchSp(text));
        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu.show(txt_Search_SP, 0, txt_Search_SP.getHeight());
            //            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
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
                
            
        }
        
    }//GEN-LAST:event_tbl_BanHangMouseClicked

    private void txt_TienDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienDuaKeyReleased
       
//        String sByr = txt_TienDua.getText().toString();
//        double dblByr = Double.parseDouble(sByr);
//        DecimalFormat df = new DecimalFormat("### ### ###");
//        txt_TienDua.setText(df.format(dblByr));
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

    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
       
        System.out.println("ok");
        
        
       
        
    }//GEN-LAST:event_btn_ThanhToanMouseClicked

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
               
              
    }//GEN-LAST:event_lbl_XoaKhMouseClicked

    private void txt_TienDuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienDuaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDuaFocusLost

    private void txt_TienDuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienDuaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDuaFocusGained

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
        minus = sl-1; 
        
        txt_SuaSL.setText(String.valueOf(minus));
        tbl_BanHang.setValueAt(minus, r, 3);
        double donGia = Double.parseDouble( tbl_BanHang.getValueAt(r, 4).toString());
        tbl_BanHang.setValueAt(minus * donGia, r, 5);
        lbl_GiamSL.setEnabled(true);
        TinhTong();
        }
    }//GEN-LAST:event_lbl_GiamSLMouseClicked

    private void lbl_TangSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TangSLMouseClicked
        int plus = 0;
        int sl = Integer.parseInt(txt_SuaSL.getText().toString());
        plus = sl+1; 
        txt_SuaSL.setText(String.valueOf(plus));
        tbl_BanHang.setValueAt(plus, r, 3);
        lbl_GiamSL.setEnabled(true);
        double donGia = Double.parseDouble( tbl_BanHang.getValueAt(r, 4).toString());
        tbl_BanHang.setValueAt(plus * donGia, r, 5);
        TinhTong();
    }//GEN-LAST:event_lbl_TangSLMouseClicked

    private void txt_TienDua1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienDua1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDua1FocusGained

    private void txt_TienDua1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienDua1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDua1FocusLost

    private void txt_TienDua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TienDua1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDua1MouseClicked

    private void txt_TienDua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TienDua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDua1ActionPerformed

    private void txt_TienDua1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienDua1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDua1KeyReleased

    private void txt_TienDua1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienDua1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienDua1KeyTyped

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       new FrmThemKh().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_XoaMatHang;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_GiamSL;
    private javax.swing.JLabel lbl_Ket;
    public static javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TangSL;
    public static javax.swing.JLabel lbl_TenKh;
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
    private javax.swing.JTextField txt_Search_KH;
    private javax.swing.JTextField txt_Search_SP;
    private javax.swing.JTextField txt_SuaSL;
    private javax.swing.JTextField txt_TienDua;
    public static javax.swing.JTextField txt_TienDua1;
    // End of variables declaration//GEN-END:variables
}
