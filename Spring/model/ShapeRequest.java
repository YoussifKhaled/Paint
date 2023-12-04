package com.example.paint.model;

public class ShapeRequest {
    private String shapeType;
    private double x;
    private double y;
    private String Id;

    public ShapeRequest(){
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

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
}
