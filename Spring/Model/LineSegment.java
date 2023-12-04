package dev.PainterApplication.Painter.Model;

public class LineSegment extends Shape{
    private double[] points;
    private double length = 200;

    public LineSegment(){

    }

    public LineSegment(ShapeRequest shapeRequest){
        super(shapeRequest);
        points = new double[4];
    }

    public void setLength(double length){

        this.length = length;
    }
    public double getLength(){

        return length;
    }

    public double[] getPoints() {
        points[0] = this.x;
        points[1] = this.y;
        points[2] = this.x + this.length;
        points[3] = this.y;
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    @Override
    public void draw(){
        System.out.println("Line segment is drawn");
    }
}