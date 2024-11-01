package lotto.validator;

import static lotto.constants.ErrorMessage.*;

public class AmountsValidator {

    private final int PURCHASABLE_MAX_AMOUNTS = 100000;
    private final int PURCHASABLE_MIN_AMOUNTS = 1000;

    private int lottoAmounts;

    public void validateLottoAmount(String amounts) {
        checkEmptyAmounts(amounts);
        checkNonNumeric(amounts);
        checkMinAmounts(lottoAmounts);
        checkMaxAmounts(lottoAmounts);
        checkDivisibilityByThousand(lottoAmounts);
    }

    private void checkEmptyAmounts(String amounts) {
        if (amounts.isBlank()){
            throw new IllegalArgumentException(EMPTY_AMOUNT.getMessage());
        }
    }

    private void checkNonNumeric(String amounts) {
        try{
            lottoAmounts = Integer.parseInt(amounts);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NON_NUMERIC.getMessage());
        }
    }

    private void checkMinAmounts(int lottoAmounts) {
        if (lottoAmounts < PURCHASABLE_MIN_AMOUNTS){
            throw new IllegalArgumentException(UNDER_MIN_AMOUNTS.getMessage());
        }
    }

    private void checkMaxAmounts(int lottoAmounts) {
        if (lottoAmounts > PURCHASABLE_MAX_AMOUNTS){
            throw new IllegalArgumentException(OVER_MAX_AMOUNTS.getMessage());
        }
    }

    private void checkDivisibilityByThousand(int lottoAmounts) {
        if ((lottoAmounts % PURCHASABLE_MIN_AMOUNTS) != 0) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
        }
    }
}
