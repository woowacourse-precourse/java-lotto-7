package message;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),

    // [ERROR] 로또 숫자의 범위가 1에서 45 사이를 초과 했습니다.
    LOTTO_NUMBER_RANGE("로또 숫자의 범위가 1에서 45 사이를 초과 했습니다."),

    // [ERROR] 로또 숫자가 중복되었습니다.
    LOTTO_NUMBER_OVERLAP("로또 숫자가 중복되었습니다."),

    // [ERROR] 로또 당첨 번호와 보너스 번호가 중복 되었습니다.
    BONUS_NUMBER_OVERLAP("로또 당첨 번호와 보너스 번호가 중복 되었습니다."),

    // [ERROR] 로또의 숫자는 6개 이어야 합니다.
    LOTTO_NUMBER_SIX("로또의 숫자는 6개 이어야 합니다."),

    // [ERROR] 로또가 오름차순 정렬이 되어있지 않습니다.
    LOTTO_NUMBER_ASCENDING("로또가 오름차순 정렬이 되어있지 않습니다."),

    // [ERROR] 숫자가 아닌 값이 입력되었습니다.
    IS_NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),

    // [ERROR] 금액이 입력되지 않았습니다.
    MONEY_EMPTY("금액이 입력되지 않았습니다."),

    // [ERRER] 입금 금액은 1000의 배수여야합니다.
    // [ERROR] 입금 금액의 최소 단위는 1000원 입니다.
    IS_NOT_MULTIPLE_OF_ONE_THOUSAND("입금 금액은 1000의 배수여야 합니다."),

    // [ERROR] 금액의 값이 너무 큽니다.
    IS_TOO_LARGE("금액의 값이 너무 큽니다.");


    private final String errorMessage;


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX.errorMessage + errorMessage;
    }
}
