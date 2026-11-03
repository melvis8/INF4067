package inf4067.solid.lsp;
public class Mainlsp{
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(4); // Attend une aire de 20
        System.out.println("Aire du rectangle ="+rectangle.getArea());

        Rectangle rectangle1 = new Square();
        rectangle1.setWidth(5);
        rectangle1.setHeight(4); // Attend une aire de 20, mais obtient 16 (4x4)
        System.out.println("Aire du carre ="+rectangle1.getArea()); // resultat inattendu
    }
}