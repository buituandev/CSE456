package vn.edu.eiu.lab5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @Column(name = "CustomerId", nullable = false)
    private String id;

    @Column(name = "CustomerName", columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "CustomerAddress", nullable = false)
    private String address;

    @Column(name = "Email", columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "PhoneNumber", nullable = false)
    private String phoneNumber;

    public Customer(String id, String name, String address, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Invoice> invoices = new ArrayList<>();
    
    public void addInvoice(Invoice invoice) {   
        invoices.add(invoice);
        invoice.setCustomer(this);
    }
}
