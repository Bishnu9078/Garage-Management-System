package service;

import entity.Invoice;

import java.sql.SQLDataException;
import java.util.List;

public class BillingService {

    public CustomerService customerService=new CustomerService();

    public InvoiceService invoiceService=new InvoiceService();

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws Exception
    {
        for (int serviceId : serviceIds)
        {
            invoiceService.addInvoice(new Invoice (0,customerId,vehicleId,serviceId));
        }
        System.out.println("Invoice created successfully");
    }

    public void showAllInvoices() throws Exception
    {
        List<Invoice> invoices=invoiceService.getAllInvoices();
        for(Invoice invoice:invoices)
        {
            System.out.println(invoice);
        }
    }
}
