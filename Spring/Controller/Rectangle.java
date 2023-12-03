package dev.PainterApplication.Painter.Controller;

public class Rectangle extends Shape{
    private double height;
    private double width;
    //Default rectangle of height 1.0 and width 1.0
    public Rectangle(){
        this.height=100;
        this.width=200;
    }
    //Customized rectangle
    Rectangle(double height,double width){
        this.height=height;
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    @Override
    public void draw(){
        System.out.println("Rectangle is drawn");
    }
}
