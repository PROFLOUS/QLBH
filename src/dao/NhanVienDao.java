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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.ArrayList;
import java.sql.Date;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialBlob;
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
                                 String trangthai = rs.getString(8);
                                 String maCV = rs.getString(7);

                                 
                                 ChucVuDao chucVuDao = new ChucVuDao();
                                 ChucVu cv = chucVuDao.getCVByMaCV(maCV);
                              
                                 nv = new NhanVien(maNhanVien, tenNV, sdt, diaChi, ngaySinh, ngayVaoLam, trangthai, cv);
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
                NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("TenNV"), rs.getString("SDT"),rs.getString("DiaChi"), rs.getDate("NgaySinh"), rs.getDate("NgayVaoLam"), rs.getString("TrangThai"));
                nv.setChucVu(cv);
                 Blob img = rs.getBlob("img");
                if(img != null){
                nv.setImg(img.getBytes(1, (int)img.length() ));
               }
               // System.out.println(nv.toString() + "\n");
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    
    //cap nhat trang thai dang nhap cua nhanVien
     public  boolean upadateTrangThai(String trangThai,String maNV){
            int n = 0;
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            try {
		
                stmt = con.prepareStatement("UPDATE NhanVien SET TRangThai = ? WHERE MaNV = ?");
		
		stmt.setString(1,trangThai );
		stmt.setString(2,maNV );
		
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
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
                                 String maCV = rs.getString("MaCV");
                                  Blob img = rs.getBlob("img");
                                   
                                 
                                 ChucVuDao cv_dao = new ChucVuDao();
                                  ChucVu cv = cv_dao.getCVByMaCV(maCV);
                                 nv = new NhanVien(maNhanVien, tenNV, sdt, diaChi, ngaySinh, ngayVaoLam, tinhTrang);
                               
                                 nv.setChucVu(cv);
                                  if(img != null){
                                    nv.setImg(img.getBytes(1, (int)img.length() ));
                                   }
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
                ChucVu cv = cv_dao.getCVByMaCV(rs.getString(7));
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(5),
                        rs.getDate(4), rs.getDate(6),rs.getString(8));
                nv.setChucVu(cv);
           
                list.add(nv);
            }
            } catch (Exception e) {
                e.printStackTrace();
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
    

    //them nhan
    public  boolean  themNV(NhanVien nv){
        
        try {
            java.sql.Connection con = connect.getInstance().getConnection();
            PreparedStatement nvAdd = con.prepareStatement("INSERT INTO NhanVien([TenNV],[SDT],[NgaySinh],[DiaChi],[NgayVaoLam],[MaCV],[TrangThai], [img])\n" +
"VALUES ( ? ,?, ?, ?, ?,?, ?, ?)");
            nvAdd.setString(1, nv.getTenNV());
            nvAdd.setString(2,nv.getSdt() );
            nvAdd.setDate(3,nv.getNgaySinh() );
            nvAdd.setString(4,nv.getDiaChi() );
            nvAdd.setDate(5,nv.getNgayVaoLam() );
            nvAdd.setString(6,nv.getChucVu().getMaCV());
            nvAdd.setString(7,nv.getTrangThai() );
           if(nv.getImg() != null){
                   Blob hinh = new SerialBlob(nv.getImg());
                   nvAdd.setBlob(8, hinh);
           }
           else{
               Blob hinh = null;
               nvAdd.setBlob(8, hinh);
           }
            int n = nvAdd.executeUpdate();
            if(n>0){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    //cap nhat
    public boolean updateNV(String maNV, NhanVien nv) {
            java.sql.Connection con = connect.getInstance().getConnection();
            String sql = "update NhanVien set TenNV = ?, SDT = ?, NgaySinh = ?, DiaChi = ? , NgayVaoLam = ? , MaCV = ?, TrangThai = ?, img = ? where MaNV = '"+maNV+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getSdt());
            ps.setDate(3, nv.getNgaySinh());
            ps.setString(4, nv.getDiaChi());
            ps.setString(6, nv.getChucVu().getMaCV());
            ps.setString(7, nv.getTrangThai());
            ps.setDate(5, nv.getNgayVaoLam());
           if(nv.getImg() != null){
                   Blob hinh = new SerialBlob(nv.getImg());
                   ps.setBlob(8, hinh);
           }
           else{
               Blob hinh = null;
               ps.setBlob(8, hinh);
           }
             int n = ps.executeUpdate();
            if(n>0){
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
