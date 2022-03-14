package com.rev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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
    String uname;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        System.out.println("project started...");
        Configuration conf = new Configuration();
        conf.configure("hibernate2.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Cookie[] cookies =  req.getCookies();
        if(cookies!=null){
            uname = cookies[0].getValue();
        }

        List<UserTransactionsObj> tList = (List<UserTransactionsObj>) session.createQuery("from UserTransactionsObj u where u.userName='" + uname + "'", UserTransactionsObj.class).list();

        out.println("<h4> All Reimbursements </h4>");
        for(UserTransactionsObj u: tList){
            out.println("<tr>");
            out.println("<td>" + "Amount: " + u.getAmount() + "<br>" + "</td>");
            out.println("<td>" + "Date: " + u.getDate() + "<br>" + "</td>");
            out.println("<td>" + "Status: " + u.getisAprove() + "<br>" + "</td>");
            out.println("<td>" + "Employee Note: " + u.getNote() + "<br>" + "</td>");
            out.println("<br>  </tr>");
        }

        out.println("</br>");
        out.println("<a href='com.rev.transactins.Pending'>View Pending</a>");
        out.println("</br>");
        out.println("<a href='com.rev.transactins.Approve'>View Approved</a>");
        out.println("</br>");
        out.println("<a href='com.rev.transactins.Disprove'>View Disprove</a>");
        out.println("</br>");
        out.println("</br>");

        out.println("<form action='com.rev.Profile' method='post'><input type='submit' value='Back'>");

        session.close();
    }
}
