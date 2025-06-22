package ecommerce;

import java.text.DecimalFormat;

public class Product {

    private int id;
    private String name = "";
    private double cost;
    private static double taxRate = 0.25; // Default tax rate
    private double markup = 0.13; // Default markup rate

    // Package Private methods
    void setProductId (int id) {
        this.id = id;
    }
    void setName (String name){
        this.name = name;
    }
    void setCost (Double cost){
        this.cost = cost;
    }

    double getCost () {    
        return cost;
    }    // returns the wholesale cost of the item

    /* parameter is between 0 and 1.
    values outside this range should be ignored and a default
    value of .13 used */
    static void setTaxRate (double taxRate){
        if (taxRate >= 0 && taxRate <= 1){
            Product.taxRate = taxRate;
        } else {
            Product.taxRate = 0.25;
        }
    }

    /* parameter is between 0 and 1.
    values outside this range should be ignored, and a default 
    value of 0.25 used */
    void setMarkUp(Double markup){
        if (markup >= 0 && markup <= 1) {
            this.markup = markup;
        } else {
            this.markup = 0.13;
        }
    } // Parameter is between 0 and 1

    // Public methods
    public int getProductId(){
        return id;
    }
    public String getName(){
        return name;
    }

    /* returns the retail price for the item
    retail price = (wholesaleCost * (1 + markup)) * (1 + taxRate)
    */
    public double getRetailPrice(){
        double retailPrice = (cost * (1 + markup)) * (1 + taxRate);
        return retailPrice;
    }

    // Returns the markup as a decimal between 0 and 1
    public double getMarkupRate(){
        return markup;
    }

    // Returns a string consisting of the item name, a colon, a space, and the retail price of the item rounded up to 2 decimal places
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        String roundedPrice = df.format(getRetailPrice());
        return name+": "+roundedPrice;
    }

    // Static method to return the tax rate
    // Returns the tax rate as a decimal between 0 and 1
    public static double getTaxRate(){
        return taxRate;
    }
}