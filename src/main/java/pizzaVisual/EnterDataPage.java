package pizzaVisual;

import skeleton.BackButton;
import skeleton.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnterDataPage implements ActionListener, MouseListener {
    private Map<Pizza, Integer> orders;
    private List<JTextField> textFieldList = new ArrayList<>(); // no for additional info !
    private List<JLabel> labels = new ArrayList<>();

    private CurrentDueTextField currentDueTextField;

    private JTextField nameTextField = new JTextField();
    private JLabel nameLabel = new JLabel("Name and surname ");

    private JTextField phoneNumberTextField = new JTextField();
    private JLabel phoneNumberLabel = new JLabel("Phone number ");

    private JTextField addressTextField = new JTextField();
    private JLabel addressLabel = new JLabel("Address ");

    private JTextField additionalInfoTextField = new JTextField();
    private JLabel additionalInfoAboutOrder = new JLabel("Additional info about order ");

    private JButton submitOrder = new JButton("Submit :)");

    private JFrame frame = new JFrame("Final page");
    private JPanel textFieldsPanel = new JPanel(new GridLayout(4, 1, 100, 100));

    private BackButton backButton = new BackButton();
    public EnterDataPage(Map<Pizza, Integer> orders, CurrentDueTextField currentDueTextField) {
        this.currentDueTextField = currentDueTextField;
        backButton.setBounds(685, 0, 100, 50);
        backButton.addMouseListener(this);
        backButton.addActionListener(this::actionPerformed);

        textFieldList.add(nameTextField);
        textFieldList.add(phoneNumberTextField);
        textFieldList.add(addressTextField);
        textFieldList.add(additionalInfoTextField);

        labels.add(nameLabel);
        labels.add(phoneNumberLabel);
        labels.add(addressLabel);
        labels.add(additionalInfoAboutOrder);

        nameLabel.setBounds(100, 80, 250, 50);
        addressLabel.setBounds(240, 280, 250, 50);
        phoneNumberLabel.setBounds(160, 470, 300, 50);
        additionalInfoAboutOrder.setBounds(0, 660, 350, 50);

//        addressLabel.setBounds(120, );
        // adres i additional

        this.orders = orders;
        frame.setSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        textFieldsPanel.setBounds(350, 50, 300, 700);
        textFieldsPanel.setBackground(Color.LIGHT_GRAY);

        for (JTextField textField:this.textFieldList) {
            textField.setFont(new Font("MV Boli", Font.BOLD, 25));
            textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            // terAZ ROBISZ TEXT FIELDY NA DANE IMIE ITP POTEM DODAJESZ PRZYCISZ SUMBIT I JAK TO KLIKNIECZ TO WYWOŁUJESZ
            textFieldsPanel.add(textField); // STATYCZAN METODĘ Z KLASY ORDER LOGIC I JEST SUPI
        }

        for (JLabel label:this.labels) {
            label.setFont(new Font("MV Boli", Font.BOLD, 25));
            label.setForeground(Color.BLACK);

        }

        submitOrder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        submitOrder.addActionListener(this::actionPerformed);
        submitOrder.addMouseListener(this);
        submitOrder.setFont(new Font("MV Boli", Font.BOLD, 20));
        submitOrder.setForeground(Color.BLACK);
        submitOrder.setBackground(Color.LIGHT_GRAY);
        submitOrder.setFocusable(false);
        submitOrder.setBounds(660, 650, 120, 100);

        frame.add(currentDueTextField);
        frame.add(backButton);
        frame.add(nameLabel);
        frame.add(addressLabel);
        frame.add(phoneNumberLabel);
        frame.add(additionalInfoAboutOrder);
        frame.add(textFieldsPanel);
        frame.add(submitOrder);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backButton)) {
            frame.dispose();
            new MenuFrame(orders, currentDueTextField);
        }

        if (e.getSource().equals(submitOrder)) {
            frame.dispose();
            new FinalPage(orders, currentDueTextField);
            String[] nameAndSurname = nameTextField.getText().split(" ");
            OrderLogic.writeOrderIntoTheFile(orders, nameAndSurname[0], nameAndSurname[1], phoneNumberTextField.getText(),
                    addressTextField.getText(), additionalInfoTextField.getText());


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
        if (e.getSource().equals(submitOrder)) {
            submitOrder.setForeground(Color.CYAN);
            submitOrder.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(submitOrder)) {
            submitOrder.setForeground(Color.BLACK);
            submitOrder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        }
    }


}
