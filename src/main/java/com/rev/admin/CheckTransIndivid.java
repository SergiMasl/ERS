package com.rev.admin;

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

public class CheckTransIndivid extends HttpServlet {
    List<UserTransactionsObj> employeeList;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html");
        PrintWriter out = response.getWriter();

        String approve = request.getParameter("approve");
        String disapprove = request.getParameter("disapprove");
        String pending = request.getParameter("pending");
        String all = request.getParameter("all");
        String uname = request.getParameter("uname");

        Configuration config = new Configuration();
        config.configure("hibernate2.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        

        if(approve != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Approve' and u.userName='"+uname+"'", UserTransactionsObj.class).list();
        } else if(disapprove != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Disapprove' and u.userName='"+uname+"'", UserTransactionsObj.class).list();
        }  else if(pending != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.isAprove='Pending' and u.userName='"+uname+"'", UserTransactionsObj.class).list();
        }else if(all != null){
            employeeList = session.createQuery("from UserTransactionsObj u where u.userName='"+uname+"'", UserTransactionsObj.class).list();
        }



        for(UserTransactionsObj e : employeeList){
            out.println();
            out.println( e.getAmount());
            out.println( e.getDate() );
            out.println( e.getisAprove() );
            out.println( e.getNote() );
            out.println("<br>");
        }

        session.close();

    }
}

