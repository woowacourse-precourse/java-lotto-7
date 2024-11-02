package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static final int LOTTO_UNIT_PRICE = 1000;
    public void run() {
        int purchaseAmount = calculatePurchaseAmount(InputView.scanPurchasePrice());

        List<Lotto> lottos = generateLottos(purchaseAmount);
        OutputView.printLottos(purchaseAmount, lottos);

        Lotto winningNumbers = InputView.scanWinningNumbers();
        int bonusNumber = InputView.scanBonusNumber(winningNumbers);

        Map<PrizeRank, Integer> prizeRankCounts = getPrizeRankCounts(lottos, winningNumbers, bonusNumber);
        double rateOfReturn = getRateOfReturn(prizeRankCounts, purchaseAmount);

        OutputView.printPrizeStats(prizeRankCounts, rateOfReturn);
    }

    public static int calculatePurchaseAmount(int purchasePrice) {
        return purchasePrice / LOTTO_UNIT_PRICE;
    }

    public static List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public static List<Integer> getWinningNumbers(String[] winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbersInput) {
            int number = Validator.validateNumber(winningNumber);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public static Map<PrizeRank, Integer> getPrizeRankCounts(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> prizeRankCounts = new HashMap<>();
        for (PrizeRank prizeRank : PrizeRank.values()) {
            prizeRankCounts.put(prizeRank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
            PrizeRank prizeRank = PrizeRank.getPrizeRank(matchCount, isBonusMatch);
            prizeRankCounts.put(prizeRank, prizeRankCounts.get(prizeRank) + 1);
        }
        return prizeRankCounts;
    }

    public static double getRateOfReturn(Map<PrizeRank, Integer> prizeRankCounts, int purchaseAmount) {
        // 수익률 = 총상금 / 구입금액 * 100
        // 수익률 = 총상금 / (구입개수 * 1000) * 100
        double totalPrizeAmount = 0;
        for (PrizeRank prizeRank : PrizeRank.values()) {
            double prizeAmount = prizeRank.getPrizeAmount();
            int prizeCount = prizeRankCounts.get(prizeRank);
            totalPrizeAmount += prizeAmount * prizeCount;
        }
        return totalPrizeAmount / (purchaseAmount * 1000) * 100;
    }
}
