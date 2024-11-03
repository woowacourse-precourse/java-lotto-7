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

    // 당첨번호 에러 메세지
    public static final String INSUFFICIENT_WINNING_NUMBERS_MESSAGE = SUFFIX + "당첨번호 개수가 부족합니다.";
    public static final String DUPLICATED_WINNING_NUMBER_MESSAGE = SUFFIX + "당첨번호는 중복될 수 없습니다.";
    public static final String INVALID_RANGE_NUMBER_MESSAGE = SUFFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    // 보너스 번호 에러 메세지
    public static final String EMPTY_WINNGING_NUMBER_MESSAGE = SUFFIX + "당첨번호를 먼저 입력해주세요.";
    public static final String DUPLICATED_BONUS_NUMBER_MESSAGE = SUFFIX + "보너스번호는 당첨번호와 중복될 수 없습니다.";

    // 로또 번호 에러 메세지
    public static final String INSUFFICIENT_LOTTO_NUMBERS_MESSAGE = SUFFIX + "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = SUFFIX + "로또 번호는 중복될 수 없습니다.";
}
