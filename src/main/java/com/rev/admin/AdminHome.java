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

        out.println(" <a href='com.rev.LogOut'>Log out</a>" +
                "    <div>|</div>" +
                "    <form action='com.rev.MyProfile' method='post'>" +
                "       <input type='submit' value='View My profile' />" +

                "    </form>" +

                "    <a href='com.rev.MyProfile'>Profile</a>" +
                "    <div>|</div>" +

                "    <a href='com.rev.admin.printAllEmployees'>Print All Employees</a>" +
                "    <div>|</div>" +

//                "   out.println(<form action='com.rev.AllReimbursement' method='post'>" +
//                        "                <input type='submit' value='Look your Reimbursement'/>" +
//                        "                </form>"+
//                "     <br>"+
                "    <a href='com.rev.admin.ViewAllPending'>View Pending Reimbursement</a>" +
                 "  <a href='com.rev.admin.ViewApprove'>View Approve Reimbursement</a>"+
                "  <a href='com.rev.admin.ViewDisapprove'>View Disapprove Reimbursement</a>"+
                "<br/>"+
                "    <a href='verify.html'>Verify Test</a>"   +
            "    <a href='certainReim.html'>Specific Employee</a>"
        );
    }
}
