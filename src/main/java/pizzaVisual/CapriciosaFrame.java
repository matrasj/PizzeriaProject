package pizzaVisual;

import javax.swing.*;
import java.util.Map;

public class CapriciosaFrame extends PizzaFrame{
    public CapriciosaFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField) {
        super(currentOrder, pizza, currentDueTextField);
        super.getPizzaNameLabel().setText("Capriscioa :) :)");
        super.getPizzaDescriptionLabel().setText(Pizza.CAPRICIOSA.getUnNumeratedInfoList());
        super.getPizzaIconLabel().setIcon(new ImageIcon("PizzaIcons\\ThirdPizza.png"));
    }
}
