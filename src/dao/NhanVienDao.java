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
}
