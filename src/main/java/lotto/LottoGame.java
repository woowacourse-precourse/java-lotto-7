package lotto;

import java.util.List;

public class LottoGame {
    private final LottoStore lottoStore = new LottoStore();

    public void start() {
        int amount = InputView.inputPurchaseAmount();
        List<Lotto> purchasedLottos = lottoStore.buyLottos(amount);
        OutputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        calculateAndPrintResults(purchasedLottos, winningLotto, amount);
    }

    private void calculateAndPrintResults(List<Lotto> purchasedLottos, WinningLotto winningLotto, int amount) {
        int[] resultCount = new int[LottoRank.values().length];
        int totalPrize = 0;

        for(Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto, winningLotto.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            resultCount[rank.ordinal()]++;
            totalPrize += rank.getPrize();
        }

        double profitRate = calculateProfitRate(totalPrize, amount);
        OutputView.printResult(resultCount, profitRate);
    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for(int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private double calculateProfitRate(double totalPrize, int amount) {
        return (double) totalPrize / amount * 100;
    }
}
