package lotto.model;

import java.util.HashMap;
import java.util.List;

public class Buyer {
    private List<Lotto> lottos;
    private HashMap<Rank, Integer> resultLotto = new HashMap<>();

    public Buyer() {
        initResultLotto();
    }

    public Buyer(List<Lotto> lottos) {
        this.lottos = lottos;
        initResultLotto();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void initResultLotto() {
        for (Rank rank : Rank.values()) {
            this.resultLotto.put(rank, 0);
        }
    }

    public int getMatchCount(List<Integer> winningNumber, Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasBonusNumber(int number, Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }

    public Rank getRank(int matchCount, boolean hasBonusNumber) {
        Rank rank = Rank.values()[matchCount];
        if (rank == Rank.THIRD && hasBonusNumber) {
            rank = Rank.SECOND;
        }
        return rank;
    }
}
