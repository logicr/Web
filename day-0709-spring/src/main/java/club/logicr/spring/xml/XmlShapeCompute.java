package club.logicr.spring.xml;

import club.logicr.spring.common.Shape;
import club.logicr.spring.common.imp.Circular;
import club.logicr.spring.common.imp.Rectangle;
import club.logicr.spring.common.imp.Triangle;
import javafx.scene.shape.Circle;


/**
 * @author Jan
 */
public class XmlShapeCompute {
    private Shape circular;
    private Shape rectangle;
    private Shape triangle;


    public Shape compute(String shapeName) {
        if (shapeName == null || shapeName.length() == 0) {
            throw new IllegalArgumentException("Not found " + shapeName);
        }
        if (shapeName.equals("circular")) {
            /*手动new*/
//            this.circular = new Circular(10);
            return circular;
        }
        if (shapeName.equals("rectangle")) {
//            this.rectangle = new Rectangle(100, 100);
            return rectangle;
        }
        if (shapeName.equals("triangle")) {
//            this.triangle = new Triangle(90, 90, 90);
            return triangle;
        }
        throw new IllegalArgumentException("Not found " + shapeName);
    }

    public void setCircular(Shape circular) {
        this.circular = circular;
    }

    public void setRectangle(Shape rectangle) {
        this.rectangle = rectangle;
    }

    public void setTriangle(Shape triangle) {
        this.triangle = triangle;
    }

//    public static void main(String[] args) {
//        XmlShapeCompute xmlShapeCompute = new XmlShapeCompute();
//        Shape shape = xmlShapeCompute.compute("circular");
//        Shape shape2 = xmlShapeCompute.compute("rectangle");
//        Shape shape3 = xmlShapeCompute.compute("triangle");
//        System.out.println(shape);
//        System.out.println(shape2);
//        System.out.println(shape3);
//    }
}
