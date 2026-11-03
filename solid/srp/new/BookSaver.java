package inf4067.solid.srp;
// Classe BookSaver : persistance
class BookSaver {
    public void saveToDatabase(BookSRP book){
        System.out.println("\nSauvegarde de '" + book.getTitle() + "' en base de donnees...");
    }

// On peut ajouter d'autres facons de sauvegarder
    public void saveToFile(BookSRP book, String filename){
        System.out.println("\nSauvegarde de '" + book.getTitle() + "' par " + filename);
    }
}

// classe BookBusinessLogic : Logique metier
class BookBusinessLogic {
    public void emprunter(BookSRP book, String lecteur){
        System.out.println("\nEmprunt du livre'" + book.getTitle() + "' par " + lecteur);
    }

    // on peut ajouter d'autres logiques
    public void autreService(BookSRP book){
        System.out.println("\nAutre logique metier sur le livre '" + book.getTitle());
    }
}