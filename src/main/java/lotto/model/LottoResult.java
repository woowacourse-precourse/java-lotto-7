package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.WinningType;

public class LottoResult {

    private final Map<WinningType, Integer> result;

    private LottoResult() {
        this.result = new HashMap<>();
    }

    public static LottoResult create() {
        return new LottoResult();
    }

    public void update(final CorrectCount correctCount) {
        final WinningType type = WinningType.getType(correctCount);
        result.put(type, result.getOrDefault(type, 0) + 1);
    }

    public double getIncomeRatio(int lottoCount) {
        long totalIncome = 0L;
        for (Entry<WinningType, Integer> entry : result.entrySet()) {
            totalIncome += entry.getKey().getPrice() * entry.getValue();
        }
        return (double) totalIncome / lottoCount;
    }

    public Map<WinningType, Integer> getResult() {
        return result;
    }
}
