public abstract class Shape {
    protected double center_X,center_Y;
    protected void setCoordinates(double center_X,double center_Y){
        this.center_X=center_X;
        this.center_Y=center_Y;
    }
    protected double[]getCoordinates(){
        double []coordinates=new double[2];
        coordinates[0]=center_X;
        coordinates[1]=center_Y;
        return coordinates;
    }
}
