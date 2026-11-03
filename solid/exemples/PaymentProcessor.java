package solid.exemples;
public class PaymentProcessor {
    public void processPayment(String paymentType, double amount){
        if (paymentType.equals("mobil_pay")){
            System.out.println("Processing mobile payment: " + amount +"CFA");
            // Logique specifique aux payements mobiles
        } else if (paymentType.equals("credit_card")){
            System.out.println("processing credit card payment: " + amount +" CFA");
            // Logique specifique aux cartes bancaire
        } else if (paymentType.equals("paypal")){
            System.out.println("processing paypal payment: " + amount +" CFA");
            // Logique specifique a paypal
        } else if (paymentType.equals("crypto")){
            System.out.println("processing crypto payment: " + amount +" CFA");
            // Logique specifique aux crypto-monnaies
        }
    }
}
// utilisation

class MainOld {
    public static void main (String[] args){
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("mobile_pay", 1500);
        processor.processPayment("credit_card", 6500);
        processor.processPayment("paypal", 4500);
    }
}