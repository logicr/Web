package club.logicr.spring.impl.case5;

import club.logicr.spring.PayService;
import org.springframework.stereotype.Service;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
@Service
public class AlipayService implements PayService {
    public void pay() {
//        安全检查
//        日志记录
//        支付开始时间
//        核心支付逻辑
//        支付结束时间
        System.out.println("AlipayService");
    }
}
