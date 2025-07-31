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
@Table(name = "tbl_product")
public class Product {
    @Id
    @Column(name = "ProductId", nullable = false)
    private String id;

    @Column(name = "ProductName", nullable = false, length = 100)
    private String name;

    @Column(name = "Price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "InvoiceId")
    private Invoice invoice;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}