
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@ManagedBean(name = "kayitCek3", eager = true)
@RequestScoped
public class kayitCek3 {
    String musteri_adi;

    public String getMusteri_adi() {
        return musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
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
            PreparedStatement ps = con.prepareStatement("SELECT id,marka,plaka,fiyat,yakit,detay,model FROM aracbilgileri ");
          
            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }

    public String sil(String id) throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {

            String query = "DELETE FROM aracbilgileri WHERE model=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            int i = ps.executeUpdate();
            ps.close();
            if (i > 0) {

               return "/admin.xhtml";


            }
            con.close();
            
        } finally {
            con.close();

        }
       return "/admin.xhtml";
    }
    
    

}
