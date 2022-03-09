package logDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnactionProvider implements MyProvider {

    static Connection con = null;
    public static Connection getCon() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(connUrl, username, uPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
