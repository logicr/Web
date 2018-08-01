package club.logicr.javaWeb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jan on 2018/7/30.
 * @version 1.0
 */
public class LoginFilter implements Filter {
    private String[] urlArray;

    /**
     * 获取排除名单
     * @param filterConfig
     * @throws ServletException
     */
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
        /*截取request*/
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        /*截取response*/
        HttpServletResponse resq = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        boolean exclude = false;
        for (String item : urlArray) {
            if (item.equals(uri)) {
                exclude = true;
                break;
            }
        }
        if (exclude) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resq.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resq.getWriter();
            HttpSession session = req.getSession();
            Object att = session.getAttribute("current_user");
            if (null == att) {
                writer.append("<a href='/login'>").append("还未登录，请登录了").append("</a>");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
