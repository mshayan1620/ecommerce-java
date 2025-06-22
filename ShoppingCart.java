package ecommerce;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {

    private List<Product> cartItems = new ArrayList<>();

    // Public Methods
    public void addProduct(Product product){
        cartItems.add(product);
    } // adds a single object of the product to the cart

    public void removeProduct(Product product) {
        cartItems.remove(product);
    }

    // returns true if product is in cart already, false otherwise
    public boolean hasProduct(Product product) {
        return cartItems.contains(product);
    }

    // returns the total retail cost of the products in the cart, including tax
    public double totalCartPrice() {
        double totalPrice = 0.0;
        for(Product product : cartItems) {
            totalPrice += product.getRetailPrice();
        }
        return totalPrice;
    }

    // returns the total retail cost of products in the cart without tax
    public double beforeTaxPrice() {
        double totalPrice = 0.0;
        for(Product product : cartItems) {
            totalPrice += product.getCost() * (1 + product.getMarkupRate());
        }
        return totalPrice;
    }
    // returns the total cost of the products in the cart, including tax, empties the cart
    public double checkout() {
        double totalPrice = totalCartPrice();
        cartItems.clear(); // Empty the cart after checkout
        return totalPrice;
    }
    // returns the number of items in the cart
    public int getCartSize() {
        return cartItems.size();
    }
    /*
    returns a single String that contains every item in the cart, each on its own line.
    Product lines must be the same format as specified in the Product toString() method.
    */
    public String toString() {
        StringBuilder cartString = new StringBuilder();
        for (Product product : cartItems) {
            cartString.append(product.getName()).append(" $"+product.getCost()).append("\n");
        }
        return cartString.toString().trim(); // Trim to remove extra newline at the end
    }
}