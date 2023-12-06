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
    @GetMapping("/delete/{id}")
    public void deleteShape(@PathVariable String id){
        shapeService.deleteShape(id);
    }
    @GetMapping("/copy/{id}")
    public Shape copyShape(@PathVariable String id){
        return shapeService.getClone(id);
    }
    @PostMapping("/modify")
    public void modifyShape(@RequestBody ShapeRequest shapeRequest){
        Shape modifiedShape=createShape(shapeRequest);
        shapeService.modifyShape(modifiedShape);
    }
    @GetMapping("/save")
    public String Save(@RequestParam String filePath) throws IOException {
        System.out.println(filePath);
        shapeService.ShapesSave(filePath);
        return filePath;
    }
    @GetMapping("/load")
    public ArrayList<Shape> load(@RequestParam String filePath)throws IOException{
        ArrayList<Shape>JSONShapes=readXmlFile(filePath);

        String jsonShapes=convertToJson(JSONShapes);

        System.out.println(JSONShapes);

        return JSONShapes;
    }
    private ArrayList<Shape>readXmlFile(String xmlFilePath)throws IOException{
        XmlMapper xmlMapper=new XmlMapper();
        return xmlMapper.readValue(new File(xmlFilePath), ArrayList.class);
    }
    private String convertToJson(ArrayList<Shape>jsonShapes)throws IOException{
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(jsonShapes);
    }
}