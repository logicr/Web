package club.logicr.spring.common.imp;

import club.logicr.spring.common.Shape;

/**
 * @author Jan
 * 计算圆的面积
 */
public class Circular implements Shape {
    private  final double radius;

    /**
     * @param radius/* 构造，获取半径
     */

    public Circular(double radius) {
        this.radius = radius;
    }

    /**
     * @return // 计算面积
     */

    public double computeArea() {
        return Math.PI * Math.pow(radius,2);
    }

    /**
     * @return 计算周长
     */

    public double computeSide() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circular{" +
                "radius=" + radius +
                ", area="+this.computeArea()+", sideLength=" + this.computeSide() +
                '}'
                ;
    }
}
