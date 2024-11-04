package lotto;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoChecker {

    private Lotto winningLotto;
    private int bonusNumber;
    private LinkedHashMap<Prize, Integer> rankings;
    private long profit;

    public LottoChecker() {
        this.profit = 0;
        this.rankings = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            this.rankings.put(prize, 0);
        }
    }

    public void chooseWinningLotto() {
        List<Integer> winningNumbers = InputManager.getWinningNumbers();
        winningLotto = new Lotto(winningNumbers);
    }

    public void chooseBonusNumber() {
        while (true) {
            try {
                bonusNumber = InputManager.getBonusNumber();
                validateBonusNumber();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber() {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public void getResult(List<Lotto> lottos) {
        getRanking(lottos);
        printResult();
        printProfitRate(lottos.size());
    }

    private void getRanking(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int correct = winningLotto.getDuplicateNumbers(lotto);
            boolean bonusCorrect = lotto.getNumbers().contains(bonusNumber);
            Prize matchedPrize = Prize.getMatchedPrize(correct, bonusCorrect);
            profit += matchedPrize.getAmount();
            rankings.put(matchedPrize, rankings.getOrDefault(matchedPrize, 0) + 1);
        }
    }

    private void printResult() {
        System.out.println("당첨 통계\n---");
        for (Prize prize : rankings.keySet()) {
            if (prize == Prize.NONE) {
                continue;
            }
            System.out.println(prize + " - " + rankings.get(prize) + "개");
        }
    }

    private void printProfitRate(int purchase) {
        double profitRate = (double) this.profit / (purchase * 10);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
