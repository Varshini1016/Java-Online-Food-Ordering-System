public class VegItem extends FoodItem {
    public VegItem(int id, String name, double price) {
        super(id, name, "VEG", price);
    }

    @Override
    public String getType() {
        return "Vegetarian";
    }
}
