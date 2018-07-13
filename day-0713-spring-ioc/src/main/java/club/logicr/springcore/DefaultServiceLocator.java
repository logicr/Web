package club.logicr.springcore;

/**
 * @author Jan on 2018/7/13.
 * @version 1.0
 * 工厂实例化
 */
public class DefaultServiceLocator {
    private ExampleBean exampleBean = new ExampleBean(1);
    public ExampleBean createClientInstance(){
        return exampleBean;
    }
}
