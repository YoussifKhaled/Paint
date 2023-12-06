package com.example.paint.controller;
import com.example.paint.model.Shape;
import com.example.paint.model.ShapeRequest;
import com.example.paint.service.ShapeFactory;
import com.example.paint.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/paint")
@CrossOrigin(origins = "http://localhost:3000")
public class ShapeController {

    private ShapeFactory shapeFactory;
    private ShapeService shapeService;

    @Autowired
    public ShapeController(ShapeFactory shapeFactory, ShapeService shapeService){
        this.shapeFactory = shapeFactory;
        this.shapeService = shapeService;
    }

    @PostMapping("/shapes")
    public Shape addShape(@RequestBody ShapeRequest shapeRequest){
        Shape shape = shapeFactory.getShape(shapeRequest);
        return shapeService.addShape(shape);
    }

    @DeleteMapping("/shapes/{id}")
    public void deleteShape(@PathVariable String id){
        shapeService.deleteShape(id);
    }

    @GetMapping("/copy/{id}")
    public Shape copyShape(@PathVariable String id){
        System.out.println(shapeService.getShapes());
        return shapeService.getClone(id);
    }

    @PostMapping("/modify")
    public void modifyShape(@RequestBody ShapeRequest shapeRequest){
        Shape modifiedShape = shapeFactory.getShape(shapeRequest);
        System.out.println(modifiedShape);
        shapeService.modifyShape(modifiedShape);
    }

    @GetMapping("/save")
    public void Save(@RequestParam String filePath,@RequestParam String fileType) throws IOException {
        shapeService.SaveShapes(filePath,fileType);
    }

    @GetMapping("/load")
    public ArrayList<Shape> load(@RequestParam String filePath,@RequestParam String fileType) throws IOException {
        return shapeService.loadShapes(filePath,fileType);
    }
}
