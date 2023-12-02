import java.util.Scanner;

public class EllipticalShapes implements AbstractFactory{
    @Override
    public Shape getShape(String ellipticalShape){
        //creating default circle
        if(ellipticalShape.equals("Circle")){
                return new Circle();
        }
        //creating default ellipse
        else if(ellipticalShape.equals("Ellipse")){
            return new Ellipse();
        }
        else{
            return null;
        }
    }
}
