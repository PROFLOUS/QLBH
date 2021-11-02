/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author GMT
 */

//     MaNV – varchar(30) – Foreign Key
//       MatKhau – varchar(25) - not null
//       TenQuyen – varchar(255) -  not null
//       TrangThai – varchar(255) -  not null (1 : Khóa - 2:  Hoạt động)

public class TaiKhoan {
    private NhanVien nhanVien;
    private String matKhau;
    private String tenQuyen;
    private String trangThai;

    public TaiKhoan(String matKhau, String tenQuyen, String trangThai) {
        this.matKhau = matKhau;
        this.tenQuyen = tenQuyen;
        this.trangThai = trangThai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

  
    
    
}
