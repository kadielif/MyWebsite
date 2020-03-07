

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.sql.rowset.CachedRowSet;

@ManagedBean(name="hakkimizdaKayitCek",eager=true)
@SessionScoped
public class hakkimizda {
  
    public ResultSet getAddresses() throws SQLException{
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
         try {
            PreparedStatement ps = con.prepareStatement("SELECT yazi FROM hakkimizda");
            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
        
    }
    
    
    

    
}
