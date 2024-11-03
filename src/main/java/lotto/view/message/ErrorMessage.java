package lotto.view.message;

public enum ErrorMessage {
    IS_EMPTY("빈 입력입니다."),
    NOT_NUMERIC("숫자가 아닌 문자가 포함되었습니다."),
    NOT_POSITIVE("양수가 아닙니다."),
    NOT_PRICE_UNITS("구입 금액이 1,000원 단위가 아닙니다."),
    NO_COMMA("쉼표(,)가 없는 입력입니다."),
    NOT_DEFAULT_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    HAS_DUPLICATED_NUMBER("중복된 숫자가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
