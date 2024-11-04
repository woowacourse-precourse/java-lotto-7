package lotto.application.ticket.domain.ticket;

import static lotto.application.ticket.constants.Constants.LOTTO_END_INCLUSIVE_NUMBER;
import static lotto.application.ticket.constants.Constants.LOTTO_SIZE;
import static lotto.application.ticket.constants.Constants.LOTTO_START_INCLUSIVE_NUMBER;

public enum LottoNumberRule {
    START_INCLUSIVE(LOTTO_START_INCLUSIVE_NUMBER),
    END_INCLUSIVE(LOTTO_END_INCLUSIVE_NUMBER),
    SIZE(LOTTO_SIZE);

    private int value;

    LottoNumberRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
