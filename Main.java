package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        System.out.print("1-Register\n2-Login\n3-Display items only\n0-Exit \n");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        sc.nextLine();
        try
        {
            Thread.sleep(20);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(choice == 1)
        {
            int quantity = 0;
            Boolean isExist = false;
            System.out.print("Enter Your Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Your Email : ");
            String email = sc.nextLine();
            System.out.print("Enter Your Password : ");
            String password = sc.nextLine();
            System.out.print("Enter Your Address : ");
            String address = sc.nextLine();
            System.out.print("Enter Your Phone : ");
            String phone = sc.nextLine();
            System.out.print("Enter Your Balance : ");
            double balance = sc.nextDouble();
            System.out.print("Enter Your credit card num : ");
            int creditCardNUm = sc.nextInt();
            sc.nextLine();
            try
            {
                Thread.sleep(20);
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            Manager ma = new Manager();

            if(ma.register(name , email , password , address , phone , balance , creditCardNUm))
            {
                System.out.println("registration successfully");
                customer cust =new customer(name, email, password, address, phone , balance , creditCardNUm);
                System.out.print("1-Display items only\n2-Make order\n0-Exit\n");
                int choice1;
                choice1 = sc.nextInt();
                try
                {
                    Thread.sleep(20);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sc.nextLine();
                if(choice1 == 1)
                {
                    catalog  ca = new catalog("catalog.txt");
                    ca.displayItem();
                    System.exit(0);
                }
                else if(choice1 == 2)
                {
                    shoppingCart sCart = new shoppingCart(cust);
                    catalog  ca = new catalog("catalog.txt");
                    ca.displayItem();
                    System.out.print("how many items you want : ");
                    int numOfItems = sc.nextInt();
                    sc.nextLine();
                    while ( numOfItems > 0){
                        System.out.print("Enter Name of item : ");
                        String itemName = sc.nextLine();
                        for (items itm : ca.getItem())
                        {
                            if(itemName.equals(itm.getNameOfItem()))
                            {
                                isExist = true;
                                System.out.print("quantity of items you want : ");
                                quantity = sc.nextInt();
                                int temp = quantity ;
                                sc.nextLine();
                                while(itm.getQuantity() <quantity)
                                {
                                    System.out.print("Quantity is not Available Now \n");
                                    System.out.print("choose quantity less than "+ itm.getQuantity() + " : ");
                                    quantity =  sc.nextInt();
                                }
                                while (temp>0) {
                                    sCart.addItem(itm);
                                    temp--;
                                }
                                System.out.println("Done");
                                if(cust.getBalance()>= (sCart.getTotalPrice()) && sCart.getTotalPrice()!=0 && itm.getQuantity()-quantity!=0 )
                                {
                                    ma.delete(itm);
                                    itm.setQuantity(itm.getQuantity()-quantity);
                                    ma.add(itm);
                                    break;
                                }
                                else if(cust.getBalance()>= (sCart.getTotalPrice()) && sCart.getTotalPrice()!=0 && itm.getQuantity()-quantity==0)
                                {
                                    ma.delete(itm);
                                    break;
                                }
                                break;
                            }
                        }
                        if(isExist==false)
                        {
                            System.out.print("Item Name is not Available \n");
                            numOfItems++;
                        }
                        numOfItems--;
                        isExist=false;
                    }
                    try
                    {
                        Thread.sleep(500);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("payment by : \n 1-your balance \n 2-credit card\n ");
                    int choice2 = sc.nextInt();
                    sc.nextLine();
                    if(choice2==1)
                    {
                        payment payment = new payment();
                        payment.setPayMethod("balance");
                        order or;
                        or = new order(cust , sCart , payment);
                        if(cust.getBalance()>= (sCart.getTotalPrice()) && sCart.getTotalPrice()!=0)
                        {
                            ma.delete(cust);
                            cust.setBalance(cust.getBalance()-(sCart.getTotalPrice()));
                            cust.setOrder(or);
                            ma.add(cust);
                            System.out.println("Your Order Has Been Placed Successfully - _ -");
                            System.out.println("Your Order Price is : " + (sCart.getTotalPrice()));
                            System.out.println("Your Order Items are : ");
                            sCart.display();
                            System.out.println("Your Balance becomes : " + cust.getBalance());
                            or.setPaid(true);
                        }
                        else if(sCart.getTotalPrice()== 0)
                        {
                            System.out.println("No order Done thaks");
                            System.exit(0);
                        }
                        else if(cust.getBalance() < sCart.getTotalPrice())
                        {
                            System.out.println("Insufficient Balance!");
                            System.out.println("Please charge and come back soon");
                            System.exit(0);
                        }
                        else
                        {
                            System.out.println("Unexpected Error!!!");
                            System.exit(0);
                        }
                    }
                    else if(choice2 ==2)
                    {
                        int counter = 2;
                        payment payment = new payment();
                        payment.setPayMethod("credit card");
                        System.out.println("please enter you credit card num : ");
                        int cc = sc.nextInt();
                        while (!(cc == cust.getCreditCardNum()) && counter>0) {
                            System.out.println("Wrong credit card num!!! ");
                            System.out.print("you have "+counter+" chance pleas type the correct num : ");
                            cc = sc.nextInt();
                            counter--;
                        }
                        if((cc == cust.getCreditCardNum()))
                        {
                            if(sCart.getTotalPrice()>0)
                            {
                                order or;
                                or = new order(cust , sCart , payment);
                                cust.setOrder(or);
                                System.out.println("Your Order Has Been Placed Successfully - _ -");
                                System.out.println("Your Order Price is : " + (sCart.getTotalPrice()));
                                System.out.println("Your Order Items are : ");
                                sCart.display();
                                or.setPaid(true);
                            }
                            else if(sCart.getTotalPrice()== 0)
                            {
                                System.out.println("No order Done thaks");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Unexpected Error!!!");
                                System.exit(0);
                            }
                        }
                        else
                        {
                            System.out.println("sorry order cancelled");
                            System.exit(0);
                        }
                    }

                }
                else
                {
                    System.exit(0);
                }
            }
            else
            {
                System.out.println("This email is existed");
                System.exit(0);
            }

        }
        else if(choice == 2)
        {
            int quantity = 0;
            Boolean isExist = false;
            System.out.print("Enter Your Email : ");
            String email = sc.nextLine();
            System.out.print("Enter Your Password : ");
            String password = sc.nextLine();
            Manager ma = new Manager();
            try
            {
                ma.Login(email, password);
                customer cust = new customer(ma.Login(email , password));
                if(cust != null)
                {
                    System.out.println("Login successfully");
                    System.out.print("1-Display items only\n2-Make order\n0-Exit\n");
                    int choice1;
                    choice1 = sc.nextInt();
                    try
                    {
                        Thread.sleep(20);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sc.nextLine();
                    if(choice1 == 1)
                    {
                        catalog  ca = new catalog("catalog.txt");
                        ca.displayItem();
                    }
                    else if(choice1 == 2)
                    {
                        shoppingCart sCart = new shoppingCart(cust);
                        catalog  ca = new catalog("catalog.txt");
                        ca.displayItem();
                        System.out.print("how many items you want : ");
                        int numOfItems = sc.nextInt();
                        sc.nextLine();
                        while ( numOfItems > 0){
                            System.out.print("Enter Name of item : ");
                            String itemName = sc.nextLine();
                            for (items itm : ca.getItem())
                            {
                                if(itemName.equals(itm.getNameOfItem()))
                                {
                                    isExist = true;
                                    System.out.print("quantity of items you want : ");
                                    quantity = sc.nextInt();
                                    int temp = quantity ;
                                    sc.nextLine();
                                    while(itm.getQuantity() <quantity)
                                    {
                                        System.out.print("Quantity is not Available Now \n");
                                        System.out.print("choose quantity less than "+ itm.getQuantity() + " : ");
                                        quantity =  sc.nextInt();
                                    }
                                    while (temp>0) {
                                        sCart.addItem(itm);
                                        temp--;
                                    }
                                    System.out.println("Done");
                                    if(cust.getBalance()>= (sCart.getTotalPrice()) && sCart.getTotalPrice()!=0 && itm.getQuantity()-quantity!=0 )
                                    {
                                        ma.delete(itm);
                                        itm.setQuantity(itm.getQuantity()-quantity);
                                        ma.add(itm);
                                        break;
                                    }
                                    else if(cust.getBalance()>= (sCart.getTotalPrice()) && sCart.getTotalPrice()!=0 && itm.getQuantity()-quantity==0)
                                    {
                                        ma.delete(itm);
                                        break;
                                    }
                                }
                            }
                            if(isExist==false)
                            {
                                System.out.print("Item Name is not Available \n");
                                numOfItems++;
                            }
                            numOfItems--;
                            isExist=false;
                        }
                        try
                        {
                            Thread.sleep(500);
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("payment by : \n 1-your balance \n 2-credit card\n ");
                        int choice2 = sc.nextInt();
                        sc.nextLine();
                        if(choice2==1)
                        {
                            payment payment = new payment();
                            payment.setPayMethod("balance");
                            order or;
                            or = new order(cust , sCart , payment);
                            if(cust.getBalance()>= (sCart.getTotalPrice()) && sCart.getTotalPrice()!=0)
                            {
                                ma.delete(cust);
                                cust.setBalance(cust.getBalance()-(sCart.getTotalPrice()));
                                cust.setOrder(or);
                                ma.add(cust);
                                System.out.println("Your Order Has Been Placed Successfully - _ -");
                                System.out.println("Your Order Price is : " + (sCart.getTotalPrice()));
                                System.out.println("Your Order Items are : ");
                                sCart.display();
                                System.out.println("Your Balance becomes : " + cust.getBalance());
                                or.setPaid(true);
                            }
                            else if(sCart.getTotalPrice()== 0)
                            {
                                System.out.println("No order Done thaks");
                                System.exit(0);
                            }
                            else if(cust.getBalance() < sCart.getTotalPrice())
                            {
                                System.out.println("Insufficient Balance!");
                                System.out.println("Please charge and come back soon");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Unexpected Error!!!");
                                System.exit(0);
                            }
                        }
                        else if(choice2 ==2)
                        {
                            int counter = 2;
                            payment payment = new payment();
                            payment.setPayMethod("credit card");
                            System.out.println("please enter you credit card num : ");
                            int cc = sc.nextInt();
                            while (!(cc == cust.getCreditCardNum()) && counter>0) {
                                System.out.println("Wrong credit card num!!! ");
                                System.out.print("you have "+counter+" chance pleas type the correct num : ");
                                cc = sc.nextInt();
                                counter--;
                            }
                            if((cc == cust.getCreditCardNum()))
                            {
                                if(sCart.getTotalPrice()>0)
                                {
                                    order or;
                                    or = new order(cust , sCart , payment);
                                    cust.setOrder(or);
                                    System.out.println("Your Order Has Been Placed Successfully - _ -");
                                    System.out.println("Your Order Price is : " + (sCart.getTotalPrice()));
                                    System.out.println("Your Order Items are : ");
                                    sCart.display();
                                    or.setPaid(true);
                                }
                                else if(sCart.getTotalPrice()== 0)
                                {
                                    System.out.println("No order Done thaks");
                                    System.exit(0);
                                }
                                else
                                {
                                    System.out.println("Unexpected Error!!!");
                                    System.exit(0);
                                }
                            }
                            else
                            {
                                System.out.println("sorry order cancelled");
                                System.exit(0);
                            }
                        }

                    }
                    else
                    {
                        System.exit(0);
                    }
                }
            }
            catch (Exception e) {
                // Login unsuccessful, handle the error or prompt the user for valid credentials
                System.out.println(e.getMessage());
            }
        }
        else if(choice == 3)
        {
            catalog  ca = new catalog("catalog.txt");
            ca.displayItem();
            System.exit(0);
        }
        else
        {
            System.exit(0);
        }
        sc.close();
    }
}
