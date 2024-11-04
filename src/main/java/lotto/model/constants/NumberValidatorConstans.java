package lotto.model.constants;

public enum NumberValidatorConstans {
    NUMBER_NOT_NUMERIC_MESSAGE("번호는 숫자만 입력할 수 있습니다."),
    NUMBER_NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_NOT_WINNING_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    NumberValidatorConstans(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
