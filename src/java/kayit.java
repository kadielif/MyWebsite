
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
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

@Named(value="kayit")
@RequestScoped
//@SessionScoped
public class kayit {

    private String tc;
    private String ad;
    private String soyad;
    private String sifre;
    private String mail;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String kaydet() throws SQLException {
        Connection baglanti = null;
        PreparedStatement statement = null;
        baglanti = DriverManager.getConnection("jdbc:derby://localhost:1527/carDb", "carDb", "carDb");
        statement = baglanti.prepareStatement("INSERT INTO musteri values(?,?,?,?,?)");
        statement.setString(1, tc);
        statement.setString(2, ad);
        statement.setString(3, soyad);
        statement.setString(4, mail);
        statement.setString(5, sifre);
        int sonuc=statement.executeUpdate();
        if(sonuc==1)
        {
            return "/giris.xhtml";
        }
            
        return "/kayit.xhtml";
        
        
    }

}
