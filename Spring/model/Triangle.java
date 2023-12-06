package com.example.paint.model;

public class Triangle extends Shape {
    private double radius;

    public Triangle(){

    }

    public Triangle(double radius){

        this.radius = radius;
    }

    public Triangle(ShapeRequest shapeRequest) {
        super(shapeRequest);
        this.radius = shapeRequest.getRadius() == 0 ?  100 : shapeRequest.getRadius();

    }
    public double getRadius() {
        return radius;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw(){

        System.out.println("Triangle is drawn");
    }
}