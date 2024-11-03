package lotto.constant;

public class GameConfig {
    public static final int MIN_RANGE_NUMBER = 1;
    public static final int MAX_RANGE_NUMBER = 45;

    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int WINNING_LOTTO_NUMBERS_COUNT = 7;

    public static final int LOTTO_PRICE = 1000;

    //정규식
    public static final String VALID_DIGIT_LENGTH_PATTERN = "^\\d{1,8}$";
    public static final String VALID_UNIT_PATTERN = ".*000$";
    public static final String VALID_LOTTO_NUMBERS_PATTERN = "^(\\d{1,2},){5}\\d{1,2}$";
    public static final String VALID_BONUS_NUMBER_PATTERN = "^\\d{1,2}$";


}
