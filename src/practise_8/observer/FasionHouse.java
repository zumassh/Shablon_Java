package practise_8.observer;

import java.util.ArrayList;
import java.util.Scanner;

public class FasionHouse {
    private String trendColor;
    private ArrayList<Customer> customers;

    public FasionHouse(String trendColor) {
        this.trendColor = trendColor;
        this.customers = new ArrayList<>();
    }
    public void subscribe(Customer c){
        customers.add(c);
    }
    public void unsubscribe(Customer c){
        try {
            customers.remove(c);
        } catch (Exception e) {
            System.out.println("Такого покупателя нет.");
        }
    }
    public void notifyCustomers(){
        for (Customer c : customers){
            c.update(trendColor);
        }
    }
    public void changeTrendColor(){
        Scanner sc = new Scanner(System.in);
        String color = sc.nextLine();
        trendColor = color;
        notifyCustomers();
    }

}
