package com.example.paint.model;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(){
    }

    public Rectangle(double height,double width){
        this.height=height;
        this.width=width;
    }

    public Rectangle(ShapeRequest shapeRequest) {
        super(shapeRequest);
        if(shapeRequest.getHeight() == 0 || shapeRequest.getWidth() == 0){
            this.height = 100;
            this.width = 200;
        }
        else{
            this.height= shapeRequest.getHeight();
            this.width= shapeRequest.getWidth();
        }
        super.x = x - this.width / 2.0;
        super.y = y - this.height / 2.0;
    }

    public void setHeight(double height){

        this.height = height;
    }
    public void setWidth(double width){

        this.width = width;
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
