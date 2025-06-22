package ecommerce;

public class Runner {   
    public static void main(String[] args) {
  
         // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Create some gaming laptop products
        Product laptop1 = new Product();
        laptop1.setProductId(1);
        laptop1.setName("Alienware M15 R6 Gaming Laptop");
        laptop1.setCost(1499.99);
        laptop1.setMarkUp(0.2);

        Product laptop2 = new Product();
        laptop2.setProductId(2);
        laptop2.setName("ASUS ROG Zephyrus G14 Gaming Laptop");
        laptop2.setCost(1399.99);
        laptop2.setMarkUp(0.15);

        // Add gaming laptops to the cart
        cart.addProduct(laptop1);
        cart.addProduct(laptop2);

        // Display cart contents
        System.out.println("Cart Contents:");
        System.out.println(cart.toString());

        // Check if a product is in the cart
        System.out.println(laptop1.getName()+" in Cart: " + cart.hasProduct(laptop1)); // Should be true
        System.out.println(laptop2.getName()+" in Cart: " + cart.hasProduct(laptop1)); // Should be true
        System.out.println("HP Laptop in Cart: " + cart.hasProduct(new Product())); // Should be false

        // Calculate cart total prices
        System.out.printf("Total Cart Price (before tax, market rate): $%.2f\n", cart.beforeTaxPrice());
        System.out.printf("Total Cart Price (with tax and markup): $%.2f\n", cart.totalCartPrice());
        
        // Checkout and display total cost
        double totalCost = cart.checkout();
        System.out.printf("Checkout Complete! Total Cost: $%.2f\n", totalCost);
        System.out.println("Cart Size After Checkout: " + cart.getCartSize()); // Should be 0
    }
}