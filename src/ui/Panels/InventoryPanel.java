package ui.Panels;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

    private JTextArea inventoryTextArea;

    public InventoryPanel(GamePanel gamePanel) { // Change Panel to GamePanel
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Inventory"));

        // Initialize and configure the text area for displaying inventory
        inventoryTextArea = new JTextArea();
        inventoryTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(inventoryTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    // Method to update the inventory display
    public void updateInventory(String inventoryText) {
        inventoryTextArea.setText(inventoryText);
    }

    // Method to get the panel itself
    public JPanel getPanel() {
        return this;
    }

    // Other methods related to inventory management can be added here
}
