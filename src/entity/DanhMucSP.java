/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author GMT
 */
public class DanhMucSP {
       private String maloai;
       private String tenLoai;
       
       public DanhMucSP(){
           
       }

    public DanhMucSP(String maloai, String tenLoai) {
        this.maloai = maloai;
        this.tenLoai = tenLoai;
    }

    public DanhMucSP(String maloai) {
        this.maloai = maloai;
    }
    

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.maloai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DanhMucSP other = (DanhMucSP) obj;
        if (!Objects.equals(this.maloai, other.maloai)) {
            return false;
        }
        return true;
    }
    
       
}
