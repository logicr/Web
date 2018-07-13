package club.logicr.springcore;

/**
 * @author Jan on 2018/7/13.
 * @version 1.0
 * 静态工厂实例化
 */
public class ClientService {
    private static  ClientService clientService = new ClientService();
    private ClientService() {
    }
    public static ClientService createInstance(){
        return clientService;
    }
}
