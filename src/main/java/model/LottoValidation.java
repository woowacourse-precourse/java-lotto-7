package model;

import java.util.List;
import java.util.stream.IntStream;
import utils.WinningLotto;
import utils.WinningResult;

public class LottoValidation {
    private static final int NO_MATCH = -1;
    private final List<Integer> winningNumbers;
    private final List<Integer> winningResult;

    public LottoValidation(List<Integer> winningNumbers, List<Integer> winningResult) {
        this.winningNumbers = winningNumbers;
        this.winningResult = winningResult;
    }

    public void updateWinningResult(List<Integer> lottoNumber, int bonusNumber) {
        int lottoMatchCount = isMatchWinningNumbers(lottoNumber);
        boolean isMatchBonusNumber = isMatchBonusNumber(bonusNumber);
        int updateIndex = validateWinningResult(lottoMatchCount, isMatchBonusNumber);
        if (updateIndex == NO_MATCH) {
            return;
        }
        incrementWinningResult(updateIndex);
    }

    public double calculateProfitRate(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0;
        }
        int totalWinningAmount = calculateTotalWinningAmount();
        return 100 + ((double) (totalWinningAmount - purchaseAmount) / purchaseAmount * 100);
    }

    private int isMatchWinningNumbers(List<Integer> lottoNumber) {
        int lottoMatchCount = 0;
        for (Integer integer : lottoNumber) {
            if (winningNumbers.contains(integer)) {
                lottoMatchCount++;
            }
        }
        return lottoMatchCount;
    }

    private int validateWinningResult(int matchCount, boolean matchBonus) {
        for (WinningResult result : WinningResult.values()) {
            if (result.getMatchCount() == matchCount && result.isMatchBonus() == matchBonus) {
                return result.getResultIndex();
            }
        }
        return NO_MATCH;
    }

    private void incrementWinningResult(int index) {
        winningResult.set(index, winningResult.get(index) + 1);
    }

    private boolean isMatchBonusNumber(int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private int calculateTotalWinningAmount() {
        return IntStream.range(0, winningResult.size())
                .map(i -> WinningLotto.values()[i].getAmount() * winningResult.get(i))
                .sum();
    }
}
