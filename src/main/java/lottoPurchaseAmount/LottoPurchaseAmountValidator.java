package lottoPurchaseAmount;

import utils.StaticFinalMessages;

public class LottoPurchaseAmountValidator {
    // 이걸 많이 쓰게 될텐데 다른 클래스에 넣어서 그걸 꺼내서 써야되나 아니면 그건 너무 오바인가?
    private final static String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_PURCHASE_AMOUNT = "1000단위의 1000이상 50000이하 로또 구입 금액을 입력해주세요 ex) 5000";
    private final static int MAXIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT = 50000;
    private final static IllegalArgumentException EXCEPTION_LOTTO_PURCHASE_AMOUNT = new IllegalArgumentException(
            StaticFinalMessages.ERROR_TEXT_INFRONT_OF_DETAILS + RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_PURCHASE_AMOUNT);

    public void validateAllThing(String lottoPurchaseAmount) {
        validateIsNumeric(lottoPurchaseAmount);
        validateExceed50000(lottoPurchaseAmount);
        validateUnit1000(lottoPurchaseAmount);
    }

    // number format exception 말고 또 다른 것도 있나?
    private void validateIsNumeric(String lottoPurchaseAmount) {
        try {
            Integer.parseInt(lottoPurchaseAmount);
        } catch (NumberFormatException numberFormatException) {
            throw EXCEPTION_LOTTO_PURCHASE_AMOUNT;
        }
    }

    private void validateExceed50000(String lottoPurchaseAmount) {
        int convertedInputToInt = Integer.parseInt(lottoPurchaseAmount);

        if (convertedInputToInt > MAXIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT) {
            throw EXCEPTION_LOTTO_PURCHASE_AMOUNT;
        }
    }

    private void validateUnit1000(String lottoPurchaseAmount) {
        int convertedInputToInt = Integer.parseInt(lottoPurchaseAmount);

        if (convertedInputToInt % 1000 != 0) {
            throw EXCEPTION_LOTTO_PURCHASE_AMOUNT;
        }
    }
}
