package club.logicr.spring.impl.case3;

import club.logicr.spring.PayService;
import club.logicr.spring.component.LogComponent;
import club.logicr.spring.component.SecurityComponent;
import club.logicr.spring.component.TimeComponent;
import club.logicr.spring.impl.AlipayService;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
public class CglibProxy {
    public static void main(String[] args) {
//        目标对象
        PayService targat = new AlipayService();
//      拦截器
        PayServiceCglibProxy interceptor = new PayServiceCglibProxy(
                targat,
                new LogComponent(),
                new SecurityComponent(),
                new TimeComponent()
        );
//      代理对象
        PayService proxy = (PayService) Enhancer.create(targat.getClass(), interceptor);
        proxy.pay();
    }
}
