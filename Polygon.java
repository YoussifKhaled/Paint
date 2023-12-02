public class Polygon implements AbstractFactory{
    @Override
    public Shape getShape(String polygonType){
        if(polygonType.equals("Rectangle")){
            return new Rectangle();
        }
        else if(polygonType.equals("Triangle")){
            return new Triangle();
        }
        else{
            return null;
        }
    }
}
