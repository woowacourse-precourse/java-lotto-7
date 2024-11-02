package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingLong;

import java.util.Map;

public class WinningNumbers {

    private static final int TO_PERCENTAGE = 100;

    private final Numbers winnigNumbers;
    private final Number bonusNumber;

    public WinningNumbers(Numbers winnigNumbers, Number bonusNumber) {
        validateNotOverlapped(winnigNumbers, bonusNumber);

        this.winnigNumbers = winnigNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNotOverlapped(Numbers winnigNumbers, Number bonusNumber) {
        if (winnigNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 겹치면 안됩니다");
        }
    }

    public Map<WinningRank, Long> findResult(Lotties lotties) {
        return lotties.getLottoNumbers()
                .stream()
                .collect(groupingBy(this::findRank, counting()));
    }

    public double calculateProfit(Lotties lotties) {
        long totalPrice = calculateTotalPrice(lotties);
        return ((double) totalPrice) / lotties.getTotalLottoPrice() * TO_PERCENTAGE;
    }

    private long calculateTotalPrice(Lotties lotties) {
        return lotties.getLottoNumbers()
                .stream()
                .map(this::findRank)
                .collect(summarizingLong(WinningRank::getWinningAmount))
                .getSum();
    }

    private WinningRank findRank(Numbers numbers) {
        int matchCount = numbers.countOfOverlapped(winnigNumbers);
        boolean isBonusMatch = numbers.contains(bonusNumber);
        return WinningRank.findRank(matchCount, isBonusMatch);
    }
}
