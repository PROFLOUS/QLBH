/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
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
/**
 *
 * @author GMT
 */
public class TaiKhoanDao {
    	ArrayList<TaiKhoan> listTK;
	 NhanVienDao nvDao = new NhanVienDao();

    public TaiKhoanDao() {
        listTK = new ArrayList<TaiKhoan>();
      
    }
    
      //dua du lieu tu sql vao aArrayList
	public ArrayList<TaiKhoan> getDsTaiKhoan(){
		try {
			java.sql.Connection con = connect.getInstance().getConnection();
                        String sql = "select * from TaiKhoan";
				
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenTk = rs.getString(1);
                                String matKhau = rs.getString(2);
                                String tenQuyen = rs.getString(3);
                                String trangThai = rs.getString(4);
                                String maNV = rs.getString(5);

                                TaiKhoan tk = new TaiKhoan(matKhau, tenQuyen, trangThai, tenTk);
                                
                                  //set nhan Vien 
                                  NhanVien nv = nvDao.getNVByMaNV(maNV);
                                  tk.setNhanVien(nv);
                                  
                                 
                                
                                listTK.add(tk);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi day");
			// TODO: handle exception
		}
		return listTK;
	}
        
           //update 1 tai khoan
                        
        public  boolean updateTaiKhoan(TaiKhoan tk){
            int n = 0;
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            try {
		
                stmt = con.prepareStatement("UPDATE TaiKhoan SET MatKhau = ?,TenQuyen = ?, TrangThau = ?  WHERE TenTaiKhoan = ?");
		
		stmt.setString(1, tk.getMatKhau());
		stmt.setString(2, tk.getTenQuyen());
		stmt.setString(3, tk.getTrangThai());
                stmt.setString(4, tk.getTenTaiKhoan());
               
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
        }
        
        public boolean deleteTaiKhoan(String tenTK) {
            Connection con = connect.getInstance().getConnection();
            PreparedStatement stmt = null;
            int n = 0;
            try{
                stmt = con.prepareStatement("Delete from TaiKhoan where TenTaiKhoan = ?");
		stmt.setString(1, tenTK);
		n = stmt.executeUpdate();
            }catch(SQLException e) {
                    e.printStackTrace();
            }
                    return n > 0;
            }
        
        
        //tim kiem tai khoan theo username
        public TaiKhoan findTKByUserName(String username){
             TaiKhoan tk = null;
             try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from TaiKhoan where TenTaiKhoan  = '"+username+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenDN = rs.getString(1);
                                String matKhau = rs.getString(2);
				String tenQuyen = rs.getString(3);
                                String TrangThai = rs.getString(4);
                                String maNV = rs.getString(5);
                                  //set nhan Vien 
                                  NhanVien nv = nvDao.getNVByMaNV(maNV);
                                  
                                  
                                  tk = new TaiKhoan(matKhau, tenQuyen, TrangThai, tenDN);
                                  tk.setNhanVien(nv);
                                  
                                
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
               
            
            return tk;
        }
        
        //cap nhat lai trangThai
        public boolean updateTrangThaiByUser(String userName, String trangThai){
             int n = 0;
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            try {
		
                stmt = con.prepareStatement("UPDATE TaiKhoan SET TrangThau = ?  WHERE TenTaiKhoan = ?");
		
		stmt.setString(1,trangThai );
                stmt.setString(2,userName);
               
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
        }
        
         //tim kiem tai khoan theo MaNV
        public TaiKhoan findTKByMaNV(String maNV){
             TaiKhoan tk = null;
             try {
                 
                java.sql.Connection con = connect.getInstance().getConnection();
                String sql = "select * from TaiKhoan where MaNV  = '"+maNV+"' ";
                Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tenDN = rs.getString(1);
                                String matKhau = rs.getString(2);
				String tenQuyen = rs.getString(3);
                                String TrangThai = rs.getString(4);
                                String manv = rs.getString(5);
                                  //set nhan Vien 
                                  NhanVien nv = nvDao.getNVByMaNV(manv);
                                  
                                  
                                  tk = new TaiKhoan(matKhau, tenQuyen, TrangThai, tenDN);
                                  tk.setNhanVien(nv);
                                  
                                
			}
            } catch (Exception e) {
                e.printStackTrace();
            }
               
            
            return tk;
        }
        
          //them 1 taikhoan vao database
			public boolean createTaiKhoan(TaiKhoan tk) {
				java.sql.Connection con = connect.getInstance().getConnection();
			
				PreparedStatement stmt = null;
				int n = 0;
				try {
					stmt = con.prepareStatement("Insert Into TaiKhoan values(?,?,?,?,?)");
					stmt.setString(1, tk.getTenTaiKhoan());
					stmt.setString(2, tk.getMatKhau());
					stmt.setString(3, tk.getTenQuyen());
					stmt.setString(4, tk.getTrangThai());
                                        stmt.setString(5, tk.getNhanVien().getMaNV());
					
					n = stmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				return n > 0;
			}
}
