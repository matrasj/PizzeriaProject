package skeleton;

import pizzaVisual.Pizza;
import pizzaVisual.PizzaFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.*;
import java.util.List;

import pizzaVisual.*;

public class MenuFrame implements MouseListener, ActionListener {
    private Font myFont = new Font("MV Boli", Font.BOLD, 80);
    private JFrame frame;
    private JPanel panel;
    private JLabel mainLabel;
    private ImageIcon logoIcon = new ImageIcon("PizzaIcons\\pizzaLogo.png");
    private JButton finishOrderButton = new JButton("MAKE AN ORDER");
    private JButton seeCurrentOrderButton = new JButton("SEE CURRENT ORDER");
    private Map<Pizza, Integer> currentOrder;
    List<JButton> buttonList = new ArrayList<>();
    private CurrentDueTextField currentDueTextField;
    private JButton margheritaButton = new JButton(new ImageIcon("PizzaIcons\\FirstPizza.png"));
    private JButton capriciosaButton = new JButton(new ImageIcon("PizzaIcons\\ThirdPizza.png"));
    private JButton germanButton = new JButton(new ImageIcon("PizzaIcons\\SixthPizza.png"));
    private JButton norwayButton = new JButton(new ImageIcon("PizzaIcons\\SecondPizza.png"));
    private JButton torinoButton = new JButton(new ImageIcon("PizzaIcons\\SixthPizza.png"));
    private JButton veganButton = new JButton(new ImageIcon("PizzaIcons\\FourthPizza.png"));
    public MenuFrame(Map<Pizza, Integer> currentOrder, CurrentDueTextField currentDueTextField) {
        this.currentDueTextField = currentDueTextField;
        this.currentDueTextField.setBounds(0, 100, 100, 40);
        this.currentOrder = currentOrder;
        frame = new JFrame("PizzaProjectApplication");
        frame.setLayout(null);
        frame.setSize(new Dimension(1000, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(205, 200, 188));
        frame.setIconImage(logoIcon.getImage());
        frame.setResizable(false);

        buttonList.add(margheritaButton);
        buttonList.add(capriciosaButton);
        buttonList.add(germanButton);
        buttonList.add(norwayButton);
        buttonList.add(torinoButton);
        buttonList.add(veganButton);



        finishOrderButton.setBounds(750, 0, 235, 50);
        finishOrderButton.setBackground(Color.lightGray);
        finishOrderButton.setForeground(Color.BLACK);
        finishOrderButton.setBorder(null);
        finishOrderButton.setFont(new Font("MV Boli",  Font.BOLD, 20));
        finishOrderButton.setFocusable(false);
        finishOrderButton.addActionListener(this::actionPerformed);
        finishOrderButton.addMouseListener(this);

        seeCurrentOrderButton.setBounds(700, 75, 285, 50);
        seeCurrentOrderButton.setBackground(Color.lightGray);
        seeCurrentOrderButton.setForeground(Color.BLACK);
        seeCurrentOrderButton.setFont(new Font("MV Boli",  Font.BOLD, 20));
        seeCurrentOrderButton.setFocusable(false);
        seeCurrentOrderButton.setBorder(null);
        seeCurrentOrderButton.addActionListener(this::actionPerformed);
        seeCurrentOrderButton.addMouseListener(this);
      
        panel = new JPanel(new GridLayout(2, 3, 0, 100));
        panel.setBounds(0, 165, 1000, 600);
        panel.setBackground(Color.LIGHT_GRAY);

        mainLabel = new JLabel("Choose pizza :)");
        mainLabel.setFont(myFont);
        mainLabel.setBounds(0, 0, 800, 100);
        mainLabel.setForeground(Color.CYAN);


        /*
        *   Adding data to the Frame-Button map
        *
        * */

      

        for (JButton button:this.buttonList) {
            button.setBackground(new Color(206, 161, 152));
            button.addMouseListener(this);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            button.addActionListener(this::actionPerformed);
            button.setFocusable(false);
            panel.add(button);
        }

        frame.add(currentDueTextField);
        frame.add(finishOrderButton);
        frame.add(seeCurrentOrderButton);
        frame.add(panel);
        frame.add(mainLabel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(margheritaButton)) {
            frame.dispose();
            new MargheritaFrame(currentOrder, Pizza.MARGHERITA, currentDueTextField);
        }

        if (e.getSource().equals(torinoButton)) {
            frame.dispose();
            new TorinoFrame(currentOrder, Pizza.TORINO, currentDueTextField);
        }

        if (e.getSource().equals(veganButton)) {
            frame.dispose();
            new VeganPizzaFrame(currentOrder, Pizza.VEGAN, currentDueTextField);
        }

        if (e.getSource().equals(norwayButton)) {
            frame.dispose();
            new NorwayPizzaFrame(currentOrder, Pizza.NORWAY, currentDueTextField);
        }

        if (e.getSource().equals(germanButton)) {
            frame.dispose();
            new GermanPizzaFrame(currentOrder, Pizza.GERMAN, currentDueTextField);
        }

        if (e.getSource().equals(capriciosaButton)) {
            frame.dispose();
            new CapriciosaFrame(currentOrder, Pizza.CAPRICIOSA, currentDueTextField);
        }

        if (e.getSource().equals(finishOrderButton)) {
            frame.dispose();
            new EnterDataPage(currentOrder, currentDueTextField);
        }

        if (e.getSource().equals(seeCurrentOrderButton)) {
            frame.dispose();
            new DisplayCurrentOrderPage(currentOrder, currentDueTextField);
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
        if (e.getSource().equals(margheritaButton)) {
            margheritaButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            mainLabel.setText("Margaritha :)");
        }

        if (e.getSource().equals(capriciosaButton)) {
            capriciosaButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            mainLabel.setText("Capriciosa :)");
        }

        if (e.getSource().equals(torinoButton)) {
            torinoButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            mainLabel.setText("Torino pizza :)");
        }

        if (e.getSource().equals(veganButton)) {
            veganButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            mainLabel.setText("Vegan pizza :)");
        }

        if (e.getSource().equals(germanButton)) {
            germanButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            mainLabel.setText("German pizza :)");
        }

        if (e.getSource().equals(norwayButton)) {
            norwayButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            mainLabel.setText("Norway pizza :)");
        }

        if (e.getSource().equals(finishOrderButton)) {
            finishOrderButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            finishOrderButton.setForeground(Color.CYAN);
        }

        if (e.getSource().equals(seeCurrentOrderButton)) {
            seeCurrentOrderButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            seeCurrentOrderButton.setForeground(Color.CYAN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(margheritaButton)) {
            margheritaButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            mainLabel.setText("Choose pizza :)");
        }
        
        if (e.getSource().equals(capriciosaButton)) {
            capriciosaButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            mainLabel.setText("Choose pizza :)");
        }

        if (e.getSource().equals(torinoButton)) {
            torinoButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            mainLabel.setText("Choose pizza :)");
        }

        if (e.getSource().equals(veganButton)) {
            veganButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            mainLabel.setText("Choose pizza :)");
        }

        if (e.getSource().equals(germanButton)) {
            germanButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            mainLabel.setText("Choose pizza :)");
        }

        if (e.getSource().equals(norwayButton)) {
            norwayButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            mainLabel.setText("Choose pizza :)");
        }
   
        if (e.getSource().equals(finishOrderButton)) {
            finishOrderButton.setBorder(null);
            finishOrderButton.setForeground(Color.black);
        }

        if (e.getSource().equals(seeCurrentOrderButton)) {
            seeCurrentOrderButton.setBorder(null);
            seeCurrentOrderButton.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new MenuFrame(new HashMap<>(6), new CurrentDueTextField(new HashMap<>()));
    }
}
