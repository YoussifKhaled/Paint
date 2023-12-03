package dev.PainterApplication.Painter.Controller;

public class Ellipse extends Shape{
    private double radius_y;
    private double radius_x;
    //Default Ellipse of minor axis of 1.0 and major axis of 1.0
    public Ellipse(){
        this.radius_x=200;
        this.radius_y=100;
    }
    //Customized ellipse
    Ellipse(double radius_y,double radius_x){
        this.radius_x=radius_x;
        this.radius_y=radius_y;
    }
    public void setRadiusY(double radius_y){
        this.radius_y=radius_y;
    }
    public void setRadiusX(double radius_x){
        this.radius_x=radius_x;
    }
    public double getRadiusY(){
        return radius_y;
    }
    public double getRadiusX(){
        return radius_x;
    }

    @Override
    public void draw(){
        System.out.println("Ellipse is drawn");
    }
}
