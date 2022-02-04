package pizzaVisual;

import skeleton.BackButton;
import skeleton.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class DisplayCurrentOrderPage implements ActionListener, MouseListener {
    private final Map<Pizza, Integer> currentOrder;
    private JFrame frame = new JFrame("Current order");
    private JLabel mainLabel = new JLabel("Current order");
    private JTextArea currentOrderTextArea = new JTextArea();
    private BackButton backButton = new BackButton();
    private CurrentDueTextField currentDueTextField;

    public DisplayCurrentOrderPage(Map<Pizza, Integer> currentOrder, CurrentDueTextField currentDueTextField) {
        this.currentOrder = currentOrder;
        this.currentDueTextField = currentDueTextField;
        currentDueTextField.setBounds(0, 0, 100, 40);

        backButton.setBounds(650, 30, 100, 100);
        backButton.addActionListener(this::actionPerformed);
        backButton.addMouseListener(this);

        frame.setSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        mainLabel.setFont(new Font("MV Boli", Font.BOLD, 50));
        mainLabel.setBounds(50, 50, 600, 100);
        mainLabel.setForeground(Color.CYAN);

        currentOrderTextArea.setBackground(Color.LIGHT_GRAY);
        currentOrderTextArea.setBorder(null);
        currentOrderTextArea.setFont(new Font("Arial", Font.BOLD, 20));

        currentOrderTextArea.setBounds(50, 150, 700, 600);
        currentOrderTextArea.setFocusable(false);
        currentOrderTextArea.setWrapStyleWord(true);
        currentOrderTextArea.setLineWrap(true);
        currentOrderTextArea.setText(getMapInfo(currentOrder));

        frame.add(currentDueTextField);
        frame.add(mainLabel);
        frame.add(backButton);
        frame.add(currentOrderTextArea);
        frame.setVisible(true);
    }

    private String getMapInfo(Map<Pizza, Integer> currentOrder) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        double totalCost = 0.0;
        for (Map.Entry<Pizza, Integer> currentOrderMap : currentOrder.entrySet()) {
            stringBuilder.append(i).append(". ").append(currentOrderMap.getKey().name()).append(
                    " ---> "
            ).append(currentOrderMap.getKey().getPrice()).append(" x ").append(currentOrderMap.getValue()).append(
                    "    Price --> "
            ).append(currentOrderMap.getKey().getPrice() + " - " + currentOrderMap.getKey().getPizzaDescription()).append(
                    "\n\n"
            );
            totalCost += currentOrderMap.getValue() * currentOrderMap.getKey().getPrice();
            i++;

        }
        stringBuilder.append(String.format("Your total cost for this order --> " + totalCost, "%.2f"));
        return stringBuilder.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backButton)) {
            frame.dispose();
            new MenuFrame(currentOrder, currentDueTextField);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(backButton)) {
            backButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            backButton.setForeground(Color.CYAN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(backButton)) {
            backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            backButton.setForeground(Color.BLACK);
        }
    }


}
