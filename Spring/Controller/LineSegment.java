package dev.PainterApplication.Painter.Controller;

public class LineSegment extends Shape{
    private double length;
    //Default line segment of radius 1.0
    public LineSegment(){
        this.length=100;
    }
    //Customized line segment
    LineSegment(double length){
        this.length=length;
    }
    public void setLength(double length){
        this.length=length;
    }
    public double getLength(){
        return length;
    }
    @Override
    public void draw(){
        System.out.println("Line segment is drawn");
    }
}