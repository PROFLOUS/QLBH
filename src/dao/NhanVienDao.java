/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.HoaDonBanHang;
import entity.NhanVien;
import java.awt.List;
import Connect.connect;
import java.awt.List;
import  entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author GMT
 */
public class NhanVienDao {
    private ArrayList<NhanVien> listNV;
    private NhanVien nhanVien;
	

    public NhanVienDao() {
       listNV = new ArrayList<NhanVien>();
       nhanVien = new NhanVien();
    }
	
    //lay thong tin nhan vien theo ma
    //Công việc chưa lấy ra
    /*
        @param maNV String
        return nhanVien NhanVien
    */
    public NhanVien getNVByMaNV(String maNV){
         NhanVien nv = null;
            try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from NhanVien where MaNV = '"+maNV+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNhanVien = rs.getString(1);
                                String tenNV = rs.getString(2);
                                String sdt = rs.getString(3);
                                 Date ngaySinh = rs.getDate(4);
                                 String diaChi = rs.getString(5);
                                 Date ngayVaoLam = rs.getDate(6);
                                 String tinhTrang = rs.getString(7);
                                 String maCV = rs.getString(8);
                                 nv = new NhanVien(maNV, tenNV, sdt, diaChi, ngaySinh, ngayVaoLam, tinhTrang);
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
               return nv;
    } 
    
    //dọc dữ liệu lên bảng
    public ArrayList<NhanVien>getAllNV(){
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from NhanVien";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                ChucVuDao cv_dao = new ChucVuDao();
                ChucVu cv = cv_dao.getCVByMaCV(rs.getString("MaCV"));
                NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("TenNV"), rs.getString("SDT"),rs.getString("DiaChi"), rs.getDate("NgaySinh"), rs.getDate("NgayVaoLam"), rs.getString("TinhTrang"));
                nv.setChucVu(cv);
                listNV.add(nv);
            }
        } catch (Exception e) {
        }
        return listNV;
    }
    
    
     public NhanVien getNVByMaTrangThai(String trangThai){
         NhanVien nv = null;
            try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from NhanVien where TRangThai = '"+trangThai+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNhanVien = rs.getString(1);
                                String tenNV = rs.getString(2);
                                String sdt = rs.getString(3);
                                 Date ngaySinh = rs.getDate(4);
                                 String diaChi = rs.getString(5);
                                 Date ngayVaoLam = rs.getDate(6);
                                 String tinhTrang = rs.getString(7);
                                 String maCV = rs.getString(8);
                                 ChucVuDao cv_dao = new ChucVuDao();
                ChucVu cv = cv_dao.getCVByMaCV(maCV);
                                 nv = new NhanVien(maNhanVien, tenNV, sdt, diaChi, ngaySinh, ngayVaoLam, tinhTrang);
                                 nv.setChucVu(cv);
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
               return nv;
    } 
     
     //tìm nhân viên biết mã, tên ,sdt 
    public java.util.List<NhanVien>SearchMaOrTenOrSdt(String text){
            java.util.List<NhanVien> list = new ArrayList<>();
            try {
                java.sql.Connection con = connect.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("select * from NhanVien where [MaNV]='"+text+"' or [SDT] like N'%"+text+"%' or  [TenNV] like N'%"+text+"%'" );
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                ChucVuDao cv_dao = new ChucVuDao();
                ChucVu cv = cv_dao.getCVByMaCV(rs.getString(8));
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(5),
                        rs.getDate(4), rs.getDate(6), cv);
           
                list.add(nv);
            }
            } catch (Exception e) {
            }
            
            return list;
        }
    
    //xóa nhan vien khi biét mã
    public boolean xoaNV(String maNV) {
        int n = 0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "delete from NhanVien where MaNV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }
}
