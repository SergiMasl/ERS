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
        req.getRequestDispatcher("navbarUser.html").include(req, res);
        String name= req.getParameter("username");

        out.println("<div class='body_contener'>" +
                "        <div class='contener-home_admin'>" +
                "            <div class='welcom_user'>" +
                "                <h1>Welcome back!</h1>" +
                "            </div>" +
                "            <div class='activiti_wrap'>" +
                "                <div class='activiti-item'>" +
                "                    <a href='addReimbure.html' class='activiti_item-link'>" +
                "                        <img class='activiti-img' src='css/svg/addReid.svg'>" +
                "                        <p class='addReimbure.html'>Add your Reimbursement</p>" +
                "                    </a>" +
                "                </div>" +
                "                <div class='activiti-item'>" +
                "                    <form action='com.rev.AllReimbursement' method='post' class='activiti_item-link'>" +
                "                        <button class='activiti-item_btnForm' type='submit'>" +
                "                            <img class='activiti-img' src='css/svg/profile.svg'>" +
                "                            <p class='activiti_text'>View my Reimburses</p>" +
                "                        </button>" +
                "                    </form>" +
                "                </div>" +
                "                <div class='activiti-item'>" +
                "                    <form action='com.rev.MyProfile' method='post' class='activiti_item-link'>" +
                "                        <input type='hidden' name='uname' value='" + name + "' />" +
                "                        <button class='activiti-item_btnForm' type='submit'>" +
                "                            <img class='activiti-img' src='css/svg/profile.svg'>" +
                "                            <p class='activiti_text'>View my Profile</p>" +
                "                        </button>" +
                "                    </form>" +
                "                </div>              " +
                "            </div>" +
                "        </div>" +
                "    </div>");
    }
}
