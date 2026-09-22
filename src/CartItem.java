public class CartItem {
    private FoodItem foodItem;
    private int quantity;

    public CartItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return foodItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-24s %5d %10.2f %12.2f",
                foodItem.getName(), quantity,
                foodItem.getPrice(), getTotal());
    }
}
