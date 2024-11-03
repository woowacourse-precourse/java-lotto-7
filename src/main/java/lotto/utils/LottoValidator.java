package lotto.utils;

import static lotto.constant.LottoStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;

import java.math.BigInteger;

public class LottoValidator {

    public void validatePurchaseAmount(String inputPurchaseAmount) {
        BigInteger purchaseAmount;

        plusSignValidate(inputPurchaseAmount);
        blankValidate(inputPurchaseAmount);
        decimalValidate(inputPurchaseAmount);
        purchaseAmount = parsingValidate(inputPurchaseAmount);
        greaterThanZeroValidate(purchaseAmount);
        purchaseAmountUnitValidate(purchaseAmount);
    }

    private void plusSignValidate(String input) {
        if (input.contains("+")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "+ 기호가 포함된 입력은 불가합니다." + input);
        }
    }

    private void blankValidate(String input) {
        if (input.contains(" ") || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "공백이 포함된 입력은 불가합니다." + input);
        }
    }

    private void decimalValidate(String input) {
        if (input.contains(".")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "소수의 입력은 불가합니다." + input);
        }
    }

    //TODO: parsing과 Validate의 간극, 있어야 할 위치 고민
    private BigInteger parsingValidate(String input) {
        BigInteger parsedValue;

        try {
            parsedValue = new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
        }

        return parsedValue;
    }

    private void greaterThanZeroValidate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "0 이하의 값은 입력할 수 없습니다.");
        }
    }

    private void purchaseAmountUnitValidate(BigInteger purchaseAmount) {
        if (!purchaseAmount.remainder(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + PURCHASE_AMOUNT_UNIT + "원 단위의 입력만 가능합니다.");
        }
    }
}
