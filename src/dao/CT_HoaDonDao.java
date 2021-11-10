/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connect.connect;
import entity.CT_HDBanHang;
import entity.HoaDonBanHang;
import entity.SanPham;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GMT
 */
public class CT_HoaDonDao {
       	ArrayList<CT_HDBanHang> listCTHD;
	CT_HDBanHang cthd;
        HoaDonDao hoaDonDao = new HoaDonDao();
        SanPhamDao sanPhamDao = new SanPhamDao();
        
        
        
    public CT_HoaDonDao() {
        listCTHD = new ArrayList<CT_HDBanHang>();
        cthd = new CT_HDBanHang();
    }
    
    //query theo ma HoaDon
    /*
        @param maHD String
        return ArrayList CT_HoaDon
    */
    public ArrayList<CT_HDBanHang> getCTHoadDonByMaHD(String maHD){
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "select * from CT_HoaDonBanHang where MaHD = '"+maHD+"' ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
		int soLuong = rs.getInt(1);
                Double donGia = rs.getDouble(2);
                String maHoaDon = rs.getString(3);
                String maSP = rs.getString(4);

                CT_HDBanHang ctHD = new CT_HDBanHang(soLuong, donGia);
                
                
                HoaDonBanHang hoaDon = hoaDonDao.findHDByMaHD(maHoaDon);
                ctHD.setHoaDon(hoaDon);
                
                
                SanPham sp = sanPhamDao.findSPByMaSP(maSP);
                ctHD.setSanPham(sp);
                
                 listCTHD.add(ctHD);
        }
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return listCTHD;
    }
	


}
