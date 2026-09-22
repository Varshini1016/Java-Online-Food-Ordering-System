public class NonVegItem extends FoodItem {
    public NonVegItem(int id, String name, double price) {
        super(id, name, "NON-VEG", price);
    }

    @Override
    public String getType() {
        return "Non-Vegetarian";
    }
}
