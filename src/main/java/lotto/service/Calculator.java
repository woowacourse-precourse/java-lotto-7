package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningInformation;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningPrize;

public class Calculator {

    public int matchCount(Lotto issuedLotto) {
        List<Integer> issuedNumbers = issuedLotto.getNumbers();
        Set<Integer> winningNumbers = new HashSet<>(WinningNumbers.getInstance().getWinningNumbers());

        int matchCount = 0;

        for (Integer issuedNumber : issuedNumbers) {
            if (winningNumbers.contains(issuedNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public WinningPrize rank(int matchCount, Lotto issuedLotto, BonusNumber bonusNumber) {
        Set<Integer> issuedNumber = new HashSet<>(issuedLotto.getNumbers());

        if (matchCount == 3) { return WinningPrize.FIFTH; }
        if (matchCount == 4) { return WinningPrize.FOURTH; }
        if (matchCount == 5) {
            if (issuedNumber.contains(bonusNumber.getNumber())) {
                return WinningPrize.SECOND;
            }
            return WinningPrize.THIRD;
        }
        if (matchCount == 6) { return WinningPrize.FIRST; }
        return WinningPrize.FAILURE;
    }

    public double rateOfReturn(PurchaseAmount purchaseAmount) {
        long totalPrize = sumOfPrize();
        double rateOfReturn = (double) totalPrize / (purchaseAmount.getCanBuyLottoCount() * 1000L);
        return roundOfTwo(rateOfReturn * 100);
    }

    private long sumOfPrize() {
        Map<WinningPrize, Integer> prizeAndCount = WinningInformation.getInstance().getPrizeAndCount();
        return prizeAndCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double roundOfTwo(double number) {
        return Math.round(number * 10.0) / 10.0;
    }
}
