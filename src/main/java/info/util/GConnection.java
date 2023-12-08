/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package info.util;

import info.model.Eintrag;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author Schulung
 */
public class GConnection {

    /**
     * Holt eine Datenbankverbindung.
     *
     * @return SQL Connection oder null wenn Fehler.
     */
    public Connection getConnection() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/gaestebuch");
           // Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connectionds.getConnection();
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestbook", "zhanfei", "zhanfei");
           
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
            Logger.getLogger(Eintrag.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
