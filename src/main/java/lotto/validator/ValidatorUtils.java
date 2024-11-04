package lotto.validator;

public class ValidatorUtils {

    public static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위의 양수를 입력해 주세요.";
    public static final String WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않도록 1 ~ 45 사이의 6개의 정수를 입력해주세요";
    public static final String BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않도록 1 ~ 45 사이의 정수를 입력해주세요.";

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static boolean isNumberInRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
