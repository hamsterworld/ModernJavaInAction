package Ch2.behavior_parameterization.step6.filterapple;

import Ch2.behavior_parameterization.step6.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
