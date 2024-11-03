package lotto.domain;

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
            if (count != LOTTO_RESULT_SIZE) {
                if (prize.getCount() == count) {
                    lottoResult.merge(prize.name(), ONE, Integer::sum);
                }
            }
            if (count == LOTTO_RESULT_SIZE) {
                if (prize.getCount() == count && prize.getBonus() == isBonus) {
                    lottoResult.merge(prize.name(), ONE, Integer::sum);
                }
            }
        }
    }

    public HashMap<String, Integer> getResult() {
        return lottoResult;
    }
}
