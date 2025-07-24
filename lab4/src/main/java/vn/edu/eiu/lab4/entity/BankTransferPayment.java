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
public class BankTransferPayment implements PaymentMethod {
    @Id
    private String id;
    private String bankAccount;
    private String bankName;

    @Override
    public void makePayment() {
        System.out.println("Processing Bank Transfer...");
        System.out.println("Bank: " + bankName);
        System.out.println("Account: ****" + bankAccount.substring(bankAccount.length() - 4));
        System.out.println("Bank transfer successful!");
        System.out.println("----------------------------------------");
    }
}
