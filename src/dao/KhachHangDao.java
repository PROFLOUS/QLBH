/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                                
                                kh = new KhachHang(maKH, tenKH, sdt);
                                
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
}
