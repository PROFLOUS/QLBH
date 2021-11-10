/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author GMT
 */

//●       MaSP – varchar(30) – Foreign Key
//●       MaHD – varchar(30) – Foreign Key
//●       SoLuong – interger – not null - Không âm ( >= 0)
//●       DonGia – double – not null - Không âm ( >= 0)


public class CT_HoaDonNhap {
    private SanPham sanPham;
    private HoaDonNhap hoaDonNhap;
    private int soLuong;
    private Double donGia;

    public CT_HoaDonNhap() {
    }

    public CT_HoaDonNhap(int soLuong, Double donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public HoaDonNhap getHoaDonNhap() {
        return hoaDonNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

   
    
    
    
}
