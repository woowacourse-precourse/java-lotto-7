package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Result {

    private static final String MATCH_3 = "3개 일치 (5,000원)";
    private static final String MATCH_4 = "4개 일치 (50,000원)";
    private static final String MATCH_5 = "5개 일치 (1,500,000원)";
    private static final String MATCH_5_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String MATCH_6 = "6개 일치 (2,000,000,000원)";
    private static final Map<String, Integer> PRIZE_MONEY;

    static {
        PRIZE_MONEY = new LinkedHashMap<>();
        PRIZE_MONEY.put(MATCH_3, 5_000);
        PRIZE_MONEY.put(MATCH_4, 50_000);
        PRIZE_MONEY.put(MATCH_5, 1_500_000);
        PRIZE_MONEY.put(MATCH_5_BONUS, 30_000_000);
        PRIZE_MONEY.put(MATCH_6, 2_000_000_000);
    }

    // 인스턴스 변수
    private final Map<String, Integer> resultMap = new LinkedHashMap<>();
    private final List<Lotto> lottos;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    // 생성자
    public Result(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initializeResultMap();
    }

    private void initializeResultMap() {
        for (String key : PRIZE_MONEY.keySet()) {
            resultMap.put(key, 0);
        }
    }
}
