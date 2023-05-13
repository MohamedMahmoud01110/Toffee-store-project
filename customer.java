package org.example;

public class customer
{
    private String name;
    private String Email;
    private String password;
    private String address;
    private String phone;
    private int creditCardNUm;
    private double balance;
    private order order;

    public customer(String name, String email, String password , String address , String phone , double balance , int creditCardNUm)
    {
        this.name = name;
        this.Email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
        this.creditCardNUm = creditCardNUm;
    }
    public customer( customer cust)
    {
        this.name = cust.name;
        this.Email = cust.Email;
        this.password = cust.password;
        this.address = cust.address;
        this.phone = cust.phone;
        this.balance = cust.balance;
        this.creditCardNUm = cust.creditCardNUm;
    }



    /**
     * @return String
     */
    public String getName()
    {
        return name;
    }


    /**
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return String
     */
    public String getAddress()
    {
        return address;
    }


    /**
     * @param address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return String
     */
    public String getPhone()
    {
        return phone;
    }


    /**
     * @param phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }


    /**
     * @return String
     */
    public String getEmail()
    {
        return Email;
    }


    /**
     * @param email
     */
    public void setEmail(String email)
    {
        this.Email = email;
    }


    /**
     * @return String
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return double
     */
    public double getBalance()
    {
        return balance;
    }


    /**
     * @param balance
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    /**
     * @return order
     */
    public order getOrder()
    {
        return order;
    }


    /**
     * @param order
     */
    public void setOrder(order order)
    {
        this.order = order;
    }

    /**
     * @return int
     */
    public int getCreditCardNum()
    {
        return creditCardNUm;
    }


    /**
     * @param creditCardNum
     */
    public void setCreditCardNum(int creditCardNum)
    {
        this.creditCardNUm = creditCardNum;
    }

    public void display()
    {
        System.out.println("Customer Name : "+ name);
        System.out.println("Customer Email : "+ Email);
        System.out.println("Customer Password : "+ password);
        System.out.println("Customer Balance : "+ balance);
        System.out.println("Customer Address : "+ address);
        System.out.println("Customer Phone : "+ phone);
        System.out.println("Customer Credit Card Number : "+ creditCardNUm);
    }
}
