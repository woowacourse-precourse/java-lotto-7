package lotto;

import static lotto.Consumer.duplicateWithWinnging;
import static lotto.Consumer.enterPurchaseAmount;
import static lotto.Consumer.getBonusNumber;
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
        int purchaseAmount = getPurchaseAmount();
        int numberOfLotto = getLottoCount(purchaseAmount);

        System.out.println();
        printLottoCountMessage(numberOfLotto);

        List lottos = issueLottos(numberOfLotto);

        System.out.println();
        List winningNumbers = getWinningNumbersInput();
        System.out.println();
        int bonusNumber = getBonusNumberInput();
        validateBonusNumber(winningNumbers, bonusNumber);

        Map rankCount = calculateRankings(lottos, winningNumbers, bonusNumber);
        displayResults(rankCount, purchaseAmount);
    }

    private int getPurchaseAmount() {
        setInputPurchaseAmount();
        return enterPurchaseAmount();
    }

    private int getLottoCount(int purchaseAmount) {
        return countNumberOfLotto(purchaseAmount);
    }

    private void printLottoCountMessage(int numberOfLotto) {
        System.out.println(getHowManyLottoMessage(numberOfLotto));
    }

    private List issueLottos(int numberOfLotto) {
        return giveLotto(numberOfLotto);
    }

    private List getWinningNumbersInput() {
        setWinningNumbers();
        return getWinningNumbers();
    }

    private int getBonusNumberInput() {
        setBonusNumbers();
        return getBonusNumber();
    }

    private void validateBonusNumber(List winningNumbers, int bonusNumber) {
        duplicateWithWinnging(winningNumbers, bonusNumber);
    }

    private Map calculateRankings(List lottos, List winningNumbers, int bonusNumber) {
        return calculateTotalRank(lottos, winningNumbers, bonusNumber);
    }

    private void displayResults(Map rankCount, int purchaseAmount) {
        printRank(rankCount);
        long totalReward = calculateTotalReward(rankCount);
        double profitRate = calculateProfitRate(totalReward, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
