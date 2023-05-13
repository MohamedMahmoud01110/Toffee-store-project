# Toffee-shop
toffee shop online store System - README

Files Included:
1. catalog.java
2. order.java
5. payment.java
6. shoppingCart.java
7. items.java
8. customer.java
9. manager.java
10. shoppingCart.java
11. otp.java
12. README.txt

Description:
This program is toffee shop online store System  that allows customers to create orders, add items to their shopping cart, and make payments. It provides classes to represent customers, shopping carts, items, orders, and payments.

Files:

1. order.java:
   - Represents an order in the system.
   - Includes methods to access customer information, shipping address, phone number, payment status, and payment method.
   - Provides a constructor to initialize an order object.

2. payment.java:
   - Represents the payment method for an order.
   - Includes a method to set the payment method and another method to get the payment method.
   - Provides a constructor to initialize a payment object.

3. shoppingCart.java:
   - Represents a shopping cart for a customer.
   - Manages a list of items, allowing customers to add and remove items.
   - Provides methods to get the items in the cart, calculate the total price with discounts, and display the items.
   - Provides a constructor to initialize a shopping cart object.

4. items.java:
   - Represents an item/product.
   - Includes attributes for the name, price, and discount percentage of the item.
   - Provides a constructor to initialize an item object.

5. customer.java:
   - Represents a customer.
   - Includes attributes for the name, address, and phone number of the customer.
   - Provides a constructor to initialize a customer object.
 
6. manager.java:
   - Represents the manager of the Order Management System.
   - Handles customer interactions, order processing, and payment management.
   - Includes methods for creating new orders, updating order status, processing payments, and managing customer details.
   - Provides a constructor to initialize a manager object.
      
7. catalog.java:
   - The catalog data file should follow a specific format where each line represents an item's information, separated by commas.
   - The expected format for each item in the file is as follows:
    Name, Brand, Description, Category, Price, Quantity, DiscountPercentage

8. main.java:
Description:
  - This program implements an online shopping system where users can register, login, and make orders. 
  - The program provides a menu-driven interface for users to interact with different functionalities such as registration, item display, and order placement. It uses a Manager class to handle user registration and login, a Catalog class to manage the list of available items, a ShoppingCart class to handle the user's shopping cart, and an Order class to represent an order.
  - The program will display a menu with the following options:
   - 1: Register
   - 2: Login
   - 3: Display items only
   - 0: Exit

   - Select an option by entering the corresponding number and press Enter.

   - If you choose option 1 (Register), follow the prompts to enter your details such as name, email, password, address, phone, balance, and credit card number.

   - After successful registration, you will be presented with additional options to display items or make an order.

   - If you choose option 2 (Login), enter your email and password to log in.

   - After successful login, you will also have options to display items or make an order.

   - If you choose option 3 (Display items only), all available items will be displayed on the console.

   - If you choose to make an order, you will be prompted to enter the number of items you want. Then, for each item, enter the name and quantity. The program will check the availability of the items, update the shopping cart, and process the payment.

   - Follow the on-screen instructions to complete the order and receive a confirmation message.

   - Exit the program by choosing option 0 (Exit) from the main menu.



   
6. README.txt:
   - This file. Provides information about the program, files included, and tools used for development.

Tools Used:
- Programming Language: Java
- Integrated Development Environment (IDE): [Insert IDE name, e.g., Eclipse, IntelliJ IDEA, Visual Studio Code]
- Compiler/Interpreter: [Insert compiler/interpreter name, e.g., JDK (Java Development Kit)]
- Version Control: [Insert version control tool used, e.g., Git]
- Documentation: [Insert any specific documentation tool used, e.g., Javadoc]

Usage:
1. Compile the Java files using a Java compiler.
2. Run the compiled program.
3. [Add any additional instructions or steps for running the program, if applicable]

Feel free to explore and modify the code to suit your requirements.

