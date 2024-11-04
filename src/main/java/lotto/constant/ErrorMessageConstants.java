package lotto.constant;

public class ErrorMessageConstants {
    public static final String MESSAGE_START = "[ERROR] ";
    public static final String VALUE_IS_NOT_NUMBER = MESSAGE_START + "숫자만 입력할 수 있습니다.";
    public static final String VALUE_IS_NOT_DIVISIBLE_BY_1000 = MESSAGE_START + "1,000원 단위 금액만 입력 가능합니다.";
    public static final String DUPLICATE_VALUE_EXISTS = MESSAGE_START + "중복된 값이 존재합니다.";
    public static final String NEGATIVE_NUMBER = MESSAGE_START + "0보다 작은 수는 입력할 수 없습니다.";
}
