package service;

import entity.Customer;
import entity.Invoice;

import java.sql.SQLDataException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BillingService {

    public CustomerService customerService=new CustomerService();

    public InvoiceService invoiceService=new InvoiceService();
    public Customer customerBasedOnNum;

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws Exception
    {
        String sids= "";
        for (int serviceId : serviceIds)
        {
            sids +=serviceId;
        }
        invoiceService.addInvoice(new Invoice (0,customerId,vehicleId,parseInt(sids)));
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
