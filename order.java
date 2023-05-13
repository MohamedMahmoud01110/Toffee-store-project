package org.example;

public class order {
    private customer customer;
    private shoppingCart cart;
    private boolean isPaid;
    private payment payment;

    public order(customer customer, shoppingCart cart,payment payment) {
        this.customer = customer;
        this.cart = cart;
        this.payment = payment;
        this.isPaid = false;
    }


    /**
     * @return customer
     */
    public customer getCustomer() {
        return customer;
    }


    /**
     * @return shoppingCart
     */
    public shoppingCart getCart() {
        return cart;
    }


    /**
     * @return String
     */
    public String getShippingAddress() {
        return customer.getAddress();
    }


    /**
     * @return String
     */
    public String getPhoneNumber() {
        return customer.getPhone();
    }


    /**
     * @return boolean
     */
    public boolean isPaid() {
        return isPaid;
    }


    /**
     * @param paid
     */
    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    /**
     * @return String
     */
    public String getPayMethod() {
        return payment.getPayMethod();
    }

    /**
     * @param payMethod
     */
    public void setPayMethod(String payMethod)
    {
        payment.setPayMethod(payMethod);
    }

}

