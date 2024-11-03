package lotto.validation;

import static lotto.constants.LottoRule.Lotto_Number_Max;
import static lotto.constants.LottoRule.Lotto_Number_Min;

import java.util.List;

public class BonusNumberValidate {

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
        if (amount < Lotto_Number_Min.getValue() ||
                amount > Lotto_Number_Max.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkContainBonusNumber(List<Integer> winNumbers, int bonus) {
        if (winNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

}
