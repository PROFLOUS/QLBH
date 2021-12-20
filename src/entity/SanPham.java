/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author GMT
 */
public class SanPham {
    private DanhMucSP dmsp;
    private String maSP;  
    private String tenSP;
    private double donGia;
    private int soLuong;
    private String hinhAnh;
    private String size;
    private String mauSac;
    private double giaNhap;

    public SanPham(){
        
    }

    public SanPham(String maSP) {
        this.maSP = maSP;
    }
    
    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String mauSac) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String hinhAnh, String size, String mauSac) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.mauSac = mauSac;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    

    public SanPham(String maSP, String tenSP, double donGia, String size, String mauSac) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.size = size;
        this.mauSac = mauSac;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String size, String mauSac) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.size = size;
        this.mauSac = mauSac;
    }

    public SanPham(DanhMucSP dmsp, String maSP, String tenSP, double donGia, int soLuong, String hinhAnh, String size, String mauSac) {
        this.dmsp = dmsp;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.mauSac = mauSac;
    }

    public SanPham(DanhMucSP dmsp, String maSP, String tenSP, double donGia, int soLuong, String hinhAnh, String size, String mauSac, double giaNhap) {
        this.dmsp = dmsp;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
    }

    public SanPham(DanhMucSP dmsp, String tenSP, double donGia, String hinhAnh, String size, String mauSac, double giaNhap) {
        this.dmsp = dmsp;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String hinhAnh, String size, String mauSac, double giaNhap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
    }

    public SanPham(DanhMucSP dmsp, String tenSP, double donGia, int soLuong, String hinhAnh, String size, String mauSac, double giaNhap) {
        this.dmsp = dmsp;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
        this.size = size;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String mauSac, double giaNhap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuong, String size, String mauSac, double giaNhap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.size = size;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
    }
    

    

    public DanhMucSP getDmsp() {
        return dmsp;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public String getSize() {
        return size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setDmsp(DanhMucSP dmsp) {
        this.dmsp = dmsp;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.maSP);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPham other = (SanPham) obj;
        if (!Objects.equals(this.maSP, other.maSP)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SanPham{" + "dmsp=" + dmsp + ", maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", soLuong=" + soLuong + ", hinhAnh=" + hinhAnh + ", size=" + size + ", mauSac=" + mauSac + '}';
    }
   
     
}
