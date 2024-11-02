package lotto.utils.validator;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoConstant.PURCHASABLE_MAX_AMOUNTS;
import static lotto.constants.LottoConstant.WON_1000;

public class AmountsValidator {

    private static int lottoAmounts;

    public static void validateLottoAmount(String amounts) {
        checkEmptyAmounts(amounts);
        checkNonNumeric(amounts);
        checkMinAmounts(lottoAmounts);
        checkMaxAmounts(lottoAmounts);
        checkDivisibilityByThousand(lottoAmounts);
    }

    private static void checkEmptyAmounts(String amounts) {
        if (amounts.isBlank()){
            throw new IllegalArgumentException(EMPTY_AMOUNT.getMessage());
        }
    }

    private static void checkNonNumeric(String amounts) {
        try{
            lottoAmounts = Integer.parseInt(amounts);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NON_NUMERIC.getMessage());
        }
    }

    private static void checkMinAmounts(int lottoAmounts) {
        if (lottoAmounts < WON_1000){
            throw new IllegalArgumentException(UNDER_MIN_AMOUNTS.getMessage());
        }
    }

    private static void checkMaxAmounts(int lottoAmounts) {
        if (lottoAmounts > PURCHASABLE_MAX_AMOUNTS){
            throw new IllegalArgumentException(OVER_MAX_AMOUNTS.getMessage());
        }
    }

    private static void checkDivisibilityByThousand(int lottoAmounts) {
        if ((lottoAmounts % WON_1000) != 0) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
        }
    }
}
