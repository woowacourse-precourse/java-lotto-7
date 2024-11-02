package lotto.config;

public class ErrorMessageConstant {
    private ErrorMessageConstant() {
    }

    private static final String SUFFIX = "[ERROR] ";

    // 입력 에러 메세지
    public static final String NON_NUMERIC_MESSAGE = SUFFIX + "유효한 숫자를 입력해주세요.";

    // 구매금액 에러 메세지
    public static final String PURCHASE_TOO_LOW_MESSAGE = SUFFIX + "구매금액이 너무 적습니다. 로또를 1개 이상 구매해주세요.";
    public static final String PURCHASE_REMINDER_MESSAGE = SUFFIX + "거스름돈이 발생하지 않는 금액을 입력해주세요.";
}
