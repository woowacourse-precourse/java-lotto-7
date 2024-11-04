package lotto.common;

public class Constants {
    // prompt
    public static String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    public static String LOTTO_TICKET_COUNT_PROMPT = "개를 구매했습니다.";
    public static String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    public static String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    // number
    public static Long MIN_PURCHASE_AMOUNT = 1L;
    public static Long MAX_PURCHASE_AMOUNT = (long) Integer.MAX_VALUE;
    public static Integer LOTTO_PRICE_UNIT = 1000;
    public static Integer LOTTO_SIZE = 6;
    public static Integer LOTTO_MIN_NUMBER = 1;
    public static Integer LOTTO_MAX_NUMBER = 45;
    public static Long MIN_WINNING_NUMBER = 1L;
    public static Long MAX_WINNING_NUMBER = 45L;
    public static Long MIN_MATCH_COUNT = 0L;
    public static Long MAX_MATCH_COUNT = 6L;

    // string
    public static String LOTTO_NUMBER_PRINT_DELIMITER = ", ";
    public static String WINNING_NUMBERS_DELIMITER = ",";

    // error message
    public static String ERROR_PROMPT = "[ERROR] ";
    public static String INVALID_PRICE_UNIT = "구입 금액은 1,000원 단위의 숫자여야 합니다.";
    public static String UP_MAX_PURCHASE_AMOUNT = "구입 금액은 2,147,483,000을 넘을 수 없습니다.";
    public static String INVALID_LOTTO_SIZE = "로또 번호는 6개여야 합니다.";
    public static String INVALID_DUPLICATE_LOTTO = "로또 번호는 중복되면 안됩니다.";
    public static String INVALID_WINNING_NUMBER = "당첨 번호는 1~45 사이의 숫자여야 합니다.";
    public static String INVALID_DUPLICATE_WINNING_NUMBER = "당첨 번호에는 중복된 수가 들어갈 수 없습니다.";
    public static String INVALID_BONUS_NUMBER = "보너스 번호는 1~45 사이의 숫자여야 합니다.";
    public static String INVALID_DUPLICATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static String INVALID_MATCH_COUNT = "당첨 개수가 범위 밖입니다.";
}
