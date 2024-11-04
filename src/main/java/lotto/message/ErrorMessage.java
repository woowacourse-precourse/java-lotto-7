package lotto.message;

import lotto.util.Constants;

public enum ErrorMessage {

    ERROR_MESSAGE("[ERROR] "),

    INVALID_FORMAT("입력받은 형식이 정수가 아닙니다"),
    EMPTY_OR_BLANK("입력이 공백이거나 없습니다."),

    AMOUNT_NOT_DIVISIBLE("금액이 %d으로 나누어 떨어지지 않습니다.".formatted(Constants.LOTTO_PRICE)),
    NON_POSITIVE_AMOUNT("금액이 양수가 아닙니다."),

    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 %d개여야 합니다.".formatted(Constants.LOTTO_PRICE)),
    DUPLICATE_LOTTO_NUMBER("로또 번호에 중복된 숫자가 있습니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."
            .formatted(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER)),

    DUPLICATE_BONUS_NUMBER("보너스 번호가 로또 번호와 중복됩니다."),
    OUT_OF_RANGE_BONUS_NUMBER("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다."
            .formatted(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE.message+message;
    }
}
