
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UpdateServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);
        String updateNumber = request.getParameter("updateNum");
        String updateId = request.getParameter("updateID");
        int upNum=Integer.parseInt(updateNumber);
        int upId = Integer.parseInt(updateId);
        //was working with balance b/c i wanted to see if the code i was doing could actually
        // change the values i wanted

        Configuration config = new Configuration();

        // read the Configuration and load in the object
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Employee> employeeList = (List<Employee>)session.createQuery("from Employee", Employee.class).list();


        // Reading complete Entity

        out.println(upNum);
        out.println(upId);

        //this is gonna be huge so i learned as long as i make the nav reach the
        //html then direct it towards the servlet class it should be able to do the functionality
        String qryString = "update Employee e set e.balance=" + upNum + " where e.id=" + upId;
        Query query = session.createQuery(qryString);
        int count = query.executeUpdate();

        out.println(count + " Record(s) Updated.");

        out.println("Updating with Query Parameters ");

      /*  String qryString2 = "update Student s set s.address='Pune' where s.studentId=?";
        Query query2 = session.createQuery(qryString2);
        query2.setParameter(0, 1);
        query2.executeUpdate();

        int count2 = query2.executeUpdate();

        System.out.println(count2 + " Record(s) Updated.");

        System.out.println("Updating with Named Parameters");*/
        transaction.commit();
        session.clear();
        session.close();
        out.close();
    }
}
