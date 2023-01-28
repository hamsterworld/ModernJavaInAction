package Ch4.part4_1.existingCode;

public class Dish {
    private String name;
    private int price;
    private int calories;

    public Dish(String name, int price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }
}
