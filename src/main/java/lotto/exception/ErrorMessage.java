package lotto.exception;

import static lotto.domain.constants.LottoConstants.*;

public enum ErrorMessage {
    LOTTO_NUMBER_DUPLICATE("로또 번호에 중복된 번포가 포함되어 있습니다."),
    INVALID_LOTTO_SIZE("로또 번호의 개수가 맞지 않습니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호의 범위가 맞지 않습니다."),
    INVALID_INPUT_TYPE("잘못된 입력 타입입니다."),
    BONUS_NUMBER_DUPLICATE("당첨 번호 중에 보너스 번호가 이미 존재합니다."),
    MONEY_INSUFFICIENT("로또를 구입하기에 부족한 금액입니다. 로또의 가격은 %d원 입니다."),
    MONEY_LEFT("금액은 로또 가격의 배수로 입력해야 합니다. 로또의 가격은 %d원 입니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }

    public String getLottoPriceIncludeMessage() {
        return ERROR_MESSAGE_PREFIX + String.format(message, LOTTO_PRICE);
    }
}
