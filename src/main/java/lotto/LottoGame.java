package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private Lotto winningLotto;
    private int bonusNumber;
    private final Map<LottoRank,Integer> result = new HashMap<>();

    public void setLottoGame(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void calculateLotto(List<Lotto> makePurchasedLottos) {
        for (Lotto lotto : makePurchasedLottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);

        }
    }
}
