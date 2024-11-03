package lotto.utils;

import java.math.BigInteger;

public class LottoValidator {

    private final String ERROR_MSG_PREFIX = "[ERROR]";

    public void validatePurchaseAmount(String inputPurchaseAmount) {

        BigInteger purchaseAmount;

        if(inputPurchaseAmount.contains("+")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "+ 기호가 포함된 입력은 불가합니다.");
        }

        if(inputPurchaseAmount.contains(" ") || inputPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "공백이 포함된 입력은 불가합니다.");
        }

        if(inputPurchaseAmount.contains(".")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "소수의 입력은 불가합니다.");
        }

        try{
            purchaseAmount = new BigInteger(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
        }

        if(purchaseAmount.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "0 이하의 값은 입력할 수 없습니다.");
        }

        //FIXME: 1000원 하드코딩 X
        if(!purchaseAmount.remainder(BigInteger.valueOf(1000L)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "1000원 단위의 입력만 가능합니다.");
        }
    }
}
