package lotto.viewHandler.exception;

public abstract class MyExceptionConstant {
    public static final String NOT_INTEGER = "숫자만 입력해주세요.";
    public static final String NOT_MONEY_UNIT = "1,000원 단위가 아닙니다.";
    public static final String NOT_WINNING_LOTTO_NUMBER_SIZE = "6개의 숫자가 입력 안되었습니다.";
    public static final String NOT_LOTTO_NUMBER_RANGE = "로또 넘버가 1 ~ 45 사이가 아닙니다.";

    public static final String DELIMITER = ",";

    public static final Integer LOTTO_SIZE = 6;
    public static final Integer ZERO = 0;
    public static final Integer MONEY_UNIT = 1_000;
    public static final Integer LOTTO_START_NUMBER = 1;
    public static final Integer LOTTO_END_NUMBER = 45;
}
