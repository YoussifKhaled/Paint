package dev.PainterApplication.Painter.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dev.PainterApplication.Painter.Model.Circle;
import dev.PainterApplication.Painter.Model.Shape;
import dev.PainterApplication.Painter.Model.ShapeRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.File;

import java.util.ArrayList;

@Service
public class ShapeService {
    private static ArrayList<Shape> shapes;
    @Autowired
    private DataBase database;
    public ShapeService(){
        shapes = new ArrayList<>();
    }
    public Shape addShape(Shape shape){
        shapes.add(shape);
        //System.out.println("Shape"+shape.getId()+" added");
        return shape;
    }
    public void deleteShape(String id){
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(id)){
                //System.out.println("shape"+id+" deleted");
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
                clonedShape.setId(id+1);
                //adding shape after modifying id
                addShape(clonedShape);
                //System.out.println("shape(copied)"+clonedShape.getId()+" added");
                return (Shape) clonedShape.Clone();
            }
        }
        return null;
    }
    public void modifyShape(Shape modifiedShape){
        for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getId().equals(modifiedShape.getId())){
                //System.out.println("shape"+modifiedShape.getId()+" modified");
                shapes.set(i,modifiedShape);
                break;
            }
        }
    }   
    public  ArrayList<Shape> loadShapes (String filePath,String type) throws IOException {
        database.setFilePath(filePath);
        shapes = database.loadDataBase(type);
        return shapes;
    }
    public  void SaveShapes (String filePath,String type) throws IOException {
        database.setFilePath(filePath);
        database.SaveDataBase(type);
    }
}
