package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeSheet;
    private Map<Integer, Integer> result;
    private final int bonusMatchPrize;
    private Integer revenue = 0;

    public LottoResult() {
        prizeSheet = new HashMap<>();
        prizeSheet.put(3, 5000);            // 3개 일치
        prizeSheet.put(4, 50000);           // 4개 일치
        prizeSheet.put(5, 1500000);         // 5개 일치
        bonusMatchPrize = 30000000;       // 5개 + 보너스 일치
        prizeSheet.put(6, 2000000000);      // 6개 일치

        result = new HashMap<>();
        for (int i = 3; i <= 6; i++) {
            result.put(i, 0);
        }
        result.put(5 + 10, 0);  // 보너스 포함 5개 일치
    }
}

