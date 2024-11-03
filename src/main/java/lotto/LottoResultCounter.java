package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultCounter {
    Map<LottoResult, Integer> counter = new HashMap<>();

    public void add(LottoResult result) {
        if (!counter.containsKey(result)) {
            counter.put(result, 0);
        }

        counter.put(result, counter.get(result) + 1);
    }
}
