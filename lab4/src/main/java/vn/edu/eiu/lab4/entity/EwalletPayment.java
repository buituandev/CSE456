package vn.edu.eiu.lab4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class EwalletPayment implements PaymentMethod {
    @Id
    private String walletId;
    private String walletProvider;

    @Override
    public void makePayment() {
        System.out.println("Processing eWallet Payment...");
        System.out.println("Wallet Provider: " + walletProvider);
        System.out.println("Wallet ID: " + walletId);
        System.out.println("eWallet payment successful!");
        System.out.println("----------------------------------------");
    }
}
