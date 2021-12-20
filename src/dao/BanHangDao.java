/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.connect;
import entity.HoaDonBanHang;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class BanHangDao {
        ArrayList<SanPham> listSP;
	   SanPham sanPham;
    private final Connection con;
           
          
           
        public BanHangDao() {
        listSP = new ArrayList<SanPham>();
        sanPham = new SanPham();
         con = connect.getInstance().getConnection();
    }
        
        //tim sam pham
        public List<SanPham> SearchSp(String text){
            List<SanPham> list = new ArrayList<>();
            try {
                PreparedStatement stmt = con.prepareStatement("select top 5 * from SanPham where [TenSP] like  ? ");
                
                stmt.setString(1,"%"+text+"%");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7));
                    
                list.add(sp);
            }
            } catch (Exception e) {
            }
            
            return list;
        }
        
        //tim sam pham theo ma vs ten
        public List<SanPham> SearchMaSpOrTenSp(String text){
            List<SanPham> list = new ArrayList<>();
            try {
                PreparedStatement stmt = con.prepareStatement("select top 4 * from SanPham where [TenSP] like N'%"+text+"%' or [MaSP]='"+text+"' and SoLuong > 0");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7),rs.getDouble(9));
                    
                list.add(sp);
                    
            }
            } catch (Exception e) {
            }
            
            return list;
        }
        
    
}
