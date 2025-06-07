package service;

import java.util.HashMap;

public class ProductManager {

    HashMap<String, Integer> productStock;

    // This HashMap will hold product names as keys and their stock quantities as
    // values.
    // For example: productStock.put("Apple", 50) means there are 50 Apples in
    // stock.
    public ProductManager() {
        productStock = new HashMap<>();
    }

    // Method to add a product with its stock quantity
    public void addProduct(String productName, int quantity) {
        if (productStock.containsKey(productName)) {
            productStock.put(productName, productStock.get(productName) + quantity);
        } else {
            productStock.put(productName, quantity);
        }
    }

    public String viewProducts() {
        if (productStock.isEmpty()) {
            return "No products available.";
        }
        StringBuilder productList = new StringBuilder("Product List:\n");
        for (String product : productStock.keySet()) {
            productList.append(product).append(": ").append(productStock.get(product)).append("\n");
        }
        return productList.toString();
    }

    public boolean updateProductStock(String productName, int newQty) {
        if (productStock.containsKey(productName)) {
            productStock.put(productName, newQty);
            return true;
        }
        return false;
    }

}
