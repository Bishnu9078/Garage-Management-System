package service;

import config.DBConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    public void addCustomer(Customer customer) throws SQLException {

        Connection conn = DBConfig.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO customers (name, phone) VALUES (?, ?)");

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());
        ps.executeUpdate();
        ps.close();
        conn.close();

    }

    public List<Customer> getAllCustomers() throws SQLException
    {
        List<Customer> list = new ArrayList<>();
        Connection conn = DBConfig.getConnection();
        Statement st = conn.createStatement();
        st.execute("SELECT * FROM customers");
        ResultSet rs=st.executeQuery("SELECT * FROM customers");

        while (rs.next())
        {
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("name"), rs.getString("phone")));
        }
        return list;
    }

    public Customer getCustomersBasedOnNum() throws SQLException {
        Customer customer = new Customer();
        Connection conn = DBConfig.getConnection();
        Statement st = conn.createStatement();
        st.execute("SELECT * FROM customers");
        ResultSet rs = st.executeQuery("SELECT * FROM customers where phone = ?");

        while (rs.next()) {
            customer = new Customer(rs.getInt("id"),
                    rs.getString("name"), rs.getString("phone"));
        }
        return customer;
    }
}
