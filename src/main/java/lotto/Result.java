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

    private final Map<String, Integer> resultMap = new LinkedHashMap<>();
    private final List<Lotto> lottos;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

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

    public void calculate() {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);
            updateResult(matchCount, bonusMatch);
        }
    }

    private void updateResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            incrementResult(MATCH_6);
            return;
        }
        if (matchCount == 5 && bonusMatch) {
            incrementResult(MATCH_5_BONUS);
            return;
        }
        if (matchCount == 5) {
            incrementResult(MATCH_5);
            return;
        }
        if (matchCount == 4) {
            incrementResult(MATCH_4);
            return;
        }
        if (matchCount == 3) {
            incrementResult(MATCH_3);
        }
    }

    private void incrementResult(String key) {
        resultMap.put(key, resultMap.get(key) + 1);
    }
}
