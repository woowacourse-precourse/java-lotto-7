package lotto.util;

public class Constants {
    public static final int LOTTO_PRICE_UNIT = 1_000;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int COUNT_OF_LOTTO_NUMBER = 6;

    public static final String ERROR_INIT = "[ERROR] ";
    public static final String ERROR_IS_VACANT_MSG = "를 입력하셔야 합니다.";
    public static final String ERROR_CONTAIN_LETTER_MSG = "는 숫자로 입력하셔야 합니다.";
    public static final String ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG
            = "는 %d 이상인 정수로 입력하셔야 합니다.".formatted(LOTTO_START_NUMBER);
    public static final String ERROR_EXCEED_LOTTO_END_NUMBER_MSG
            = "는 %d 이하인 정수로 입력하셔야 합니다.".formatted(LOTTO_END_NUMBER);

    public static final String DELIMITER = ",";
}
