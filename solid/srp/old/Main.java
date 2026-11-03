package inf4067.solid.srp;

//Utilisation de la classe Book
public class Main{
public static void main(String[] args){
    Book book = new Book ("Les principes SOLID", "Etudiants de M1-GL", "Revision des principes SOLID");
    book.printToScreen();
    book.saveToDatabase();
    book.emprunter("Martial");
}
}