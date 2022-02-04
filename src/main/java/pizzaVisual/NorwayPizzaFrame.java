package pizzaVisual;

import javax.swing.*;
import java.util.Map;

public class NorwayPizzaFrame extends PizzaFrame{
    public NorwayPizzaFrame(Map<Pizza, Integer> currentOrder, Pizza pizza, CurrentDueTextField currentDueTextField) {
        super(currentOrder, pizza, currentDueTextField);
        super.getPizzaNameLabel().setText("Norway pizza :)");
        super.getPizzaDescriptionLabel().setText(Pizza.NORWAY.getUnNumeratedInfoList());
        super.getPizzaIconLabel().setIcon(new ImageIcon("PizzaIcons\\SecondPizza.png"));
    }

}
