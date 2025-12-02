package service;

import config.DBConfig;
import entity.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceService {

    public void addInvoice(Invoice invoice) throws Exception
    {
        Connection conn = DBConfig.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO invoices (customer_id, vehicle_id,service_id) VALUES (?, ?, ?)");

        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVehicleId());
        ps.setInt(3, invoice.getServiceId());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
