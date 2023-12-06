package dev.PainterApplication.Painter.Model;

public class ShapeRequest {
    private String shapeType;
    private double x;
    private double y;
    private String Id;
    private String color;
    private double radius;
    private double radiusX;
    private double radiusY;
    private double height;
    private double width;
    private double sideLength;
    private double length;

    public ShapeRequest(){}

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
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
    public void setColor(String color){this.color=color;}
    public void setRadiusX(double radiusX){this.radiusX=radiusX;}
    public void setRadiusY(double radiusY){this.radiusY=radiusY;}
    public String getShapeType() {
        return shapeType;
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
    public String getColor(){return color;}
    public double getRadius(){return radius;}
    public double getHeight(){return height;}
    public double getWidth(){return width;}
    public double getSideLength() {return sideLength;}
    public double getLength() {return length;}
    public double getRadiusX() {return radiusX;}
    public double getRadiusY() {return radiusY;}
}
