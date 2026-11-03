package inf4067.solid.dip.old;
class MySQLDatabase {
    public void save(String data){
        System.out.println("Saving to MySQL: " + data);
    }
}

class OrderProcessor {
    private MySQLDatabase database;
    public OrderProcessor(){
        this.database = new MySQLDatabase();
    }
    public void processOrder(String order){
        database.save(order);
    }
}