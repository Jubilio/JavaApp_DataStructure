import javax.swing.JOptionPane;
import service.ProductManager;

public class StoreApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Store Application!");
        ProductManager productManager = new ProductManager();

        int option;
        do {
            // Show the menu; parentComponent is null
            String choice = JOptionPane.showInputDialog(
                null,
                "Choose an option:\n"
              + "1. Add Product\n"
              + "2. View Products\n"
              + "3. Update Product Stock\n"
              + "4. Exit"
            );

            // If user presses "Cancel" choice will be null
            if (choice == null) {
                option = 4; // treat as Exit
            } else {
                try {
                    option = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    option = -1; 
                }
            }

            switch (option) {
                case 1:
                    String productName = JOptionPane.showInputDialog(null, "Enter product name:");
                    if (productName != null) {
                        String qtyStr = JOptionPane.showInputDialog(null, "Enter quantity:");
                        try {
                            int quantity = Integer.parseInt(qtyStr);
                            productManager.addProduct(productName, quantity);
                            JOptionPane.showMessageDialog(null, "Product added successfully!");
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(null, "Invalid quantity.");
                        }
                    }
                    break;

                case 2:
                    String list = productManager.viewProducts(); 
                    // Assuming viewProducts() returns a String representation
                    JOptionPane.showMessageDialog(null, list, "Product List", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    String prodToUpdate = JOptionPane.showInputDialog(null, "Enter product name to update:");
                    if (prodToUpdate != null) {
                        String newQtyStr = JOptionPane.showInputDialog(null, "Enter new stock quantity:");
                        try {
                            int newQty = Integer.parseInt(newQtyStr);
                            boolean success = productManager.updateProductStock(prodToUpdate, newQty);
                            if (success) {
                                JOptionPane.showMessageDialog(null, "Stock updated successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Product not found.");
                            }
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(null, "Invalid quantity.");
                        }
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }

        } while (option != 4);
    }
}
