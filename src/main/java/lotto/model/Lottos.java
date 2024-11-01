package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.WinningType;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<List<Integer>> lottoContents) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> content : lottoContents) {
            lottos.add(Lotto.createLotto(content));
        }
        this.lottos = lottos;
    }

    public LottoResult check(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        LottoResult result = LottoResult.create();
        for (Lotto lotto : lottos) {
            final CorrectCount correctCount = winningNumbers.check(lotto.getNumbers());
            if (correctCount.getCount() == WinningType.BONUS.getCorrectCount()) {
                checkWithBonusNumber(bonusNumber, lotto, correctCount);
            }
            result.update(correctCount);
        }
        return result;
    }

    private void checkWithBonusNumber(final BonusNumber bonusNumber, final Lotto lotto,
                                      final CorrectCount correctCount) {
        bonusNumber.check(lotto.getNumbers(), correctCount);
    }
}
