package com.example.paint.model;


public class Circle extends Shape{
    private double radius;

    public Circle(){
    }

    public Circle(double radius,double x,double y){
        this.radius=radius;
        this.x = x;
        this.y = y;
    }

    public Circle(ShapeRequest shapeRequest) {
        super(shapeRequest);
        this.radius =  shapeRequest.getRadius() == 0 ? 50 :  shapeRequest.getRadius();
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
