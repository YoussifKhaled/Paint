package com.example.paint.service;

import com.example.paint.model.Shape;
import com.example.paint.model.ShapeRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public void deleteShape(String id) {
        shapes.removeIf(shape -> shape.getId().equals(id));
    }
    public Shape getClone(String id) {
        Shape clonedShape;

        for (Shape shape : shapes) {

            if (shape.getId().equals(id)) {
                clonedShape = (Shape) shape.Clone();
                clonedShape.setId(Long.toString(System.currentTimeMillis()));
                clonedShape.setX(shape.getX() + 15);
                clonedShape.setY(shape.getY() + 15);
                return this.addShape(clonedShape);
            }
        }
        return null;
    }

    public void modifyShape(Shape modifiedShape) {

        for (Shape shape : shapes) {
            if (shape.getId().equals(modifiedShape.getId())) {
                shapes.set(shapes.indexOf(shape), modifiedShape);
            }
        }
    }

    public  ArrayList<Shape> loadShapes (String filePath,String type) throws IOException {

        DataBase database = DataBase.getInstance();
        database.setFilePath(filePath);
        shapes.clear();

        for(ShapeRequest shapeRequest : database.loadDataBase(type)){
            Shape shape = new ShapeFactory().getShape(shapeRequest);
            this.addShape(shape);
        }

        System.out.println(shapes);
        return shapes;
    }
    public  void SaveShapes (String filePath,String type) throws IOException {
        DataBase database = DataBase.getInstance();
        database.setFilePath(filePath);
        database.SaveDataBase(shapes,type);
    }
}
