package service;

import java.util.HashSet;

import javax.swing.JOptionPane;

public class NameManager {
    private HashSet<String> names;

    public NameManager() {
        this.names = new HashSet<>();
    }

    public String addName(final String name) {
        names.add(name);
        return "Name: " + name;
    }

    public String showAllNames() {
        if (names.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No names available.");
            return "No names available.";
        }
        for (String n : names) {
            // Print to console
            System.out.println("Name: " + n);
            //JOptionPane.showMessageDialog(null, "Name: " + n);
        }
        return "Name: " + names.toString();
    }

    public String removeName(final String name) {
        if (names.remove(name)) {
            return "Name removed: " + name;
        } else {
            return "Name not found: " + name;
        }
    }
    public void clearNames() {
        names.clear();
        JOptionPane.showMessageDialog(null, "All names cleared.");
    }
}
