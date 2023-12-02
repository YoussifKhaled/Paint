public class FactoryProducer {
    public static AbstractFactory createFactory(String factoryType){
        if(factoryType.equals(null)){
            return null;
        }
        else if(factoryType.equals("Elliptical")){
            //Creating new elliptical shapes factory
            return new EllipticalShapes();
        }
        else if(factoryType.equals("Polygons")){
            //Creating new polygons factory
            return new Polygon();
        }
        else if(factoryType.equals("Base")){
            //creating new Base factory
            return new Base();
        }
        else{
            return  null;
        }
    }
}
