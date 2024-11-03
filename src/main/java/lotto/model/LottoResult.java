package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.WinningType;

public class LottoResult {

    private final Map<WinningType, Integer> result;

    private LottoResult() {
        this.result = new LinkedHashMap<>();
        for (WinningType type : WinningType.values()) {
            this.result.put(type, 0);
        }
    }

    public static LottoResult create() {
        return new LottoResult();
    }

    public void update(final CorrectCount correctCount) {
        final WinningType type = WinningType.getType(correctCount);
        result.put(type, result.get(type) + 1);
    }

    public double getIncomeRatio(LottoPurchase purchase) {
        long totalIncome = 0L;
        for (Entry<WinningType, Integer> entry : result.entrySet()) {
            totalIncome += entry.getKey().getPrice() * entry.getValue();
        }
        return (double) totalIncome / purchase.getPrice();
    }

    public Map<WinningType, Integer> getResult() {
        return result;
    }
}
