package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;

public class WinningNumbers {

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

    private WinningRank findRank(Numbers numbers) {
        int matchCount = numbers.countOfOverlapped(winnigNumbers);
        boolean isBonusMatch = numbers.contains(bonusNumber);
        return WinningRank.findRank(matchCount, isBonusMatch);
    }
}
