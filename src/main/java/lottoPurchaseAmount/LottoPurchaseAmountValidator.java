package lottoPurchaseAmount;

import convert.SingleStringToNumConverter;

public class LottoPurchaseAmountValidator {
    // 이걸 많이 쓰게 될텐데 다른 클래스에 넣어서 그걸 꺼내서 써야되나 아니면 그건 너무 오바인가?
    private final static String ERROR_TEXT_INFRONT_OF_DETAILS = "[ERROR] ";
    private final static String RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_PURCHASE_AMOUNT = "1000단위의 1000이상 50000이하 로또 구입 금액을 입력해주세요 ex) 5000";
    private final static int MAXIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT = 50000;

    private final static IllegalArgumentException EXCEPTION_LOTTO_PURCHASE_AMOUNT = new IllegalArgumentException(ERROR_TEXT_INFRONT_OF_DETAILS + RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_PURCHASE_AMOUNT);


    private final String lottoPurchaseAmount;
    private final SingleStringToNumConverter stringToIntConverter;

    public LottoPurchaseAmountValidator(String lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        stringToIntConverter = new SingleStringToNumConverter(lottoPurchaseAmount);
    }

    public void validateAllThing() {
        validateIsNumeric();
        validateExceed50000();
        validateUnit1000();
    }

    // number format exception 말고 또 다른 것도 있나?
    private void validateIsNumeric() {
        try {
            stringToIntConverter.convert();
        } catch (NumberFormatException numberFormatException) {
            throw EXCEPTION_LOTTO_PURCHASE_AMOUNT;
        }
    }

    private void validateExceed50000() {
        int convertedInputToInt = stringToIntConverter.convert();

        if (convertedInputToInt > MAXIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT) {
            throw EXCEPTION_LOTTO_PURCHASE_AMOUNT;
        }
    }

    private void validateUnit1000() {
        int convertedInputToInt = stringToIntConverter.convert();

        if (convertedInputToInt % 1000 != 0) {
            throw EXCEPTION_LOTTO_PURCHASE_AMOUNT;
        }
    }
}
