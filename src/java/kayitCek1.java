
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@ManagedBean(name="kayitCek1",eager=true)
@SessionScoped

public class kayitCek1 {
       public ResultSet getAddresses() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT marka,plaka,fiyat,yakit,detay,model FROM aracbilgileri where marka='Audi' and stok!=0");
            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }

    public String kirala() throws SQLException{
        
        return "/kirala.xhtml";
    }
    
}
