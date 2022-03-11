package com.rev.admin;

import com.rev.User;
import com.rev.UserTransactionsObj;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class printAllEmployees extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();


//        request.getRequestDispatcher("navbar.html").include(request, response);
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        //List<User> employeeList = session.createQuery("from User", User.class).list();
        List<User> userList = session.createQuery("from User u where u.role='user'", User.class).list();
        out.println("<h1> Employee List</h1>");
        for(User e : userList){
            out.println();
            out.println("Employee Name: " + e.getname() + "<br>");
            out.println( "Position: " + e.getrole() + "<br>");
            out.println("Employee email: " + e.getemail() + "<br>");
            out.println( "Phone Number: " + e.getphone() + "<br>");
            out.println( "Address: " + e.getadress() + "<br>");
            out.println("<br>");
        }

        session.close();

    }
}
