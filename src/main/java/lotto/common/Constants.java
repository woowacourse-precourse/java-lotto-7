package lotto.common;

public class Constants {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_VALUE = 1;
    public static final int LOTTO_MAX_VALUE = 45;
    public static final int LOTTO_COUNT = 6;

    public static final int FIRST_MATCHING_COUNT = 6;
    public static final int SECOND_MATCHING_COUNT = 5;
    public static final int THIRD_MATCHING_COUNT = 5;
    public static final int FOURTH_MATCHING_COUNT = 4;
    public static final int FIFTH_MATCHING_COUNT = 3;

    public static final String NUMBER_DELIMITER = ",";
    public static final String ERROR_HEADER = "[ERROR] ";
    public static final String INVALID_INPUT_ERROR = ERROR_HEADER + "문자가 입력됐거나 숫자 범위를 초과하였습니다.";
    public static final String NULL_INPUT_ERROR = ERROR_HEADER + "입력 값이 null이어서는 안 됩니다.";
    public static final String EMPTY_INPUT_ERROR = ERROR_HEADER + "입력 값이 빈 문자여서는 안 됩니다.";
    public static final String INVALID_NUMBER_SIZE_ERROR = ERROR_HEADER + "번호는 6개의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER_ERROR = ERROR_HEADER + "번호는 중복되지 않아야 합니다.";
    public static final String OUT_OF_RANGE_ERROR = ERROR_HEADER + "번호는 1에서 45 사이여야 합니다.";
}
