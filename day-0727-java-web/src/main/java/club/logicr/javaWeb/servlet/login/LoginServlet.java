package club.logicr.javaWeb.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jan on 2018/7/29.
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>登录</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\" action=\"/login\">\n" +
                "        <label for=\"username\"> 用户名：</label><input type=\"text\" id=\"username\" name=\"username\" placeholder=\"用户名\">\n" +
                "        <label for=\"password\">密码：</label><input type=\"password\" id=\"password\" name=\"password\" placeholder=\"密码\">\n" +
                "        <input type=\"submit\" value=\"登录\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if ("13314433445".equals(username) && "123456".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("current_user", username);
//            writer.append("<a herf='/index'>").append("登录成功").append("</a>");
            /*
            * 登录成功自动跳转页面到index
            * */
            writer.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=refresh content=\"2;url=/index\">\n" +
                    "    <title>登录成功</title>\n" +
                    "    <style type=\"text/css\">\n" +
                    "        table,th,td\n" +
                    "        {\n" +
                    "            border:1px solid navajowhite;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h5>登录成功</h5>\n" +
                    "</body>\n" +
                    "</html>");
        }else {
//            writer.append("<a href='/login'>").append("登录失败，请重新登录").append("</a>");
            writer.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=refresh content=\"2;url=/login\">\n" +
                    "    <title>登录失败</title>\n" +
                    "    <style type=\"text/css\">\n" +
                    "        table,th,td\n" +
                    "        {\n" +
                    "            border:1px solid navajowhite;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h5>登录失败</h5>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}

