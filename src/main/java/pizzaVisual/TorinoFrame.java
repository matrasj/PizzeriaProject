package pizzaVisual;

import javax.swing.*;
import java.util.Map;

public class TorinoFrame extends PizzaFrame{
    public TorinoFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField) {
        super(currentOrder, pizza, currentDueTextField);
        super.getPizzaNameLabel().setText("Torino :)");
        super.getPizzaDescriptionLabel().setText(Pizza.TORINO.getUnNumeratedInfoList());
        super.getPizzaIconLabel().setIcon(new ImageIcon("PizzaIcons\\SixthPizza.png"));

    }



}
