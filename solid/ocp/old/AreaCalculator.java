package inf4067.solid.ocp;

public class AreaCalculator {
    public double calculateArea(Object shape){
        if(shape instanceof Rectangle){
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        }else if(shape instanceof Circle){
            Circle circle = (Circle) shape;
                return Math.PI * circle.getRadius() * circle.getRadius();
        }
        throw new IllegalArgumentException("Unknown shape");
    }
}

// Formes minimales requises par l'exemple (logique inchangee)
class Rectangle {
    private double width;
    private double height;
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

class Circle {
    private double radius;
    public double getRadius() { return radius; }
}