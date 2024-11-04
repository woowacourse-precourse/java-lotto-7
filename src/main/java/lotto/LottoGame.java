package lotto;

import java.util.List;

public class LottoGame {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult calculateResult(List<Lotto> purchasedLottos) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean bonusMatch = lotto.containsNumber(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            result.addResult(rank);
        }
        return result;
    }
}
