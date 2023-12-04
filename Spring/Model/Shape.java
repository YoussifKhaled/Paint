package dev.PainterApplication.Painter.Model;

public abstract class Shape implements Cloneable{
    private String id;
    protected double x, y;
    private String stroke,type;

    public Shape(){}
    public Shape(ShapeRequest shapeRequest){
        this.x = shapeRequest.getX();
        this.y = shapeRequest.getY();
        this.type = shapeRequest.getShapeType();
        this.id = shapeRequest.getId();
        this.stroke = "black";
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

    public Object Clone(){
        Object clone = null;
        try{
            clone=super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }

}
