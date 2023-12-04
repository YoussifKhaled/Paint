package dev.PainterApplication.Painter.Controller;
import dev.PainterApplication.Painter.Model.*;
import dev.PainterApplication.Painter.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/move")
    public Shape moveShape(@RequestParam("id") String id,@RequestParam("x")double x,@RequestParam("y")double y){
        return shapeService.moveShape(id,x,y);
    }

}
