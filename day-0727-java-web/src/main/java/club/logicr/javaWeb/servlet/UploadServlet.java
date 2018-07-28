package club.logicr.javaWeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * @author Jan on 2018/7/28.
 * @version 1.0
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取上传的文件
        Part part = req.getPart("filename");
        InputStream inputStream = part.getInputStream();
        String appUploadPath = req.getServletContext().getRealPath("/upload");
//      name
        String filename = part.getSubmittedFileName();
        File file = new File(appUploadPath, filename);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        OutputStream outputStream = new FileOutputStream(file);
        byte[] buff = new byte[1024];
        int len ;
        while ((len = inputStream.read(buff)) != -1) {
            outputStream.write(buff,0,len);
        }
        outputStream.close();
        inputStream.close();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>File</title>")
                .append("</head>")
                .append("<body>")
                .append("<a href='")
                .append("/upload/").append(part.getSubmittedFileName())
                .append("'>")
                .append("<img src='")
                .append("/upload/").append(part.getSubmittedFileName())
                .append("'>")
                .append("上传的文件")
                .append("</a>")
                .append("</body>")
                .append("</html>");
    }
}
