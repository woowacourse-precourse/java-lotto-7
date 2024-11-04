package lotto.util;

public class Constant {

    // InputValidator Constant
    public static final int PRICE_UNIT = 1000;
    public static final String ERROR_NOT_A_NUMBER = "[ERROR] %s 숫자로 입력해야 합니다.";
    public static final String ERROR_PRICE_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_WINNING_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호에는 중복된 숫자를 입력할 수 없습니다.";

    // LottoNumbersValidator Constant
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String ERROR_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.";
    public static final String ERROR_LOTTO_RANGE = "[ERROR] 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호에는 중복된 숫자를 포함할 수 없습니다.";
}