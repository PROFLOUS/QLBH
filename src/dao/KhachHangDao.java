/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GMT
 */
public class KhachHangDao {
     private ArrayList<KhachHang> listKH;
    private KhachHang khachHang;
    private final Connection con;
    
     public KhachHangDao() {
       listKH = new ArrayList<KhachHang>();
       khachHang = new KhachHang();
       con = connect.getInstance().getConnection();
    }
     
     
     //tim kiesm 1 khach hàng theo maKH
      public KhachHang getKHByMaKH(String maKH){
         KhachHang kh = null;
            try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from KhachHang where MaKH = '"+maKH+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
                                String tenKH = rs.getString(2);
                                String sdt = rs.getString(3);
                                String diaChi = rs.getString(4);
                                kh = new KhachHang(maKhachHang, tenKH, sdt,diaChi);
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
               return kh;

    } 
      
      
      //tìm kím sdt kh
      public List<KhachHang> SearchKh(String text){
            List<KhachHang> list = new ArrayList<>();
            try {
                PreparedStatement stmt = con.prepareStatement("select top 3 * from KhachHang where [SDT] like  ? ");
                
                stmt.setString(1,"%"+text+"%");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
 
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(kh);
            }
            } catch (Exception e) {
            }
            
            return list;
        }
      
      //tìm kím KH bang sdt
      public KhachHang SearchKhBySDT(String sdt){
             KhachHang kh = null;
            try {
                PreparedStatement stmt = con.prepareStatement("select * from KhachHang where [SDT] =  ? ");
                
                stmt.setString(1,sdt);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
 
                 kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3));
               
            }
            } catch (Exception e) {
            }
            
            return kh;
        }
      //them 1 KH vao database
	public boolean createKhachHang(KhachHang kh) {
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            int n = 0;
            try {
		stmt = con.prepareStatement("Insert Into KhachHang values(?,?,?,?)");
		stmt.setString(1, kh.getMaKH());
                stmt.setString(2, kh.getTenKH());
                stmt.setString(3, kh.getSdt());
                stmt.setString(4, kh.getDiaChi());
                

                                        
                 n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
                    return n > 0;
		}
        
        //doc du lieu tu database
      public ArrayList<KhachHang> getAllKh() {
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String Sql = "select * from KhachHang";
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"),rs.getString("SDT"),rs.getString("DiaChi"));
                listKH.add(kh);
            }
        } catch (Exception e) {

        }
        return listKH;
    }
      //tim khach hang theo ma vs ten vs sdt
      public List<KhachHang>SearchMaOrTenOrSdt(String text){
            List<KhachHang> list = new ArrayList<>();
            try {
                java.sql.Connection con = connect.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("select * from KhachHang where [MaKH]='"+text+"' or [SDT] like N'%"+text+"%' or  [TenKH] like N'%"+text+"%'" );
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(kh);
            }
            } catch (Exception e) {
            }
            
            return list;
        }
      
      //tim khach hang theo ma vs ten vs sdt
      public List<KhachHang>SearchMaOrTenOrSdt2(String text){
            List<KhachHang> list = new ArrayList<>();
            try {
                java.sql.Connection con = connect.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement("select top 5 * from KhachHang where [MaKH]='"+text+"' or [SDT] like N'%"+text+"%' or  [TenKH] like N'%"+text+"%'" );
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(kh);
            }
            } catch (Exception e) {
            }
            
            return list;
        }
      
      //xóa khach hang khi biét mã
    public boolean xoaKH(String maKh) {
        int n = 0;
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "delete from KhachHang where MaKH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maKh);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }
    // them khach hang
      public  boolean  themKH(KhachHang kh){
        
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement khAdd = con.prepareStatement("INSERT INTO KhachHang([TenKH],[SDT],[DiaChi])\n" +
"VALUES (?, ?, ?)");
            khAdd.setString(1, kh.getTenKH());
            khAdd.setString(2, kh.getSdt());
            khAdd.setString(3, kh.getDiaChi());

            int n = khAdd.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
      
      //cap nhat khach hang
      public  boolean  updateKH(String maKh, KhachHang kh){
        java.sql.Connection con = connect.getInstance().getConnection();
        String sql = "update KhachHang set TenKh = ? , SDT = ?, DiaChi = ? Where MaKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getMaKH());
            int n = ps.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
      /*
      *Tìm khách hàng mới thêm
      */
      public KhachHang getKhNew(){
             KhachHang kh = null;
            try {
                PreparedStatement stmt = con.prepareStatement("select  top 1 * from [dbo].[KhachHang] \n" +
"order by MaKH desc");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                 kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
               
            }
            } catch (Exception e) {
            }
            
            return kh;
        }
      
      
}
