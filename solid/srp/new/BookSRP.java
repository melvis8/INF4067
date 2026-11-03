package inf4067.solid.srp;
//Gere les donnees du livre
public class BookSRP{
    private String title;
    private String author;
    private String content;

    public BookSRP(String title, String author, String content){
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Methode pour acceder aux donnees (getters)
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getContent(){ return content; }
}