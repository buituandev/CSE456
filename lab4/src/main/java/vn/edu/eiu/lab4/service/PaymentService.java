package vn.edu.eiu.lab4.service;

import lombok.Setter;
import vn.edu.eiu.lab4.entity.PaymentMethod;
import vn.edu.eiu.lab4.repo.PaymentRepo;

/**
 * Single Responsibility Principle (SRP):
 * This class has a single responsibility - to process payments.
 * It delegates the actual payment processing to the PaymentMethod
 * implementations, while handling the business logic flow.
 */
public class PaymentService {
    private PaymentRepo paymentRepo;
    // Method to change payment method at runtime (demonstrates flexibility)
    @Setter
    private PaymentMethod paymentMethod;

    // Constructor Dependency Injection
    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Business logic for processing payment
    public void pay() {
        paymentMethod.makePayment();
    }
}
