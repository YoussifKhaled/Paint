package com.example.paint.model;

public class Ellipse extends Shape{
    private double radiusY;
    private double radiusX;

    public Ellipse(){

    }

    public Ellipse(double radiusY, double radiusX){
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipse(ShapeRequest shapeRequest) {
        super(shapeRequest);
        this.radiusX = 70;
        this.radiusY = 35;
    }

    public void setRadiusY(double radiusY){

        this.radiusY = radiusY;
    }
    public void setRadiusX(double radiusX){

        this.radiusX =radiusX;
    }
    public double getRadiusY(){

        return radiusY;
    }
    public double getRadiusX(){
        return radiusX;
    }

    @Override
    public void draw(){
        System.out.println("Ellipse is drawn");
    }
}
