package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoDraw {
    private int pieces;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int[] matchCount;
    private long revenue;
    private double revenueRate;

    public LottoDraw(int pieces) {
        this.pieces = pieces;
        this.lottos = new ArrayList<>();
        this.matchCount = new int[8];
    }

    public void generateLottos() {
        for (int i = 0; i < pieces; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void calculateResults() {
        for (Lotto lotto : lottos) {
            matchTest(lotto);
        }
        calculateRevenue();
        calculateRevenueRate();
    }

    private void matchTest(Lotto lotto) {
        List<Integer> intersection = new ArrayList<>(winningNumbers);
        intersection.retainAll(lotto.getNumbers());
        if (intersection.size() == 5 && bonusMatchTest(lotto)) {
            matchCount[7]++;
        }
        matchCount[intersection.size()]++;
    }

    private boolean bonusMatchTest(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void calculateRevenue() {
        revenue = matchCount[3] * 5000;
        revenue += matchCount[4] * 50000;
        revenue += matchCount[5] * 1500000;
        revenue += matchCount[7] * 30000000;
        revenue += matchCount[6] * 2000000000;
    }

    private void calculateRevenueRate() {
        revenueRate = Math.round((double) revenue / (pieces * 1000) * 100 * 100) / 100.0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int[] getMatchCount() {
        return matchCount;
    }

    public double getRevenueRate() {
        return revenueRate;
    }
}
