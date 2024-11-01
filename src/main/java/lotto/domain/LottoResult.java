package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import lotto.constants.Prizes;

public class LottoResult {
    private static HashMap<String, Integer> lottoResult = new LinkedHashMap<>(5);

    private LottoResult() {

    }

    public static LottoResult initialize() {
        for (String prizeName : Arrays.stream(Prizes.values())
                .map(Prizes::name)
                .toList()) {
            lottoResult.put(prizeName, 0);
        }

        return new LottoResult();
    }

    public void addResult(int count, boolean isBonus) {
        for (Prizes prize : Arrays.stream(Prizes.values()).toList()) {
            if (count != 5) {
                if (prize.getCount() == count) {
                    lottoResult.merge(prize.name(), 1, Integer::sum);
                }
            }
            if (count == 5) {
                if (prize.getCount() == count && prize.getBonus() == isBonus) {
                    lottoResult.merge(prize.name(), 1, Integer::sum);
                }
            }
        }
    }

    public HashMap<String, Integer> getResult() {
        return lottoResult;
    }
}
