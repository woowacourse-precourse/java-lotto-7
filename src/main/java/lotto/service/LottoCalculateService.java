package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Winning;

public class LottoCalculateService {
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
