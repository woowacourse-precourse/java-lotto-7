package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.UserLotto;

public class LottoComparator {
    private final List<Lotto> lotties;
    private final UserLotto userLotto;

    private LottoComparator(List<Lotto> lotties, UserLotto userLotto) {
        this.lotties = lotties;
        this.userLotto = userLotto;
    }

    public static LottoComparator from(List<Lotto> lotties, UserLotto userLotto) {
        return new LottoComparator(lotties, userLotto);
    }

    public void compare(LottoResult lottoResult) {
        for (Lotto lotto : lotties) {
            int count = lotto.countDuplication(userLotto.getUserLotto());
            boolean isBonus = lotto.hasNumber(userLotto.getBonusBall());

            lottoResult.addResult(count, isBonus);
        }
    }
}