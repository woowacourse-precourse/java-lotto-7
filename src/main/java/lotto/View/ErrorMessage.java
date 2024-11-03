package lotto.View;

public class ErrorMessage {
    public static final String SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String EMPTY_VALUE_ERROR = "[ERROR] 빈 값은 포함할 수 없습니다.";
    public static final String NON_NUMERIC_ERROR = "[ERROR] 숫자 외 문자 혹은 공백은 포함할 수 없습니다.";
    public static final String RANGE_ERROR = "[ERROR] 로또 번호는 1~45여야 합니다.";
    public static final String BONUS_RANGE_ERROR = "[ERROR] 보너스 번호는 1~45여야 합니다.";
    public static final String BONUS_DUPLICATE_ERROR = "[ERROR] 당첨번호와 숫자가 중복됩니다.";
    public static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 중복된 숫자가 포함되어 있습니다.";

    public static void printError(String message) {
        System.out.println(message);
    }
}