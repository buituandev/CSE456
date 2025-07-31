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
@Table(name = "tbl_invoice")
public class Invoice {
    @Id
    @Column(name = "InvoiceId", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<Product> products = new ArrayList<>();

    public Invoice(String id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setInvoice(this);
    }
}