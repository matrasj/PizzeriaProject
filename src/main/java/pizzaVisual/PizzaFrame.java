package pizzaVisual;

import skeleton.BackButton;
import skeleton.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class PizzaFrame implements ActionListener, MouseListener {
    private Map<Pizza, Integer> currentOrder = new HashMap<>(6);
    private Pizza pizza;

    private JFrame frame = new JFrame("PizzaFrame");
    private JLabel pizzaIconLabel = new JLabel();
    private JLabel pizzaNameLabel = new JLabel("NAME LABEL");
    private JLabel pizzaDescriptionLabel = new JLabel();
    private JLabel howManyPizzasLabel = new JLabel("Choose quantity");
    private JTextField howManyPizzasTextField = new JTextField();
    private JTextField howMuchToPay = new JTextField();
    private JButton addToTheOrder = new JButton("ADD");
    private JButton addPizzaButton = new JButton("+");
    private JButton deletePizzaButton = new JButton("-");
    private BackButton backButton = new BackButton();
    private JLabel priceLabel = new JLabel();
    private CurrentDueTextField currentDueTextField = new CurrentDueTextField(currentOrder);

    public PizzaFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField) {
        this.currentDueTextField = currentDueTextField;
        currentDueTextField.setBounds(0, 0, 100, 40);
        this.currentOrder = currentOrder;
       // data (we would not like to modify)
        this.pizza = pizza;

        frame.setSize(new Dimension(1000, 900));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY); // frame  (we would not like to modify)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pizzaIconLabel.setBackground(Color.RED);
        pizzaIconLabel.setBounds(50, 100, 250 ,250);  // Here we give pizza's icon in
        pizzaIconLabel.addMouseListener(this);// inherit class

        priceLabel.setBounds(50, 50, 200, 50);
        priceLabel.setText(String.valueOf("Price: " + pizza.getPrice()));
        priceLabel.setBackground(Color.LIGHT_GRAY);
        priceLabel.setForeground(Color.CYAN);
        priceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        priceLabel.setHorizontalAlignment(JLabel.CENTER);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));


        pizzaNameLabel.setBounds(50, 370, 250, 50);
        pizzaNameLabel.setFont(new Font("MV Boli", Font.BOLD, 30));  // Here we give pizza's name in
        pizzaNameLabel.setHorizontalAlignment(JLabel.CENTER);                  // inherit class

        pizzaDescriptionLabel.setText(Pizza.MARGHERITA.getUnNumeratedInfoList());  // Here we call method
        pizzaDescriptionLabel.setBounds(50, 350, 500, 400);      // on pizza which particular class
        pizzaDescriptionLabel.setFont(new Font("Arial", Font.BOLD, 20)); // inherits
        pizzaDescriptionLabel.setForeground(Color.MAGENTA);

        howManyPizzasTextField.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        howManyPizzasTextField.setFocusable(false);
        howManyPizzasTextField.setText("0");
        howManyPizzasTextField.setBounds(350, 175, 100, 50);
        howManyPizzasTextField.setFont(new Font("Arial", Font.BOLD, 30));
        howManyPizzasTextField.setBackground(Color.LIGHT_GRAY);
        howManyPizzasTextField.setForeground(Color.CYAN);

        addPizzaButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        addPizzaButton.setFocusable(false);
        addPizzaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        addPizzaButton.setBounds(475, 150, 50, 50);
        addPizzaButton.setBackground(Color.LIGHT_GRAY);
        addPizzaButton.addMouseListener(this);
        addPizzaButton.addActionListener(this::actionPerformed);
        addPizzaButton.setForeground(Color.BLACK);

        howMuchToPay.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        howMuchToPay.setFocusable(false);
        howMuchToPay.setText("0");
        howMuchToPay.setBounds(350, 300, 200, 50);
        howMuchToPay.setFont(new Font("Arial", Font.BOLD, 30));
        howMuchToPay.setBackground(Color.LIGHT_GRAY);
        howMuchToPay.setForeground(Color.CYAN);

        addToTheOrder.setBounds(560, 190, 200, 50);
        addToTheOrder.setBackground(Color.LIGHT_GRAY);
        addToTheOrder.setFont(new Font("MV Boli", Font.BOLD, 30));
        addToTheOrder.setHorizontalAlignment(JLabel.CENTER);
        addToTheOrder.addMouseListener(this);
        addToTheOrder.addActionListener(this::actionPerformed);
        addToTheOrder.setFocusable(false);
        addToTheOrder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));



        deletePizzaButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        deletePizzaButton.setFocusable(false);
        deletePizzaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        deletePizzaButton.setForeground(Color.BLACK);
        deletePizzaButton.setBounds(475, 225, 50, 50);
        deletePizzaButton.setBackground(Color.LIGHT_GRAY);
        deletePizzaButton.addMouseListener(this);
        deletePizzaButton.addActionListener(this::actionPerformed);



        backButton.addMouseListener(this);
        backButton.addActionListener(this::actionPerformed);


        frame.add(currentDueTextField);
        frame.add(addToTheOrder);
        frame.add(howManyPizzasTextField);
        frame.add(howMuchToPay);
        frame.add(backButton);
        frame.add(addPizzaButton);
        frame.add(deletePizzaButton);
        frame.add(pizzaIconLabel);
        frame.add(pizzaNameLabel);
        frame.add(pizzaDescriptionLabel);
        frame.add(priceLabel);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public Map<Pizza, Integer> getCurrentOrder() {
        return currentOrder;
    }

    public Pizza getPizza() {
        return pizza;
    }



    public JFrame getFrame() {
        return frame;
    }



    public JLabel getPizzaNameLabel() {
        return pizzaNameLabel;
    }

    public JLabel getPizzaDescriptionLabel() {
        return pizzaDescriptionLabel;
    }

    public JLabel getHowManyPizzasLabel() {
        return howManyPizzasLabel;
    }

    public JTextField getHowManyPizzasTextField() {
        return howManyPizzasTextField;
    }

    public JButton getAddPizzaButton() {
        return addPizzaButton;
    }

    public JButton getDeletePizzaButton() {
        return deletePizzaButton;
    }

    public BackButton getBackButton() {
        return backButton;
    }

    public void setCurrentOrder(Map<Pizza, Integer> currentOrder) {
        this.currentOrder = currentOrder;
    }


    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }



    public void setPizzaNameLabel(JLabel pizzaNameLabel) {
        this.pizzaNameLabel = pizzaNameLabel;
    }

    public void setPizzaDescriptionLabel(JLabel pizzaDescriptionLabel) {
        this.pizzaDescriptionLabel = pizzaDescriptionLabel;
    }

    public void setHowManyPizzasLabel(JLabel howManyPizzasLabel) {
        this.howManyPizzasLabel = howManyPizzasLabel;
    }

    public JLabel getPizzaIconLabel() {
        return pizzaIconLabel;
    }

    public void setPizzaIconLabel(JLabel pizzaIconLabel) {
        this.pizzaIconLabel = pizzaIconLabel;
    }

    public void setHowManyPizzasTextField(JTextField howManyPizzasTextField) {
        this.howManyPizzasTextField = howManyPizzasTextField;
    }

    public void setAddPizzaButton(JButton addPizzaButton) {
        this.addPizzaButton = addPizzaButton;
    }

    public void setDeletePizzaButton(JButton deletePizzaButton) {
        this.deletePizzaButton = deletePizzaButton;
    }

    public void setBackButton(BackButton backButton) {
        this.backButton = backButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backButton)) {
            frame.dispose();
            new MenuFrame(currentOrder, currentDueTextField);
        }

        if (e.getSource().equals(addPizzaButton)) {
            howManyPizzasTextField.setText(String.valueOf(Integer.parseInt(howManyPizzasTextField.getText()) + 1));
            howMuchToPay.setText(String.format(String.valueOf(Double.parseDouble(howManyPizzasTextField.getText()) * pizza.getPrice()), "%2f"));
        }

        if (e.getSource().equals(deletePizzaButton)) {
            if (Integer.parseInt(howManyPizzasTextField.getText()) > 0) {
                howManyPizzasTextField.setText(String.valueOf(Integer.parseInt(howManyPizzasTextField.getText()) - 1));
                howMuchToPay.setText(String.format(String.valueOf(Double.parseDouble(howManyPizzasTextField.getText()) * pizza.getPrice()), "%2f"));
            }
        }

        if (e.getSource().equals(addToTheOrder)) {
            currentDueTextField.setText(String.valueOf(Double.parseDouble(currentDueTextField.getText()) +
                    (Integer.parseInt(howManyPizzasTextField.getText()) * pizza.getPrice())));
            if (this.currentOrder.containsKey(pizza)) {
                currentOrder.replace(pizza, currentOrder.get(pizza), currentOrder.get(pizza) + Integer.parseInt(howManyPizzasTextField.getText()));
            } else {
                this.currentOrder.put(pizza, Integer.parseInt(howManyPizzasTextField.getText()));
            }
            howManyPizzasTextField.setText("0");
            howMuchToPay.setText("0.0");



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
        if (e.getSource().equals(pizzaIconLabel)) {
            pizzaIconLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            pizzaDescriptionLabel.setForeground(Color.CYAN);
        }

        if (e.getSource().equals(addPizzaButton)) {
            addPizzaButton.setForeground(Color.CYAN);
            addPizzaButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        }

        if (e.getSource().equals(deletePizzaButton)) {
            deletePizzaButton.setForeground(Color.CYAN);
            deletePizzaButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        }

        if (e.getSource().equals(addToTheOrder)) {
            addToTheOrder.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            addToTheOrder.setForeground(Color.CYAN);
        }

    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(pizzaIconLabel)) {
            pizzaIconLabel.setBorder(null);
            pizzaDescriptionLabel.setForeground(Color.MAGENTA);
        }

        if (e.getSource().equals(addPizzaButton)) {
            addPizzaButton.setForeground(Color.BLACK);
            addPizzaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        }

        if (e.getSource().equals(deletePizzaButton)) {
            deletePizzaButton.setForeground(Color.BLACK);
            deletePizzaButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        }

        if (e.getSource().equals(addToTheOrder)) {
            addToTheOrder.setForeground(Color.BLACK);
            addToTheOrder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        }


    }

    //    public static void main(String[] args) {
//        new PizzaFrame(null, null, null);
//    }


}
