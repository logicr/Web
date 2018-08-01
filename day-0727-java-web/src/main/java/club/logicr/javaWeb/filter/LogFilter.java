package club.logicr.javaWeb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jan on 2018/7/30.
 * @version 1.0
 */
public class LogFilter implements Filter {
    private String prefix;
    private PrintWriter writer;

    /**
     *
     * 初始化Filter
     * @param filterConfig
     * prefix 设置前缀
     * logFileName 输出文件名字
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        prefix = filterConfig.getInitParameter("prefix");
        String filename = filterConfig.getInitParameter("logFileName");
        /*获取输出路径*/
        String logPath = filterConfig.getServletContext().getRealPath("/log");
        File logFile = new File(logPath, filename);
        if (!logFile.getParentFile().exists()) {
            logFile.getParentFile().mkdirs();
        }
        try {
            /*创建输出文件*/
            writer = new PrintWriter(logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (null == writer) {
            throw new RuntimeException("PrintWriter cant be null");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*HttpServletRequest接收Filter拦截的request*/
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        /*获取统一资源标识符*/
        String uri = req.getRequestURI();
        /*串输出*/
        String log = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + "--" + this.prefix + "--" + uri + "\n";
        writer.write(log);
        writer.flush();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        if (null != writer) {
            writer.close();
        }
    }
}
