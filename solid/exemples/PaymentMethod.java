package solid.exemples;

// Interface commune pour tous les moyens de paiement
public interface PaymentMethod {
    void processPayment(double amount);
}

// impementations concretes
class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: " + amount + "CFA");
    }
}

class MobilPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing mobile payment: " + amount + "CFA");
    }
}

class PaypalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing paypal payment: " + amount + "CFA");
    }
}

class CryptoPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment: " + amount + "CFA");
    }
}

class PaymentProcessor2 {
    private PaymentMethod paymentMethod;
    public PaymentProcessor2(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount){
        paymentMethod.processPayment(amount);
    }
}

// utilisation
class MainNew{
    public static void main(String[] args){
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentProcessor2 processor1 = new PaymentProcessor2(creditCard);
        processor1.processPayment(10000);

        PaymentMethod paypal =  new PaypalPayment();
        PaymentProcessor2 processor2 = new PaymentProcessor2(paypal);
        processor2.processPayment(5000);
    }
}
