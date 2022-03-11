package com.rev.admin;

import com.rev.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewCertainRei extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("updateID");

    //    request.getRequestDispatcher("navbar.html").include(request, response);

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        out.println("<h1>"+userName+"</h1>");
        out.println("<br/>");
        List<User> employeeList = (List<User>)session.createQuery("from User u where u.userName='" + userName + "'", User.class).list();

        for(User e : employeeList) {
            out.println("Name: " + e.getname() + "<br>");
            out.println("Address: " + e.getadress() + "<br>");
            out.println("Phone Number: " + e.getphone() + "<br>");
            out.println("Position: " + e.getrole() + "<br>");
            out.println("Username:" + e.getuserName() + "<br>");
        }

        out.println("<form></form>");
        out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='approve' value='approve'><input type='hidden' name='uname' value='"+userName+"'> <input type='submit' value='View Approved of this user'></form>");
        out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='disapprove' value='disapprove'><input type='hidden' name='uname' value='"+userName+"'> <input type='submit' value='View Disapproved of this user'></form>");
        out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='pending' value='pending'><input type='hidden' name='uname' value='"+userName+"'> <input type='submit' value='View Pending of this user'></form>");
        out.println("<form action='com.rev.admin.CheckTransIndivid' method='post'> <input type='hidden' name='all' value='all'><input type='hidden' name='uname' value='"+userName+"'> <input type='submit' value='View All of this user'></form>");

        session.close();
    }
}
