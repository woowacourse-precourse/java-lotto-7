package lotto.viewHandler.exception;

public abstract class MyExceptionConstant {
    public static final String NOT_INTEGER = "숫자만 입력해주세요.";
    public static final String NOT_MONEY_UNIT = "1,000원 단위가 아닙니다.";
    public static final String NOT_WINNING_LOTTO_NUMBER_SIZE = "6개의 숫자가 입력 안되었습니다.";
    public static final String NOT_LOTTO_NUMBER_RANGE = "로또 넘버가 1 ~ 45 사이가 아닙니다.";
    public static final String DUPLICATE_NUMBER = "중복된 숫자가 포함되어 있습니다.";
    public static final String NOT_LOTTO_SIZE = "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "당첨 번호랑 겹치면 안됩니다.";
    public static final String DELIMITER = ",";

    public static final Integer SERVER_SUCCESS_CODE = 200;
    public static final Integer ZERO = 0;
    public static final Integer CLIENT_ERROR_CODE = 400;
}
