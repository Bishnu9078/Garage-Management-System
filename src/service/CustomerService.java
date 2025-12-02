package service;

import config.DBConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException {

       Connection conn = DBConfig.getConnection();
       PreparedStatement ps =
               conn.prepareStatement("INSERT INTO customer (name, phone) VALUES (?, ?)");

       ps.setString(1, customer.getName());
       ps.setString(2, customer.getPhone());
       ps.executeUpdate();
       ps.close();
       conn.close();

    }

    public ArrayList<Customer> getAllCustomers() throws SQLException
    {
        List<Customer> list = new ArrayList<>();
        Connection conn = DBConfig.getConnection();
        Statement st = conn.createStatement();
        st.execute("SELECT * FROM customer");
        ResultSet rs=st.executeQuery("SELECT * FROM customer");

        while (rs.next())
        {
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("name"), rs.getString("phone")));
        }
        return (ArrayList<Customer>) list;
    }
}
