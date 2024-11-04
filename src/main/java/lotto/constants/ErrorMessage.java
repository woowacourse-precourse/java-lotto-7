package lotto.constants;

public enum ErrorMessage {
    INPUT_CAN_NOT_BE_BLANK("빈 값은 입력할 수 없습니다."),

    AMOUNT_CAN_NOT_HAVE_CHARACTER("구입 금액은 숫자 이외의 문자를 포함할 수 없습니다."),
    AMOUNT_CAN_NOT_BE_ZERO("구입 금액은 0이 될 수 없습니다."),
    AMOUNT_SHOULD_BE_DIVIDED_BY_THOUSAND("구입 금액은 1,000으로 나누어 떨어져야 합니다."),

    LOTTO_CAN_NOT_HAVE_CHARACTER("로또 번호는 숫자 이외의 문자를 포함할 수 없습니다."),
    LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED("로또 번호는 중복될 수 없습니다.");

    private static final String header = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return header + errorMessage;
    }
}
