package skeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BackButton extends JButton implements ActionListener, MouseListener {

    public BackButton() {
        this.setText("BACK");
        this.addActionListener(this::actionPerformed);
        this.addMouseListener(this);
        this.setFocusable(false);
        this.setBounds(835 , 10, 150, 100);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        this.setForeground(Color.black);
        this.setBackground(Color.lightGray);
        this.setFont(new Font("MV Boli", Font.BOLD, 30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
        if (e.getSource().equals(this)) {
            this.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
            this.setForeground(Color.CYAN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(this)) {
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            this.setForeground(Color.BLACK);
        }
    }
}
