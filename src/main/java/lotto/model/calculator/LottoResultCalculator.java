package lotto.model.calculator;

import lotto.model.lottos.Lotto;

import java.util.*;

public class LottoResultCalculator {

    private final List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    public List<Integer> getResult() {
        return result;
    }

    public void calculate(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);

        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbersSet);
            boolean hasBonus = lottoHasBonus(winningNumbersSet, bonusNumber);

            updateResult(matchCount, hasBonus);
        }
    }

    private int countMatches(List<Integer> numbers, Set<Integer> winningNumbersSet) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningNumbersSet.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean lottoHasBonus(Set<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void updateResult(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            result.set(0, result.get(0) + 1);
        }
        if (matchCount == 5 && hasBonus) {
            result.set(1, result.get(1) + 1);
        }
        if (matchCount == 5 && !hasBonus) {
            result.set(2, result.get(2) + 1);
        }
        if (matchCount == 4) {
            result.set(3, result.get(3) + 1);
        }
        if (matchCount == 3) {
            result.set(4, result.get(4) + 1);
        }
    }
}
