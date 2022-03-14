package com.rev.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AdminHome extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();


        out.println(" <link rel='stylesheet' href='adminHome.css'>");
        out.println("<div class='prof-contener'>");
        out.println("<h1 style = 'color: white'> Manger Account </h1>");

        out.println("<div class='prof-wrap-main'>");
       // out.println("<div class='prof_right'>");
        out.println("<div class='prof-wrap'>");

        out.println("<div class='prof_right'>");
      //  out.println("<h1> Manger Account </h1>");
        out.println(//" <a href='com.rev.LogOut'>Log out</a>" +
           //     "    <div>|</div>" +
                        "    <form action='com.rev.LogOut' method='get'>" +
                        "       <input type='submit' value='Logout' />" +
                        "    </form>" +
                "    <form action='com.rev.MyProfile' method='post'>" +
                "       <input type='submit' value='View My profile' />" +
                "    </form>" +
                //"    <a href='com.rev.MyProfile'>Profile</a>" +
             //   "    <div>|</div>" +
               // "    <a href='com.rev.admin.printAllEmployees'>Print All Employees</a>" +
                        "    <form action='com.rev.admin.printAllEmployees' method='get'>" +
                        "       <input type='submit' value='Print All Employees' />" +
                        "    </form>" +
               // "    <div>|</div>" +

//                "   out.println(<form action='com.rev.AllReimbursement' method='post'>" +
//                        "                <input type='submit' value='Look your Reimbursement'/>" +
//                        "                </form>"+
//                "     <br>"+
                 //       "    <div>|</div>" +
                        "    <form action='com.rev.admin.ViewAllPending' method='get'>" +
                        "       <input type='submit' value='View Pending Reimbursements' />" +
                        "    </form>" +
                   //     "    <div>|</div>" +
                     //   "    <div>|</div>" +
                        "    <form action='com.rev.admin.ViewApprove' method='get'>" +
                        "       <input type='submit' value='View Approve Reimbursement' />" +
                        "    </form>" +
                       // "    <div>|</div>" +
              //          "<br>" +
            //    "    <a href='com.rev.admin.ViewAllPending'>View Pending Reimbursement</a><br>" +
         //        "  <a href='com.rev.admin.ViewApprove'>View Approve Reimbursement</a><br>"+
                //  "    <div>|</div>" +
                        "    <form action='com.rev.admin.ViewDisapprove' method='get'>" +
                        "       <input type='submit' value='View Disapproved Reimbursement' />" +
                        "    </form>" +
                  //      "    <div>|</div>" +
               // "  <a href='com.rev.admin.ViewDisapprove'>View Disapprove Reimbursement</a>"+
                        //"    <div>|</div>" +
                        "    <form action='com.rev.admin.ViewAllResolved' method='get'>" +
                        "       <input type='submit' value='View Resolved Reimbursement' />" +
                        "    </form>" +
                        //"    <div>|</div>" +
                        //"    <div>|</div>" +
                        "    <form action='verify.html' method='post'>" +
                        "       <input type='submit' value='Approve/Deny Reuests' />" +
                        "    </form>" +
                        //"    <div>|</div>" +
            //    "<br/>"+ "  <a href='com.rev.admin.ViewAllResolved'>View All Resolved Reimbursement</a><br>"+
            //    "    <a href='verify.html'>Approve/Deny Requests</a><br>"   +
                        //"    <div>|</div>" +
                        "    <form action='certainReim.html' method='post'>" +
                        "       <input type='submit' value='Select Specific Employee' />" +
                        "    </form>"// +
                     //   "    <div>|</div>"// +
          //  "    <a href='certainReim.html'>Select Specific Employee</a><br>"
        );
    }
}
