package dev.PainterApplication.Painter.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/painter")
public class PainterController {
    @Autowired
    private ShapeFactory shapeFactory;
    @Autowired
    private ShapeStore shapeStore;
    @GetMapping("/create")
    @ResponseBody
    public Shape createShape(@RequestParam String shapeName){
        Shape newShape=shapeFactory.getShape(shapeName);
        shapeStore.addShape(newShape);
        return newShape;
    }

}
