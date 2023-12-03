package dev.PainterApplication.Painter.Controller;

import java.util.Hashtable;

public class Triangle extends Shape{
    private double side_length;
    //Default triangle of radius 1.0
    public Triangle(){
        this.side_length=100;
    }
    //Customized triangle
    Triangle(double side_length){
        this.side_length=side_length;
    }
    public void setSideLength(double side_length){
        this.side_length=side_length;
    }
    public double getSideLength(){
        return side_length;
    }
    @Override
    public void draw(){
        System.out.println("Triangle is drawn");
    }
}