package dev.PainterApplication.Painter.Service;
import dev.PainterApplication.Painter.Model.*;
import org.springframework.stereotype.Service;
@Service
public class ShapeFactory {
    public Shape getShape(ShapeRequest shapeRequest){
        return switch (shapeRequest.getShapeType()) {
            case "circle" -> new Circle(shapeRequest);
            case "ellipse" -> new Ellipse(shapeRequest);
            case "rectangle" -> new Rectangle(shapeRequest);
            case "triangle" -> new Triangle(shapeRequest);
            case "line" -> new LineSegment(shapeRequest);
            case "square" -> new Square(shapeRequest);
            default -> null;
        };
    }
}
