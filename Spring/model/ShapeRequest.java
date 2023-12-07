package com.example.paint.model;


public class ShapeRequest {
    private String type;
    private double x;
    private double y;
    private String Id;
    private String fill;
    private double radius;
    private double radiusX;
    private double radiusY;
    private double height;
    private double width;
    private double sideLength;
    private double length;
    private String stroke;
    private double[] points;

    public ShapeRequest(){

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius){this.radius=radius;}
    public void setHeight(double height){this.height=height;}
    public void setWidth(double width){this.width=width;}
    public void setSideLength(double sideLength){this.sideLength=sideLength;}
    public void setLength(double length){this.length=length;}
    public void setFill(String fill){this.fill = fill;}
    public void setRadiusX(double radiusX){this.radiusX=radiusX;}
    public void setRadiusY(double radiusY){this.radiusY=radiusY;}
    public String getType() {
        return type;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getId() {
        return Id;
    }
    public String getFill(){return fill;}
    public double getRadius(){return radius;}
    public double getHeight(){return height;}
    public double getWidth(){return width;}
    public double getSideLength() {return sideLength;}
    public double getLength() {return length;}
    public double getRadiusX() {return radiusX;}
    public double getRadiusY() {return radiusY;}
    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStroke() {
        return stroke;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    public double[] getPoints() {
        return points;
    }

}
