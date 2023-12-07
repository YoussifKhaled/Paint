package dev.PainterApplication.Painter.Model;

public abstract class Shape implements Cloneable{
    private String id;
    protected double x, y;
    protected String color;
    private String type;

    public Shape(){}
    public Shape(ShapeRequest shapeRequest){
        this.x = shapeRequest.getX();
        this.y = shapeRequest.getY();
        this.type = shapeRequest.getType();
        this.id = shapeRequest.getId();
        this.color=shapeRequest.getFill();
    }
    public abstract void draw();
    //Setters
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setColor(String color){this.color=color;}
    public void setType(String type) {
        this.type = type;
    }
    //Getters
    public String getType() {
        return type;
    }
    public String getColor(){return color;}
    public String getId(){
        return id;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    //Copying Shape
    public Object Clone(){
        try{
            return super.clone();
        }
        catch (CloneNotSupportedException e){
            throw new InternalError();
        }
    }

}
