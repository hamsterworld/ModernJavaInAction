package Ch2.behavior_parameterization.step6.filterapple;


import Ch2.behavior_parameterization.step6.Apple;

import static Ch2.behavior_parameterization.step4.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(GREEN);
    }
}
