
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@ManagedBean(name="onkayit",eager=true)
@SessionScoped

public class kiralama {

    private int id;
    private String musteri_adi;
    private String marka;
    private String model;
    private String yakit;
    private String tc;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
    private int saat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusteri_adi() {
        return musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
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

    public String getYakit() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public String kirala() throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
         PreparedStatement ps2 = null;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/carDb", "carDb", "carDb");
        ps = con.prepareStatement("INSERT INTO kirala values(?,?,?,?,?,?,?)");
       
        ps.setInt(1, id);
        ps.setString(2, musteri_adi);
        ps.setString(3, marka);
        ps.setString(4, model);
        ps.setString(5, yakit);
        ps.setInt(6, saat);
        ps.setString(7, tc);
        ps2=con.prepareStatement("UPDATE aracbilgileri SET  stok=stok-1 WHERE model='"+model+"'");
        int sonuc2=ps2.executeUpdate();
        int sonuc = ps.executeUpdate();
        ps.close();
        con.close();
        if (sonuc == 1 && sonuc2==1) {
            return "/kirala.xhtml";
        }
        
        return "/kirala.xhtml";

    }
}
