/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;


/**
 *
 * @author GMT
 */
//●       MaHD – varchar(30) – PrimaryKey
//●       MaKH – varchar(30) - Foreign Key
//●       MaNV – varchar(30) - Foreign Key
//●       NgayLapHD – date - not null
//●       SoLuongSP – interger – not null - Không âm ( >= 0)
//●       TongTien – double – not null - Không âm ( >= 0)
//●       TienKhachDua – double – not null
//●       GhiChu – varchar(255)

public class HoaDonBanHang {
    private String maHD;
   
    private int soLuong;
    private Double tongTien;
    private Double tienKhachDua;
    private String ghiChu;
    private Double tienKhuyenMai;
    private Date ngayLap;
    private KhachHang khachHang;
    private NhanVien nhanVien;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(String maHD, int soLuong, Double tongTien, Double tienKhachDua, String ghiChu, Double tienKhuyenMai ) {
        this.maHD = maHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.ngayLap = new Date();
        this.tienKhuyenMai = tienKhuyenMai;
    }
    

    public HoaDonBanHang(String maHD,Date ngayLap,  int soLuong, Double tongTien, Double tienKhachDua, String ghiChu, Double KhuyenMai) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        this.tienKhuyenMai = KhuyenMai;
    }
    
      public HoaDonBanHang(String maHD,Date ngayLap,  int soLuong, Double tongTien, Double tienKhachDua, String ghiChu) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
        
    }

    public HoaDonBanHang(int soLuong, Double tongTien) {
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
      

  

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

   

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public void setTienKhachDua(Double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaHD() {
        return maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public Double getTienKhachDua() {
        return tienKhachDua;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    @Override
    public String toString() {
        return "HoaDonBanHang{" + "maHD=" + maHD +  ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", tienKhachDua=" + tienKhachDua + ", ghiChu=" + ghiChu + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + '}';
    }

    public Double getTienKhuyenMai() {
        return tienKhuyenMai;
    }

    public Date getNgayLapHD() {
        return ngayLap;
    }
    
    
}
