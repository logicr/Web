package club.logicr.javaWeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jan on 2018/7/28.
 * @version 1.0
 */
public class QueryServlet extends HttpServlet {
    private Map<String, String> cityMap = new HashMap<>();
    private Map<String, List<String>> scenicSpot = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        List<String> xian = new ArrayList<String>();
        xian.add("华清池");
        xian.add("兵马俑");
        xian.add("大雁塔");
        scenicSpot.put("xian", xian);
        cityMap.put("xian", "西安");

        List<String> baoJi = new ArrayList<String>();
        baoJi.add("太白山");
        baoJi.add("法门寺");
        baoJi.add("关山牧场");
        scenicSpot.put("baoJi", baoJi);
        cityMap.put("baoJi", "宝鸡");

        List<String> xianyang = new ArrayList<String>();
        xianyang.add("乾陵");
        xianyang.add("袁家村");
        scenicSpot.put("xianyang", xianyang);
        cityMap.put("xianyang", "咸阳");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>QU</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/query\">\n" +
                "    <input type=\"text\" name=\"city\" value=\"\" placeholder=\"请输入城市名称（拼音）\">\n" +
                "    <input type=\"submit\" value=\"提交\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        List<ScenicsDto> scenicsDtoList = new ArrayList<>();
        if (city == null || city.length() == 0) {
            //全部输出
            for (Map.Entry<String, List<String>> entry : scenicSpot.entrySet()) {
                String citykey = entry.getKey();
                List<String> scenics = entry.getValue();
                for (String s : scenics) {
                    ScenicsDto scenicsDto = new ScenicsDto();
                    scenicsDto.setCity(cityMap.get(citykey));
                    scenicsDto.setName(s);
                    scenicsDtoList.add(scenicsDto);
                }
            }
        }else {
//            单个
            List<String> scenics = scenicSpot.get(city);
            if (scenics == null) {
                scenics = new ArrayList<>();
            }
            for (String item : scenics) {
                ScenicsDto scenicsDto = new ScenicsDto();
                scenicsDto.setCity(cityMap.get(city));
                scenicsDto.setName(item);
                scenicsDtoList.add(scenicsDto);
            }
        }
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>景点</title>\n" +
                "    <style type=\"text/css\">\n" +
                "        table,th,td\n" +
                "        {\n" +
                "            border:1px solid navajowhite;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <table style=\"border:1px solid darkgoldenrod;\">\n" +
                "        <thead >\n" +
                "        <tr>\n" +
                "            <td>编号</td>\n" +
                "            <td>所在城市</td>\n" +
                "            <td>景点名称</td>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>");
        int id = 1;
        for (ScenicsDto dto : scenicsDtoList) {
            writer.append("<tr>")
                    .append("<td>").append(String.valueOf(id)).append("</td>")
                    .append("<td>").append(dto.city).append("</td>")
                    .append("<td>").append(dto.name).append("</td>")
                    .append("</tr>");
            id += 1;
        }
        writer.append("    </tbody>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");
    }
    public  static class ScenicsDto{
        private String city;
        private String name;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
