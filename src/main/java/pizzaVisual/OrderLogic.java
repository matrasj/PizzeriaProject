package pizzaVisual;

import java.io.*;
import java.util.Map;

public class OrderLogic {
    public static boolean writeOrderIntoTheFile(Map<Pizza, Integer> orders, String name, String surname,
                                                String phoneNumber, String address, String addInformation) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("order.txt"), true));
            double totalIncome = 0.0;
            for (Map.Entry<Pizza, Integer> order : orders.entrySet()) {
                bufferedWriter.write("\nPizza: " + order.getKey().name() + ", Quantity: " +
                        order.getValue() + ", Income: " + order.getValue() * order.getKey().getPrice() + "\n");
                totalIncome+=order.getValue() * order.getKey().getPrice();
            }
            bufferedWriter.write("\nTotal income: " + totalIncome + "\n\n");
            bufferedWriter.write("Data: " + "\n");
            bufferedWriter.write("Name: " + name + "\n");
            bufferedWriter.write("Surname: " + surname + "\n");
            bufferedWriter.write("Phone number: " + phoneNumber + "\n");
            bufferedWriter.write("Particular address: " + address + "\n");
            bufferedWriter.write("Additional info: " + addInformation + "\n");
            bufferedWriter.write("============================================");
            bufferedWriter.write("\n");
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
