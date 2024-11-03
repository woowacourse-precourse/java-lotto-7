package lotto.domain.prize;

import static lotto.domain.ticket.LottoNumberRule.END_INCLUSIVE;
import static lotto.domain.ticket.LottoNumberRule.START_INCLUSIVE;

import lotto.domain.ticket.Lotto;

public class BonusNumber {
    private final int value;

    public BonusNumber(int value) {
        this.value = value;
    }

    public static BonusNumber of(int value, Lotto lotto) {
        validate(value, lotto);
        return new BonusNumber(value);
    }

    public int getValue() {
        return 0;
    }

    private static void validate(int value, Lotto lotto) {
        validateNumberRange(value);
    }

    private static void validateNumberRange(int value) {
        if (value < END_INCLUSIVE.getValue() || value > START_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
