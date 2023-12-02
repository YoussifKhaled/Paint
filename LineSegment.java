
public class LineSegment extends Shape{
    private double length;
    //Default line segment of radius 1.0
    LineSegment(){
        this.length=length=1;
    }
    //Customized line segment
    LineSegment(double length){
        this.length=length;
    }
    public void setLength(double length){
        this.length=length;
    }
    public double getLength(){
        return length;
    }
}