package dev.PainterApplication.Painter.Model;


public class Circle extends Shape{
    private double radius;
    public Circle(){}
    public Circle(double radius,double x,double y,String color){
        this.radius=radius;
        this.x = x;
        this.y = y;
        this.color=color;
    }
    public Circle(ShapeRequest shapeRequest) {
        super(shapeRequest);
        if(shapeRequest.getRadius()==0){
            this.radius = 50;
        }
        else{
            this.radius=shapeRequest.getRadius();
        }
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
