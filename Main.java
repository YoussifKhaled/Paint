import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        String geometricalShape=null;
        geometricalShape=cin.nextLine();
        AbstractFactory shapeFactory;
        if(geometricalShape.equals("Circle") || geometricalShape.equals("Ellipse")){
             shapeFactory=FactoryProducer.createFactory("Elliptical");
        }
        else if (geometricalShape.equals("Rectangle") || geometricalShape.equals("Triangle")) {
             shapeFactory=FactoryProducer.createFactory("Polygon");
        } else {
             shapeFactory=FactoryProducer.createFactory("Base");
        }
        Shape newShape=shapeFactory.getShape(geometricalShape);
        double []coordintes=new double[2];
        if(newShape instanceof Circle){
            Circle c=(Circle)newShape;
            coordintes=c.getCoordinates();
            System.out.println("Dimensions: X="+coordintes[0]+" Y="+coordintes[1]+"\nRadius="+c.getRadius());
        }
        else if(newShape instanceof Ellipse){
            Ellipse e=(Ellipse) newShape;
            coordintes=e.getCoordinates();
            System.out.println("Dimensions: X="+coordintes[0]+" Y="+coordintes[1]+"\nMajor axis="+e.getMajorAxisLength()+" Minor axis="+e.getMinorAxisLength());
        }
        else if(newShape instanceof Rectangle){
            Rectangle r=(Rectangle) newShape;
            coordintes=r.getCoordinates();
            System.out.println("Dimensions: X="+coordintes[0]+" Y="+coordintes[1]+"\nHeight="+r.getHeight()+" Width="+r.getWidth());

        }
        else if(newShape instanceof Triangle){
            Triangle t=(Triangle) newShape;
            coordintes=t.getCoordinates();
            System.out.println("Dimensions: X="+coordintes[0]+" Y="+coordintes[1]+"\nSide length="+t.getSideLength());
        }
        else{
            LineSegment l=(LineSegment) newShape;
            coordintes=l.getCoordinates();
            System.out.println("Dimensions: X="+coordintes[0]+" Y="+coordintes[1]+"\nlength="+l.getLength());
        }
    }
}