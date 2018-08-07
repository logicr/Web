package club.logicr.myweb;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLPermission;

/**
 * @author Jan on 2018/8/2.
 * @version 1.0
 */
//@WebServlet(urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if ("porn".equals(username) && "porn".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("current_user", username);
            resp.sendRedirect("video.jsp");
        }else{
            resp.sendRedirect("/login.jsp");
        }
    }
}
