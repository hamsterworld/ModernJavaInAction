package Ch4.common;

public class Dish {
    private final String name;
    private final boolean vegetrian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetrian, int calories, Type type) {
        this.name = name;
        this.vegetrian = vegetrian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetrian() {
        return vegetrian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT,OTHER,FISH
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetrian=" + vegetrian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
