package dev.PainterApplication.Painter.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dev.PainterApplication.Painter.Model.Circle;
import dev.PainterApplication.Painter.Model.Shape;
import dev.PainterApplication.Painter.Model.ShapeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.Stack;

@Service
public class ShapeService {
    private static ArrayList<Shape> shapes;
    private static Stack<ArrayList<Shape>>shapesContainer;
    private static Stack<ArrayList<Shape>>undoneShapesContainer;
    private int number_of_undo=0;
    private ShapeFactory shapeFactory;
    public ShapeService(){
        shapes = new ArrayList<>();
        shapesContainer=new Stack<>();
        undoneShapesContainer=new Stack<>();
        shapeFactory=new ShapeFactory();
    }
    public Shape addShape(Shape shape){
        ArrayList<Shape> currentShapes = new ArrayList<>(shapes);
        currentShapes.add(shape);
        number_of_undo=0;
        while(!undoneShapesContainer.empty()){
            undoneShapesContainer.pop();
        }
        shapesContainer.push(new ArrayList<>(currentShapes));
        shapes=currentShapes;
        return shape;
    }
    public ArrayList<Shape> deleteShape(String id){
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(id)){
                ArrayList<Shape> currentShapes = new ArrayList<>(shapes);
                currentShapes.remove(i);
                shapesContainer.push(new ArrayList<>(currentShapes));
                shapes=currentShapes;
                for(Shape shape:shapes){
                    System.out.println(shape);
                }
                return shapes;
            }
        }
        return null;
    }
    public  ArrayList<Shape> getShapes() {
        return shapes;
    }
    public Shape getClone(String id){
        Shape clonedShape;
        for(Shape shape:shapes){
            if(shape.getId().equals(id)){
                clonedShape=(Shape)shape.Clone();
                clonedShape.setId(Long.toString(System.currentTimeMillis()));
                clonedShape.setX(shape.getX()+15);
                clonedShape.setY(shape.getY()+15);
                addShape(clonedShape);
                return (Shape) clonedShape.Clone();
            }
        }
        return null;
    }
    public ArrayList<Shape> modifyShape(Shape modifiedShape){
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(modifiedShape.getId())){
                ArrayList<Shape> currentShapes = new ArrayList<>(shapes);
                currentShapes.set(i,modifiedShape);
                shapesContainer.push(new ArrayList<>(currentShapes));
                shapes=currentShapes;
                return shapes;
            }
        }
        return null;
    }
    public  ArrayList<Shape> loadShapes (String filePath,String type) throws IOException {
        DataBase dataBase=DataBase.getInstance();
        dataBase.setFilePath(filePath);
        shapes.clear();
        for(ShapeRequest shapeRequest:dataBase.loadDataBase(type)){
            Shape shape=shapeFactory.getShape(shapeRequest);
            addShape(shape);
        }
        while(!shapesContainer.empty()){
            shapesContainer.pop();
        }
        while(!undoneShapesContainer.empty()){
            undoneShapesContainer.pop();
        }
        number_of_undo=0;
        shapesContainer.push(shapes);
        return shapes;
    }
    public  void SaveShapes (String filePath,String type) throws IOException {
        DataBase dataBase=DataBase.getInstance();
        dataBase.setFilePath(filePath);
        dataBase.SaveDataBase(type);
    }
    public ArrayList<Shape> undo(){
        if(!shapesContainer.empty()){
            undoneShapesContainer.push(shapesContainer.peek());
            shapesContainer.pop();
            number_of_undo++;
            if(!shapesContainer.empty()){
                ArrayList<Shape>currentShapes=shapesContainer.peek();
                shapes=currentShapes;
            }
            else{
                shapes=null;
            }
            return shapes;
        }
        return null;
    }
    public ArrayList<Shape> redo(){
        if(!undoneShapesContainer.empty() && number_of_undo!=0){
            ArrayList<Shape> currentShapes=undoneShapesContainer.peek();
            undoneShapesContainer.pop();
            number_of_undo--;
            shapesContainer.push(currentShapes);
            shapes=currentShapes;
            return shapes;
        }
        return null;
    }
}
