package pizzaVisual;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class CurrentDueTextField extends JTextField {
    public CurrentDueTextField(Map<Pizza, Integer> currentOrder) {
        this.setBounds(10, 0, 100, 40);
        this.setFont(new Font("Arial", Font.BOLD, 15));
        this.setFocusable(false);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.setForeground(Color.CYAN);
        this.setBackground(Color.GRAY);
        double totalDue = 0.0;
        for (Map.Entry<Pizza, Integer> pizzas:currentOrder.entrySet()) {
            totalDue += pizzas.getValue() * pizzas.getKey().getPrice();
        }

        this.setText(String.format(String.valueOf(totalDue), "%.2f"));
    }
}
