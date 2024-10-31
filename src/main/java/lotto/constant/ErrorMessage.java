package lotto.constant;

public enum ErrorMessage {
    MONEY_FORMAT_WRONG("입력 금액은 정수여야 합니다."),
    MONEY_NEGATIVE("입력 금액은 1원 이상이어야 합니다."),
    MONEY_UNIT_WRONG("입력 금액은 1000원 단위여야 합니다."),

    LOTTO_NUMBER_FORMAT_WRONG("당첨 번호 입력 양식이 잘못되었습니다."),
    NUMBER_OF_LOTTO_NUMBERS_WRONG("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_WRONG("로또 번호가 1~45 범위를 벗어납니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호는 중복될 수 없습니다."),

    BONUS_NUMBER_FORMAT_WRONG("보너스 숫자의 형식이 잘못되었습니다."),
    BONUS_NUMBER_RANGE_WRONG("보너스 숫자의 범위가 1~45를 벗어납니다."),
    BONUS_NUMBER_DUPLICATED("보너스 숫자가 당첨 번호와 중복됩니다.");


    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE_HEADER + errorMessage;
    }
}
