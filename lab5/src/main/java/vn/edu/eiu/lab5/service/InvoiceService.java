package vn.edu.eiu.lab5.service;

import org.springframework.stereotype.Service;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.entity.Product;

import java.util.List;

@Service
public class InvoiceService {
    private final PdfPrinter pdfPrinter;

    public InvoiceService(PdfPrinter pdfPrinter) {
        this.pdfPrinter = pdfPrinter;
    }

    public Invoice create(String invoiceId, Customer customer, List<Product> products) {
        Invoice invoice = new Invoice(invoiceId);
        for (Product product : products) {
            invoice.addProduct(product);
        }
        customer.addInvoice(invoice);
        return invoice;
    }

    public void exportInvoiceToPdf(Invoice invoice) {
        pdfPrinter.printInvoice(invoice);
    }
}
