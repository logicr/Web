package club.logicr.spring.component;

import org.springframework.stereotype.Component;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
@Component
public class TimeComponent {
//    时间记录
//    支付开始时间
    public long startTime(){
        System.out.println("start-time");
        return System.currentTimeMillis();
    }
//    支付结束时间
    public long endTime(){
        System.out.println("end-time");
        return System.currentTimeMillis();
    }
//
    public long comute(long start,long end){
        return end - start;
    }
}
