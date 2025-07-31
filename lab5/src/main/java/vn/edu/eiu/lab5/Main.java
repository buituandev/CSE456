package vn.edu.eiu.lab5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.entity.Product;
import vn.edu.eiu.lab5.service.CustomerService;
import vn.edu.eiu.lab5.service.InvoiceService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Customer customer = new Customer("C01", "Joe", "NY, NYC", "joe@mail.com", "14567894123");
        Product product = new Product("P01", "Iphone17", 1000d);
        Product product2 = new Product("P02", "Iphone17+", 1500d);
        Product product3 = new Product("P03", "Iphone17 pro", 2000d);
        InvoiceService invoiceService = context.getBean(InvoiceService.class);
        Invoice invoice = invoiceService.create("I01",customer, List.of(new Product[]{product, product2, product3}));
        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.create(customer);
        invoiceService.exportInvoiceToPdf(invoice);
    }
}