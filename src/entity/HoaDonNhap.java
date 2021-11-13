/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author GMT
 * 
 */

//●       MaNV – varchar(30) – Foreign Key
//●       MaNCC – varchar(30) – Foreign Key
//●       MaHDNhap – varchar(30) – Primary Key
//●       NgayLapHD – date – not null
//●       SoLuongSP – interger – not null – Không âm ( >= 0)
//●       TongTien – double – not null - Không âm ( >= 0)
//●       GhiChu – varchar(255)

public class HoaDonNhap {
    
    private String maHDNhap;
    private Date ngayLapHD;
    private int soLuong;
    private Double tongTien;
    private String ghiChu;
    
    
    private NhanVien nhanVien;
    private NhaCC NCC;

    public HoaDonNhap() {
    }

    public HoaDonNhap(String maHDNhap, Date ngayLapHD, int soLuong, Double tongTien, String ghiChu) {
        this.maHDNhap = maHDNhap;
        this.ngayLapHD = ngayLapHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
    }

    public HoaDonNhap(Date ngayLapHD, int soLuong, Double tongTien, String ghiChu, NhanVien nhanVien, NhaCC NCC) {
        this.ngayLapHD = ngayLapHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.nhanVien = nhanVien;
        this.NCC = NCC;
    }

    public HoaDonNhap(String maHDNhap, Date ngayLapHD, int soLuong, Double tongTien, String ghiChu, NhanVien nhanVien, NhaCC NCC) {
        this.maHDNhap = maHDNhap;
        this.ngayLapHD = ngayLapHD;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.nhanVien = nhanVien;
        this.NCC = NCC;
    }
    
    public String getMaHDNhap() {
        return maHDNhap;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public NhaCC getNCC() {
        return NCC;
    }

    public void setMaHDNhap(String maHDNhap) {
        this.maHDNhap = maHDNhap;
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

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setNCC(NhaCC NCC) {
        this.NCC = NCC;
    }

    
    
    
}
