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
        if(shapeRequest.getRadiusX()==0 || shapeRequest.getRadiusY()==0){
            this.radiusX = 70;
            this.radiusY = 35;
        }
        else{
            this.radiusX=shapeRequest.getRadiusX();
            this.radiusY=shapeRequest.getRadiusY();
        }
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
