package lotto.exception;

public class ErrorMessage {
    public static final String IS_NOT_DIVIDED_BY_LOTTERY_NUMBER = "[ERROR] 금액이 로또 개수로 나누어 떨어지지 않습니다";
    public static final String INVALID_PAYMENT = "[ERROR] 구입 금액이 최소 기준 금액 이상이어야 합니다.";
    public static final String IS_NOT_NUMERIC = "[ERROR] 숫자 이외의 값은 허용하지 않습니다.";
    public static final String IS_INVALID_SIZE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    public static final String IS_INVALID_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String IS_DUPLICATED = "[ERROR] 숫자끼리의 중복은 허용하지 않습니다.";
}
