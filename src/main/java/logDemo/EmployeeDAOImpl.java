package logDemo;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAOImpl implements EmployeeDao{
    static Connection con;
    static PreparedStatement ps;

    @Override
    public int insertEmployee(Employee e) {
        int status =0;
        try{
            con=MyConnactionProvider.getCon();
            ps =con.prepareStatement("insert into user values(?,?)");
            ps.setString(1, e.getuName());
            ps.setString(2, e.getuPassword());
            status = ps.executeUpdate();
            con.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public Employee getEmployee(String username, String uPassword) {
        Employee emp = new Employee(username, uPassword);
        try{
           con =MyConnactionProvider.getCon();
           ps = con.prepareStatement("select * from customer where userName=? and password=?");
           ps.setString(1, username);
           ps.setString(2, uPassword);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               emp.setuName(rs.getString(1));
               emp.setuPassword(rs.getString(2));

           }

        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
}
