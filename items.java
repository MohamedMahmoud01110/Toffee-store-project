package org.example;

//class item for have an items attributes and methods
public class items
{
    private String nameOfItem;
    private String brandName;
    private String description;
    private double priceOfItem;
    private int quantity;
    private String category;
    private double discountPercentage;

    public items(String nameOfItem, String brandName, String description,String category, double priceOfItem, int quantity,double discountPercentage)
    {
        this.nameOfItem = nameOfItem;
        this.brandName = brandName;
        this.description = description;
        this.priceOfItem = priceOfItem;
        this.quantity = quantity;
        this.category = category;
        this.discountPercentage = discountPercentage;
    }

    /**
     * @return String
     */
    public String getNameOfItem()
    {
        return nameOfItem;
    }


    /**
     * @param nameOfItem
     */
    public void setNameOfItem(String nameOfItem)
    {
        this.nameOfItem = nameOfItem;
    }


    /**
     * @return String
     */
    public String getBrandName()
    {
        return brandName;
    }


    /**
     * @param brandName
     */
    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }


    /**
     * @return String
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    /**
     * @return double
     */
    public double getPriceOfItem()
    {
        return priceOfItem;
    }


    /**
     * @param priceOfItem
     */
    public void setPriceOfItem(double priceOfItem)
    {
        this.priceOfItem = priceOfItem;
    }


    /**
     * @return int
     */
    public int getQuantity()
    {
        return quantity;
    }


    /**
     * @param quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


    /**
     * @param category
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * @return String
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param discountPercentage
     */
    public void setDiscountPercentage(double discountPercentage)
    {
        this.discountPercentage = discountPercentage;
    }

    /**
     * @return double
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }



}
