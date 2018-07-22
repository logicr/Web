package club.logicr.spring.impl.case4;

import club.logicr.spring.PayService;
import club.logicr.spring.component.LogComponent;
import club.logicr.spring.component.SecurityComponent;
import club.logicr.spring.component.TimeComponent;
import com.sun.javafx.image.IntPixelGetter;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
public class PayServiceStatic implements PayService {

    private final PayService payService;
    private final SecurityComponent securityComponent;
    private final LogComponent logComponent;
    private final TimeComponent timeComponent;

    public PayServiceStatic(PayService payService,  SecurityComponent securityComponent, LogComponent logComponent, TimeComponent timeComponent) {
        this.payService = payService;
        this.securityComponent = securityComponent;
        this.logComponent = logComponent;
        this.timeComponent = timeComponent;
    }

    public void pay() {
        securityComponent.security();
        logComponent.log();
        timeComponent.startTime();
        payService.pay();
        timeComponent.endTime();
    }
}
