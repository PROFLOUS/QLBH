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
    private Date ngayLapHD;
    private int soLuong;
    private Double tongTien;
    private Double tienKhachDua;
    private String ghiChu;
    
    
    private KhachHang khachHang;
    private NhanVien nhanVien;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(String maHD, Date ngayLapHD, int soLuong, Double tongTien, Double tienKhachDua, String ghiChu) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.ghiChu = ghiChu;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
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

    public Date getNgayLapHD() {
        return ngayLapHD;
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
    
    
}
