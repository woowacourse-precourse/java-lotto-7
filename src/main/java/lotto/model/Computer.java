package lotto.model;

import java.util.HashMap;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.config.RankType;

public class Computer {
    private static final int MIN_CORRECT_COUNT = 3;
    private static final int MAX_RANK = 5;
    private static final int MIN_RANK = 1;
    private static final int ONE_HUNDRED = 100;

    private final Lotto winningLotto;
    private int bonusNumber;
    private final HashMap<Integer, Integer> results;

    public Computer(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);

        HashMap<Integer, Integer> results = new HashMap<>();
        for (int i = MAX_RANK; i >= MIN_RANK; i--) {
            results.put(i, 0);
        }
        this.results = results;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void compareLotto(List<Lotto> lotto) {
        for (Lotto oneOfLotto : lotto) {
            int correctCount = getCorrectCount(oneOfLotto);

            if (correctCount >= MIN_CORRECT_COUNT) {
                int rank = findRank(correctCount, hasBonusNumber(oneOfLotto));
                addResult(rank);
            }
        }
    }

    private int getCorrectCount(Lotto lotto) {
        int correctCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                correctCount += 1;
            }
        }
        return correctCount;
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int findRank(int correctCount, boolean hasBonus) {
        return RankType.findByCorrectCountAndHasBonus(correctCount, hasBonus).getRank();
    }

    private void addResult(int rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public HashMap<Integer, Integer> getResults() {
        return results;
    }

    public float calculateRateOfReturn(int quantity) {
        int purchaseAmount = quantity * LottoConfig.PRICE.getNumber();

        float totalReturn = 0;
        for (int i = MAX_RANK; i >= MIN_RANK; i--) {
            totalReturn += RankType.findByRank(i).getMoney() * results.get(i);
        }

        return (totalReturn / purchaseAmount) * ONE_HUNDRED;
    }
}
