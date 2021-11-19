/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author GMT
 * 
 */
//
//●       MaNV - varchar(30) - Primary Key
//●       TenNV - varchar(255) - not null
//●       SDT - varchar(255)
//●       NgaySinh – date
//●       DiaChi  - varchar(255)
//●       NgayVaoLam – date – trong khoảng từ năm 2020 đến thời điểm hiện tại
//●       TinhTrang  - varchar(255) - not null
 

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String sdt;
    private String diaChi;
    private Date ngaySinh;
    private Date ngayVaoLam;
    private String tinhTrang;
    private String trangThai;
    
    private ChucVu chucVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String trangThai, ChucVu chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
    }

//    public NhanVien(String maNV, String tenNV, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String tinhTrang) {
//        this.maNV = maNV;
//        this.tenNV = tenNV;
//        this.sdt = sdt;
//        this.diaChi = diaChi;
//        this.ngaySinh = ngaySinh;
//        this.ngayVaoLam = ngayVaoLam;
//        this.tinhTrang = tinhTrang;
//    }
    public NhanVien(String maNV, String tenNV, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, ChucVu chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.chucVu = chucVu;
    }

    public NhanVien(String maNV, String tenNV, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.trangThai = trangThai;
    }
    

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", sdt=" + sdt + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", tinhTrang=" + tinhTrang + ", chucVu=" + chucVu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.maNV);
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
        final NhanVien other = (NhanVien) obj;
        if (!Objects.equals(this.maNV, other.maNV)) {
            return false;
        }
        return true;
    }

    
    
      
}
