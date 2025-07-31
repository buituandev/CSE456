package vn.edu.eiu.lab5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.entity.Product;
import vn.edu.eiu.lab5.service.CustomerService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Customer customer = new Customer("C01", "Joe", "NY, NYC", "joe@mail.com", "14567894123");
        Product product = new Product("P01", "Iphone17", 1000d);
        Product product2 = new Product("P02", "Iphone17+", 1500d);
        Product product3 = new Product("P03", "Iphone17 pro", 2000d);
        Invoice invoice = new Invoice("I01");
        invoice.addProduct(product);
        invoice.addProduct(product2);
        invoice.addProduct(product3);

        customer.addInvoice(invoice);
        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.create(customer);
        customerService.exportInvoiceToPdf(invoice);
    }
}