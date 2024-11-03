package lotto.domain;

import static lotto.constant.OutputMessage.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.LottoResult;

public class LottoResultCounter {
    private static final List<LottoResult> TARGET_LOTTO_RESULT_TYPES = List.of(
        LottoResult.THREE_MATCH,
        LottoResult.FOUR_MATCH,
        LottoResult.FIVE_MATCH,
        LottoResult.FIVE_MATCH_BONUS,
        LottoResult.SIX_MATCH
    );

    private final Map<LottoResult, Integer> counter = new HashMap<>();

    {
        for (LottoResult lottoResult : TARGET_LOTTO_RESULT_TYPES) {
            counter.put(lottoResult, 0);
        }
    }

    public void add(LottoResult result) {
        if (!TARGET_LOTTO_RESULT_TYPES.contains(result)) {
            return;
        }

        counter.put(result, counter.get(result) + 1);
    }

    public int getProfit() {
        int profit = 0;

        for (LottoResult result : TARGET_LOTTO_RESULT_TYPES) {
            profit += result.price * counter.get(result);
        }

        return profit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (LottoResult result : TARGET_LOTTO_RESULT_TYPES) {
            builder.append(LOTTO_RESULT_COUNTER_FORMAT.formatted(result.toString(), counter.get(result)));
        }

        return builder.toString();
    }
}
