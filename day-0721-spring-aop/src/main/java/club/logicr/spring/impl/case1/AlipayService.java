package club.logicr.spring.impl.case1;

import club.logicr.spring.PayService;
import club.logicr.spring.component.LogComponent;
import club.logicr.spring.component.SecurityComponent;
import club.logicr.spring.component.TimeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
@Service(value = "alipayService1")
public class AlipayService implements PayService {
    @Autowired
    private LogComponent logComponent;
    @Autowired
    private SecurityComponent securityComponent;
    @Autowired
    private TimeComponent timeComponent;
    public void pay() {
//        安全检查
        securityComponent.security();
//        日志记录
//        支付开始时间
        long start = timeComponent.startTime();

//        核心支付逻辑
//        支付结束时间
        long end = timeComponent.endTime();
        timeComponent.comute(start,end);
    }
}
