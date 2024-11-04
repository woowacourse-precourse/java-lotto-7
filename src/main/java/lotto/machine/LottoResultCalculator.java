package lotto.machine;

import java.util.List;
import java.util.Optional;
import lotto.Lotto;

public class LottoResultCalculator {
    final Lotto lotto;

    LottoResultCalculator(Lotto lotto) {
        this.lotto = lotto;
    }


    Optional<PrizeStatus> calculate(List<Integer> winnerNumbers, int bonusNumber) {
        final List<Integer> currentLottoNumbers = lotto.getNumbers();

        int matchCount = 0;
        for (int number : winnerNumbers) {
            if (currentLottoNumbers.contains(number)) {
                matchCount += 1;
            }
        }

        boolean isMatchBonusNumber = currentLottoNumbers.contains(bonusNumber);

        for (PrizeStatus value : PrizeStatus.values()) {
            if (value.getMatchCount() == matchCount && (value == PrizeStatus.FIVE_MATCH_WITH_BONUS
                    && value.getIsRequireToMatchBonusNumber() == isMatchBonusNumber)) {
                return Optional.of(value);
            }
            if (value.getMatchCount() == matchCount) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
