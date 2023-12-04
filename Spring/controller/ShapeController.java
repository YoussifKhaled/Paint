package com.example.paint.controller;


import com.example.paint.model.Shape;
import com.example.paint.model.ShapeRequest;
import com.example.paint.service.ShapeFactory;
import com.example.paint.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
