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
        req.getRequestDispatcher("navbar.html").include(req, res);
        out.println(
                "<div class='body_contener'>" +
                        "        <div class='contener-home_admin'>" +
                        "            <div class='welcom_user'>" +
                        "                <h1>Welcome to Expense Reimbursement System!</h1>" +
                        "            </div>" +
                        "            <div class='activiti_wrap'>" +
                        "" +
                        "                <div class='activiti-item'>" +
                        "" +
                        "                    <form action='com.rev.MyProfile' method='post' class='activiti_item-link'>" +
                        "                        <button class='activiti-item_btnForm' type='submit'>" +
                        "                            <img class='activiti-img' src='css/svg/profile.svg'>" +
                        "                            <p class='activiti_text'>View my Profile</p>" +
                        "                        </button>" +
                        "                    </form>" +
                        "" +
                        "                </div>" +
                        "                <div class='activiti-item'>" +
                        "                    <a href='com.rev.admin.printAllEmployees'>" +
                        "                        <img class='activiti-img' src='css/svg/allEmpl.svg'>" +
                        "                        <p class='activiti_text'>View profiles of ALL Employees</p>" +
                        "                    </a>" +
                        "                </div>" +
                        "                <div class='activiti-item'>" +
                        "                    <a href='certainReim.html'>" +
                        "                        <img class='activiti-img' src='css/svg/targetEmpl.svg'>" +
                        "                        <p class='activiti_text'>View Specific Employee</p>" +
                        "                    </a>" +
                        "                </div>" +
                        "                <div class='activiti-item'>" +
                        "                    <a href='com.rev.admin.ViewAllPending'>" +
                        "                        <img class='activiti-img' src='css/svg/pending.svg'>" +
                        "                        <p class='activiti_text'>View Pending Reimbursement</p>" +
                        "                    </a>" +
                        "                </div>\n" +
                        "                <div class='activiti-item'>" +
                        "                    <a href='com.rev.admin.ViewApprove'>" +
                        "                        <img class='activiti-img' src='css/svg/approve.svg'>" +
                        "                        <p class='activiti_text'>View Approve Reimbursement</p>" +
                        "                    </a>" +
                        "                </div>" +
                        "                <div class='activiti-item'>" +
                        "                    <a href='com.rev.admin.ViewDisapprove'>" +
                        "                        <img class='activiti-img' src='css/svg/disapprove.svg'>" +
                        "                        <p class='activiti_text'>View Disapprove Reimbursement</p>" +
                        "                    </a>" +
                        "                </div>" +
                        "                <div class='activiti-item'>" +
                        "                    <a href='verify.html'>" +
                        "                        <img class='activiti-img' src='css/svg/verify.svg'>" +
                        "                        <p class='activiti_text'>Verify Reimbursement</p>" +
                        "                    </a>" +
                        "                </div>" +
                        "              " +
                        "            </div>" +
                        "        </div>" +
                        "    </div>"
        );
    }
}
