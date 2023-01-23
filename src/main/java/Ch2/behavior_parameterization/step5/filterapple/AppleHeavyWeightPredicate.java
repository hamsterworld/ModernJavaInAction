package Ch2.behavior_parameterization.step5.filterapple;

import Ch2.behavior_parameterization.step5.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
