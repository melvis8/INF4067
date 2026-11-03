package inf4067.solid.srp;
// classe BookPrinter : presentation
public class BookPrinter{
    // Methode pour afficher le livre a l'ecran
    public void printToScreen(BookSRP book){
        System.out.println("===Print to Screen=== ");
        System.out.println("Titre: " + book.getTitle());
        System.out.println("Auteur: " + book.getAuthor());
        System.out.println("Content: " + book.getContent());
    }

    // On peut ajouter d'autre methodes d'affichage sans toucher a BookSRP
    public void printToHTML(BookSRP book){
        System.out.println("\n===Print to HTML=== ");
        System.out.println("<h1>" + book.getTitle() + "</h1>");
        System.out.println("<h2>par: " + book.getAuthor() + "</h2>");
        System.out.println("<p>: " + book.getContent() + "</p>");
    }
}