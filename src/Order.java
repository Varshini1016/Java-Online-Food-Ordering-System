import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderId = 1001;

    private int orderId;
    private List<CartItem> items;
    private double subtotal;
    private double discount;
    private double finalAmount;
    private LocalDateTime orderDate;

    public Order(Cart cart) {
        this.orderId = nextOrderId++;
        this.items = new ArrayList<CartItem>();

        for (CartItem item : cart.getItems()) {
            this.items.add(new CartItem(
                    item.getFoodItem(),
                    item.getQuantity()
            ));
        }

        this.subtotal = cart.getSubtotal();
        this.discount = calculateDiscount(subtotal);
        this.finalAmount = subtotal - discount;
        this.orderDate = LocalDateTime.now();
    }

    private double calculateDiscount(double amount) {
        if (amount >= 1000) {
            return amount * 0.10;
        }

        return 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return orderDate.format(formatter);
    }

    public void displayOrder() {
        System.out.println("\n========================================");
        System.out.println("              ORDER SUMMARY");
        System.out.println("========================================");
        System.out.println("Order ID: " + orderId);
        System.out.println("Date: " + getFormattedDate());
        System.out.println("----------------------------------------");

        for (CartItem item : items) {
            System.out.printf("%-22s x%-3d %.2f%n",
                    item.getFoodItem().getName(),
                    item.getQuantity(),
                    item.getTotal());
        }

        System.out.println("----------------------------------------");
        System.out.printf("Subtotal:       %.2f%n", subtotal);
        System.out.printf("Discount:       %.2f%n", discount);
        System.out.printf("Final Amount:   %.2f%n", finalAmount);
        System.out.println("========================================");
    }

    public String toFileString() {
        return orderId + "|" + getFormattedDate() + "|" +
                String.format("%.2f", subtotal) + "|" +
                String.format("%.2f", discount) + "|" +
                String.format("%.2f", finalAmount);
    }
}
