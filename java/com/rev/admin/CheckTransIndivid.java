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


        out.println("<h1>Checking Certain Employee</h1>");
        for(UserTransactionsObj e : employeeList){
            out.println();


            out.println(" <link rel='stylesheet' href='adminHome.css'>");
            out.println("<div class='prof-contener'>");
            out.println("<div class='prof-wrap-main'>");

            out.println("<div class='prof-wrap'>");

            out.println("<div class='prof_right'>");

            // out.println("<h3>My profile</h3>");
            out.println("<div class='user-info-contener'>");
            out.println("<div class='user-infoblock green'>");
            //out.println("<div class='prof_svg svg_user'></div>");
            out.println("<p class='userName'>Request ID: </p>");
            out.println("   <p class='info'> "+ e.getId()+"</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock blue'>");
            //out.println("   <div class='prof_svg svg_adress'></div>");
            out.println("   <p class='userName'>Username: </p>");
            out.println("   <p class='info'> "+ e.getUserName() + "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            // out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Amount: </p>");
            out.println("   <p class='info'> $" + e.getAmount() + "</p>");
            out.println("</div>");
            //out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Date: </p>");
            out.println("   <p class='info'> " + e.getDate() + "</p>");
            out.println("</div>");
            //out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            // out.println("   <div class='prof_svg svg_mail'></div>");
            out.println("   <p class='userName'>Status: </p>");
            out.println("   <p class='info'> " + e.getisAprove() + "</p>");
            out.println("</div>");
            // out.println("</div>");
            out.println("<div class='user-infoblock yellow'>");
            //out.println("   <div class='prof_svg svg_phone'></div>");
            out.println("   <p class='userName'>Employee Note: </p>");
            out.println("   <p class='info'> " + e.getNote() + "</p>");
            out.println("</div>");
            out.println("<div class='user-infoblock red'>");
            //out.println("   <div class='prof_svg email'></div>");
            out.println("   <p class='userName'>Admin Note: </p>");
            out.println("   <p class='info'> "+  e.getAdminNote() +"</p>");
            out.println("</div>");
            out.println("</div></div></div></div></div></div>");
        }

        session.close();

    }
}

