/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhaCC;
import java.util.ArrayList;
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
public class NhaCCDao {
  private  ArrayList<NhaCC> listNCC;
   private NhaCC ncc;
   
    public NhaCCDao() {
        listNCC = new ArrayList<NhaCC>();
        ncc = new NhaCC();
    }
    /**
    *
    * @param  no
    * @return arrList dsNCC
    */
	public ArrayList<NhaCC> getDsNcc(){
		try {
			java.sql.Connection con = connect.getInstance().getConnection();
                        String sql = "select * from NhaCC";
				
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNCC = rs.getString(1);
				
                                String tenNCC = rs.getString(2);
                                 String sdt = rs.getString(3);
                                  String mail = rs.getString(4);
                                   String diaChi = rs.getString(5);

                                NhaCC nhaCungCap = new NhaCC(maNCC, tenNCC, sdt, mail, diaChi);
                                
                                
                                
                                listNCC.add(nhaCungCap);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi day");
			// TODO: handle exception
		}
		return listNCC;
	}
         //update 1 NCC
                        
        public  boolean updateNCC(NhaCC ncc){
            int n = 0;
            java.sql.Connection con = connect.getInstance().getConnection();
			
            PreparedStatement stmt = null;
            try {
		
                stmt = con.prepareStatement("UPDATE NhaCC SET TenNCC = ?, SDT = ?,Mail = ?, DiaChi = ?  WHERE MaNCC = ?");
		
		stmt.setString(1, ncc.getTenNCC());
		stmt.setString(2, ncc.getSdt());
		stmt.setString(3, ncc.getMail());
                stmt.setString(4, ncc.getDiaChi());
                stmt.setString(5, ncc.getMaNCC());
					
		n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
            return n > 0;
        }
        
                        //them 1 NCC vao database
			public boolean createNCC(NhaCC ncc) {
				java.sql.Connection con = connect.getInstance().getConnection();
			
				PreparedStatement stmt = null;
				int n = 0;
				try {
					stmt = con.prepareStatement("Insert Into NhaCC values(?,?,?,?,?)");
					stmt.setString(1, ncc.getMaNCC());
					stmt.setString(2, ncc.getTenNCC());
					stmt.setString(3, ncc.getSdt());
					stmt.setString(4, ncc.getMail());
                                        stmt.setString(5, ncc.getDiaChi());
					
					n = stmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				return n > 0;
			}
           
                       
                        
                        
}
