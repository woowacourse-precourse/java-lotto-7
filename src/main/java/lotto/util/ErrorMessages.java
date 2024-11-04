package lotto.util;

public class ErrorMessages {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static final String NOT_NUMERIC = ERROR_PREFIX + "로또 번호는 숫자 형식이어야 합니다.";
    public static final String OUT_OF_RANGE = ERROR_PREFIX + "로또 번호는 1과 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER = ERROR_PREFIX + "당첨 번호와 중복된 번호입니다.";
    public static final String CONTAINS_WHITESPACE = ERROR_PREFIX + "공백은 포함될 수 없습니다.";
    public static final String CONTAINS_DUPLICATES = ERROR_PREFIX + "중복된 숫자가 포함되어 있습니다.";
    public static final String INVALID_LOTTO_SIZE = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String NOT_DIVISIBLE_BY_THOUSAND = ERROR_PREFIX + "1,000 원 단위의 값이어야 합니다.";
    public static final String BELOW_MINIMUM_AMOUNT = ERROR_PREFIX + "1,000 원 이상의 값이어야 합니다.";
}
