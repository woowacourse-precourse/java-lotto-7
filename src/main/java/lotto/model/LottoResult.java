package lotto.model;

import java.util.HashMap;
import java.util.Map;
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

    public Map<WinningType, Integer> getResult() {
        return result;
    }
}
