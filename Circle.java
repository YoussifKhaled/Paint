public class Circle extends Shape{
    private double radius;
    //Default Circle of radius 1.0
    Circle(){
        this.radius=1;
    }
    //Customized circle
    Circle(double radius,double X,double Y){
        this.radius=radius;
        this.center_X=X;
        this.center_Y=Y;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }

}
