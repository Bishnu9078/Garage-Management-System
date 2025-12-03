package service;

import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BillingService service = new BillingService();

        while (true) {
            System.out.println("1. Add Customer with vehicle \n2. Generate Invoice \n3. Show Invoice \n4. Exit");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Customer name:");
                    String name = sc.next();
                    System.out.println("phone:");
                    String phone = sc.next();
                    service.customerService.addCustomer(new Customer(0, name, phone));
                    System.out.println("Enter vehicle number:");
                    String Vehiclenum= sc.next();
                    System.out.println("Enter vehicle model");
                    String model = sc.next();
                    service.customerBasedOnNum = service.customerService.getCustomersBasedOnNum(phone);
                    service
                    break;


                case 2:
                    System.out.println("Customer ID:");
                    int cid = sc.nextInt();
                    System.out.println("Enter vehicle ID:");
                    int vid = sc.nextInt();
                    System.out.println("Enter number of services:");
                    int n= sc.nextInt();
                    List<Integer> sids=new ArrayList<>();
                    for (int i=0 ; i<n; i++)
                {
                    System.out.println("Enter service ID:");
                    sids.add(sc.nextInt());
                }
                    service.createInvoice(cid, vid, sids);
                    break;


                case 3:
                    service.showAllInvoices();
                    break;
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
