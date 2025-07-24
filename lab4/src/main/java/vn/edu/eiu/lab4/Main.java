package vn.edu.eiu.lab4;

import vn.edu.eiu.lab4.entity.BankTransferPayment;
import vn.edu.eiu.lab4.entity.CardPayment;
import vn.edu.eiu.lab4.entity.EwalletPayment;
import vn.edu.eiu.lab4.entity.PaymentMethod;
import vn.edu.eiu.lab4.service.PaymentService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PaymentMethod card = new CardPayment("1","123456789","Nguyen Van A", LocalDate.parse("2020-02-02"));
        PaymentMethod ewallet = new EwalletPayment("987456123","MOMO");
        PaymentMethod bank = new BankTransferPayment("1","9999999","MB");
        PaymentService paymentService = new PaymentService(card);
        paymentService.pay();
        paymentService.setPaymentMethod(ewallet);
        paymentService.pay();
        paymentService.setPaymentMethod(bank);
        paymentService.pay();
    }
}