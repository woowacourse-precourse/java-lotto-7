package lotto.validator;

import lotto.model.Lotto;

public class PurchaseAmountValidator extends Validator {
    static final String INVALID_AMOUNT_UNIT = "구입금액의 단위는 " + Lotto.getLottoPrice() + "원 단위입니다.";

    private PurchaseAmountValidator() {
        // 인스턴스화 방지를 위해서 사용
    }

    static public void validate(int amount) {
        checkAmountUnit(amount);
    }

    static void checkAmountUnit(int amount) {
        int lottoPrice = Lotto.getLottoPrice();

        if (amount < lottoPrice || amount % lottoPrice != 0) {
            throwInvalidInputException(INVALID_AMOUNT_UNIT);
        }
    }
}