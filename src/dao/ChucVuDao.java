/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import Connect.connect;
import entity.ChucVu;
import entity.DanhMucSP;
import entity.NhanVien;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GMT
 */
public class ChucVuDao {
    private ArrayList<ChucVu> listCV;
    private ChucVu cv;

    public ChucVuDao() {
        listCV = new ArrayList<ChucVu>();
        cv = new ChucVu();
    }
    
    //tìm chức vụ biết mã
    public ChucVu getCVByMaCV(String maCV){
         ChucVu cv = null;
            try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from ChucVu where MaCV = '"+maCV+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maCv = rs.getString(1);
                                String tenCv = rs.getString(2);
                                float hsLuong = rs.getFloat(3);
                                cv = new ChucVu(maCv, tenCv, hsLuong);
                               //  nv = new NhanVien(maNV, tenNV, sdt, diaChi, ngaySinh, ngayVaoLam, tinhTrang);
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
               return cv;
    }
    //tìm chức vụ theo tên
    public ChucVu getCVByTen(String tenCV){
        ChucVu cv = null;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "Select * from ChucVu where TenCV =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenCV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cv = new ChucVu(rs.getString("MaCV"),rs.getString("TenCV") , rs.getDouble("HSLuong"));
                
            }
        } catch (Exception e) {
            
            System.out.println("loi");
            e.printStackTrace();
        }
        return cv;
    }
    //dọc du liệu từ database
    public ArrayList<ChucVu> getAllCV() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from ChucVu";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString("MaCV"), rs.getString("TenCV"), rs.getDouble("HSLuong"));
                listCV.add(cv);
            }
        } catch (Exception e) {
        }
        return listCV;
    }
    
}
