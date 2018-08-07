package club.logicr.myweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jan on 2018/8/2.
 * @version 1.0
 */
//@WebFilter(urlPatterns = {"/video1.jsp","/video2.jsp","/video3.jsp","/video4.jsp"},
//        initParams= {
//        @WebInitParam(name = "exclude", value = "/video,/video.jsp,/,/login.jsp,/login,/getaccount.html/,"),
//        @WebInitParam(name = "encoding", value = "utf-8")
//}
//)
public class Filter implements javax.servlet.Filter {
    private String[] urlArray;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("exclude");
        if (null == urls || 0 == urls.length()) {
            urlArray = new String[]{};
        } else {
            urlArray = urls.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        boolean exclude = false;
        for (String item : urlArray) {
            if (item.equals(uri) ||item.contains(".css") ||item.contains(".png")||item.contains(".gif") ||item.contains(".js")) {
                exclude = true;
                break;
            }
        }
        if (exclude) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.setContentType("text/html; charset=UTF-8");
            HttpSession session = req.getSession();
            Object att = session.getAttribute("current_user");
            if (null == att) {
                resp.sendRedirect("login.jsp");
            }
            else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
