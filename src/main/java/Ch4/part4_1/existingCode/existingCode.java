package Ch4.part4_1.existingCode;

import Ch4.part4_1.renewalCode.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class existingCode {

    public List<String> getLowCaloricDishesName(List<Dish> menu){

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }
        lowCaloricDishes.sort(Comparator.comparingInt(Dish::getCalories));
        List<String> lowCaloricDishesNames = new ArrayList<>();
        for (Dish lowCaloricDish : lowCaloricDishes) {
            lowCaloricDishesNames.add(lowCaloricDish.getName());
        }
        return lowCaloricDishesNames;
    }
}
