package lotto.model;

import static lotto.constant.ExceptionMessage.INVALID_BONUS_DUPLICATE;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.DrawType;

public class LottoGame {

    private DrawResults drawResults;

    private final Lottos lottos;
    private final Lotto winningLotto;
    private final int bonusNum;

    public LottoGame(Lottos lottos, Lotto winningLotto, int bonusNum) {
        validateDuplicate(winningLotto, bonusNum);
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public void draw() {
        drawResults = lottos.getDrawResult(winningLotto, bonusNum);
    }

    public Map<DrawType, Integer> generateDrawResult() {
        Map<DrawType, Integer> result = new HashMap<>();

        for (DrawType type : DrawType.values()) {
            result.put(type, 0);
        }

        for (DrawResult singleResult : drawResults.getDrawResults()) {
            DrawType type = singleResult.formatDrawResult();
            result.put(type, result.get(type) + 1);
        }

        return result;
    }

    public double calculateEarns(Map<DrawType, Integer> drawTypeIntegerMap, int purchasePrice) {
        int totalEarnings = 0;

        for (Map.Entry<DrawType, Integer> entry : drawTypeIntegerMap.entrySet()) {
            DrawType drawType = entry.getKey();
            int count = entry.getValue();

            totalEarnings += drawType.getPrize() * count;
        }

        return ((double) totalEarnings / purchasePrice) * 100;
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNum) {
        if (winningLotto.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException(INVALID_BONUS_DUPLICATE.getMessage());
        }
    }
}
