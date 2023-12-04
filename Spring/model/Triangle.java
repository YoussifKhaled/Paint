package com.example.paint.model;

public class Triangle extends Shape {
    private double length;
    private double[] points;

    public Triangle(){

    }

    public Triangle(double length){

        this.length = length;
    }

    public Triangle(ShapeRequest shapeRequest) {
        super(shapeRequest);
        points = new double[6];
        this.length = 200;
    }

    public double getLength() {
        return length;
    }

    public double[] getPoints() {
        points[0] = this.x - 0.5 * this.length;
        points[1] = this.y + 0.2887 * this.length;
        points[2] = this.x + 0.5 * this.length;
        points[3] = points[1];
        points[4] = this.x;
        points[5] = this.y - 0.5773 * this.length;
        return points;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    public void draw(){

        System.out.println("Triangle is drawn");
    }
}