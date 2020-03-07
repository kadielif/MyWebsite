
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.rowset.CachedRowSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author E. KADI
 */

@ManagedBean
@RequestScoped

public class profil extends giris {

    String tc;
    String ad;
    String soyad;
    String mail;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ResultSet getAddress() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            // sql cümlesi yazmak için PreparedStatement oluşturmalıyız.    
            // create a PreparedStatement to select the records
            PreparedStatement object1 = con.prepareStatement("SELECT tc,ad,soyad,mail FROM  musteri WHERE tc = ?");
            object1.setString(1, giris.tc);
            CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
            resultSet1.populate(object1.executeQuery());
            return resultSet1;
        } // end try
        finally {
            con.close(); // return this connection to pool
        } // end finally

    }
    
        public ResultSet getAddresses() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT k.MARKA,k.MODEL,k.YAKIT,k.SAAT, a.PLAKA  FROM aracbilgileri a INNER JOIN kirala k ON a.ID=k.ID WHERE k.MUSTERI_ADI='Elif' ");
         
            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }


}
