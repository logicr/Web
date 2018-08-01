package club.logicr.javaWeb.filter;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Jan on 2018/7/30.
 * @version 1.0
 */
public class CounterFilter implements Filter {
    private final Executor executor = Executors.newSingleThreadExecutor();

    private Properties properties;
    private File countFile;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        String filename = filterConfig.getInitParameter("counterFilename");
//        String logPath = filterConfig.getServletContext().getRealPath("/log");
//        countFile = new File(logPath, filename);
        String filename = filterConfig.getInitParameter("counterFileName");
        String logPath = filterConfig.getServletContext().getRealPath("/log");
        countFile = new File(logPath, filename);
        if (countFile.getParentFile().exists()) {
            countFile.getParentFile().mkdirs();
        }
        if (!countFile.exists()) {
            try {
                countFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        properties = new Properties();
        try {
            /*读取属性*/
            properties.load(new FileInputStream(countFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        final StringBuffer url = req.getRequestURL();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Object value = null;
                try {
                    value = properties.get(url.toString());
                } catch (Exception e) {
                    System.out.println("61行出错了");
                }
                if (null == value) {
                    value = "1";
                } else {
                    value = Integer.parseInt(value.toString())+1;
                }
                properties.put(url.toString(), String.valueOf(value));
                try {
                    properties.store(new FileOutputStream(countFile), "Filter 请求计数");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
