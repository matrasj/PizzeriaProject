package pizzaVisual;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum Pizza {

    MARGHERITA("Basic pizza only with cheese and tmato sauce", true,
            true, false, false, false, false, false, false, 20.42),

    CAPRICIOSA("Pizza with ham cheese and mushrooms", true, true, true, true
    ,false, false, false, false, 25.22),

    GERMAN("Pizza directly form the German country, consists a lot of meat", true ,true,
            true, true, true, false, true, false, 27.12),

    NORWAY("Pizza from cold country, various cheese kinds of", true, true, true,
            false, false, true, true ,true, 27.99),

    TORINO("Pizza for big guys, with a lot of testosterone", true ,true ,true,
            false, true, false, false, true, 30.99),

    VEGAN("Pizza with tomato, without meat", true, true, false, false,
            false, true, true, true, 40.50);

    private String pizzaDescription;
    private final boolean cheese;
    private final boolean tomatoSauce;
    private final boolean ham;
    private final boolean mushrooms;
    private final boolean onion;
    private final boolean blueCheese;
    private final boolean tomato;
    private final boolean corn;
    private final double price;
    private final Map<String, Boolean> ingredientsBooleanMap = new HashMap<>();

    Pizza(String pizzaDescription, boolean cheese, boolean tomatoSauce, boolean ham, boolean mushrooms, boolean onion, boolean blueCheese, boolean tomato, boolean corn,
          double price) {
        this.pizzaDescription = pizzaDescription;
        this.cheese = cheese;
        this.tomatoSauce = tomatoSauce;
        this.ham = ham;
        this.mushrooms = mushrooms;
        this.onion = onion;
        this.blueCheese = blueCheese;
        this.tomato = tomato;
        this.corn = corn;
        this.price = price;
        ingredientsBooleanMap.put("Cheese", this.cheese);
        ingredientsBooleanMap.put("Tomato sauce", this.tomatoSauce);
        ingredientsBooleanMap.put("Ham", this.ham);
        ingredientsBooleanMap.put("Mushrooms", this.mushrooms);
        ingredientsBooleanMap.put("Onion", this.onion);
        ingredientsBooleanMap.put("Blue cheese", this.blueCheese);
        ingredientsBooleanMap.put("Tomato", this.tomato);
        ingredientsBooleanMap.put("Corn", this.corn);
    }
    public String getUnNumeratedInfoList() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html> Ingredients list: ").append("<br/>");
        for (Map.Entry<String, Boolean> ingredient : this.ingredientsBooleanMap.entrySet()) {
            if (ingredient.getValue()) {
                builder.append("<br/>").append(ingredient.getKey());
            }
        }
        builder.append("Price --> " + this.price + "<br/>");
        builder.append(this.pizzaDescription).append("<br/>");
        builder.append("</html>");
        return builder.toString();

    }

    public String getPizzaDescription() {
        return pizzaDescription;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isTomatoSauce() {
        return tomatoSauce;
    }

    public boolean isHam() {
        return ham;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public boolean isOnion() {
        return onion;
    }

    public boolean isBlueCheese() {
        return blueCheese;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isCorn() {
        return corn;
    }

    public double getPrice() {
        return price;
    }

    public Map<String, Boolean> getIngredientsBooleanMap() {
        return ingredientsBooleanMap;
    }
    //    public static void main(String[] args) {
//        System.out.println(Pizza.CAPRICIOSA.getUnNumeratedInfoList());
//    }
}
