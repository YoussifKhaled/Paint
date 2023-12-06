package com.example.paint.controller;


import com.example.paint.model.Shape;
import com.example.paint.model.ShapeRequest;
import com.example.paint.service.DataBase;
import com.example.paint.service.ShapeFactory;
import com.example.paint.service.ShapeService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



@RestController
@RequestMapping("/paint")
@CrossOrigin(origins = "http://localhost:3000")
public class ShapeController {

    private ShapeFactory shapeFactory;
    private ShapeService shapeService;
    private DataBase dataBase;

    @Autowired
    public ShapeController(ShapeFactory shapeFactory, ShapeService shapeService,DataBase dataBase){
        this.shapeFactory = shapeFactory;
        this.shapeService = shapeService;
        this.dataBase=dataBase;
    }

    @PostMapping("/shapes")
    public Shape addShape(@RequestBody ShapeRequest shapeRequest){
        Shape shape = shapeFactory.getShape(shapeRequest);
        return shapeService.addShape(shape);
    }

    @GetMapping("/save")
    public void Save(@RequestParam String filePath) throws IOException {
        System.out.println(filePath);
        String type="xml";
        shapeService.SaveShapes(filePath,type);
    }
    @GetMapping("/load")
    public ArrayList<Shape> load(@RequestParam String filePath)throws IOException{
        String type="xml";
        System.out.println(shapeService.loadShapes(filePath,type));
         return  shapeService.loadShapes(filePath,type);

    }


}
