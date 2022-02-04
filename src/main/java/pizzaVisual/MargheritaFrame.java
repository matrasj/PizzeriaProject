package pizzaVisual;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public  class MargheritaFrame extends PizzaFrame  {

    public MargheritaFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField) {
        super(currentOrder, pizza, currentDueTextField);
        super.getPizzaNameLabel().setText("Margherita :)");
        super.getPizzaDescriptionLabel().setText(Pizza.MARGHERITA.getUnNumeratedInfoList());
        super.getPizzaIconLabel().setIcon(new ImageIcon("PizzaIcons\\FirstPizza.png"));
        super.getBackButton().setBackground(Color.GREEN);
    }



}
