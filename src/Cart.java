import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<CartItem>();

    public void addItem(FoodItem foodItem, int quantity) {
        for (CartItem item : items) {
            if (item.getFoodItem().getId() == foodItem.getId()) {
                item.increaseQuantity(quantity);
                return;
            }
        }

        items.add(new CartItem(foodItem, quantity));
    }

    public boolean removeItem(int foodId) {
        Iterator<CartItem> iterator = items.iterator();

        while (iterator.hasNext()) {
            CartItem item = iterator.next();

            if (item.getFoodItem().getId() == foodId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public boolean updateQuantity(int foodId, int quantity) {
        for (CartItem item : items) {
            if (item.getFoodItem().getId() == foodId) {
                item.setQuantity(quantity);
                return true;
            }
        }

        return false;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        double subtotal = 0;

        for (CartItem item : items) {
            subtotal += item.getTotal();
        }

        return subtotal;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n================ YOUR CART ================");
        System.out.printf("%-24s %5s %10s %12s%n",
                "Food", "Qty", "Price", "Total");
        System.out.println("--------------------------------------------");

        for (CartItem item : items) {
            System.out.println(item);
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Subtotal: %.2f%n", getSubtotal());
    }
}
