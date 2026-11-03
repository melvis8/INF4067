import java.util.List;

public class Commande {
    private List<Double> prixItems;
    private double total;

    public Commande(List<Double> prixItems) {
        this.prixItems = prixItems;
    }

    // BON : Logique metier propre a la Commande
    public void calculerTotal() {
        this.total = prixItems.stream().mapToDouble(Double::doubleValue).sum();
    }

    // MAUVAIS : Faible cohesion (melange metier et technique)
    // MAUVAIS : Fort couplage (fige sur MYSQL, impossible de charger facilement)
    public void sauvegarderDansBaseMysql(){
        MysqlConnection connexion = new MysqlConnection("location", "root", "password");
        String requete = "INSERT INTO commande (total) VALUE (" + this.total + ")";
        connexion.executerRequest(requete);
    }
}

// Stub minimal pour permettre la compilation (logique inchangee)
class MysqlConnection {
    public MysqlConnection(String location, String user, String password) {
    }
    public void executerRequest(String requete) {
    }
}