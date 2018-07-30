package club.logicr.javaWeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * @author Jan on 2018/7/28.
 * @version 1.0
 */
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Form</title>\n" +
                "</head>\n" +
                "    <body>\n" +
                "        <form method=\"post\" action=\"form\">\n" +
                "            <input type=\"text\" name=\"yourname\" value=\"\" placeholder=\"Your name\" >\n" +
                "            <input type=\"submit\" value=\"submit\" >\n" +
                "        </form>\n" +
                "    </body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("yourname");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html lang='en'>")
                .append("<head>")
                .append(" <meta charset='UTF-8'>")
                .append("<title>Form</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("欢迎，")
                .append(new String(name.getBytes("ISO-8859-1"),"UTF-8"))
                .append("</h1>")
                .append("</body>")
                .append("</html>");


    }
}
