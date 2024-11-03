package lotto.domain.manager;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;

public class WinningLottos {

    private final Lotto lotto;
    private final LottoNumber bouns;

    public WinningLottos(Lotto lotto, LottoNumber bouns) {
        validates(lotto, bouns);
        this.lotto = lotto;
        this.bouns = bouns;
    }

    int match(Lotto lotto) {
        return this.lotto.match(lotto);
    }

    boolean isMatchBonus(Lotto lotto) {
        return lotto.isContain(bouns);
    }

    private static void validates(Lotto lotto, LottoNumber bouns) {
        boolean exist = lotto.isContain(bouns);
        if (exist) {
            throw new IllegalArgumentException("[ERROR] 당첨번호화 보너스번호는 중복되지 않아야합니다.");
        }
    }
}
