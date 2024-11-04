package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    public void purchaseLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int[] calculateResults() {
        int[] matchCounts = new int[Rank.values().length];
        for (Lotto lotto : purchasedLottos) {
            int matches = countMatches(lotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.findRank(matches, bonusMatch);
            if (rank != null) {
                matchCounts[rank.ordinal()]++;
            }
        }
        return matchCounts;
    }

    public double calculateProfitRate(int[] matchCounts, int totalAmountSpent) {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += matchCounts[rank.ordinal()] * rank.getPrizeAmount();
        }
        return (double) totalPrize / totalAmountSpent * 100;
    }

    private int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}

