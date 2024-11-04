package lotto.exception;

public enum ExceptionMessage {
    TOO_MANY_NUMBERS("로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBER_LOTTO("로또에 중복된 번호가 있습니다."),
    INVALID_PURCHASE_PRICE("잘못된 단위의 가격입니다."),
    INVALID_LOTTO_NUMBER("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호에 중복된 번호가 있습니다."),
    NOT_NUMBER_STRING("입력값이 숫자가 아닙니다ㅣ."),
    NULL_OF_NOT_NULL("null 값이 존재합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
