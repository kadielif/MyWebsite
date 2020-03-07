
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
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

public class rapor {

    public ResultSet getAddress() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT MARKA,COUNT(MARKA) AS SAYI FROM ARACBILGILERI WHERE id IN (SELECT id FROM kirala )GROUP BY MARKA  ORDER BY SAYI");

            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }

    public ResultSet getAdd() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT M.ad,M.soyad FROM MUSTERI M INNER JOIN KIRALA K ON M.TC=K.TC \n"
                    + "    WHERE K.MARKA='Audi' ");

            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }

    public ResultSet getAd() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT M.ad,M.soyad FROM MUSTERI M INNER JOIN KIRALA K ON M.TC=K.TC \n"
                    + "    WHERE K.MARKA='BMW' ");

            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }

    public ResultSet getAd1() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT K.MUSTERI_ADI,A.MARKA, A.MODEL FROM ARACBILGILERI A \n" +
"	LEFT JOIN KIRALA K ON A.ID=K.ID\n" +
"	WHERE A.FIYAT IN (SELECT MAX(FIYAT) FROM ARACBILGILERI )");

            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }
     public ResultSet getAd2() throws SQLException {
        String url = "jdbc:derby://localhost:1527/carDb";
        String user = "carDb";
        String password = "carDb";
        Connection con = DriverManager.getConnection(url, user, password);
        if (con == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            PreparedStatement ps = con.prepareStatement("SELECT A.MARKA,A.MODEL,A.PLAKA FROM BAKIM B\n" +
"	 RIGHT JOIN ARACBILGILERI A \n" +
"		ON A.ID=B.ARACID WHERE BAKIM=FALSE");

            CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
            rs.populate(ps.executeQuery());
            return rs;
        } finally {
            con.close();

        }
    }

}
