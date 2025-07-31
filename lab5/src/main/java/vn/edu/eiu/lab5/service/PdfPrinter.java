package vn.edu.eiu.lab5.service;

import org.springframework.stereotype.Service;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.entity.Product;

@Service
public class PdfPrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("===== INVOICE =====");
        System.out.println("Customer: " + invoice.getCustomer().getName());
        System.out.println("Products:");
        double total = 0.0;
        for (Product product : invoice.getProducts()) {
            System.out.printf("- %s: $%.2f\n", product.getName(), product.getPrice());
            total += product.getPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
        System.out.println("===================");
    }
}
