import java.util.List;

//1. ABSTRACTION (pour garantir le faible couplage)
// ================================================
interface BaseDeDonnees {
    void executer(String requete);
}

// Implementation concrete interchangeable
class MysqlDatabase implements BaseDeDonnees{
    public void executer(String requete){
        System.out.println("Execution MySQL : " + requete);
    }
}

//2. CLASSES AVEC FORTE COHESION
// ===========================================================
// Cette classe ne gere QUE les donnees de la commande
class Commande {
    private List<Double> prixItems;

    public Commande(List<Double> prixItems){
        this.prixItems = prixItems;
    }
   
   public double getCalculerTotal(){
       return prixItems.stream().mapToDouble(Double::doubleValue).sum();
   } 
}

// Cette classe ne gere QUE la persistence(le stockage)
class CommandeRepository{
    private BaseDeDonnees db;

    // Injection de dependance : on recoit l'interface, pas une classe concrete
    public CommandeRepository(BaseDeDonnees db){
        this.db = db; // Faible couplage : accepte MySQL, PostgreSQL, Oracle,etc.
    }

    public void sauvegarder(Commande commande){
        String requete = "INSERT INTO commande (total) VALUES (" + commande.getCalculerTotal() + ")";
        db.executer(requete);
    }
}