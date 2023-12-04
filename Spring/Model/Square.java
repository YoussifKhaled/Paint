package dev.PainterApplication.Painter.Model;

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
        this.height = 100;
        this.width = 100;
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
    public void draw() {
        System.out.println("draw Square");
    }
}
