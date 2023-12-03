package dev.PainterApplication.Painter.Controller;

import dev.PainterApplication.Painter.Controller.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
@Service
public class ShapeStore {
    private static ArrayList<Shape> shapeStore;
    ShapeStore(){
        shapeStore=new ArrayList<>();
    }
    public void addShape(Shape shape){
        shapeStore.add(shape);
        int index=shapeStore.indexOf(shape);
        System.out.println("mahfouz");
        shape.setId(index);
    }
    public static Shape getClone(int index){
        Shape clonedShape=shapeStore.get(index);
        return (Shape)clonedShape.Clone();
    }
   /* public static void loadShapes(){
        Shape circle=new Circle();
        circle.setId("1");
        shapeStore.add(circle);
        Shape ellipse=new Ellipse();
        ellipse.setId("2");
        shapeStore.add(ellipse);
        Shape rectangle=new Rectangle();
        rectangle.setId("3");
        shapeStore.add(rectangle);
        Shape triangle=new Triangle();
        triangle.setId("4");
        shapeStore.add(triangle);
        Shape lineSegment=new LineSegment();
        lineSegment.setId("5");
        shapeStore.add(lineSegment);
    }*/


}
