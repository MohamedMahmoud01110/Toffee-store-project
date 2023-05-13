package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class catalog
{
    private ArrayList<items> Item;

    public catalog(String filePath)
    {
        this.Item = new ArrayList<>();
        toFile(filePath);
    }

    /**
     * @return ArrayList<items>
     */
    public ArrayList<items> getItem() {
        return Item;
    }

    public void setItem(items item)
    {
        this.Item.add(item);
    }

    public void deleteItem(items item)
    {
        this.Item.remove(item);
    }


    /**
     * @param filePath
     */
    //this function for load the item from file
    public void toFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (fields.length == 7 ) {
                    String name = fields[0];
                    String brandName = fields[1];
                    String description = fields[2];
                    String category = fields[3];
                    double price = Double.parseDouble(fields[4].trim());
                    int quantity = Integer.parseInt(fields[5].trim());
                    double discountPercentage = Double.parseDouble(fields[6]);
                    items item = new items(name, brandName, description, category, price, quantity,discountPercentage);
                    this.Item.add(item);
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Catalog file isn't found ");
        }
    }



    //this function for display an items from catalog
    public  void displayItem()
    {
        for (items itm : Item)
        {
            System.out.println("- The name of  product : " + itm.getNameOfItem() + " - Price = "
                    + itm.getPriceOfItem() + "  - Description :" + itm.getDescription()
                    + " - The name of brand: " + itm.getBrandName() + " - Type: " + itm.getCategory()
                    + " - Discount Percentage : " + itm.getDiscountPercentage() + "\n");
        }

    }

}
