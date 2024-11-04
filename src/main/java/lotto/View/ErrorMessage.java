package lotto.View;

public class ErrorMessage {
    public static final String SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String EMPTY_VALUE_ERROR = "[ERROR] 번호는 비어 있을 수 없습니다.";
    public static final String NON_NUMERIC_ERROR = "[ERROR] 숫자(양수) 외 문자열 혹은 공백 등을 포함할 수 없습니다.";
    public static final String RANGE_ERROR = "[ERROR] 번호는 1~45여야 합니다.";
    public static final String NUMBER_DUPLICATE_ERROR = "[ERROR] 중복된 숫자가 포함되어 있습니다.";
    public static final String BONUS_DUPLICATE_ERROR = "[ERROR] 당첨번호와 숫자가 중복됩니다.";
    public static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 중복된 숫자가 포함되어 있습니다.";
    public static final String PAY_ERROR = "[ERROR] 구매는 1000원 단위로만 가능합니다.";
    public static final String PAY_ZERO = "[ERROR] 구매하시려면 1000원 이상의 금액을 입력하셔야 됩니다.";

    public static void printError(String message) {
        System.out.println(message);
    }
}