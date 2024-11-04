package lotto.validation;

import static lotto.constant.LotteryConstant.DEFAULT_ERROR_MESSAGE;

public class LotteryValidator {

    public boolean validateInputPurchaseAmount(final String inputPurchaseAmount) {
        try {
            Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + " 숫자로 변환 불가능합니다.");
            return false;
        }
        return true;
    }
}
