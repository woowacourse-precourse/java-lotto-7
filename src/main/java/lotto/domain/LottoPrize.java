package lotto.domain;

import lotto.config.LottoSettings;
import java.util.HashMap;
import java.util.Map;

public class LottoPrize {
    private static final Map<Integer, Integer> prizeInfo = new HashMap<>() {{
        put(3, LottoSettings.PRIZE_3.getValue());
        put(4, LottoSettings.PRIZE_4.getValue());
        put(5, LottoSettings.PRIZE_5.getValue());
        put(55, LottoSettings.PRIZE_5_BONUS.getValue()); // 키값 55는 번호5개 + 보너스 번호 1개 맞춘 경우
        put(6, LottoSettings.PRIZE_6.getValue());
    }};

    public static long getPrize(int numberMatch, int bonusMatch) {
        if (numberMatch == 5 && bonusMatch == 1) {
            return prizeInfo.get(55);
        }
        return prizeInfo.get(numberMatch);
    }

    public static long getPrize(int numberMatch) {
        return prizeInfo.get(numberMatch);
    }
}
