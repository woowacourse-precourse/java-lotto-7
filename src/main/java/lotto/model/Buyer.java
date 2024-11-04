package lotto.model;

import java.util.HashMap;
import java.util.List;

public class Buyer {
    private List<Lotto> lottos;
    private final HashMap<Rank, Integer> resultLotto = new HashMap<>();
    private static final int PERCENTAGE = 100;

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

    public HashMap<Rank, Integer> getResultLotto() {
        return this.resultLotto;
    }

    private void initResultLotto() {
        for (Rank rank : Rank.values()) {
            this.resultLotto.put(rank, 0);
        }
    }

    public int getMatchCount(List<Integer> winningNumber, Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (hasWinningNumber(winningNumber, number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasWinningNumber(List<Integer> winningNumber, int number) {
        return winningNumber.contains(number);
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

    public void matchLottos(List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(winningNumber, lotto);
            boolean hasBonusNumber = hasBonusNumber(bonusNumber, lotto);
            Rank rank = getRank(matchCount, hasBonusNumber);
            resultLotto.put(rank, resultLotto.get(rank) + 1);
        }
    }

    public double getTotalRevenue() {
        double total = 0;
        double cost = lottos.size() * 1000;
        for (Rank key : resultLotto.keySet()) {
            if (resultLotto.get(key) > 0) {
                total += (key.getPrize() * resultLotto.get(key));
            }
        }
        return Double.parseDouble(String.format("%.1f", (total / cost) * PERCENTAGE));
    }
}
