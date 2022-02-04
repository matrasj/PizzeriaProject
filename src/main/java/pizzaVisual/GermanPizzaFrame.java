package pizzaVisual;

import javax.swing.*;
import java.util.Map;

public class GermanPizzaFrame extends PizzaFrame{
    public GermanPizzaFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField){
        super(currentOrder, pizza, currentDueTextField);
        super.getPizzaNameLabel().setText("German pizza :)");
        super.getPizzaDescriptionLabel().setText(Pizza.GERMAN.getUnNumeratedInfoList());
        super.getPizzaIconLabel().setIcon(new ImageIcon("PizzaIcons\\SixthPizza.png"));
    }
}
