package com.rev;

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

public class AllReimbursement extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        List<User> userList = (List<User>) session.createQuery("from com.rev.User", User.class).list();

        for(User u: userList){
            out.println("<tr>");
            out.println("<td>"+ u.getAmount() + "</td>");
            out.println("<td>"+ u.getDate() + "</td>");
            out.println("<td>"+ u.getNote() + "</td>");
            out.println("</tr>");
        }



        session.close();
    }
}
