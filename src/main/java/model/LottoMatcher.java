package model;

import java.util.HashSet;
import java.util.Set;

public class LottoMatcher {

    public static int compareNumbers(Lotto randomLotto, Lotto winningLotto) {
        int result = 0;
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());

        for (Integer number : randomLotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                result += 1;
            }
        }

        return result;
    }

    public static boolean compareBonusNumber(Lotto randomLotto, Integer bonusNumber) {
        Set<Integer> randomNumbers = new HashSet<>(randomLotto.getNumbers());
        return randomNumbers.contains(bonusNumber);
    }
}
