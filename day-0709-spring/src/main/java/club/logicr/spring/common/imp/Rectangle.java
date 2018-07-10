package club.logicr.spring.common.imp;

import club.logicr.spring.common.Shape;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    /**
     * 构造
     *
     * @param width
     * @param height
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 计算面积
     * @return
     */
    public double computeArea() {
        return width * height;
    }

    /**
     * 计算边长
     * @return
     */
    public double computeSide() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height + ", area="+this.computeArea()+", sideLength=" + this.computeSide() +
                '}';
    }
}
