package dev.PainterApplication.Painter.Model;

public class LineSegment extends Shape{
    private double[] points;
    private double length;
    public LineSegment(ShapeRequest shapeRequest){
        super(shapeRequest);
        this.length = 200;
        if(shapeRequest.getPoints() == null){
            points = new double[]{0, 0,this.length , 0};
        }
        else{
            this.points = shapeRequest.getPoints();
        }
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
}