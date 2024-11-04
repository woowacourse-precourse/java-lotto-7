package lotto.Service;

import java.util.List;
import lotto.View.OutputView;
import lotto.controller.MarginController;

public class CheckerService {
    private static int firstPrizeCount = 0;
    private static int secondPrizeCount = 0;
    private static int thirdPrizeCount = 0;
    private static int fourthPrizeCount = 0;
    private static int fifthPrizeCount = 0;
    private boolean hasBonus;

    public int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void matchBonus(List<Integer> lotto, int bonusNumber) {
        hasBonus = lotto.contains(bonusNumber);
    }

    public void isDetermine(int matchCount) {
        if (matchCount == 6) {
            firstPrizeCount++;
        }
        if (matchCount == 5 && hasBonus) {
            secondPrizeCount++;
        }
        if (matchCount == 5 && !hasBonus) {
            thirdPrizeCount++;
        }
        if (matchCount == 4) {
            fourthPrizeCount++;
        }
        if (matchCount == 3) {
            fifthPrizeCount++;
        }
        hasBonus = false;
    }

    public void result() {
        OutputView.displayPrizeResults(firstPrizeCount, secondPrizeCount, thirdPrizeCount, fourthPrizeCount,
                fifthPrizeCount);
        int money = getMoney();
        int payment = LottoService.getPayment();
        MarginController.run(money, payment);
    }

    public static int getMoney() {
        int money = (firstPrizeCount * 2000000000)
                + (secondPrizeCount * 30000000)
                + (thirdPrizeCount * 1500000)
                + (fourthPrizeCount * 50000)
                + (fifthPrizeCount * 5000);
        return money;
    }

}
