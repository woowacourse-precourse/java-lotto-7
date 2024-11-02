package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;

public class LottoMatchingCounter {
    private final String WINNING_COUNT = "winningCount";
    private final String BONUS_COUNT = "bonusCount";
    private final int bonusNumber;
    private final List<Integer> winningNumbers;
    private HashMap<String, Integer> matchingCount;

    public LottoMatchingCounter(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initMatchingCount();
    }

    private void initMatchingCount() {
        this.matchingCount = new HashMap<>();
        matchingCount.put(WINNING_COUNT, 0);
        matchingCount.put(BONUS_COUNT, 0);
    }

    public HashMap<String, Integer> countMatchingNumbers(Lotto purchasedLotto) { //당첨 번호와 구매 내역 중 몇 개의 숫자가 일치하는지 센다.
        List<Integer> numbers = purchasedLotto.getNumbers();
        countWinningNumbers(numbers);
        if (matchingCount.get(WINNING_COUNT) == 5) {
            countBonusNumber(numbers);
        }
        return matchingCount;
    }

    private void countWinningNumbers(List<Integer> numbers) {
        for (Integer number : winningNumbers) {
            if (numbers.contains(number)) {
                addCount(WINNING_COUNT);
            }
        }
    }

    private void countBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            addCount(BONUS_COUNT);
        }
    }

    private void addCount(String type) {
        int count = matchingCount.get(type);
        matchingCount.put(type, count + 1);
    }

}
