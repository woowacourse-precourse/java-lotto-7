package lotto.exception;

import static java.lang.String.format;

import lotto.configuration.LottoConfiguration;

public enum WinnerNumberExceptionMessage implements ExceptionMessage {
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    BONUS_NUMBER_OUT_OF_RANGE(
            format("보너스 번호는 %d에서 %d 사이의 숫자여야 합니다.",
                    LottoConfiguration.LOTTO_MIN_NUMBER.getValue(),
                    LottoConfiguration.LOTTO_MAX_NUMBER.getValue()));

    private final String message;

    WinnerNumberExceptionMessage(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
