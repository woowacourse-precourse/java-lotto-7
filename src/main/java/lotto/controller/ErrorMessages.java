package lotto.controller;

public class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String INVALID_PAID_AMOUNT_FORMAT =
            "구입금액은 0보다 큰 정수 형태여야 합니다.";
    public static final String INVALID_WINNING_NUMBERS_FORMAT =
            "당첨 번호는 띄어쓰기 없이 쉼표(,)와 0 보다 큰 정수로 이루어져야 합니다.";

    public static final String INVALID_BONUS_NUMBER_FORMAT = "보너스 번호는 0보다 큰 정수 형태여야 합니다.";
}
