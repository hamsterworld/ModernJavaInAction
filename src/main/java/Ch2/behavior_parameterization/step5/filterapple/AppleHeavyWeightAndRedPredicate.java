package Ch2.behavior_parameterization.step5.filterapple;

import Ch2.behavior_parameterization.step5.Apple;

import static Ch2.behavior_parameterization.step4.Color.RED;

public class AppleHeavyWeightAndRedPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150 && apple.getColor().equals(RED);
    }
}
