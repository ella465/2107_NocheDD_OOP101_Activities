import java.util.Scanner;

public class CanteenFoodMenu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] food = {
            "Chicken Rice",
            "Hotdog Rice",
            "Bread",
            "Siomai Rice",
            "Lemonade"
        };

        double[] price = {
            60.00,
            50.00,
            20.00,
            65.00,
            40.00
        };

        int totalItems = 0;
        double totalBeforeDiscount = 0.00;
        double totalDiscount = 0.00;

        char orderAgain = 'Y';

        while (orderAgain == 'Y') {

            System.out.println("\n===== CANTEEN FOOD MENU =====");

            for (int i = 0; i < food.length; i++) {
                System.out.printf("%d. %-15s - $%.2f%n",
                        i + 1, food[i], price[i]);
            }

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > 5 || quantity < 1) {
                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = Character.toUpperCase(
                    input.next().charAt(0));

            double subtotal = price[itemNumber - 1] * quantity;

            double discountRate = 0.00;

            if (student == 'Y' && subtotal >= 500) {
                discountRate = 0.15;
            } else if (student == 'Y') {
                discountRate = 0.10;
            } else if (subtotal >= 500) {
                discountRate = 0.05;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            System.out.printf("%nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            totalItems += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            System.out.print(
                "\nDo you want to order again? (Y/N): "
            );

            orderAgain = Character.toUpperCase(
                    input.next().charAt(0));
        }

        double finalAmount =
                totalBeforeDiscount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);

        System.out.printf(
                "Total before discount: $%.2f%n",
                totalBeforeDiscount);

        System.out.printf(
                "Total discount: $%.2f%n",
                totalDiscount);

        System.out.printf(
                "Final amount: $%.2f%n",
                finalAmount);

        System.out.println("Thank you for ordering!");

        input.close();
    }
}