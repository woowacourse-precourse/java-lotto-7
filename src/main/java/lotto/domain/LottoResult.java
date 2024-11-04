package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.Constants;

public class LottoResult {
    private Map<String, Integer> result;
    private int prize;

    public LottoResult() {
        this.prize = 0;
        initResult();
    }

    private void initResult() {
        result = new HashMap<>();
        result.put("three", 0);
        result.put("four", 0);
        result.put("five", 0);
        result.put("fiveBonus", 0);
        result.put("six", 0);
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public int getPrize() {
        return prize;
    }

    public void addResult(String rank) {
        result.replace(rank, result.get(rank) + 1);
    }

    public void updateWinningResult(LottoCount lottoCount) {
        int matchCount = lottoCount.getMatchCount();
        boolean hasBonusNumber = lottoCount.isHasBonusNumber();
        if (matchCount == 6) {
            addResult("six");
        } else if (matchCount == 5 && hasBonusNumber) {
            addResult("fiveBonus");
        } else if (matchCount == 5) {
            addResult("five");
        } else if (matchCount == 4) {
            addResult("four");
        } else if (matchCount == 3) {
            addResult("three");
        }
    }

    public void calculatePrize() {
        this.prize = result.get("three") * Constants.THREE_PRIZE.getValue() +
                result.get("four") * Constants.FOUR_PRIZE.getValue() +
                result.get("five") * Constants.FIVE_PRIZE.getValue() +
                result.get("fiveBonus") * Constants.FIVE_BONUS_PRIZE.getValue() +
                result.get("six") * Constants.SIX_PRIZE.getValue();
    }
}
