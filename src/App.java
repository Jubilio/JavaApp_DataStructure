
import javax.swing.JOptionPane;

import service.NameManager;

public class App {

    public static void main(String[] args) {
        NameManager nameManager = new NameManager();

        int opt = 5;

        do {

            opt = Integer.parseInt(JOptionPane.showInputDialog(
                    """
                    Choose an option:
                    1. Add Name
                    2. Show Names
                    3. Remove Name
                    4. Clear Names
                    5. Exit
                    """));

            switch (opt) {
                case 1: {
                    System.out.println(
                            nameManager.addName(
                                    JOptionPane.showInputDialog("Enter a name:")));
                    break;
                }
                case 2:
                    System.out.println("Showing all names:");
                    String names = nameManager.showAllNames();
                    JOptionPane.showMessageDialog(null, names, "List Name", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3: {
                    System.out.println("Enter the name to remove:");
                    System.out.println(
                            nameManager.removeName(
                                    JOptionPane.showInputDialog("Enter a name:")));
                    break;
                }
                case 4: {
                    System.out.println("All names cleared.");
                    nameManager.clearNames();
                    break;
                }
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (opt != 5);
    }
}