package lotto.util.message;

import static lotto.util.message.OutputMessage.ERROR_MESSAGE;

public enum ExceptionMessage {

    BLANK_INPUT("빈 문자열을 입력했습니다."),
    NOT_INTEGER("정수로 변환할 수 없는 문자열입니다."),
    NOT_POSITIVE_INTEGER("입력한 값이 양의 정수가 아닙니다."),
    NOT_DIVIDED_TO_LOTTO_PRICE("로또 구입 비용이 로또 1장의 가격으로 나누어 떨어지지 않습니다."),

    ILLEGAL_DELIMITER_USE("쉼표의 사용 방식이 올바르지 않습니다."),
    LOTTO_NUMBER_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("당첨 번호 중 서로 중복된 번호가 있습니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호와 중복되는 당첨 번호가 있습니다."),
    WINNING_NUMBER_NOT_IN_RANGE("입력한 번호가 1~45 사이의 정수가 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s %s", ERROR_MESSAGE, message);
    }
}
