package lotto.constant;

public class LottoConstants {
    // 로또 관련 상수
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    // 구분자 관련 상수
    public static final String COMMA_DELIMITER = ",";
    public static final String ERROR_PREFIX = "[ERROR] ";

    // 정규식 패턴
    public static final String NUMBER_PATTERN = "^[0-9]+$";
    public static final String WINNING_NUMBERS_PATTERN =
            "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5]))*$";

    private LottoConstants() {
        throw new AssertionError();
    }
}
