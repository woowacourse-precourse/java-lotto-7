package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int lottoPurchaseCount = LottoPurchaseHandler.purchaseLotto();

        List<List<Integer>> randomLottoBundle = new ArrayList<List<Integer>>();
        LottoPurchaseHandler.getRandomLottoBundle(lottoPurchaseCount, randomLottoBundle);

        Lotto winningNumbers = Lotto.getWinningNumbers();

        int bonusNumber = Lotto.getBonusNumber(winningNumbers);

        List<Integer> prizeCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (List<Integer> randomNumbers : randomLottoBundle) {
            int numberMatchCount = Lotto.numberMatchCount(winningNumbers, randomNumbers);
            boolean matchBonusNumber = randomNumbers.contains(bonusNumber);

            LottoPrize.getIndividualResult(numberMatchCount, matchBonusNumber, prizeCount);
        }

        LottoPrize.printResult(prizeCount);
    }
}