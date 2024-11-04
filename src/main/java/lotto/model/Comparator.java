package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparator {
    public List<Result> compareLottos(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        List<Result> results = new ArrayList<>();
        for(Lotto lotto : lottos) {
            Result result = compareLotto(lotto, winningNumbers, bonusNumber);
            results.add(result);
        }
        return results;
    }
    public Result compareLotto(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        int correctCount = getCorrectCount(lotto, winningNumbers);
        int bonusCount = getBonusCount(lotto, bonusNumber);
        return Result.valueOf(correctCount, bonusCount);
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
