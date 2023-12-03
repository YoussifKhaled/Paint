package dev.PainterApplication.Painter.Controller;

import org.springframework.stereotype.Service;

@Service
public class Circle extends Shape{
    private double radius;
    //Default Circle of radius 50
    public Circle(){
        this.radius=50;
    }
    //Customized circle
    Circle(double radius,double X,double Y){
        this.radius=radius;
        this.center_X=X;
        this.center_Y=Y;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    @Override
    public void draw(){
        System.out.println("Circle is drawn");
    }

}
