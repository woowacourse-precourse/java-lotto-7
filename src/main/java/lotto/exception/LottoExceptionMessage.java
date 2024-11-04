package lotto.exception;

import static java.lang.String.format;

import lotto.configuration.LottoConfiguration;

public enum LottoExceptionMessage implements ExceptionMessage {
    DUPLICATE_NUMBERS("로또 번호는 중복될 수 없습니다."),
    NULL_OR_EMPTY_NUMBERS("로또 번호는 비어있거나 null일 수 없습니다."),

    INVALID_NUMBER_COUNT(
            format("로또 번호는 %d개여야 합니다.",
                    LottoConfiguration.LOTTO_NUMBER_COUNT.getValue())),
    NUMBER_OUT_OF_RANGE(
            format("로또 번호는 %d에서 %d 사이의 숫자여야 합니다.",
                    LottoConfiguration.LOTTO_MIN_NUMBER.getValue(),
                    LottoConfiguration.LOTTO_MAX_NUMBER.getValue()));

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
