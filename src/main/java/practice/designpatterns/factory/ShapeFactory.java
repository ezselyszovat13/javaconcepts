package practice.designpatterns.factory;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null) {
            throw new RuntimeException("No shape was given.");
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
