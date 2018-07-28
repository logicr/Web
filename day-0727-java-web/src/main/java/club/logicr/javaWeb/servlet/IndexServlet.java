package club.logicr.javaWeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Jan on 2018/7/27.
 * @version 1.0
 */
public class IndexServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.append("<html>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append("hello java web power by servlet").format(String.valueOf(new Date()))
                .append("</h1>")
                .append("</body>");

    }

}
