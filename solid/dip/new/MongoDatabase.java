package inf4067.solid.dip;
class MongoDBDatabase implements Database {
    @Override 
    public void save(String data){
        System.out.println("Saving to MongoDB: " + data);
    }
}

class OrderProcessor{
    private Database database;
    public OrderProcessor(Database database){
        this.database = database;
    }
    public void processOrder(String order){
        database.save(order);
    }
}