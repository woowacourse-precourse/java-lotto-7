package lotto.controller;

public class ErrorMessages {
    private static final String PREFIX_OF_ERROR_MESSAGE = "[ERROR] ";

    public static final String INVALID_PAID_AMOUNT_FORMAT =
            PREFIX_OF_ERROR_MESSAGE + "구입금액은 0보다 큰 정수 형태여야 합니다.";

    public static final String INVALID_UNIT_OF_PAID_AMOUNT =
            PREFIX_OF_ERROR_MESSAGE + "구입금액은 1000원 단위로 입력하셔야 합니다.";
}
