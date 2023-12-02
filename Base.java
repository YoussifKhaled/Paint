public class Base implements AbstractFactory{
    @Override
    public Shape getShape(String base){
        if(base.equals("Line")){
            return new LineSegment();
        }
        else{
            return null;
        }
    }
}
