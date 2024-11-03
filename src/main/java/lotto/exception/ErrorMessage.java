package lotto.exception;

import static lotto.model.LottoOption.*;

public enum ErrorMessage {
    INVALID_WINNING_NUMBER_PATTERN("당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다."),
    INVALID_NOT_BLANK("공백을 입력할 수 없습니다."),
    NUMBER_FORMAT("숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE("범위를 벗어난 숫자입니다. %d부터 %d사이여야 합니다.".formatted(MIN_NUMBER_OF_RANGE.value(), MAX_NUMBER_OF_RANGE.value())),
    INVALID_SIZE("로또 번호는 %d개여야 합니다.".formatted(TOTAL_ELEMENT_COUNT.value())),
    HAS_DUPLICATE_NUMBER("중복된 번호는 사용 할 수 없습니다."),
    NOT_ENOUGH_MONEY("구매 금액이 부족합니다. 최소 %d원 이상 입력해주세요.".formatted(SALE_PRICE.value())),
    INVALID_MONEY_UNIT("로또 구입 금액은 %d원 단위로 입력해야 합니다.".formatted(SALE_PRICE.value()));


    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
