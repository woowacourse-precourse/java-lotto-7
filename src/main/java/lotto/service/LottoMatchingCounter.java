package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.constant.GlobalConstant;
import lotto.model.Lotto;

public class LottoMatchingCounter {
    private final int bonusNumber;
    private final List<Integer> winningNumbers;
    private HashMap<String, Integer> matchingCount;

    public LottoMatchingCounter(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void initMatchingCount() {
        this.matchingCount = new HashMap<>();
        matchingCount.put(GlobalConstant.WINNING_COUNT.value(), 0);
        matchingCount.put(GlobalConstant.BONUS_COUNT.value(), 0);
    }

    public HashMap<String, Integer> countMatchingNumbers(Lotto purchasedLotto) { //당첨 번호와 구매 내역 중 몇 개의 숫자가 일치하는지 센다.
        initMatchingCount();
        List<Integer> lottoNumbers = purchasedLotto.getNumbers();
        countWinningNumbers(lottoNumbers);
        if (matchingCount.get(GlobalConstant.WINNING_COUNT.value()) == 5) {
            countBonusNumber(lottoNumbers);
        }
        return matchingCount;
    }

    private void countWinningNumbers(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                addCount(GlobalConstant.WINNING_COUNT.value());
            }
        }
    }

    private void countBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            addCount(GlobalConstant.BONUS_COUNT.value());
        }
    }

    private void addCount(String type) {
        int count = matchingCount.get(type);
        matchingCount.put(type, count + 1);
    }

}
