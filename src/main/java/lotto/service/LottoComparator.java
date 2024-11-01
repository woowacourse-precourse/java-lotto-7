package lotto.service;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.UserLotto;

public class LottoComparator {
    private final Lotties lotties;
    private final UserLotto userLotto;

    private LottoComparator(Lotties lotties, UserLotto userLotto) {
        this.lotties = lotties;
        this.userLotto = userLotto;
    }

    public static LottoComparator from(Lotties lotties, UserLotto userLotto) {
        return new LottoComparator(lotties, userLotto);
    }

    public void compare(LottoResult lottoResult) {
        for (Lotto lotto : lotties.getLotties()) {
            int count = lotto.countDuplication(userLotto.getUserLotto());
            boolean isBonus = lotto.hasNumber(userLotto.getBonusBall());

            lottoResult.addResult(count, isBonus);
        }
    }
}