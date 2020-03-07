
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author E. KADI
 */
@Named(value = "arac")
@RequestScoped
public class arac {

    private int id;
    private String marka;
    private String model;
    private String plaka;
    private String yakit;
    private int fiyat;
    private String detay;
    private int stok;

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getYakit() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String ekle() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/carDb", "carDb", "carDb");
        ps = con.prepareStatement("INSERT INTO aracbilgileri values(?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, marka);
        ps.setString(3, plaka);
        ps.setInt(4, fiyat);
        ps.setString(5, yakit);
        ps.setString(6, detay);
        ps.setString(7, model);
        ps.setInt(8, stok);
        int sonuc = ps.executeUpdate();
        if (sonuc == 1) {
            return "/admin.xhtml";
        }

        return "/admin.xhtml";

    }

    public String guncelle() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/carDb", "carDb", "carDb");
        ps = con.prepareStatement("UPDATE aracbilgileri SET detay=?, stok=?, fiyat=? WHERE id=?");
        ps.setInt(2, stok);
        ps.setString(1, detay);
        ps.setInt(3, fiyat);
        ps.setInt(4, id);

        int sonuc = ps.executeUpdate();
        if (sonuc == 1) {
            return "/index.xhtml";
        }

        return "/admin.xhtml";
    }

}
