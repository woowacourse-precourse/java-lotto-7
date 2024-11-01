package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Comparator {
    public Map<String, Integer> compareLotto(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        Map<String, Integer> result = new HashMap<>();
        result.put("correct", getCorrectCount(lotto, winningNumbers));
        result.put("bonus", getBonusCount(lotto, bonusNumber));
        return result;
    }

    public int getCorrectCount(Lotto lotto, Lotto winningLotto) {
        long correctCount = lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        return (int) correctCount;
    }

    public int getBonusCount(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}
