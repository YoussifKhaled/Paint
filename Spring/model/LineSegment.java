package com.example.paint.model;

public class LineSegment extends Shape{
    private double[] points = new double[4];
    private double length;

    public LineSegment(){

    }

    public LineSegment(ShapeRequest shapeRequest){
        super(shapeRequest);
        this.length = 200;
        if(shapeRequest.getPoints() == null){
            points = new double[]{0, 0,this.length , 0};
        }
        else{
            this.points = shapeRequest.getPoints();
        }
    }

    public void setLength(double length){

        this.length = length;
    }
    public double getLength(){

        return length;
    }

    public double[] getPoints() {

        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    @Override
    public void draw(){
        System.out.println("Line segment is drawn");
    }
}