package vn.edu.eiu.lab4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class CardPayment implements PaymentMethod {
    @Id
    private String id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expiryDate;

    @Override
    public void makePayment() {
        System.out.println("Processing Card Payment...");
        System.out.println("Card Number: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card payment successful!");
        System.out.println("----------------------------------------");
    }
}
