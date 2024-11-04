package lotto.error;

public enum ErrorMessage {
    INVALID_INTEGER("정수로 입력해야하는 값입니다."),
    NOT_MULTIPLE_OF_THOUSAND("금액은 1000원 단위로 입력해야 합니다."),
    BELOW_MINIMUM_AMOUNT("최소 금액은 1000원 이상이어야 합니다."),
    OUT_OF_RANGE("입력값이 유효한 범위를 벗어났습니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    NUMBER_OUT_OF_RANGE("로또 번호의 범위는 1~45입니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    INVALID_DELIMITER("숫자는 쉼표(,)로 구분되어야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}

