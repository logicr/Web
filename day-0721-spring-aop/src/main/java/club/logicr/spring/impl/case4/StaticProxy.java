package club.logicr.spring.impl.case4;

import club.logicr.spring.component.LogComponent;
import club.logicr.spring.component.SecurityComponent;
import club.logicr.spring.component.TimeComponent;
import club.logicr.spring.impl.AlipayService;
import club.logicr.spring.impl.WeixinPayService;
import sun.rmi.runtime.Log;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
public class StaticProxy {
    public static void main(String[] args) {
//        静态代理
        PayServiceStatic proxy = new PayServiceStatic(
//                new AlipayService(),
                new WeixinPayService(),
                new SecurityComponent(),
                new LogComponent(),
                new TimeComponent()
        );
        proxy.pay();
    }
}
