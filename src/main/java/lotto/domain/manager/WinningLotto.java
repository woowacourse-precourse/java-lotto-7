package lotto.domain.manager;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;

public class WinningLotto {
    private static final String VIOLATION_UNIQUE_WINNING_NUMBERS_WITH_BONUS_NUMBER = "[ERROR] 당첨번호와 보너스번호는 중복되지 않아야합니다.";

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        validates(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    int match(Lotto lotto) {
        return this.lotto.match(lotto);
    }

    boolean isMatchBonus(Lotto lotto) {
        return lotto.isContain(bonus);
    }

    private static void validates(Lotto lotto, LottoNumber bouns) {
        boolean exist = lotto.isContain(bouns);
        if (exist) {
            throw new IllegalArgumentException(VIOLATION_UNIQUE_WINNING_NUMBERS_WITH_BONUS_NUMBER);
        }
    }
}
