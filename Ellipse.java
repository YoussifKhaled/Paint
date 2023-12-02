public class Ellipse extends Shape{
    private double minor_axis_length;
    private double major_axis_length;
    //Default Ellipse of minor axis of 1.0 and major axis of 1.0
    Ellipse(){
        this.major_axis_length=1;
        this.minor_axis_length=1;
    }
    //Customized ellipse
    Ellipse(double minor_axis_length,double major_axis_length){
        this.major_axis_length=major_axis_length;
        this.minor_axis_length=minor_axis_length;
    }
    public void setMinorAxisLength(double minor_axis_length){
        this.minor_axis_length=minor_axis_length;
    }
    public void setMajorAxisLength(double major_axis_length){
        this.major_axis_length=major_axis_length;
    }
    public double getMinorAxisLength(){
        return minor_axis_length;
    }
    public double getMajorAxisLength(){
        return major_axis_length;
    }
}
