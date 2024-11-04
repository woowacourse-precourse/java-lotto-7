package lotto.domain;

import static lotto.constants.Constants.BONUS_LOTTO_COUNT;
import static lotto.constants.Constants.INITIAL_COUNT;
import static lotto.constants.Constants.LOTTO_RESULT_SIZE;
import static lotto.constants.Constants.ONE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import lotto.constants.Prizes;

public class LottoResult {
    private static HashMap<String, Integer> lottoResult = new LinkedHashMap<>(LOTTO_RESULT_SIZE);

    private LottoResult() {

    }

    public static LottoResult initialize() {
        for (String prizeName : Arrays.stream(Prizes.values())
                .map(Prizes::name)
                .toList()) {
            lottoResult.put(prizeName, INITIAL_COUNT);
        }

        return new LottoResult();
    }

    public void addResult(int count, boolean isBonus) {
        for (Prizes prize : Arrays.stream(Prizes.values()).toList()) {
            incrementLottoCountByCountAndBonus(count, isBonus, prize);
        }
    }

    public HashMap<String, Integer> getResult() {
        return lottoResult;
    }

    private void incrementLottoCountByCountAndBonus(int count, boolean isBonus, Prizes prize) {
        if (count != BONUS_LOTTO_COUNT) {
            increaseCount(count, prize);
        }
        if (count == BONUS_LOTTO_COUNT) {
            increaseCount(count, isBonus, prize);
        }
    }

    private void increaseCount(int count, Prizes prize) {
        if (isSamePrizeCount(prize, count)) {
            lottoResult.merge(prize.name(), ONE, Integer::sum);
        }
    }

    private void increaseCount(int count, boolean isBonus, Prizes prize) {
        if (isSamePrizeCount(prize, count) && hasBonus(prize, isBonus)) {
            lottoResult.merge(prize.name(), ONE, Integer::sum);
        }
    }

    private boolean isSamePrizeCount(Prizes prize, int count) {
        return prize.getCount() == count;
    }

    private boolean hasBonus(Prizes prize, boolean isBonus) {
        return prize.getBonus() == isBonus;
    }
}
