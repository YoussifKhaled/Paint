public class Rectangle extends Shape{
    private double height;
    private double width;
    //Default rectangle of height 1.0 and width 1.0
    Rectangle(){
        this.height=1;
        this.width=1;
    }
    //Customized rectangle
    Rectangle(double height,double width){
        this.height=height;
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
}
