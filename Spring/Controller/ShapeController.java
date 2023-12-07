package dev.PainterApplication.Painter.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dev.PainterApplication.Painter.Model.*;
import dev.PainterApplication.Painter.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/paint")
@CrossOrigin(origins = "http://localhost:8082")
public class ShapeController {
    private ShapeFactory shapeFactory;
    private ShapeService shapeService;
    @Autowired
    public ShapeController(ShapeFactory shapeFactory, ShapeService shapeService){
        this.shapeFactory = shapeFactory;
        this.shapeService = shapeService;
    }
    @PostMapping("/create")
    public Shape addShape(@RequestBody ShapeRequest shapeRequest){
        return createShape(shapeRequest);
    }
    private Shape createShape(ShapeRequest shapeRequest){
        Shape shape = shapeFactory.getShape(shapeRequest);
        return shapeService.addShape(shape);
    }
    @DeleteMapping("/delete/{id}")
    public ArrayList<Shape> deleteShape(@PathVariable String id){
        return shapeService.deleteShape(id);
    }
    @GetMapping("/copy/{id}")
    public Shape copyShape(@PathVariable String id){
        return shapeService.getClone(id);
    }
    @PostMapping("/modify")
    public ArrayList<Shape> modifyShape(@RequestBody ShapeRequest shapeRequest){
        Shape modifiedShape = shapeFactory.getShape(shapeRequest);
        return shapeService.modifyShape(modifiedShape);
    }
    @GetMapping("/save")
    public void Save(@RequestParam String filePath,@RequestParam String fileType) throws IOException {
        System.out.println(filePath);
        shapeService.SaveShapes(filePath,fileType);
    }
    @GetMapping("/load")
    public ArrayList<Shape> load(@RequestParam String filePath,@RequestParam String fileType)throws IOException{
        System.out.println(shapeService.loadShapes(filePath,fileType));
        return shapeService.loadShapes(filePath,fileType);
    }
   @GetMapping("/undo")
    public ArrayList<Shape> undo(){
        return shapeService.undo();
   }
    @GetMapping("/redo")
    public ArrayList<Shape> redo(){
        return shapeService.redo();
    }
}