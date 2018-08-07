package club.logicr.myweb.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 检测是否登录，没有登录则跳转登录界面，
 * 已登录则跳转播放界面
 *
 * @author Jan on 2018/8/2.
 * @version 1.0
 */
@Controller
@RequestMapping
public class PlayFilterSpringMVC {
    /**
     * 如果有xxx.video.html的请求，验证登录，如果已经登录，返回video
     */
    @RequestMapping(value = {"/video1"}, method = {RequestMethod.GET})
    public ModelAndView login(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Object account = session.getAttribute("current_user");
        if (null != account) {
            modelAndView.setViewName("video1");
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/video2"}, method = {RequestMethod.GET})
    public ModelAndView login2(  HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Object account = session.getAttribute("current_user");
        if (null != account) {
            modelAndView.setViewName("video2");
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/video3"}, method = {RequestMethod.GET})
    public ModelAndView login3(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Object account = session.getAttribute("current_user");
        if (null != account) {
            modelAndView.setViewName("video3");
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping(value = {"/video4"}, method = {RequestMethod.GET})
    public ModelAndView login4(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Object account = session.getAttribute("current_user");
        if (null != account) {
            modelAndView.setViewName("video4");
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }
    @RequestMapping(value = {"/xie"}, method = {RequestMethod.GET})
    public ModelAndView xie(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Object account = session.getAttribute("current_user");
        if (null != account) {
            modelAndView.setViewName("xie");
            return modelAndView;
        } else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

}
