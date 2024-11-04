package lotto.domain.number;

import lotto.domain.ticket.Lotto;

public class BonusNumber {
    private static final String ERROR_DUPLICATE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    private final LottoNumber number;

    private BonusNumber(LottoNumber number, Lotto winningLotto) {
        validateDuplicate(number, winningLotto);
        this.number = number;
    }

    public static BonusNumber of(LottoNumber number, Lotto winningLotto) {
        return new BonusNumber(number, winningLotto);
    }

    private void validateDuplicate(LottoNumber number, Lotto winningLotto) {
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public int getNumber() {
        return number;
    }
}