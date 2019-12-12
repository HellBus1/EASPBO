package connection_utils;

import com.mysql.jdbc.Connection;

import javax.swing.*;
import java.sql.DriverManager;

public class ConnectionUtils {
    Connection connection = null;

    public static Connection createConnect(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javafxeas","root","");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
