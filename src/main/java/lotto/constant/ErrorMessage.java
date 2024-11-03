package lotto.constant;

public class ErrorMessage {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_SUFFIX = " 다시 입력해 주세요.";
    public static String LOTTO_NUMBER_SIZE_ERROR_MESSAGE = ERROR_PREFIX + "로또 번호는 6개여야 합니다." + ERROR_SUFFIX;
    public static String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = ERROR_PREFIX + "보너스 숫자는 1부터 45사이의 숫자여야 합니다." + ERROR_SUFFIX;
    public static String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = ERROR_PREFIX + "로또 번호는 서로 다른 6개여야 합니다." + ERROR_SUFFIX;
    public static String MINIMUM_PURCHASE_AMOUNT_ERROR_MESSAGE = ERROR_PREFIX + "로또 최소 구입 금액 1000원 입니다." + ERROR_SUFFIX;
    public static String PURCHASE_AMOUNT_DIVISIBILITY_ERROR_MESSAGE = ERROR_PREFIX + "로또 구입 금액은 1000원으로 나누어 떨어져야 합니다." + ERROR_SUFFIX;
    public static String BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE = ERROR_PREFIX + "보너스 번호는 담청 번호와 중복되면 안됩니다." + ERROR_SUFFIX;
    public static String WINNING_NUMBER_FORMAT_ERROR_MESSAGE = ERROR_PREFIX + "당첨 번호는 숫자만 가능합니다. 입력 형식을 확인해 주세요" + ERROR_SUFFIX;
    public static String PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE = ERROR_PREFIX + "구입 금액은 양의 정수여야 합니다." + ERROR_SUFFIX;
    public static String BONUS_NUMBER_POSITIVE_INTEGER_ERROR_MESSAGE = ERROR_PREFIX + "보너스 번호는 자연수입니다." + ERROR_SUFFIX;
}
