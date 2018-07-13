package club.logicr.springcore;

/**
 * @author Jan on 2018/7/13.
 * @version 1.0
 */
public class ExampleBean {
    private final Integer id;

    public ExampleBean(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "id=" + id +
                '}';
    }
}
