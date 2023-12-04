package dev.PainterApplication.Painter.Service;

import dev.PainterApplication.Painter.Model.Shape;
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
    public void deleteShape(String id){
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(id)){
                shapes.remove(shapes.get(i));
            }
        }
    }
    public  ArrayList<Shape> getShapes() {
        return shapes;
    }
    public Shape getClone(String id){
        Shape clonedShape=null;
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(id)){
                clonedShape=shapes.get(i);
            }
        }
        if(clonedShape ==null){
            return null;
        }
        return (Shape) clonedShape.Clone();
    }
    public Shape moveShape(String id,double x,double y){
        Shape movedShape=null;
        //get the shape
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(id)){
                movedShape=shapes.get(i);
            }
        }
        if(movedShape==null){
            return null;
        }
        movedShape.setX(x);
        movedShape.setY(y);
        return movedShape;
    }
}
