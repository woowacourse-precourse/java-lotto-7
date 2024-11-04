package lotto;

import static lotto.Consumer.duplicateWithWinnging;
import static lotto.Consumer.enterPurchaseAmount;
import static lotto.Consumer.getBousNumber;
import static lotto.Consumer.getWinningNumbers;
import static lotto.LottoCalculator.calculateProfitRate;
import static lotto.LottoCalculator.calculateTotalRank;
import static lotto.LottoCalculator.calculateTotalReward;
import static lotto.LottoCalculator.printRank;
import static lotto.Seller.countNumberOfLotto;
import static lotto.Seller.getHowManyLottoMessage;
import static lotto.Seller.giveLotto;
import static lotto.Seller.setBonusNumbers;
import static lotto.Seller.setInputPurchaseAmount;
import static lotto.Seller.setWinningNumbers;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void start() {
        setInputPurchaseAmount();
        int purchaseAmount = enterPurchaseAmount();
        int numberOfLotto = countNumberOfLotto(purchaseAmount);
        System.out.println();
        System.out.println(getHowManyLottoMessage(numberOfLotto));
        List<Lotto> lottos = giveLotto(numberOfLotto);
        System.out.println();
        setWinningNumbers();
        List<Integer> winningNumbers = getWinningNumbers();
        System.out.println();
        setBonusNumbers();
        int bonusNumber = getBousNumber();
        duplicateWithWinnging(winningNumbers, bonusNumber);

        Map<Rank, Integer> rankCount = calculateTotalRank(lottos, winningNumbers, bonusNumber);
        printRank(rankCount);
        long totalReward = calculateTotalReward(rankCount);
        double profitRate = calculateProfitRate(totalReward, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
