package com.rev.admin;

import com.rev.User;
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

public class ViewCertainByName extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String name = fName +" " + lName;

        //    request.getRequestDispatcher("navbar.html").include(request, response);

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        out.println("<p>"+name+"</p>");
        List<User> employeeList = (List<User>)session.createQuery("from User u where u.name='" + name + "'", User.class).list();

        for(User e : employeeList) {
            out.println(e.getname());
            out.println(e.getadress());
            out.println(e.getphone());
            out.println(e.getrole());
            out.println(e.getuserName());
            session.close();
        }


    }
}