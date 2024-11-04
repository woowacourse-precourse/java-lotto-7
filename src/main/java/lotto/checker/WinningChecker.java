package lotto.checker;

import java.util.List;
import java.util.Map;
import lotto.data.Lotto;
import lotto.config.enumerate.WinningInfo;
import lotto.data.WinningLotto;
import lotto.data.WinningResult;

public class WinningChecker {

    private final int BONUS_CHECK_CRITERIA = 5;

    private final WinningLotto winningLotto;
    private final WinningResult winningResult = new WinningResult();

    public WinningChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningResult getWinningResult(long lottoPurchaseAmount, List<Lotto> lottoes) {

        updateWinningCount(lottoes);
        updateProfitRate(lottoPurchaseAmount);
        return winningResult;

    }

    private void updateWinningCount(List<Lotto> lottoes) {
        Map<WinningInfo, Integer> winningCount = winningResult.getWinningCount();

        for (Lotto lotto : lottoes) {
            WinningInfo winningInfo = getWinningInfo(lotto);
            winningCount.put(winningInfo, winningCount.get(winningInfo) + 1);
        }
    }

    private void updateProfitRate(long lottoPurchaseAmount) {
        int totalPrize = 0;
        Map<WinningInfo, Integer> winningCount = winningResult.getWinningCount();
        for (Map.Entry<WinningInfo, Integer> entry : winningCount.entrySet()) {
            WinningInfo winningInfo = entry.getKey();
            int eachCount = entry.getValue();
            totalPrize += winningInfo.getPrize() * eachCount;
        }
        double profitRate = (double) totalPrize / lottoPurchaseAmount * 100;
        winningResult.setProfitRate(profitRate);
    }

    private WinningInfo getWinningInfo(Lotto lotto) {
        int numberOfMatch = findNumberOfMatch(lotto);
        boolean isBonus = false;
        if (numberOfMatch == BONUS_CHECK_CRITERIA) {
            isBonus = checkBonus(lotto);
        }

        return WinningInfo.getWinningInfo(numberOfMatch, isBonus);
    }

    private int findNumberOfMatch(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int numberOfMatch = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbersHasNumber(lottoNumber)) {
                numberOfMatch += 1;
            }
        }

        return numberOfMatch;
    }

    private boolean winningNumbersHasNumber(int number) {
        for (int lottoWinningNumber : winningLotto.getNumbers()) {
            if (number == lottoWinningNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean checkBonus(Lotto lotto) {
        int numberToCheckBonus = getNumberToCheckBonus(lotto.getNumbers());
        return numberToCheckBonus == winningLotto.getBonusNumber();
    }

    private int getNumberToCheckBonus(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (!winningNumbersHasNumber(lottoNumber)) {
                return lottoNumber;
            }
        }
        return -1;
    }

}
