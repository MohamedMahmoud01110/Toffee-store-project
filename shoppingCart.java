package org.example;

import java.util.ArrayList;

public class shoppingCart {
    private ArrayList<items> items;
    private customer customer;

    public shoppingCart(customer customer) {
        this.customer = customer;
        this.items = new ArrayList<items>();
    }


    /**
     * @param item
     */
    public void addItem(items item) {
        items.add(item);
    }


    /**
     * @param item
     */
    public void removeItem(items item) {
        items.remove(item);
    }


    /**
     * @return ArrayList<items>
     */
    public ArrayList<items> getItems() {
        return items;
    }


    /**
     * @return customer
     */
    public customer getcustomer() {
        return customer;
    }


    /**
     * @return double
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (items item : items) {
            totalPrice += (( item.getPriceOfItem() - ((item.getPriceOfItem())*(item.getDiscountPercentage()/100))));
        }
        return totalPrice;
    }
    public void display()
    {
        int counter=1;
        for (items itm : items)
        {
            System.out.println(counter+"- The name of product : " + itm.getNameOfItem());
            counter++;
        }
    }
}