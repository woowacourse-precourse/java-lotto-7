package lotto.valuate;

import static lotto.constant.LottoErrorConstant.ERROR_BONUS_NUMBER_ONLY_ONE;

public class BonusNumberValidate {

    public static void isValidNumber(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_ONLY_ONE);
        }
    }
}
