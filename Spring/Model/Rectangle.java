package dev.PainterApplication.Painter.Model;

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
        this.height = 100;
        this.width = 200;
        super.x = x - this.width / 2.0;
        super.y = y - this.height / 2.0;
    }

    public void setHeight(double height){

        this.height=height;
    }
    public void setWidth(double width){

        this.width=width;
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
