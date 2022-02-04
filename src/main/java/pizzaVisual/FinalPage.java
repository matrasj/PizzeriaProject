package pizzaVisual;

import skeleton.BackButton;
import skeleton.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FinalPage implements ActionListener, MouseListener {
    private JFrame frame = new JFrame("Final page");
    private JLabel madeAnOrderLabel = new JLabel("Ordered :)");
    private BackButton backButton = new BackButton();
    private CurrentDueTextField currentDueTextField;

    public FinalPage(Map<Pizza, Integer> orders, CurrentDueTextField currentDueTextField) {
        this.currentDueTextField = currentDueTextField;
        currentDueTextField.setBounds(0, 0, 100, 40);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        frame.setBackground(Color.LIGHT_GRAY);

        madeAnOrderLabel.setFont(new Font("MV Boli", Font.BOLD, 100));
        madeAnOrderLabel.setBounds(0, 0, 800, 800);
        madeAnOrderLabel.setHorizontalTextPosition(JLabel.CENTER);
        madeAnOrderLabel.setHorizontalAlignment(JLabel.CENTER);

        backButton.addMouseListener(this);
        backButton.addActionListener(this::actionPerformed);
        backButton.setBounds(650, 0, 100, 100);

        frame.add(madeAnOrderLabel);
        frame.add(backButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(backButton)) {
            frame.dispose();
            new MenuFrame(new HashMap<Pizza, Integer>(), new CurrentDueTextField(new HashMap<Pizza, Integer>()));
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
