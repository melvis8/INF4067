package inf4067.solid.dip;
interface Database{
    public void  save (String data);
}

class MySQLDatabase implements Database {
    @Override 
    public void save(String data){
        System.out.println("Saving to MySQL: " + data);
    }
}