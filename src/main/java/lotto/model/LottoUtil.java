package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoRank;

public class LottoUtil {
    public LottoRank getLottoPrizeRank(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = countMatchingNumbers(numbers, winningNumbers);
        return LottoRank.getRankByMatchingCountAndBonus(matchingCount, containsBonusNumber(numbers, bonusNumber));
    }

    private int countMatchingNumbers(List<Integer> numbers, List<Integer> winningNumbers) {
        List<Integer> retainNumbers = new ArrayList<>(numbers);
        retainNumbers.retainAll(winningNumbers);
        return retainNumbers.size();
    }

    private boolean containsBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
