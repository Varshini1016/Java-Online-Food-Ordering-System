public abstract class FoodItem {
    private int id;
    private String name;
    private String category;
    private double price;

    public FoodItem(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();

    public String toFileString() {
        return id + "|" + name + "|" + category + "|" + price;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-24s %-15s %.2f",
                id, name, category, price);
    }
}
