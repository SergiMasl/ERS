package com.rev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Profile extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
      //  req.getRequestDispatcher("nav.html").include(req, res);
        String name= req.getParameter("username");

        out.println(" <link rel='stylesheet' href='adminHome.css'>");
        out.println("<div class='prof-contener'>");
      //  out.println("Welcome "+ name);
        out.println("<h1 style = 'color: white'> Welcome "+ name +  "</h1>");

        out.println("<div class='prof-wrap-main'>");
        // out.println("<div class='prof_right'>");
        out.println("<div class='prof-wrap'>");

        out.println("<div class='prof_right'>");

        out.println("</br>");
        out.println("</br>" +
        "    <form action='com.rev.LogOut' method='get'>" +
                "       <input type='submit' value='Logout' />" +
                "    </form>");
      //  out.println("<a href='com.rev.LogOut'>Logout</a>");
        out.println("    <form action='addReimbure.html' method='post'>" +
                "       <input type='submit' value='Add Reimbursement' />" +
                "    </form>");
       // out.println(" <a href='addReimbure.html'>Add Reimbursement</a>");
        out.println("<form action='com.rev.AllReimbursement' method='post'>" +
                "<input type='submit' value='Look your Reimbursement'/>" +
                "</form>");

        out.println("<form action='com.rev.MyProfile' method='post'>");
        out.println("<input type='hidden' name='uname' value='" + name + "' />");
        out.println("<input type='submit' value='View My profile' />");
        out.println("</form>");

    }
}
