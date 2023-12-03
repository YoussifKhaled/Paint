package dev.PainterApplication.Painter.Controller;

import org.springframework.stereotype.Service;

@Service
public class ShapeFactory {
    public Shape getShape(String shapeId){
        if(shapeId.equals("Circle")){
                return new Circle();
        }
        else if(shapeId.equals("Ellipse")){
            return new Ellipse();
        }
        else if(shapeId.equals("Rectangle")){
            return new Rectangle();
        }
        else if(shapeId.equals("Triangle")){
            return new Triangle();
        }
        else if(shapeId.equals("Line")){
            return new LineSegment();
        }
        else{
            return null;
        }
    }
}
