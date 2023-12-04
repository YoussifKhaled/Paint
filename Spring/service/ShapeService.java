package com.example.paint.service;

import com.example.paint.model.Shape;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ShapeService {
    private static ArrayList<Shape> shapes;

    public ShapeService(){
        shapes = new ArrayList<>();
    }
    public Shape addShape(Shape shape){
        shapes.add(shape);
        return shape;
    }

    public  ArrayList<Shape> getShapes() {
        return shapes;
    }

    public static Shape getClone(int index){
        Shape clonedShape = shapes.get(index);
        return (Shape) clonedShape.Clone();
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
