package club.logicr.javaWeb.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jan on 2018/7/29.
 * @version 1.0
 */
public class ProServlet extends HttpServlet {
    /*
   装省 和市 的list
    */
    private Map<String, List<String>> proCity = new HashMap<>();
    /*
    市 和 区
     */
    private Map<String, List<String>> cityDist = new HashMap<>();

    /**
     * 初始化操作，正常开发时，里面应该是重数据库取数据的
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        List<String> citys = new ArrayList<>();
        citys.add("西安");
        citys.add("宝鸡");
        citys.add("咸阳");
        proCity.put("陕西", citys);

        List<String> xianDist = new ArrayList<>();
        xianDist.add("雁塔区");
        xianDist.add("临潼区");
        xianDist.add("长安区");
        cityDist.put("西安", xianDist);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pro = req.getParameter("pro");
//        String city = req.getParameter("city");
//        创建HttpSession
        HttpSession session = req.getSession();
        session.setAttribute("pro", pro);
        if (pro != null){
            resp.setContentType("text/html; charset=UTF-8");
            List<String> citys = proCity.get(pro);
            PrintWriter writer = resp.getWriter();
            writer.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>市</title>\n" +
                    " <style type=\"text/css\">\n" +
                    "        table,th,td\n" +
                    "        {\n" +
                    "            border:1px solid navajowhite;\n" +
                    "        }\n" +
                    "    </style>"+
                    "</head>\n" +
                    "<body>\n" +
                    "<table>\n" +
                    "    <thead>\n" +
                    "    <tr>\n" +
                    "        <td>编号</td>\n" +
                    "        <td>市</td>\n" +
                    "    </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>");
            int id = 1;
            for (String c : citys) {
                /*
                列出一个链接，当点击的时候，又是一次post，这是通过for循环把city加上了
                 */
                writer.append("<tr>")
                        .append("<td>").append(String.valueOf(id)).append("</td>")
                        .append("<td>")
                        .append("<a href='").append("/city3?pro=").append(pro).append("&city=").append(c).append("'>")
                        .append(c)
                        .append("</a>")
                        .append("</td>")
                        .append("</tr>");
                id += 1;
            }
            writer.append("    </tbody>\n" +
                    "</table>\n" +
                    "</body>\n" +
                    "</html>");
        }else {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.append("No data");
        }

    }
}


