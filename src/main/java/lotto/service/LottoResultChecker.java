package lotto.service;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoResultChecker {
    private List<Integer> result = List.of(0, 0, 0, 0, 0);
    private long prize = 0L;

    public void lottoChecker(List<Lotto> lottos, Lotto winningNumber, Bonus bonus) {
        for (Lotto lotto : lottos) {
            long matched = lotto.getNumbers().stream()
                    .filter(winningNumber.getNumbers()::contains)
                    .count();
            boolean hasBonus = lotto.getNumbers().contains(bonus.getBonus());

            Rank rank = Rank.getRank(matched, hasBonus);
            recordLottoResult(rank);
        }
    }

    private void recordLottoResult(Rank rank) {
        if (rank.getRank() > 0) {
            result.set(rank.getRank() - 1, 1);
        }
        prize += rank.getPrize();
    }

    public List<Integer> getResult() {
        return result;
    }

    public long getPrize() {
        return prize;
    }
}
