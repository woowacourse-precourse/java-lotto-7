package model;

import java.util.List;
import java.util.stream.IntStream;
import utils.WinningLotto;

public class LottoValidation {
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
        incrementWinningResult(updateIndex);
    }


    public double calculateProfitRate(int purchaseAmount) {
        int totalWinningAmount = calculateTotalWinningAmount();
        return (double) totalWinningAmount / purchaseAmount;
    }

    private int calculateTotalWinningAmount() {
        return IntStream.range(0, winningResult.size())
                .map(i -> WinningLotto.values()[i].getAmount() * winningResult.get(i))
                .sum();
    }

    private int validateWinningResult(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return 0;
        }
        if (matchCount == 5 && matchBonus) {
            return 1;
        }
        if (matchCount == 5) {
            return 2;
        }
        if (matchCount == 4) {
            return 3;
        }
        if (matchCount == 3) {
            return 4;
        }
        return -1;
    }

    private void incrementWinningResult(int index) {
        winningResult.set(index, winningResult.get(index) + 1);
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

    private boolean isMatchBonusNumber(int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

}
