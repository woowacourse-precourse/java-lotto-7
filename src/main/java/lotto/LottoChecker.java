package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    List<Integer> rankCounts;
    List<Integer> winningNumber;
    int bonusNumber;

    public LottoChecker(List<Integer> winningNumber, int bonusNumber) {
        rankCounts = new ArrayList<>(LottoRank.values().length);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void recordLottoRank(Lotto lotto) {
        int lottoRank = lotto.getLottoRank(winningNumber, bonusNumber);
        rankCounts.set(lottoRank, rankCounts.get(lottoRank) + 1);
    }
}
