package com.example.paint.model;

public class Square extends Shape{
    private double height;
    private double width;

    public Square(){
    }

    public Square(double height){
        this.height = height;
        this.width = height;
    }

    public Square(ShapeRequest shapeRequest) {
        super(shapeRequest);
        if(shapeRequest.getHeight()==0){
            this.height = 100;
            this.width = 100;
        }
        else{
            this.height=this.width=shapeRequest.getHeight();
        }
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
    public void draw() {
        System.out.println("draw Square");
    }
}
