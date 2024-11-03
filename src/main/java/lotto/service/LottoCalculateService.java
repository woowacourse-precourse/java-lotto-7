package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Winning;

public class LottoCalculateService {
    private static final int THREE_NUMBER_MATCHES = 3;
    private static final int FOUR_NUMBER_MATCHES = 4;
    private static final int FIVE_NUMBER_MATCHES = 5;
    private static final int SIX_NUMBER_MATCHES = 6;
    private static final int BONUS_ENUM_LABEL = 7;
    private static final int BEFORE_BONUS_NUMBER_INDEX = 6;

    public LottoCalculateService() {
    }

    public int calculatePrize(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> matchResult = calculateWinning(userLotto, winningLotto, bonusNumber);
        int matchingCount = matchResult.get(0);
        int bonusCount = matchResult.get(1);

        Winning winning = Winning.findPrize(matchingCount, bonusCount);
        return winning.getPrice();
    }

    private List<Integer> calculateWinning(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int matchingCount = countMatchingNumbers(userLotto.getNumbers(), winningLotto.getNumbers());
        int bonusCount = 0;

        if (userLotto.hasBonusNumber(bonusNumber)) {
            bonusCount = 1;
        }

        return List.of(matchingCount, bonusCount);
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
