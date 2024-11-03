package lotto.validation;

import java.util.List;

public class BonusNumberValidate {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static int bonusValidation(List<Integer> winNumbers, String inputBonusAmount) {
        int bonus = checkInputBonus(inputBonusAmount);
        checkNumberRange(bonus);
        checkContainBonusNumber(winNumbers, bonus);
        return bonus;
    }

    public static int checkInputBonus(String inputBonusAmount) {
        try {
            return Integer.parseInt(inputBonusAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberRange(int amount) {
        if (amount < LOTTO_NUMBER_MIN || amount > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkContainBonusNumber(List<Integer> winNumbers, int bonus) {
        if (winNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

}
