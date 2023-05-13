package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//this class for store the database of store
public class Manager
{
    protected ArrayList<customer> customers;
    protected catalog catalog;

    public Manager() {
        customers = new ArrayList<>();
    }

    public Manager(ArrayList<customer> customers)
    {
        this.customers = customers;
        try {
            File file = new File("customer.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] p = line.split(",");
                if (p.length == 7) {
                    String name = p[0];
                    String email = p[1];
                    String password = p[2];
                    String address = p[3];
                    String phone = p[4];
                    double balance = Double.parseDouble(p[5]);
                    int creditCardNum = Integer.parseInt(p[6]);
                    customer user = new customer(name , email , password , address , phone , balance , creditCardNum);
                    customers.add(user);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Sorry,Failed to load user information from file");
            e.printStackTrace();
        }
    }


    /**
     * @param name
     */
    //function to read file and check if read .
    public void readFile(String name)
    {
        if(name =="customer.txt" )
        {
            try {
                File file = new File("customer.txt");
                Scanner scanner = new Scanner(file);
                customers.clear();
                while (scanner.hasNextLine())
                {
                    String line = scanner.nextLine();
                    String[] p = line.split(",");
                    if (p.length == 7)
                    {
                        String custName = p[0].trim();
                        String custEmail = p[1].trim();
                        String custPassword = p[2].trim();
                        String custAddress = p[3].trim();
                        String custPhone = p[4].trim();
                        double custBalance = Double.parseDouble(p[5].trim());
                        int custCreditCardNum = Integer.parseInt(p[6].trim());
                        customer cust = new customer(custName, custEmail, custPassword, custAddress, custPhone, custBalance, custCreditCardNum);
                        customers.add(cust);
                    }
                }
                scanner.close();
            } catch (IOException ex) {
                System.out.println("Sorry,Failed to read  information of user from file");
                ex.printStackTrace();
            }
        }
        else if(name == "catalog.txt")
        {
            catalog = new catalog("catalog.txt");
        }
    }

    //function to write in the file
    public void writToFile()
    {
        try {
            File file = new File("customer.txt");
            FileWriter writer = new FileWriter(file);

            for (customer cust : customers) {
                String line = cust.getName() + " , " + cust.getEmail() + " , " + cust.getPassword() + " , " +
                        cust.getAddress() + " , " + cust.getPhone() + " , " + cust.getBalance() + " , " +
                        cust.getCreditCardNum();
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Sorry, Failed to save  information of user to file");
            ex.printStackTrace();
        }
    }



    /**
     * @return boolean
     */
    //registration function
     public  boolean register(String name , String email , String password, String address ,String phone , double balance , int creditCardNum)
     {
         readFile("customer.txt");
             //for check if the email is existed before or not
             for (customer cust : customers) {
                 if (cust.getEmail().equals(email)) {
                     System.out.println("This email is  Exist ");
                     return false;
                 }
             }
              String geneOtp = otp.generateOTP();
                 otp.sendOTPByEmail(email, geneOtp);
                 //verify if the otp is entered and  match with otp sent
             while (true) {
                 if (otp.verifyOtp(geneOtp)) {
                     //create a new user
                     customer cst = new customer(name, email, password, address, phone, balance, creditCardNum);
                     customers.add(cst);
                     // Save updated customer information to the file
                     writToFile();
                     System.out.println("Registration successfully.\n");
                     return true;
                 } else {
                     int choice = 0;
                     System.out.println("otp is not correct\n");
                     System.out.println("press '1' if you want send a new otp\n");
                     Scanner sc = new Scanner(System.in);
                     choice = sc.nextInt();
                     if (choice == 1) {
                         geneOtp = otp.generateOTP();
                         otp.sendOTPByEmail(email, geneOtp);
                         otp.verifyOtp(geneOtp);
                         customer cst = new customer(name, email, password, address, phone, balance, creditCardNum);
                         customers.add(cst);
                         // Save updated customer information to the file
                         writToFile();
                         return true;
                     } else {
                         System.out.println("Sorry! can't register\n");
                         return false;
                     }
                 }

             }
     }
    //registration function
//    public  boolean register(String name , String email , String password, String address ,String phone , double balance , int creditCardNUm)
//    {
//        readFile("customer.txt");
//        //for check if this email is exist before or not
//        for (customer cust : customers)
//        {
//            //check if the email and password are exist
//            if (cust.getEmail().equals(email))
//            {
//                return false;
//            }
//        }
//        customer cst = new customer(name , email , password , address , phone , balance , creditCardNUm);
//        customers.add(cst);
//        //for save  information of customer in file
//        try {
//            File file = new File("customer.txt");
//            FileWriter writer = new FileWriter(file, true);
//            writer.write(name +" , "+ email + " , " + password + " , " + address + " , " + phone + " , " + balance + " , " + creditCardNUm + "\n");
//            writer.close();
//        }
//        catch (IOException ex)
//        {
//            System.out.println("Failed to save user information to file");
//            ex.printStackTrace();
//            return false;
//        }
//        return true;
//    }


    /**
     * @param email
     * @param password
     * @return customer
     * @throws Exception
     */
    //login function enter the email and password
    public customer Login( String email , String password) throws Exception
    {
        readFile("customer.txt");
        //for loop for check if the email and password are exist
        for (customer cst : customers)
        {
            if (cst.getEmail().contains(email) && cst.getPassword().contains(password))
            {
                //if the email and password are exist
                return cst;
            }
        }
        // if entered an email or password isn't correct or if entered email isn't exist
        throw new Exception("Invalid email or password");
    }

    /**
     * @param cust
     */
    //for add new customer information
    public void add(customer cust)
    {
        //for save  information of customer in file
        try {
            File file = new File("customer.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(cust.getName() +" , "+ cust.getEmail() + " , " + cust.getPassword() + " , " + cust.getAddress() + " , " + cust.getPhone() + " , " + cust.getBalance() + " , " + cust.getCreditCardNum() + "\n");
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println("Failed to save user information to file");
            ex.printStackTrace();
        }
    }


    /**
     * @param cust
     */
    //for delete  specified customer information
    public void delete(customer cust)
    {
        String filePath = "customer.txt";  // Specify the path to your file
        String patternToDelete = cust.getName();  // Specify the pattern or content to delete
        try {
            // Read the contents of the file
            File inputFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder sb = new StringBuilder();
            String line;
            // Search for the pattern and omit lines containing it
            while ((line = reader.readLine()) != null) {
                if (!line.contains(patternToDelete)) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
            }
            reader.close();
            // Write the modified contents back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void add(items item)
    {
        //for save  information of customer in file
        try {
            File file = new File("catalog.txt");
            FileWriter writer = new FileWriter(file, true);
            String line = item.getNameOfItem() +" , "+ item.getBrandName() + " , " + item.getDescription()+ " , " + item.getCategory() + " , " + item.getPriceOfItem() + " , " + item.getQuantity() + " , " + item.getDiscountPercentage() ;
            writer.write(line + "\n");
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println("Failed to save user information to file");
            ex.printStackTrace();
        }
    }

    public void delete(items item)
    {
        String filePath = "catalog.txt";  // Specify the path to your file
        String patternToDelete = item.getNameOfItem();  // Specify the pattern or content to delete
        try {
            // Read the contents of the file
            File inputFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder sb = new StringBuilder();
            String line;
            // Search for the pattern and omit lines containing it
            while ((line = reader.readLine()) != null) {
                if (!line.contains(patternToDelete)) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
            }
            reader.close();
            // Write the modified contents back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}








