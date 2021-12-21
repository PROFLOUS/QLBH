package entity;

import java.util.Objects;

/**
 *
 * @author GMT
 */
public class ChucVu {

    private String maCV;
    private String tenCV;
    private double hsLuong;

    public ChucVu() {
    }

    public ChucVu(String maCV, String tenCV, double hsLuong) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.hsLuong = hsLuong;
    }

    public String getMaCV() {
        return maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public double getHsLuong() {
        return hsLuong;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public void setHsLuong(double hsLuong) {
        this.hsLuong = hsLuong;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "maCV=" + maCV + ", tenCV=" + tenCV + ", hsLuong=" + hsLuong + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.maCV);
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
        final ChucVu other = (ChucVu) obj;
        if (!Objects.equals(this.maCV, other.maCV)) {
            return false;
        }
        return true;
    }

}
