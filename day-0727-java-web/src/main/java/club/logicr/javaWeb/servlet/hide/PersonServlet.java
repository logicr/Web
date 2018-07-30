package club.logicr.javaWeb.servlet.hide;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jan on 2018/7/29.
 * @version 1.0
 */
public class PersonServlet extends HiddenServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        if (null == id) {
            writer.append("参数不能为空");
        } else {
            Person person = personMap.get(id);
            writer.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>修改人员信息</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>修改人员信息</h1>\n" +
                    "<form method=\"post\" action=\"/person\">\n" +
                    "    <input type=\"text\" name=\"id\" hidden=\"hidden\" value=\"" + person.getId() + "\"/>\n" +
                    "    姓名：<input type=\"text\" name=\"name\" value=\"" + person.getName() + "\" placeholder=\"请输入姓名\">\n" +
                    "    年龄:<input type=\"text\" name=\"age\" value=\"" + person.getAge() + "\" placeholder=\"请输入年龄\">\n" +
                    "    <input type=\"submit\" value=\"保存更新\">\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }

    /**
     * 这里的doPost用来接收上面的post请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        if (null == id) {
            writer.append("不支持新建用户");
        }else{
            String name = req.getParameter("name");
            String ageStr = req.getParameter("age");
            Person person = personMap.get(id);
            person.setName(name);
            person.setAge(Integer.parseInt(ageStr));
            writer.append("<a href='/hide'>").append("回到列表").append("</a>");
        }
    }
}
