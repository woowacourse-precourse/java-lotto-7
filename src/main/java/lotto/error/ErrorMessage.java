package lotto.error;

import lotto.domain.LottoConstants;

public enum ErrorMessage {

    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 %d개여야 합니다.", LottoConstants.LOTTO_NUMBER_COUNT.getValue()),
    DUPLICATED_LOTTO_NUMBER("로또 번호에 중복된 숫자가 있습니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 %d부터 %d 사이여야 합니다.",
            LottoConstants.LOTTO_MIN_NUMBER.getValue(), LottoConstants.LOTTO_MAX_NUMBER.getValue()),

    AMOUNT_TOO_LOW("구입 금액은 최소 %d원 이상이어야 합니다.", LottoConstants.LOTTO_PRICE.getValue()),
    INVALID_AMOUNT_UNIT("구입 금액은 %d원 단위여야 합니다.", LottoConstants.LOTTO_PRICE.getValue()),
    INVALID_AMOUNT_FORMAT("구입 금액은 숫자만 입력 가능합니다."),

    INVALID_WINNING_NUMBER_FORMAT("당첨 번호는 숫자와 쉼표, 공백만 포함할 수 있습니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호는 숫자만 입력 가능합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    EXCEEDED_MAXIMUM_RETRY_ATTEMPTS("최대 재시도 횟수를 초과했습니다."),
    ;

    private final String format;
    private final Object[] args;

    ErrorMessage(String format, Object... args) {
        this.format = "[ERROR] " + format;
        this.args = args;
    }

    public String getMessage() {
        return String.format(format, args);
    }
}
