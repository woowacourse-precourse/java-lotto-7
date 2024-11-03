package lotto.checker;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.config.enumerate.WinningInfo;

public class WinningChecker {

    private final int BONUS_CHECK_CRITERIA = 5;

    private final int[] winningNumbers;
    private final int bonusNumber;
    private final Map<WinningInfo, Integer> winningResult = new EnumMap<>(WinningInfo.class);

    public WinningChecker(int[] winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        for (WinningInfo info : WinningInfo.values()) {
            winningResult.put(info, 0);
        }
    }

    public Map<WinningInfo, Integer> getWinningResult(List<Lotto> lottoes) {

        for (Lotto lotto : lottoes) {
            WinningInfo winningInfo = getWinningInfo(lotto);
            winningResult.put(winningInfo, winningResult.get(winningInfo) + 1);
        }

        return winningResult;
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
        for (int lottoWinningNumber : winningNumbers) {
            if (number == lottoWinningNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean checkBonus(Lotto lotto) {
        int numberToCheckBonus = getNumberToCheckBonus(lotto.getNumbers());
        return numberToCheckBonus == bonusNumber;
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
