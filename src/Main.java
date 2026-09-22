import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FoodOrderingSystem system = new FoodOrderingSystem();

        while (true) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    system.displayMenu();
                    break;

                case 2:
                    searchFood(system);
                    break;

                case 3:
                    filterFood(system);
                    break;

                case 4:
                    addFood(system);
                    break;

                case 5:
                    system.displayCart();
                    break;

                case 6:
                    removeFood(system);
                    break;

                case 7:
                    updateFood(system);
                    break;

                case 8:
                    system.placeOrder();
                    break;

                case 9:
                    system.displayLastOrder();
                    break;

                case 10:
                    System.out.println("Thank you for using the Online Food Ordering System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1 to 10.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("       ONLINE FOOD ORDERING SYSTEM");
        System.out.println("========================================");
        System.out.println("1. View Menu");
        System.out.println("2. Search Food");
        System.out.println("3. Filter by Category");
        System.out.println("4. Add Food to Cart");
        System.out.println("5. View Cart");
        System.out.println("6. Remove Item");
        System.out.println("7. Update Quantity");
        System.out.println("8. Place Order");
        System.out.println("9. View Last Order");
        System.out.println("10. Exit");
        System.out.println("========================================");
    }

    private static void searchFood(FoodOrderingSystem system) {
        System.out.print("Enter food name to search: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return;
        }

        system.searchFood(keyword);
    }

    private static void filterFood(FoodOrderingSystem system) {
        System.out.print("Enter category (VEG or NON-VEG): ");
        String category = scanner.nextLine().trim();

        system.filterByCategory(category);
    }

    private static void addFood(FoodOrderingSystem system) {
        int id = readInt("Enter food ID: ");
        int quantity = readPositiveInt("Enter quantity: ");

        system.addToCart(id, quantity);
    }

    private static void removeFood(FoodOrderingSystem system) {
        int id = readInt("Enter food ID to remove: ");
        system.removeFromCart(id);
    }

    private static void updateFood(FoodOrderingSystem system) {
        int id = readInt("Enter food ID: ");
        int quantity = readPositiveInt("Enter new quantity: ");

        system.updateCart(id, quantity);
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Value must be greater than zero.");
        }
    }
}
