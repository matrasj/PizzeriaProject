package pizzaVisual;

import javax.swing.*;
import java.util.Map;

public class VeganPizzaFrame extends PizzaFrame{
    public VeganPizzaFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField) {
        super(currentOrder, pizza, currentDueTextField);
        super.getPizzaNameLabel().setText("Vegan pizza :)");
        super.getPizzaDescriptionLabel().setText(Pizza.VEGAN.getUnNumeratedInfoList());
        super.getPizzaIconLabel().setIcon(new ImageIcon("PizzaIcons\\FourthPizza.png"));
    }


}
