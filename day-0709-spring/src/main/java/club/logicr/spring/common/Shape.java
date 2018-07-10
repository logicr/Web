package club.logicr.spring.common;

/**
 * @author Jan
 * 这个接口的作用是提供一个结算面积和边长的方法
 */
public interface Shape {

    /**
     * area
     * @return
     */
    double computeArea();

    /**
     * side length
     * @return
     */
    double computeSide();
}
