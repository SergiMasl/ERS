import jakarta.servlet.ServletException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

       // request.getRequestDispatcher("navbar.html").include(request, response);

        Cookie cookie = new Cookie("username", "");
        response.addCookie(cookie);

        out.println("you are logged out successfully");
        out.println("<br><a href=\"login.html\">Login</a>");
    }

}