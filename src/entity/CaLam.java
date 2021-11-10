/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author GMT
 */

//●       MaCa – varchar(30) – Primary Key
//●       MaNV – varchar(30) - Foreign Key
//●       NgayLam – date
//●       Buoi – varchar(25)
//      (ca sáng : 8h - 3h - ca chiều( 2h - 9h)

public class CaLam {
    private String maCa;
    private NhanVien NV;
    private String buoi;

    public CaLam() {
    }

    public CaLam(String maCa, NhanVien NV, String buoi) {
        this.maCa = maCa;
        this.NV = NV;
        this.buoi = buoi;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public NhanVien getNV() {
        return NV;
    }

    public void setNV(NhanVien NV) {
        this.NV = NV;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    @Override
    public String toString() {
        return "CaLam{" + "maCa=" + maCa + ", NV=" + NV + ", buoi=" + buoi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maCa);
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
        final CaLam other = (CaLam) obj;
        if (!Objects.equals(this.maCa, other.maCa)) {
            return false;
        }
        return true;
    }

    

   
    
}
