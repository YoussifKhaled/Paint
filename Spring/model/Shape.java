package com.example.paint.model;

public abstract class Shape implements Cloneable{
    private String id,stroke,type, fill;
    protected double x, y;

    public Shape(){

    }
    public Shape(ShapeRequest shapeRequest){
        this.x = shapeRequest.getX();
        this.y = shapeRequest.getY();
        this.type = shapeRequest.getType();
        this.id = shapeRequest.getId();
        this.stroke = "black";
        this.fill = shapeRequest.getFill();
    }

    public abstract void draw();
    public void setX(double x){
        this.x = x;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStroke() {
        return stroke;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getFill() {
        return fill;
    }

    public Object Clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
