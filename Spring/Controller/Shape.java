package dev.PainterApplication.Painter.Controller;

import org.springframework.stereotype.Service;

@Service
public abstract class Shape implements Cloneable{
    private int id;
    protected double center_X,center_Y;

    abstract void draw();
    protected void setCenter_X(double center_X){
        this.center_X=center_X;
    }
    public double getCenter_X(){
        return center_X;
    }
    public double getCenter_Y(){
        return center_Y;
    }
    protected void setCenter_Y(double center_Y){
        this.center_Y=center_Y;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Object Clone(){
        Object clone=null;
        try{
            clone=super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }

}
