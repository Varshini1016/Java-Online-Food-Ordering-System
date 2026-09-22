import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderingSystem {
    private List<FoodItem> menu = new ArrayList<FoodItem>();
    private Cart cart = new Cart();
    private Order lastOrder;

    private final String menuFile = "data/menu.txt";
    private final String orderFile = "data/orders.txt";

    public FoodOrderingSystem() {
        loadMenu();
    }

    private void loadMenu() {
        File file = new File(menuFile);

        if (!file.exists()) {
            createSampleMenu();
            saveMenu();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length != 4) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String category = parts[2];
                    double price = Double.parseDouble(parts[3]);

                    if (category.equalsIgnoreCase("VEG")) {
                        menu.add(new VegItem(id, name, price));
                    } else {
                        menu.add(new NonVegItem(id, name, price));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipped invalid menu record.");
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to load menu: " + e.getMessage());
        }

        if (menu.isEmpty()) {
            createSampleMenu();
        }
    }

    private void createSampleMenu() {
        menu.add(new VegItem(101, "Vegetable Biryani", 180));
        menu.add(new VegItem(102, "Paneer Pizza", 250));
        menu.add(new VegItem(103, "Masala Dosa", 120));
        menu.add(new NonVegItem(104, "Chicken Biryani", 280));
        menu.add(new NonVegItem(105, "Chicken Burger", 220));
        menu.add(new VegItem(106, "French Fries", 90));
        menu.add(new VegItem(107, "Gulab Jamun", 80));
        menu.add(new VegItem(108, "Fresh Lime Soda", 70));
    }

    private void saveMenu() {
        File file = new File(menuFile);
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (FoodItem item : menu) {
                writer.println(item.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Unable to save menu.");
        }
    }

    public void displayMenu() {
        System.out.println("\n================ FOOD MENU ================");
        System.out.printf("%-5s %-24s %-15s %s%n",
                "ID", "Name", "Category", "Price");
        System.out.println("--------------------------------------------");

        for (FoodItem item : menu) {
            System.out.println(item);
        }
    }

    public void searchFood(String keyword) {
        boolean found = false;

        System.out.println("\nSearch Results:");

        for (FoodItem item : menu) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching food item found.");
        }
    }

    public void filterByCategory(String category) {
        boolean found = false;

        System.out.println("\nCategory: " + category);

        for (FoodItem item : menu) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No food items found for this category.");
        }
    }

    public FoodItem findFoodById(int id) {
        for (FoodItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public void addToCart(int foodId, int quantity) {
        FoodItem item = findFoodById(foodId);

        if (item == null) {
            System.out.println("Food item not found.");
            return;
        }

        cart.addItem(item, quantity);
        System.out.println(item.getName() + " added to cart.");
    }

    public void removeFromCart(int foodId) {
        if (cart.removeItem(foodId)) {
            System.out.println("Item removed from cart.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public void updateCart(int foodId, int quantity) {
        if (cart.updateQuantity(foodId, quantity)) {
            System.out.println("Cart quantity updated.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public void displayCart() {
        cart.displayCart();
    }

    public void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cannot place an empty order.");
            return;
        }

        lastOrder = new Order(cart);
        saveOrder(lastOrder);
        cart.clear();

        System.out.println("Order placed successfully.");
        System.out.println("Order ID: " + lastOrder.getOrderId());
        System.out.printf("Final Amount: %.2f%n", lastOrder.getFinalAmount());
    }

    private void saveOrder(Order order) {
        File file = new File(orderFile);
        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(file, true))) {
            writer.println(order.toFileString());
        } catch (IOException e) {
            System.out.println("Unable to save order.");
        }
    }

    public void displayLastOrder() {
        if (lastOrder == null) {
            System.out.println("No order has been placed in this session.");
            return;
        }

        lastOrder.displayOrder();
    }
}
