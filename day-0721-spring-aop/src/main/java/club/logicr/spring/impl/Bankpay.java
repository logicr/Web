package club.logicr.spring.impl;

import club.logicr.spring.PayService;

/**
 * @author Jan on 2018/7/22.
 * @version 1.0
 */
public class Bankpay implements PayService {

    public void pay() {
//        bank pay
        System.out.println("BankPay");
    }
}
